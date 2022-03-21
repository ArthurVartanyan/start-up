FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/start-up-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} start-up-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/start-up-1.0-SNAPSHOT.jar"]