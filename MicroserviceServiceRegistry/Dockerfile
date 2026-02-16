FROM openjdk:27-ea-trixie
COPY target/*.jar ServiceRegistryDemo.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","ServiceRegistryDemo.jar"]
