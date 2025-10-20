package com.networknt.schema.perftest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.ValidationException;
import net.jimblackler.jsonschemafriend.Validator;

public class JsonSchemaFriendRunner implements Callable<Object> {
    private Schema schema;
    private Validator validator;
    private List<Object> instances;
    
    public JsonSchemaFriendRunner() {
    	this("draft4_basic-schema.json", "draft4_basic-instance.json", "schemas");
    }

    @SuppressWarnings("unchecked")
    public JsonSchemaFriendRunner(String schema, String instance, String instanceKey) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectReader reader = objectMapper.reader();
            Object schemaNode = reader.readValue(classLoader.getResourceAsStream(schema), Object.class);
            Map<String, Object> root = reader.readValue(classLoader.getResourceAsStream(instance), Map.class);
            Map<String, Object> schemas = (Map<String, Object>) root.get(instanceKey);
            final SchemaStore schemaStore = new SchemaStore(url -> url, true);
            this.schema = schemaStore.loadSchema(schemaNode);

            instances = new ArrayList<>();
            schemas.entrySet().forEach(entry -> instances.add(entry.getValue()));

            validator = new Validator(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() {
        List<Object> results = new ArrayList<>();
        for (Object instance : instances) {
            ValidationException result = null;
            try {
                validator.validate(schema, instance);
            } catch (ValidationException e) {
                result = e;
            }
            results.add(result);
        }
        return results;
    }
}
