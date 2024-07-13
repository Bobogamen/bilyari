#FROM eclipse-temurin:20-jdk AS build
#COPY . /app
#WORKDIR /app
#RUN chmod +x gradlew
#RUN ./gradlew bootJar
#RUN mv -f build/libs/*.jar app.jar
#
#FROM eclipse-temurin:20-jre
#ARG PORT
#ENV PORT=${PORT}
#COPY --from=build /app/app.jar .
#RUN useradd runtime
#USER runtime
#ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]

# Build stage
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Runtime stage
FROM openjdk:11-jre-slim
COPY --from=build /app/target/myapp.jar /app/myapp.jar
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
