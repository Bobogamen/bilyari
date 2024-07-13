# Use a Gradle image with JDK 17 for the build stage
FROM gradle:7.4.2-jdk17 as build

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Make the Gradle wrapper executable
RUN chmod +x gradlew

# Build the project and generate the jar file
RUN ./gradlew bootJar

# Use an OpenJDK image with JRE 17 for the runtime stage
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
