package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class NetworkntPerfCql2Fix {
    public static void main(final String[] args) throws Exception {
        Callable<Object> openapi = new NetworkntRunner("draft2020_12_cql2-fix-schema.json", "draft2020_12_cql2-instance.json",
                "instances");
        Perf.run(openapi);
    }
}
