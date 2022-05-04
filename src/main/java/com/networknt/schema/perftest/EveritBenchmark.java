package com.networknt.schema.perftest;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;

public class EveritBenchmark {

	@State(Scope.Thread)
	public static class BenchmarkState {

		private Schema jsonSchema;
		private JSONObject schemas;
		private List<String> schemaNames;

		public BenchmarkState() {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			JSONObject root = new JSONObject(new JSONTokener(classLoader.getResourceAsStream("perftest.json")));
			JSONObject schemaObject = new JSONObject(new JSONTokener(classLoader.getResourceAsStream("schema-draft4.json")));
			jsonSchema = SchemaLoader.load(schemaObject);
			schemas = root.getJSONObject("schemas");
			schemaNames = Arrays.asList(JSONObject.getNames(schemas));
		}
	}

	@BenchmarkMode(Mode.Throughput)
	@Fork(2)
	@Warmup(iterations = 5, time = 5)
	@Measurement(iterations = 5, time = 5)
	@Benchmark
	public void testValidate(BenchmarkState state) {
		for (String name : state.schemaNames) {
			JSONObject json = (JSONObject) state.schemas.get(name);
			state.jsonSchema.validate(json);
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(EveritBenchmark.class.getSimpleName())
				.addProfiler(GCProfiler.class)
				.build();

		new Runner(opt).run();
	}

}
