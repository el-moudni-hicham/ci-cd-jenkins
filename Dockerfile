# Build stage
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /build
COPY pom.xml .
# RUN mvn dependency:go-offline
COPY src ./src

RUN mvn clean package -DskipTests


# Runtime stage
FROM openjdk:17-alpine3.13

WORKDIR /app
COPY --from=build /build/target/*.jar /app/

EXPOSE 8090

CMD java -jar *.jar