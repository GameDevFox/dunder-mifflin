FROM frolvlad/alpine-oraclejdk8:slim
COPY ./build/libs/dunder-mifflin-*.jar app.jar
CMD ["java","-jar","/app.jar"]