package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class JsonSchemaFriendPerf {
    public static void main(final String[] args) throws Exception {
        Callable<Object> basic = new JsonSchemaFriendRunner();
        Perf.run(basic);
    }
}
