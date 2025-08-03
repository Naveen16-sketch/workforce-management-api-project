# Build stage
FROM gradle:jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build

# Runtime stage
FROM eclipse-temurin:17-jre
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]