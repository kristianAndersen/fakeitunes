FROM openjdk:15
ADD target/fakeitunes-0.0.1.jar fakeitunes-0.0.1
ENTRYPOINT ["java", "-jar", "fakeitunes-0.0.1.jar"]