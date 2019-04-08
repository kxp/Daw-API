FROM openjdk:8-jre

COPY target/dawproject-0.0.1-SNAPSHOT.jar /opt/spring-cloud/lib/

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar", "/opt/spring-cloud/lib/dawproject-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080


#mvn package
#docker build -t daw-api:v0.0.1 .
#docker run -it -p 8080:8080 daw-api:v0.0.1