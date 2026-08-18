# ========================================================
# Stage 1: Build Phase
# Uses Maven and OpenJDK 17 to compile and package the application
# ========================================================
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the build container
WORKDIR /app

# Copy the dependency model and source code to the container
COPY pom.xml .
COPY src ./src

# Package the Spring Boot application into an executable JAR file, skipping unit tests
RUN mvn clean package -DskipTests

# ========================================================
# Stage 2: Runtime Phase
# Uses a lightweight OpenJDK runtime environment to run the compiled JAR
# ========================================================
FROM openjdk:17-jdk-slim

# Set the working directory inside the execution container
WORKDIR /app

# Copy the generated JAR artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Document that the application listens on port 8080 at runtime
EXPOSE 8080

# Configure the entry point to run the application executable
ENTRYPOINT ["java", "-jar", "app.jar"]
