FROM amazoncorretto:21-alpine-jdk

COPY user-service-0.0.2-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]