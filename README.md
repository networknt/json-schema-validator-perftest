# json-schema-validator-perftest
A performance test project that compares networknt, fge and everit json-schema-validator

This library provides a skeletal performance test suite for this JSON Schema Validator library:

https://github.com/networknt/json-schema-validator

It contains the same test suite for the other two Java schema validators:

https://github.com/fge/json-schema-validator/wiki/Performance

https://github.com/everit-org/json-schema


Test results comparison
------------------------------------------------------------------

For testing the performance of the `fge/json-schema-validator` library I've used [this main class](https://github.com/fge/json-schema-validator/blob/master/src/test/java/com/github/fge/jsonschema/NewAPIPerfTest.java) .

I ran the testsuite of both libraries 10 times (each execution performing 500 validations).

Tests results on my local computer:


fge: 7130ms

everit-org: 1168ms

networknt: 223ms




Running the tests on other workstations gave a bit different numbers but similar ratios.

Running the tests
-----------------

Clone this repository:

`git clone https://github.com/erosb/json-schema-perftest.git`

Build the project with Maven:

```
cd json-schema-perftest/
mvn clean install -Pdist
```

Run the test:

`java -jar target/perftest.jar`


Test on July 09, 2017. 

Everit result:

```
Now test overit...
Iteration 0 (in 75ms)
Iteration 20 (in 184ms)
Iteration 40 (in 238ms)
Iteration 60 (in 290ms)
Iteration 80 (in 333ms)
Iteration 100 (in 369ms)
Iteration 120 (in 403ms)
Iteration 140 (in 438ms)
Iteration 160 (in 472ms)
Iteration 180 (in 507ms)
Iteration 200 (in 541ms)
Iteration 220 (in 577ms)
Iteration 240 (in 613ms)
Iteration 260 (in 649ms)
Iteration 280 (in 685ms)
Iteration 300 (in 721ms)
Iteration 320 (in 757ms)
Iteration 340 (in 793ms)
Iteration 360 (in 828ms)
Iteration 380 (in 866ms)
Iteration 400 (in 900ms)
Iteration 420 (in 934ms)
Iteration 440 (in 968ms)
Iteration 460 (in 1002ms)
Iteration 480 (in 1036ms)
total time: 1068 ms

```

Fge result:

```
Running example Fge
Please point your web browser at http://localhost:8080
Initial validation :182 ms
Iteration 0 (in 45 ms)
Iteration 20 (in 609 ms)
Iteration 40 (in 1103 ms)
Iteration 60 (in 1533 ms)
Iteration 80 (in 1867 ms)
Iteration 100 (in 2164 ms)
Iteration 120 (in 2426 ms)
Iteration 140 (in 2688 ms)
Iteration 160 (in 2905 ms)
Iteration 180 (in 3106 ms)
Iteration 200 (in 3307 ms)
Iteration 220 (in 3516 ms)
Iteration 240 (in 3723 ms)
Iteration 260 (in 3930 ms)
Iteration 280 (in 4132 ms)
Iteration 300 (in 4343 ms)
Iteration 320 (in 4551 ms)
Iteration 340 (in 4753 ms)
Iteration 360 (in 4955 ms)
Iteration 380 (in 5155 ms)
Iteration 400 (in 5354 ms)
Iteration 420 (in 5560 ms)
Iteration 440 (in 5770 ms)
Iteration 460 (in 5975 ms)
Iteration 480 (in 6200 ms)
END -- time in ms: 6427

```

Networknt result:

```
Running example Networknt
Please point your web browser at http://localhost:8080
Initial validation :13 ms
Iteration 0 (in 4 ms)
Iteration 20 (in 46 ms)
Iteration 40 (in 73 ms)
Iteration 60 (in 93 ms)
Iteration 80 (in 111 ms)
Iteration 100 (in 127 ms)
Iteration 120 (in 137 ms)
Iteration 140 (in 145 ms)
Iteration 160 (in 153 ms)
Iteration 180 (in 159 ms)
Iteration 200 (in 165 ms)
Iteration 220 (in 171 ms)
Iteration 240 (in 177 ms)
Iteration 260 (in 183 ms)
Iteration 280 (in 189 ms)
Iteration 300 (in 195 ms)
Iteration 320 (in 207 ms)
Iteration 340 (in 212 ms)
Iteration 360 (in 217 ms)
Iteration 380 (in 223 ms)
Iteration 400 (in 228 ms)
Iteration 420 (in 234 ms)
Iteration 440 (in 239 ms)
Iteration 460 (in 244 ms)
Iteration 480 (in 250 ms)
END -- time in ms: 254

```

