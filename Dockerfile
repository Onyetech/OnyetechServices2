FROM openjdk:11
EXPOSE 8080
#LABEL maintainer="onyetech.com"
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]

