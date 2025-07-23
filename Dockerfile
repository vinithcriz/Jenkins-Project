# Stage 1: Build using Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Stage 2: Runtime with JRE only
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy only the compiled JAR from the build stage
COPY --from=build /app/target/LoginAppNoDB-1.0-SNAPSHOT.jar app.jar

# Set entrypoint to run the Swing app
ENTRYPOINT ["java", "-jar", "app.jar"]
