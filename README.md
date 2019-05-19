[![Build Status](https://travis-ci.org/navicore/lots-of-names-api.svg?branch=master)](https://travis-ci.org/navicore/lots-of-names-api)

LotsOfNamesApi
=======

An http service for the [LotsOfNames scala library](https://github.com/navicore/lots-of-names).

## Start:
```console
sbt run
```

## Usage:
call to get a name for id 12345:
```console
curl localhost:8080/names/12345
```
returns:
```console
{
  "datetime": "2019-05-19T05:12:17.413Z",
  "id": "6f6bde77-ad04-4ef9-b2f9-2086755f08b3",
  "name": "Gangstababy Egoi",
  "sourceId": "12345"
}
```
see examples dir for post and batch results examples

# DEVELOPMENT

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
