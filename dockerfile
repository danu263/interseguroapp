FROM openjdk:11

COPY target/*.jar /

EXPOSE 8082:8082

WORKDIR /

ENTRYPOINT java -jar *.jar

