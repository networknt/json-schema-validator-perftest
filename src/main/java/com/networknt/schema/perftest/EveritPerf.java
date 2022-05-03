package com.networknt.schema.perftest;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class EveritPerf {

  public static void main(final String[] args) {
    JSONObject root = new JSONObject(
        new JSONTokener(EveritPerf.class.getResourceAsStream("/perftest.json")));
    JSONObject schemaObject = new JSONObject(
        new JSONTokener(EveritPerf.class.getResourceAsStream("/schema-draft4.json")));
    Schema schema = SchemaLoader.load(schemaObject);
    JSONObject subjects = root.getJSONObject("schemas");
    String[] names = JSONObject.getNames(subjects);
    System.out.println("Now test overit...");
    long startAt = System.currentTimeMillis();
    for (int i = 0; i < 500; ++i) {
      for (String subjectName : names) {
        JSONObject subject = (JSONObject) subjects.get(subjectName);
        schema.validate(subject);
      }
      if (i % 20 == 0) {
        System.out
            .println("Iteration " + i + " (in " + (System.currentTimeMillis() - startAt) + "ms)");
      }
    }
    long endAt = System.currentTimeMillis();
    long execTime = endAt - startAt;
    System.out.println("total time: " + execTime + " ms");

  }

}
