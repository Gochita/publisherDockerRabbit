FROM openjdk:8-alpine
ADD target/publisher-0.0.1-SNAPSHOT.jar publisher.jar
RUN sh -c 'touch /publisher.jar'
ENTRYPOINT ["java", "-jar","publisher.jar"]
