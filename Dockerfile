FROM eclipse-temurin:17.0.9_9-jre

MAINTAINER Ed Sweeney <ed@onextent.com>

EXPOSE 8080

RUN mkdir -p /app

COPY target/scala-2.12/*.jar /app/

WORKDIR /app

# override CMD from your run command, or k8s yaml, or marathon json, etc...
CMD java -Dlog4j2.formatMsgNoLookups=true -jar ./LotsOfNamesApi.jar

