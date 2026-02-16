FROM openjdk:27-ea-trixie
COPY target/*.jar MicroserviceAPIGateway.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","MicroserviceAPIGateway.jar"]
