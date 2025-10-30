FROM openjdk:17
EXPOSE 8080
ADD target/calculate-service.jar calculate-service.jar
ENTRYPOINT ["java","-jar","/calculate-service.jar"]