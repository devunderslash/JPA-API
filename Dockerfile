FROM tomcat:9.0-alpine
VOLUME /tmp
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/ROOT.war" ]
