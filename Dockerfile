FROM openjdk:17-oracle
EXPOSE 8080
VOLUME /tmp
COPY build/libs/rick-and-morty-api-0.0.1-SNAPSHOT.jar rick-and-morty-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/rick-and-morty-api-0.0.1-SNAPSHOT.jar"]