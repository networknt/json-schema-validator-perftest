window.BENCHMARK_DATA = {
  "lastUpdate": 1761009625225,
  "repoUrl": "https://github.com/networknt/json-schema-validator-perftest",
  "entries": {
    "JSON Schema Validator Benchmark": [
      {
        "commit": {
          "author": {
            "email": "stevehu@gmail.com",
            "name": "Steve Hu",
            "username": "stevehu"
          },
          "committer": {
            "email": "noreply@github.com",
            "name": "GitHub",
            "username": "web-flow"
          },
          "distinct": true,
          "id": "dc4f85bbcf3e2bd305ce8a62d0b76463827b488f",
          "message": "Merge pull request #12 from justin-tay/benchmark\n\nAdd benchmark action and implementations",
          "timestamp": "2025-10-19T21:31:47-04:00",
          "tree_id": "0d73eb856849412d49f0dfc7e0ecf640a9beb9fa",
          "url": "https://github.com/networknt/json-schema-validator-perftest/commit/dc4f85bbcf3e2bd305ce8a62d0b76463827b488f"
        },
        "date": 1761009624308,
        "tool": "jmh",
        "benches": [
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"networknt\"} )",
            "value": 323.01410606238784,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"devHarrel\"} )",
            "value": 302.8700987646216,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 50.29009202753472,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"optimumCode\"} )",
            "value": 143.17024525684477,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"networknt\"} )",
            "value": 14592.23399019605,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"devHarrel\"} )",
            "value": 11792.57279556171,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 1734.8015605906546,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"optimumCode\"} )",
            "value": 4034.695943060986,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"networknt\"} )",
            "value": 998.2028710869102,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"devHarrel\"} )",
            "value": 413.4673974112363,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 46.622760983646934,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"optimumCode\"} )",
            "value": 483.07628517237964,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"networknt\"} )",
            "value": 206506.7365306899,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"devHarrel\"} )",
            "value": 193229.765063777,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 40023.14342370059,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"optimumCode\"} )",
            "value": 177224.35309943775,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"networknt\"} )",
            "value": 7776.033557899654,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"everit\"} )",
            "value": 3185.9664100775103,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"devHarrel\"} )",
            "value": 2890.7581557866724,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 428.32791310762394,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"optimumCode\"} )",
            "value": 3830.759669829859,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"networknt\"} )",
            "value": 8951.466301362818,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"everit\"} )",
            "value": 6976.685153936099,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"devHarrel\"} )",
            "value": 3756.9353073217776,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 1198.6640966964571,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          }
        ]
      }
    ]
  }
}