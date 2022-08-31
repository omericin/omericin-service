FROM openjdk:11
ADD target/phoneswap-service.jar phoneswap-service.jar
ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=mongodb://mongoservice:27017/phoneselling","-Djava.security.egd=file:/dev/./urandom" ,"phoneswap-service.jar"]
EXPOSE 8080