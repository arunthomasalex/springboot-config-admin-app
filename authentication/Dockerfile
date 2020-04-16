FROM openjdk:8-jdk-alpine
EXPOSE 9000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} authenication.jar
ENTRYPOINT ["java", "-jar", "/authenication.jar"]