FROM openjdk:27-ea-trixie
COPY target/*.jar MicroserviceAccount.jar
EXPOSE 9092
ENTRYPOINT ["java","-jar","MicroserviceAccount.jar"]
