FROM azul/zulu-openjdk:21-jdk-crac-latest
COPY target/crac-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/app/crac-example.jar
