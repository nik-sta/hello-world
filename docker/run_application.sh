#!/bin/sh

JAVA_OPTS="${JAVA_OPTS:="-Dfile.encoding=UTF-8 -Duser.timezone=UTC -XX:NativeMemoryTracking=summary -XX:+HeapDumpOnOutOfMemoryError"}"
PORT="${PORT:="8080"}"

cd /srv/"$APP" || exit
/opt/java/bin/java $JAVA_OPTS org.springframework.boot.loader.JarLauncher --bind 0.0.0.0:$PORT