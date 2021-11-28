# NAGP DEVOPS DEMO PROJECT


Clone this Git repository : https://github.com/ramanjha001/nagp-devops-assignment.git

Steps to test cases:

1. To Run only unit test : `mvn clean test`
2. To Run only integration test : `mvn integration-test -DskipUnitTests`
3. To Run both unit and integration test together : `mvn clean verify` 


Steps to run user-service and mysql in container using docker images:

1. Pull mysql : `docker pull mysql`
2. Run mysql container using mysql image :  `docker run --name devops-mysql --rm -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=ramanjha mysql`
3. Build docker image of created service : `docker build -t devops-nagp-userservice .`
4. Run container using  devops-nagp-userservice image : `docker run -p 8085:8085 --link devops-mysql:mysql --rm --name devops-mysql-assignment devops-nagp-userservice`

Steps to run user-service and mysql in container using docker compose:

1. To run both my-sql and userservice container using docker-compose.yml : `docker-compose up`
2. To stop containers using docker-compose.yml : `docker-compose down`
