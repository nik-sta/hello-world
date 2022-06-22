# Making here use of a docker multi-stage build
# https://docs.docker.com/develop/develop-images/multistage-build/

# Build-time container
FROM eclipse-temurin:17.0.3_7-jre-alpine as builder
WORKDIR application
ARG JAR_FILE
COPY $JAR_FILE application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# Run-time container
FROM eclipse-temurin:17.0.3_7-jre-alpine

ARG APP_NAME=app
ARG USER=exie
ARG GROUP=party
ARG LOG_FOLDER=/srv/app/logs

ENV APP=$APP_NAME

## Adding programs for operation
RUN apk update && \
    apk add dumb-init curl jq && \
    rm -rf /var/cache/apk/*

WORKDIR /srv/$APP

COPY run_application.sh /etc

RUN addgroup -S $GROUP && \
    adduser -S -D -H $USER -G $GROUP && \
    mkdir -p $LOG_FOLDER && \
    chgrp $GROUP $LOG_FOLDER && \
    chmod g+rwx $LOG_FOLDER && \
    chmod +x /etc/run_application.sh

## Spring Boot Layers
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

USER $USER
ENTRYPOINT ["/usr/bin/dumb-init", "--"]
CMD ["/etc/run_application.sh"]