FROM openjdk:11.0.11-jre-slim

ARG VERSAO=1.0.0

ADD ./poker-sboot/target/poker-sboot-${VERSAO}.jar app.jar

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5084","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=\"-03:00\"","-jar","/app.jar"]
