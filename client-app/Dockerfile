FROM openjdk:8-jdk-alpine
EXPOSE 9000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} clientapp.jar
ENTRYPOINT ["java", "-jar", "clientapp.jar"]