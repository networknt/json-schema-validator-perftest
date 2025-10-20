package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class NetworkntPerfOpenapi {
    public static void main(final String[] args) throws Exception {
        Callable<Object> openapi = new NetworkntRunner("draft2020_12_openapi-schema.json", "draft2020_12_openapi-instance.json",
                "instances");
        Perf.run(openapi);
    }
}
