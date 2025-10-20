package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class SkemaPerf {
    public static void main(final String[] args) throws Exception {
        Callable<Object> basic = new SkemaRunner();
        Perf.run(basic);
    }
}
