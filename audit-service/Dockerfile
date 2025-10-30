FROM openjdk:17
EXPOSE 8080
ADD target/audit-service.jar audit-service.jar
ENTRYPOINT ["java","-jar","/audit-service.jar"]