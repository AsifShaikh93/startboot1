FROM openjdk:17-alpine

EXPOSE 80

ADD target/startboot1.jar startboot1.jar

ENTRYPOINT [ "java","-jar","startboot1.jar" ]

