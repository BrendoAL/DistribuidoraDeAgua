FROM openjdk:23
WORKDIR /app
COPY target/Javagua-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
