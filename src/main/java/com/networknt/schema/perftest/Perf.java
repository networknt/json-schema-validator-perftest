package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class Perf {
    public static void run(Callable<?> runner) throws Exception {
        long begin, current;
        begin = System.currentTimeMillis();
        runner.call();
        current = System.currentTimeMillis();
        System.out.println("Initial validation :" + (current - begin) + " ms");
        begin = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            runner.call();
            if (i % 20 == 0) {
                current = System.currentTimeMillis();
                System.out.println(String.format("Iteration %d (in %d ms)", i, current - begin));
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println("END -- time in ms: " + (end - begin));
    }
}
