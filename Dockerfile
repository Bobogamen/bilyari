# Use an OpenJDK image with JDK 17 for the runtime stage
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy application JAR file
COPY build/libs/*.jar app.jar

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]
