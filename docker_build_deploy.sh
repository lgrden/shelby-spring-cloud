#!/bin/bash
mvn clean install
docker build -t shelby-eureka shelby-eureka
docker build -t shelby-api-gateway shelby-api-gateway
docker build -t shelby-refdata shelby-refdata
docker build -t shelby-ui shelby-ui
docker-compose -f docker-compose-all.yaml up -d