FROM openjdk:17-ea-16-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} hub-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hub-0.0.1-SNAPSHOT.jar"]