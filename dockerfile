FROM openjdk:9 AS base

ENV PORT=8888

ENV APP_WD=/home/git

EXPOSE $PORT

WORKDIR $APP_WD

COPY ./target/bitbucket-hooks-1.0-SNAPSHOT.jar $APP_WD

CMD ["java", "-jar", "bitbucket-hooks-1.0-SNAPSHOT.jar"]

# ENTRYPOINT [""]

#foobar



