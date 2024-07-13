## Stage 1: Build stage
#FROM eclipse-temurin:17-jdk AS build
#
## Set working directory
#WORKDIR /app
#
## Copy Gradle files and build
#COPY build.gradle settings.gradle gradlew /app/
#COPY gradle /app/gradle
#RUN ./gradlew --no-daemon dependencies
#
## Copy application source and build
#COPY src /app/src
#RUN ./gradlew --no-daemon bootJar
#
## Stage 2: Runtime stage
#FROM eclipse-temurin:17-jre
#
## Set working directory
#WORKDIR /app
#
## Copy the executable JAR file from the build stage
#COPY --from=build /app/build/libs/*.jar app.jar
#
## Create a non-root user
#RUN useradd -u 10001 runtime
#USER runtime
#
## Set the port environment variable
#ARG PORT
#ENV PORT=${PORT}
#
## Specify the command to run on container start
#ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]

#RENDER.COM
FROM eclipse-temurin:20-jdk AS build
WORKDIR /app
COPY . /app
RUN #chmod +x gradlew
RUN ./gradlew bootJar
RUN mv -f build/libs/*.jar app.jar

FROM eclipse-temurin:20-jre
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]
