package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class DevHarrelPerf {
    public static void main(final String[] args) throws Exception {
        Callable<Object> basic = new DevHarrelRunner();
        Perf.run(basic);
    }
}
