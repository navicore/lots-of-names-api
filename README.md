[![Build Status](https://travis-ci.org/navicore/lots-of-names-api.svg?branch=master)](https://travis-ci.org/navicore/lots-of-names-api)
LotsOfNamesApi
=======

to test:

`sbt test`

to package:

```
sbt assembly
docker build -t LotsOfNamesApi .
```
to generate and view code coverage reports:

```
sbt clean coverage test
sbt coverageReport
open target/scala-2.12/scoverage-report/index.html
```

for code stats:

```
sbt stats
```
