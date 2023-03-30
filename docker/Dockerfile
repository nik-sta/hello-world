# Making here use of a docker multi-stage build
# https://docs.docker.com/build/building/multi-stage/

# Build-time container
FROM azul/zulu-openjdk-alpine:17.0.6 as builder
ARG JAR_FILE
WORKDIR application
COPY $JAR_FILE application.jar
COPY build_application.sh ./
RUN sh build_application.sh

# Run-time container
FROM alpine:3.17.3

ARG APP_NAME=app
ARG USER=exie
ARG GROUP=party
ARG LOG_FOLDER=/srv/app/logs

ENV APP=$APP_NAME \
    JAVA_HOME=/opt/java \
    PATH="${JAVA_HOME}/bin:${PATH}"

## Adding programs for operation
COPY packages.list /tmp
RUN xargs -r apk -v --update-cache add < /tmp/packages.list && \
    rm -rf /var/cache/apk/* && \
    rm /tmp/packages.list

WORKDIR /srv/$APP

COPY run_application.sh /etc

RUN addgroup -S $GROUP && \
    adduser -S -D -H $USER -G $GROUP && \
    mkdir -p $LOG_FOLDER && \
    chgrp $GROUP $LOG_FOLDER && \
    chmod g+rwx $LOG_FOLDER && \
    chmod +x /etc/run_application.sh

## Application-specif created JRE
COPY --from=builder /opt/java-runtime $JAVA_HOME

## Spring Boot Layers
COPY --from=builder application/spring-boot-loader/ ./
RUN true
COPY --from=builder application/dependencies/ ./
RUN true
COPY --from=builder application/snapshot-dependencies/ ./
RUN true
COPY --from=builder application/application/ ./

USER $USER
ENTRYPOINT ["/usr/bin/dumb-init", "--"]
CMD ["/etc/run_application.sh"]