# Setup the environment using Docker Compose
## Admin Server
- The application need to be build using **gradlew bootJar**
- Then run **docker build . -t admin-server** to upload the image to the docker

## Application Properties
- The application need to be build using **gradlew bootJar**
- Then run **docker build . -t admin-server** to upload the image to the docker

## Startig the environment
- Run **docker-compose up -d** to start up all the application in detached mode
