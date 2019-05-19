[![Build Status](https://travis-ci.org/navicore/lots-of-names-api.svg?branch=master)](https://travis-ci.org/navicore/lots-of-names-api)

LotsOfNamesApi
=======

An http service for the [LotsOfNames scala library](https://github.com/navicore/lots-of-names).

## Start:
```console
sbt run
```

## Usage:

### GET

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

### POST

call to post a list of ids and get a list of names:
```console
curl -d '[{"sourceId": "b2546ee7-494f-42cc-abe0-9113c3eefee2"},{"sourceId": "99999999-494f-42cc-abe0-9113c3eefee2"}]' -H "Content-Type: application/json" -X POST https://lotsofnames.navicore.tech/names
```
returns:
```console
[{
  "datetime": "2019-05-19T17:23:57.117Z",
  "id": "e0ab40ed-15e6-443f-971f-46a29f745807",
  "name": "Mayr Zacherl",
  "sourceId": "b2546ee7-494f-42cc-abe0-9113c3eefee2"
}, {
  "datetime": "2019-05-19T17:23:57.117Z",
  "id": "2fe7efca-cf41-4958-a73b-1b96d8ad9088",
  "name": "Beckman Josey",
  "sourceId": "99999999-494f-42cc-abe0-9113c3eefee2"
}]

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

