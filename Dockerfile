# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy build/libs/*.jar to the container
COPY build/libs/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
