ARG JAR_FILE

FROM eclipse-temurin:17-jre-alpine

ENV APP $JAR_FILE

RUN apk update && apk add dumb-init curl jq

WORKDIR /srv/hello_world

COPY $APP .
COPY run_application.sh .
RUN chmod +x run_application.sh

ENV USER=exie
ENV GROUP=party
ENV LOG_FOLDER=/srv/hello_world/logs

RUN addgroup -S $GROUP && adduser -S -D -H $USER -G $GROUP
RUN mkdir -p $LOG_FOLDER && chgrp $GROUP $LOG_FOLDER && chmod g+rwx $LOG_FOLDER

USER $USER

EXPOSE 8080

ENTRYPOINT ["/usr/bin/dumb-init", "--"]
CMD ["/srv/hello_world/run_application.sh"]