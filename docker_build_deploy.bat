@ECHO OFF
call mvn clean install
docker build -t shelby-eureka shelby-eureka
docker build -t shelby-api-gateway shelby-api-gateway
docker build -t shelby-security shelby-security
docker build -t shelby-fx shelby-fx
docker-compose -f docker-compose.yaml up -d