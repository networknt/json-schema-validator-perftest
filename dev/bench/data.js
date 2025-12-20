window.BENCHMARK_DATA = {
  "lastUpdate": 1766239220829,
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
      },
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
          "id": "f9ee770225829cd53f6b33d0474f0c802cc46b83",
          "message": "Merge pull request #13 from justin-tay/2.x\n\nUpdate networknt json schema validator to 2.0.1",
          "timestamp": "2025-12-20T08:45:44-05:00",
          "tree_id": "678314d1533dd692409ee4e06bc02e245bff6285",
          "url": "https://github.com/networknt/json-schema-validator-perftest/commit/f9ee770225829cd53f6b33d0474f0c802cc46b83"
        },
        "date": 1766239219962,
        "tool": "jmh",
        "benches": [
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"networknt\"} )",
            "value": 391.55548906324776,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"devHarrel\"} )",
            "value": 281.18054430884337,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 49.45729205362832,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2 ( {\"implementation\":\"optimumCode\"} )",
            "value": 143.2969204753889,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"networknt\"} )",
            "value": 15555.181103534878,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"devHarrel\"} )",
            "value": 12414.477802028283,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 1664.8275775847976,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_cql2_fix ( {\"implementation\":\"optimumCode\"} )",
            "value": 3875.880089192051,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"networknt\"} )",
            "value": 761.6622859441637,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"devHarrel\"} )",
            "value": 420.3027640437897,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 43.70663911891332,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_openapi ( {\"implementation\":\"optimumCode\"} )",
            "value": 462.1155046574535,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"networknt\"} )",
            "value": 154912.1144039285,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"devHarrel\"} )",
            "value": 218773.39124898965,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 38371.11980867001,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft2020_12_unevaluatedProperties ( {\"implementation\":\"optimumCode\"} )",
            "value": 185975.90867976018,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"networknt\"} )",
            "value": 4460.151903848436,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"everit\"} )",
            "value": 3107.6826779840467,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"devHarrel\"} )",
            "value": 2875.830048321561,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 436.42967651692425,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft4_basic ( {\"implementation\":\"optimumCode\"} )",
            "value": 3789.3674933521056,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"networknt\"} )",
            "value": 5923.442809044301,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"everit\"} )",
            "value": 6706.991117751945,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"devHarrel\"} )",
            "value": 3726.1868596330146,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          },
          {
            "name": "com.networknt.schema.perftest.ComparisonBenchmark.draft7_krakend ( {\"implementation\":\"jsonSchemaFriend\"} )",
            "value": 1235.177130801411,
            "unit": "ops/s",
            "extra": "iterations: 3\nforks: 1\nthreads: 1"
          }
        ]
      }
    ]
  }
}