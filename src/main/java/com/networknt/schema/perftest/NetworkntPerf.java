package com.networknt.schema.perftest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by steve on 1/14/2016.
 */
public class NetworkntPerf {
    private static final JsonSchema SCHEMA;

    static {
        try {
            //JsonSchemaFactory factory = new JsonSchemaFactory();
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
            SCHEMA = factory.getSchema(EveritPerf.class.getResourceAsStream("/schema-draft4.json"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private NetworkntPerf()
    {
    }

    public static void main(final String... args)
            throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        final JsonNode googleAPI = mapper.readTree(EveritPerf.class.getResourceAsStream("/perftest.json"));
        final Map<String, JsonNode> googleSchemas = mapper.convertValue(googleAPI.get("schemas"), new TypeReference<>(){});
        long begin, current;
        begin = System.currentTimeMillis();
        doValidate(googleSchemas, -1);
        current = System.currentTimeMillis();

        System.out.println("Initial validation :" + (current - begin) + " ms");

        begin = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            doValidate(googleSchemas, i);
            if (i % 20 == 0) {
                current = System.currentTimeMillis();
                System.out.println(String.format("Iteration %d (in %d ms)", i,
                        current - begin));
            }
        }

        final long end = System.currentTimeMillis();
        System.out.println("END -- time in ms: " + (end - begin));
        System.exit(0);
    }

    private static void doValidate(final Map<String, JsonNode> schemas,
                                   final int i)
    {
        String name;
        JsonNode value;
        Set<ValidationMessage> errors;
        for (final Map.Entry<String, JsonNode> entry: schemas.entrySet()) {
            name = entry.getKey();
            value = entry.getValue();
            errors = SCHEMA.validate(value);
            if (errors.size() > 0) {
                System.err.println("ERROR: schema " + name + " did not "
                        + "validate (iteration " + i + ')');
                System.err.println(errors);
                System.exit(1);
            }
        }
    }
}
