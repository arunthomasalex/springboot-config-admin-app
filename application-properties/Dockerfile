FROM openjdk:8-jdk-alpine
EXPOSE 8888
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} confiserver.jar
ENTRYPOINT ["java", "-jar", "/confiserver.jar"]