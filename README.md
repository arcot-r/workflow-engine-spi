# workflow-engine-spi
Exposing an embedded workflow engine using Service Provider Interface

## Commands to run the multi-module application
*  mvn clean package
*  java -jar workflow-engine-application\target\workflow-engine-application-0.0.1-SNAPSHOT.jar

## Activiti Dependency
https://github.com/Activiti/Activiti/releases/tag/8.4.0

##Steps to enable docker and github actions
1. create .github/workflow/ci-cd.yml
2. create dockerfile
3. add .dockerignore file

  
## Set Up Local Docker Registry:
1. Go to Preferences -> Docker Engine and add the following configuration to enable the local registry:
      ```
          {
            "experimental": true,
            "features": {
              "buildkit": true
            },
            "insecure-registries": ["localhost:5000"]
          }
      ```
  2. Run a local Docker registry container:
     ```
     docker run -d -p 5000:5000 --name registry registry:2
     ```
  3. Tag and Push Docker Image to Local Registry
     ```
    docker tag workflow-engine-application:latest localhost:5000/workflow-engine-application:latest
    docker push localhost:5000/workflow-engine-application:latest

  
    
## To Configure GitHub Actions to automatically build Docker images using Docker Desktop locally
   1. Set Up a Self-Hosted Runner:
       *  GitHub allows you to use self-hosted runners, which are machines you manage and can use to run GitHub Actions workflows. You can use your local machine with Docker Desktop as a self-hosted runner.
       * Follow GitHub's self-hosted runner documentation to set up a self-hosted runner on your local machine.
       * Run the commands displayed in the github in powershell in a folder called action-runner
       * dont run it as a service, whenever needed.  run the .\run.cmd file

3. Register Self-Hosted Runner:
    * On your GitHub repository, go to Settings > Actions > Runners > New self-hosted runner.
    * Follow the instructions to download the runner application and configure it.

5. Install Docker and Docker Compose:
    * Ensure Docker Desktop is installed and running on your local machine.
    * Make sure docker and docker-compose commands are available in your PATH.

4. Configure the GitHub Actions Workflow:
   *  Update your .github/workflows configuration file to use the self-hosted runner.
  ```
name: CI/CD Pipeline

on:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main

jobs:
  build:
    runs-on: self-hosted
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'

    - name: Cache Maven dependencies
      uses: actions/cache@v2
      with:
        path: ~/.m2/repository
        key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
        restore-keys: |
          ${{ runner.os }}-maven-

    - name: Build and Package
      run: mvn clean package --projects workflow-engine-parent --also-make

    - name: Build Docker image
      run: |
        cd workflow-engine-application
        docker build -t workflow-engine-application:latest .
    
    - name: Push Docker image to local registry
      run: |
        docker tag workflow-engine-application:latest localhost:5000/workflow-engine-application:latest
        docker push localhost:5000/workflow-engine-application:latest
```
## List of useful docker CLI commands
- To build the docker image:
```
docker build -t workflow-engine-application:latest .
```
- Tag docker image:
```
docker tag workflow-engine-application:latest localhost:5000/workflow-engine-application:latest
```
- push docker image:
```
docker push localhost:5000/workflow-engine-application:latest
```
- run docker image:
```
docker run -d -p 8080:8080 localhost:5000/workflow-engine-application:latest
```


