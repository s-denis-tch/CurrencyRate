FROM amazoncorretto:8
COPY build/libs/gif-service.jar /opt/gif-service.jar
EXPOSE 8080 8787
ENTRYPOINT java -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=n -jar -Djava.security.egd=file:/dev/./urandom /opt/gif-service.jar
