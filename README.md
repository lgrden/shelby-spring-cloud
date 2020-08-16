# shelby-spring-cloud @ We Get IT

## Description
Shelby is a simple project that shows capabilities of spring cloud with microservices.

## System requirements
 - JDK 11+
 - Maven 3.6.1+
 - Docker 19.03.12+

## Services
  - shelby-eureka - spring cloud discovery service (port 8761)
  - shelby-api-gateway - spring spi gateway supporting zuul (port 9080), all the refdata rest endpoint are available under ```/refdata/**```
  - shelby-refdata - load-balanced microservice providing list of countries, cities and languages (port 9091 & 9092)
  - shelby-ui - simple UI written in spring webaapp and bootstrap using feign client visualizing data from refdata (port 8080)

## Build tools and Docker
  - build maven project, docker images and run services ```docker_build_deploy.sh```