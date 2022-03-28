FROM amazoncorretto:16
EXPOSE 8080
ARG JAR_FILE=build/libs/mesto-go.jar
COPY ${JAR_FILE} mesto-go.jar
ENTRYPOINT ["java","-jar","/mesto-go.jar"]