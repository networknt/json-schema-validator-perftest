package com.networknt.schema.perftest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.github.optimumcode.json.schema.JsonSchema;
import io.github.optimumcode.json.schema.ValidationError;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

public class OptimumCodeRunner implements Callable<Object> {
    private JsonSchema schema;
    private List<JsonElement> instances;
    
    public OptimumCodeRunner() {
    	this("draft4_basic-schema.json", "draft4_basic-instance.json", "schemas");
    }

    public OptimumCodeRunner(String schema, String instance, String instanceKey) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String schemaData = new String((classLoader.getResourceAsStream(schema).readAllBytes()));
            this.schema = JsonSchema.fromDefinition(schemaData);

            String inputData = new String((classLoader.getResourceAsStream(instance).readAllBytes()));
            JsonObject root = (JsonObject) Json.Default.parseToJsonElement(inputData);

            JsonObject schemas = (JsonObject) root.get(instanceKey);
            instances = new ArrayList<>();
            schemas.entrySet().forEach(entry -> instances.add(entry.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() {
        List<Object> results = new ArrayList<>();
        for (JsonElement instance : instances) {
            List<ValidationError> errors = new ArrayList<>();
            schema.validate(instance, errors::add);
            results.add(errors);
        }
        return results;
    }
}
