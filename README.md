# csd-java-quarkus Project

## Vorbereitungen

Um bestens auf den bevorstehenden Kurs vorbereitet zu sein, kannst du folgendes tun:
1. Klone dieses Projekt und prüfe, ob du das Projekt bauen und ausführen kannst (s. [run dev server with hot reload for development](#run dev server with hot reload for development))
2. Gib uns Bescheid, damit wir dich zum GitHub-Projekt hinzufügen können (kontaktiere uns dafür über E-Mail z.B. [Björn](mailto:bjoern@jensen.coach))

## On your machine
### build 
```shell script
./mvnw compile
```

### run tests
```shell script
./mvnw test
```

### run dev server with hot reload for development
```shell script
./mvnw compile quarkus:dev
```

### package
```shell script
./mvnw package
```

### run the application
```shell script
java -jar target/quarkus-app/quarkus-run.jar 
```

## On the remote machine
```
Wir setzen uns an die Integrationsmaschine
cd csd_adventure_java_quarkus/
git pull
./mvnw test
./mvnw package

#Deployment:
./package_and_run.sh
#Deployte Versio: https://csd.idiot.games:4711
```

---
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/csd-java-quarkus-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
