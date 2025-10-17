package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class EveritPerf {
    public static void main(final String[] args) throws Exception {
        Callable<Object> basic = new EveritRunner();
        Perf.run(basic);
    }
}
