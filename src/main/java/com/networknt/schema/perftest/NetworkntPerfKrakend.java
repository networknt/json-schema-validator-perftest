package com.networknt.schema.perftest;

import java.util.concurrent.Callable;

public class NetworkntPerfKrakend {
    public static void main(final String[] args) throws Exception {
        Callable<Object> krakend = new NetworkntRunner("draft7_krakend-schema.json", "draft7_krakend-instance.json",
                "instances");
        Perf.run(krakend);
    }
}
