package com.networknt.schema.perftest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class EveritRunner implements Callable<Object> {
    private Schema jsonSchema;
    private JSONObject schemas;
    private List<String> schemaNames;
    
    public EveritRunner() {
    	this("draft4_basic-schema.json", "draft4_basic-instance.json", "schemas");
    }

    public EveritRunner(String schema, String instance, String instanceKey) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        JSONObject root = new JSONObject(new JSONTokener(classLoader.getResourceAsStream(instance)));
        JSONObject schemaObject = new JSONObject(
                new JSONTokener(classLoader.getResourceAsStream(schema)));
        jsonSchema = SchemaLoader.load(schemaObject);
        schemas = root.getJSONObject(instanceKey);
        schemaNames = Arrays.asList(JSONObject.getNames(schemas));
    }

    @Override
    public Object call() {
        List<Object> results = new ArrayList<>();
        for (String name : schemaNames) {
            JSONObject json = (JSONObject) schemas.get(name);
            ValidationException result = null;
            try {
                jsonSchema.validate(json);
            } catch (ValidationException e) {
                result = e;
            }
            results.add(result);
        }
        return results;
    }

}
