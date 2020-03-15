FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    APP_SLEEP=5 \
    JAVA_OPTS=""

RUN adduser -D -s /bin/sh user
WORKDIR /home/user

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown user:user entrypoint.sh
USER user

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8081 5701/udp

ADD *.war app.war

