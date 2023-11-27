
FROM tomcat:9.0.80-jre11-temurin 
COPY target/codepostal.war /usr/local/tomcat/webapps/
EXPOSE 8080
ENV DT_RELEASE_VERSION 1.2.3
ENV DT_RELEASE_BUILD_VERSION 202311291648
ENV DT_RELEASE_PRODUCT artifact
ENV DT_RELEASE_STAGE production
COPY setenv.sh /usr/local/tomcat/bin/setenv.sh
 
