FROM gradle:7.4.2-jdk11 AS build
COPY . /app
WORKDIR /app
RUN chmod +x gradlew
RUN ./gradlew bootJar
RUN mv -f build/libs/*.jar app.jar

FROM gradle:7.4.2-jdk11
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]





## Build stage
#FROM gradle:7.4.2-jdk11 AS build
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy Gradle wrapper and project files
#COPY gradle /app/gradle
#COPY gradlew /app/gradlew
#COPY build.gradle /app/build.gradle
#COPY settings.gradle /app/settings.gradle
#
## Copy the source code
#COPY src /app/src
#
## Run Gradle build
#RUN ./gradlew build
#
## Runtime stage
#FROM openjdk:11-jre-slim
#
## Copy the built jar file from the build stage
#COPY --from=build /app/build/libs/your-app.jar /app/your-app.jar
#
## Set the entry point to run the jar
#ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]

