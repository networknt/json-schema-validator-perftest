package com.networknt.schema.perftest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.SpecificationVersion;

public class NetworkntRunner implements Callable<Object> {
    private Schema jsonSchema;
    private JsonNode schemas;
    private List<String> schemaNames;
    
    public NetworkntRunner() {
        this("draft4_basic-schema.json", "draft4_basic-instance.json", "schemas");
    }

    public NetworkntRunner(String schema, String instance, String instanceKey) {
        ObjectMapper objectMapper = new ObjectMapper();
        SchemaRegistry factory = SchemaRegistry.withDefaultDialect(SpecificationVersion.DRAFT_4);
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            ObjectReader reader = objectMapper.reader();
            JsonNode schemaNode = reader.readTree(classLoader.getResourceAsStream(schema));
            jsonSchema = factory.getSchema(schemaNode);

            JsonNode root = reader.readTree(classLoader.getResourceAsStream(instance));
            schemas = root.get(instanceKey);

            List<String> names = new ArrayList<>();
            schemas.fieldNames().forEachRemaining(names::add);
            schemaNames = names;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() {
        List<Object> results = new ArrayList<>();
        for (String name : schemaNames) {
            JsonNode json = schemas.get(name);
            results.add(jsonSchema.validate(json));
        }
        return results;
    }

}
