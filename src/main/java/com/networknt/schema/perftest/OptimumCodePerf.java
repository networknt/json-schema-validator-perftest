package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class OptimumCodePerf {
    public static void main(final String[] args) throws Exception {
        Callable<Object> basic = new OptimumCodeRunner();
        Perf.run(basic);
    }
}
