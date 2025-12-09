# Multi-stage Dockerfile for Java 21 application

# Stage 1: Build stage
# Use Maven image with Java 21 to build the application
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (for better layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src
COPY Checkstyle ./Checkstyle

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
# Use a smaller JRE image for running the application
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from build stage
COPY --from=build /app/target/DEV-OPS-1.0-SNAPSHOT.jar app.jar

# Create a non-root user for security
RUN addgroup -g 1001 appgroup && \
    adduser -u 1001 -G appgroup -s /bin/sh -D appuser

# Change ownership of the app
RUN chown -R appuser:appgroup /app

# Switch to non-root user
USER appuser

# Expose port (if needed in future for web service)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
