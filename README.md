# Docker images
```bash
docker pull mongo:3.4.10
docker pull redis:4.0.6-alpine
docker pull postgres:9.6.6-alpine
```

## Docker network
```bash
docker network create cms-application
docker network create twitter
```

## Docker container commands
```bash
docker run -d --name redis --net twitter -p 6379:6379 redis:4.0.6-alpine
docker run -d --name mongodb --net cms-application -p 27017:27017 mongo:3.4.10
docker run -d --name postgres --net cms-application -p 5432:5432 -e POSTGRES_PASSWORD=cms@springfive postgres:9.6.6-alpine
docker run -d --name mongo-express --link mongodb:mongo--net cms-application -p 8081:8081 mongo-express
```

## Tools
```bash
sudo apt-get install redis-tools -y
sudo apt-get install pgadmin3 -y
```

## Excercise repositories
[Here](https://github.com/PacktPublishing/Spring-5.0-By-Example)
