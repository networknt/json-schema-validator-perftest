package com.networknt.schema.perftest;

import java.util.Map;
import java.util.concurrent.Callable;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ComparisonBenchmark {
    public static final String NETWORKNT = "networknt";
    public static final String DEV_HARREL = "devHarrel";
    public static final String EVERIT = "everit";
    public static final String JSON_SCHEMA_FRIEND = "jsonSchemaFriend";
    public static final String OPTIMUM_CODE = "optimumCode";
    public static final String SKEMA = "skema";

    @State(Scope.Thread)
    public static class BenchmarkState {
        @Param({ NETWORKNT, EVERIT, DEV_HARREL, JSON_SCHEMA_FRIEND, OPTIMUM_CODE })
        public String implementation;

        private Map<String, Callable<Object>> basic = Map.of(NETWORKNT, new NetworkntRunner(), DEV_HARREL,
                new DevHarrelRunner(), EVERIT, new EveritRunner(), JSON_SCHEMA_FRIEND, new JsonSchemaFriendRunner(),
                OPTIMUM_CODE, new OptimumCodeRunner());

        private Map<String, Callable<Object>> krakend = Map.of(NETWORKNT,
                new NetworkntRunner("draft7_krakend-schema.json", "draft7_krakend-instance.json", "instances"),
                DEV_HARREL,
                new DevHarrelRunner("draft7_krakend-schema.json", "draft7_krakend-instance.json", "instances"), EVERIT,
                new EveritRunner("draft7_krakend-schema.json", "draft7_krakend-instance.json", "instances"),
                JSON_SCHEMA_FRIEND,
                new JsonSchemaFriendRunner("draft7_krakend-schema.json", "draft7_krakend-instance.json",
                        "instances")/*
                                     * , OPTIMUM_CODE, new OptimumCodeRunner("draft7_krakend-schema.json",
                                     * "draft7_krakend-instance.json", "instances")
                                     */);

        private Map<String, Callable<Object>> unevaluatedProperties = Map.of(NETWORKNT,
                new NetworkntRunner("draft2020_12_unevaluatedProperties-schema.json",
                        "draft2020_12_unevaluatedProperties-instance.json", "instances"),
                DEV_HARREL,
                new DevHarrelRunner("draft2020_12_unevaluatedProperties-schema.json",
                        "draft2020_12_unevaluatedProperties-instance.json", "instances"),
                SKEMA,
                new SkemaRunner("draft2020_12_unevaluatedProperties-schema.json",
                        "draft2020_12_unevaluatedProperties-instance.json", "instances"),
                JSON_SCHEMA_FRIEND,
                new JsonSchemaFriendRunner("draft2020_12_unevaluatedProperties-schema.json",
                        "draft2020_12_unevaluatedProperties-instance.json", "instances"),
                OPTIMUM_CODE, new OptimumCodeRunner("draft2020_12_unevaluatedProperties-schema.json",
                        "draft2020_12_unevaluatedProperties-instance.json", "instances"));

        private Map<String, Callable<Object>> openapi = Map.of(NETWORKNT,
                new NetworkntRunner(
                        "draft2020_12_openapi-schema.json", "draft2020_12_openapi-instance.json", "instances"),
                DEV_HARREL,
                new DevHarrelRunner("draft2020_12_openapi-schema.json", "draft2020_12_openapi-instance.json",
                        "instances"),
                SKEMA,
                new SkemaRunner("draft2020_12_openapi-schema.json", "draft2020_12_openapi-instance.json", "instances"),
                JSON_SCHEMA_FRIEND,
                new JsonSchemaFriendRunner("draft2020_12_openapi-schema.json", "draft2020_12_openapi-instance.json",
                        "instances"),
                OPTIMUM_CODE, new OptimumCodeRunner("draft2020_12_openapi-schema.json",
                        "draft2020_12_openapi-instance.json", "instances"));

        private Map<String, Callable<Object>> cql2 = Map.of(NETWORKNT,
                new NetworkntRunner("draft2020_12_cql2-schema.json", "draft2020_12_cql2-instance.json", "instances"),
                DEV_HARREL,
                new DevHarrelRunner("draft2020_12_cql2-schema.json", "draft2020_12_cql2-instance.json", "instances"),
                SKEMA, new SkemaRunner("draft2020_12_cql2-schema.json", "draft2020_12_cql2-instance.json", "instances"),
                JSON_SCHEMA_FRIEND,
                new JsonSchemaFriendRunner("draft2020_12_cql2-schema.json", "draft2020_12_cql2-instance.json",
                        "instances"),
                OPTIMUM_CODE,
                new OptimumCodeRunner("draft2020_12_cql2-schema.json", "draft2020_12_cql2-instance.json", "instances"));

        /*
         * The draft2020_12_cql2-schema.json contains expensive oneOf operations which is not recommended
         */
        private Map<String, Callable<Object>> cql2fix = Map.of(NETWORKNT,
                new NetworkntRunner(
                        "draft2020_12_cql2-fix-schema.json", "draft2020_12_cql2-instance.json", "instances"),
                DEV_HARREL,
                new DevHarrelRunner("draft2020_12_cql2-fix-schema.json", "draft2020_12_cql2-instance.json",
                        "instances"),
                SKEMA,
                new SkemaRunner("draft2020_12_cql2-fix-schema.json", "draft2020_12_cql2-instance.json", "instances"),
                JSON_SCHEMA_FRIEND,
                new JsonSchemaFriendRunner("draft2020_12_cql2-fix-schema.json", "draft2020_12_cql2-instance.json",
                        "instances"),
                OPTIMUM_CODE, new OptimumCodeRunner("draft2020_12_cql2-fix-schema.json",
                        "draft2020_12_cql2-instance.json", "instances"));
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft4_basic(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.basic.get(state.implementation).call());
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft7_krakend(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.krakend.get(state.implementation).call());
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft2020_12_unevaluatedProperties(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.unevaluatedProperties.get(state.implementation).call());
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft2020_12_openapi(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.openapi.get(state.implementation).call());
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft2020_12_cql2(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.cql2.get(state.implementation).call());
    }

    @BenchmarkMode(Mode.Throughput)
    @Fork(2)
    @Warmup(iterations = 5, time = 5)
    @Measurement(iterations = 5, time = 5)
    @Benchmark
    public void draft2020_12_cql2_fix(BenchmarkState state, Blackhole blackhole) throws Exception {
        blackhole.consume(state.cql2fix.get(state.implementation).call());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(ComparisonBenchmark.class.getSimpleName())
                .addProfiler(GCProfiler.class).build();

        new Runner(opt).run();
    }

}
