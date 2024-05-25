FROM openjdk:17
COPY target/*.jar app.jar
COPY src/main/resources/static /static
ENTRYPOINT ["java","-jar","/app.jar"]