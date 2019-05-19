#!/usr/bin/env bash

#OPTS="--dry-run --debug"
OPTS=""

TAG="latest"

helm install $OPTS --name lots-of-names-api --set image.tag=$TAG lots-of-names-api
