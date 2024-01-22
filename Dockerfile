FROM openjdk:17

COPY target/your-artifact-id-1.0.0.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","your-artifact-id-1.0.0.jar"]
