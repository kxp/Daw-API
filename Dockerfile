FROM openjdk:8-jre

COPY target/dawproject-0.0.1-SNAPSHOT.jar /opt/spring-cloud/lib/

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar", "/opt/spring-cloud/lib/dawproject-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080


#mvn package
#docker build -t kxpto/daw-api:latest .
#docker push kxpto/daw-api:latest
#docker pull  kxpto/daw-api:latest && docker run  --name daw-api -d --restart unless-stopped -p 8080:8080 kxpto/daw-api:latest