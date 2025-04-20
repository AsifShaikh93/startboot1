# Dockerfile
FROM eclipse-temurin:17-jdk

# Create a directory and copy the OpenTelemetry agent
RUN mkdir -p /otel
COPY opentelemetry-javaagent.jar /otel/opentelemetry-javaagent.jar

# Copy your app JAR (adjust path as needed)
COPY target/startboot1.jar /startboot1.jar

# Run your app with the agent
CMD ["java", "-javaagent:/otel/opentelemetry-javaagent.jar", "-jar", "/startboot1.jar"]


