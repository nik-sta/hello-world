FROM openjdk:11-jdk

WORKDIR /home/app

ENV JAVA_OPTS -Xms128m -Xmx300m -Xss512k -XX:CICompilerCount=2 -XX:+UseContainerSupport -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000

COPY $JAR_NAME/*.jar $JAR_NAME.jar

ENV PORT 8080
EXPOSE $PORT
EXPOSE 8000

CMD [ "sh", "-c", "java $JAVA_OPTS -jar $JAR_NAME.jar --bind 0.0.0.0:$PORT" ]
