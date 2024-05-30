# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the target directory to the working directory in the container
COPY workflow-engine-application/target/workflow-engine-application-*.jar workflow-engine-application.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "workflow-engine-application.jar"]
