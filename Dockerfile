FROM eclipse-temurin:21-jdk
# Create log directory
RUN mkdir -p /opt/intellifleet/apps/logs/intellifleet-api
EXPOSE 8084
COPY target/intellifleet-api.jar intellifleet-api-app.jar
ENTRYPOINT ["java","-jar","/intellifleet-api-app.jar"]