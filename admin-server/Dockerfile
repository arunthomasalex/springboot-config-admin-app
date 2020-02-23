FROM openjdk:8-jdk-alpine
EXPOSE 8889
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} adminserver.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/adminserver.jar"]