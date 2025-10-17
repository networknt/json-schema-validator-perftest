package com.networknt.schema.perftest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import com.github.erosb.jsonsKema.FormatValidationPolicy;
import com.github.erosb.jsonsKema.JsonObject;
import com.github.erosb.jsonsKema.JsonParser;
import com.github.erosb.jsonsKema.JsonString;
import com.github.erosb.jsonsKema.JsonValue;
import com.github.erosb.jsonsKema.Schema;
import com.github.erosb.jsonsKema.SchemaLoader;
import com.github.erosb.jsonsKema.ValidationFailure;
import com.github.erosb.jsonsKema.Validator;
import com.github.erosb.jsonsKema.ValidatorConfig;

public class SkemaRunner implements Callable<Object> {
    private Schema jsonSchema;
    private JsonObject schemas;
    private List<JsonString> schemaNames;

    public SkemaRunner() {
        this("draft2020_12_unevaluatedProperties-schema.json", "draft2020_12_unevaluatedProperties-instance.json", "instances");
    }

    public SkemaRunner(String schema, String instance, String instanceKey) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        JsonObject root = (JsonObject) new JsonParser(classLoader.getResourceAsStream(instance)).parse();
        JsonValue schemaObject = new JsonParser(classLoader.getResourceAsStream(schema)).parse();
        jsonSchema = new SchemaLoader(schemaObject).load();
        schemas = (JsonObject) root.get(instanceKey);
        schemaNames = Arrays.asList(schemas.getProperties().keySet().toArray(new JsonString[0]));
    }

    @Override
    public Object call() {
        List<Object> results = new ArrayList<>();
        for (JsonString name : schemaNames) {
            Validator validator = Validator.create(jsonSchema, new ValidatorConfig(FormatValidationPolicy.ALWAYS));
            JsonValue json = schemas.get(name.getValue());
            ValidationFailure failure = validator.validate(json);
            results.add(failure);
        }
        return results;
    }
}
