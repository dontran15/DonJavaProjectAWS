# syntax=docker/dockerfile:1
FROM openjdk:17-alpine
WORKDIR /app
RUN apk update && apk upgrade && \
    apk add --no-cache git 
RUN git clone https://github.com/ProRichyMan/JavaProject1.5 /app
RUN ./mvnw package
CMD ["java", "-jar", "target/spring-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
