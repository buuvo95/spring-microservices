FROM openjdk:17-slim as build

COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "/account-0.0.1-SNAPSHOT.jar"]


# for build
# docker build . -t bbank-project/account