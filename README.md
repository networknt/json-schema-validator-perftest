# json-schema-validator-perftest

This project is the performance test suite for the [NetworkNT JSON Schema Validator](https://github.com/networknt/json-schema-validator).

## Benchmark results

The benchmark results can be found [here](https://networknt.github.io/json-schema-validator-perftest/dev/bench/).

These benchmarks are run on [Standard GitHub-hosted runners for public repositories](https://docs.github.com/en/actions/reference/runners/github-hosted-runners#standard-github-hosted-runners-for-public-repositories) which are not dedicated machines. Some variance between runs are to be expected.

## Data set

| Name                                 | Description                                                                                                                                                                                                              |
| ------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `draft4_basic`                       | This is the same test used by the [fge json-schema validator](https://github.com/fge/json-schema-validator/wiki/Performance).                                                                                            |
| `draft7_krakend`                     | From [krakend-schema](https://github.com/krakend/krakend-schema).                                                                                                                                                        |
| `draft2020_12_cql2`                  | From [cql2](https://schemas.opengis.net/cql2/1.0/cql2.json). Note that this uses `oneOf` which [requires verification of every sub-schema](https://json-schema.org/understanding-json-schema/reference/combining#oneOf). |
| `draft2020_12_cql2_fix`              | Modified from [cql2](https://schemas.opengis.net/cql2/1.0/cql2.json) to convert `oneOf` to `allOf` as [recommended](https://github.com/json-schema-org/json-schema-spec/issues/1082) to compare performance.             |
| `draft2020_12_openapi`               | Validation of OpenAPI document.                                                                                                                                                                                          |
| `draft2020_12_unevaluatedProperties` | For the `unevaluatedProperties` keyword.                                                                                                                                                                                 |

## Implementations

| Name                              | Repository                                           | Dialects                                                         | Remarks                 |
| --------------------------------- | ---------------------------------------------------- | ---------------------------------------------------------------- | ----------------------- |
| NetworkNT JSON Schema Validator   | https://github.com/networknt/json-schema-validator   | Draft 4, Draft 6, Draft 7, Draft 2019-09, Draft 2020-12          |
| dev.harrel:json-schema            | https://github.com/harrel56/json-schema              | Draft 7, Draft 2019-09, Draft 2020-12                            |
| jsonschemafriend                  | https://github.com/jimblackler/jsonschemafriend      | Draft 3, Draft 4, Draft 6, Draft 7, Draft 2019-09, Draft 2020-12 |
| OptimumCode json-schema-validator | https://github.com/OptimumCode/json-schema-validator | Draft 4, Draft 6, Draft 7, Draft 2019-09, Draft 2020-12          |
| json-sKema                        | https://github.com/erosb/json-sKema                  | Draft 2020-12                                                    |
| Everit JSON Schema Validator      | https://github.com/everit-org/json-schema            | Draft 4, Draft 6, Draft 7                                        | Replaced by json-sKema. |

## Running the benchmarks

### Clone this repository

```shell
git clone https://github.com/networknt/json-schema-validator-perftest.git
```

### Build the project with Maven

```shell
cd json-schema-validator-perftest/
mvn clean package
```

### Run all the benchmarks

```shell
java -jar target/benchmarks.jar
```

### Run a specific benchmark

```shell
java -jar target/benchmarks.jar Networknt
```
