#!/usr/bin/env bash

curl -d '[{"sourceId": "b2546ee7-494f-42cc-abe0-9113c3eefee2"},{"sourceId": "99999999-494f-42cc-abe0-9113c3eefee2"}]' -H "Content-Type: application/json" -X POST https://lotsofnames.navicore.tech/names
