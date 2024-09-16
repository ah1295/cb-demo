# Build Spring Boot Application Deployment Guide

### Prerequisites
1. Java Development Kit (JDK) 17 or higher
2. Maven
3. Docker
4. Kubernetes cluster (Rancher Desktop or Minikube)
5. Helm
6. PostgreSQL database

### Pre-requisties
Install PostgreSQL in Kubernetes using Helm charts

`helm repo add bitnami https://charts.bitnami.com/bitnami`

`helm repo update`

`helm install postgresql bitnami/postgresql`

### Build the Project
Navigate to the project directory and run:

`mvn clean install`

### Run the Application
`mvn spring-boot:run`

### Access the Application 
Open your browser and navigate to http://localhost:8000/users.


### Build the Docker Image
Run the following command to build the Docker image:

`docker build -t demo .`

### Run the Docker Container
Run the Docker container to test the image:

`docker run -p 8000:8000 demo`


### Deploying on Kubernetes using Helm

`helm install demo deployment/demo`

I have pushed a working docker image at https://hub.docker.com/r/amanwork6/demo