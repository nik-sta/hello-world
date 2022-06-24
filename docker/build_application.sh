#!/bin/sh -l

JAR_FILE=application.jar
if [ ! -f "$JAR_FILE" ]; then
    echo "build.error: application jar is missing!"
    exit 1
fi

jar xf application.jar
REQUIRED_JAVA_MODULES="$(jdeps \
                            --print-module-deps \
                            --ignore-missing-deps \
                            --recursive \
                            --multi-release 17 \
                            --class-path="./BOOT-INF/lib/*" \
                            --module-path="./BOOT-INF/lib/*" \
                            ./application.jar)"

if [ -z "$REQUIRED_JAVA_MODULES" ]; then
    echo "build.error: required java modules are not determined!"
    exit 1
fi

jlink \
  --no-header-files \
  --no-man-pages \
  --compress 2 \
  --add-modules "${REQUIRED_JAVA_MODULES}" \
  --output /opt/java-runtime

java -Djarmode=layertools -jar application.jar extract

exit 0