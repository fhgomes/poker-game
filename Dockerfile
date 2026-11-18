FROM eclipse-temurin:11.0.33_10-jre@sha256:7db5776af2396377c8aae2aa124712da7b72a5b6b014c17d77ae37eb5276f37b

ARG VERSAO=1.0.0

ADD ./poker-sboot/target/poker-sboot-${VERSAO}.jar app.jar

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5084","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=\"-03:00\"","-jar","/app.jar"]
