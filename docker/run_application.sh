#!/bin/sh -l

JAVA_OPTS="-Dfile.encoding=UTF-8"
JAR_FULL_PATH="/srv/hello_world/hello-world.jar"
PORT="8080"

java $JAVA_OPTS -jar $JAR_FULL_PATH --bind 0.0.0.0:$PORT