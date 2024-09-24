# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/loan-app-backend*.jar /app/loan-app-backend.jar

ENV loan_app_someprop=value_from_docker_file

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "loan-app-backend.jar"]
