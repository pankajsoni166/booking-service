FROM openjdk:8
ADD target/booking-service.jar booking-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","booking-service.jar"]