FROM amazoncorretto:8-alpine3.14

COPY target/devops-nagp-assignment.jar /var/lib/devops-nagp-assignment.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/var/lib/devops-nagp-assignment.jar"]
