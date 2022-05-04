package com.networknt.schema.perftest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NetworkntBenchmark {

	@State(Scope.Thread)
	public static class BenchmarkState {

		private JsonSchema jsonSchema;
		private JsonNode schemas;
		private List<String> schemaNames;

		public BenchmarkState() {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
			try {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				ObjectReader reader = objectMapper.reader();
				JsonNode schemaNode = reader.readTree(classLoader.getResourceAsStream("schema-draft4.json"));
				jsonSchema = factory.getSchema(schemaNode);

				JsonNode root = reader.readTree(classLoader.getResourceAsStream("perftest.json"));
				schemas = root.get("schemas");

				List<String> names = new ArrayList<>();
				schemas.fieldNames().forEachRemaining(names::add);
				schemaNames = names;
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	@BenchmarkMode(Mode.Throughput)
	@Fork(2)
	@Warmup(iterations = 5, time = 5)
	@Measurement(iterations = 5, time = 5)
	@Benchmark
	public void testValidate(BenchmarkState state) {
		for (String name : state.schemaNames) {
			JsonNode json = state.schemas.get(name);
			state.jsonSchema.validate(json);
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(NetworkntBenchmark.class.getSimpleName())
				.addProfiler(GCProfiler.class)
				.build();

		new Runner(opt).run();
	}

}
