#!/bin/sh

./mvnw package
pgrep -f quarkus.http.port=4711 | xargs kill -9
java -Dquarkus.http.port=4711 -jar target/quarkus-app/quarkus-run.jar &
