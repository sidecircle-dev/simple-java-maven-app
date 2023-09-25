#FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
#WORKDIR /opt
#ENV PORT 8080
#EXPOSE 8080
#COPY target/*.jar /opt/app.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

FROM tomcat:9.0-jdk21-openjdk 
COPY target/hello.war /var/lib/tomcat9/webapps/
#COPY  target/hello.war /usr/local/tomcat/webapps/
EXPOSE 8080
#CMD["catalina.sh","run"]
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

