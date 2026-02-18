# Dockerfile para deploy no Render
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/quarkus-app/lib/ ./lib/
COPY target/quarkus-app/*.jar ./
COPY target/quarkus-app/app/ ./app/
COPY target/quarkus-app/quarkus/ ./quarkus/

ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=8080"
ENV JAVA_APP_JAR="/app/quarkus-run.jar"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]

