FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/app-spring-boot-client-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY fiztec.com.cer $JAVA_HOME/lib/security
RUN cd $JAVA_HOME/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias ssl-spring-boot-api -file fiztec.com.cer
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080