# json-schema-validator-perftest
A performance test project that compares networknt, fge and everit json-schema-validator

This library provides a skeletal performance test suite for this JSON Schema Validator library:

https://github.com/networknt/json-schema-validator

It contains the same test suite for the other two Java schema validators:

https://github.com/fge/json-schema-validator/wiki/Performance

https://github.com/everit-org/json-schema


# Test results comparison

For testing the performance of the `fge/json-schema-validator` library I've used [this main class](https://github.com/fge/json-schema-validator/blob/master/src/test/java/com/github/fge/jsonschema/NewAPIPerfTest.java) .

I ran the testsuite of both libraries 10 times (each execution performing 500 validations).

Tests results on my local computer:


fge: 7130ms

everit-org: 1168ms

networknt: 223ms




Running the tests on other workstations gave a bit different numbers but similar ratios.

# Running the tests

Clone this repository:

`git clone https://github.com/erosb/json-schema-perftest.git`

Build the project with Maven:

```
cd json-schema-perftest/
mvn clean install -Pdist
```

Run the test:

`java -jar target/perftest.jar`


# Test results
Check [test results](test_results)
