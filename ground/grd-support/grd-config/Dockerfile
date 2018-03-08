FROM openjdk:8u151-jre-alpine
MAINTAINER Wael Jammal <waeljammal@msn.com>

EXPOSE 8888

ENV JAVA_OPTS="-XX:MaxRAMFraction=1 \
               -XX:+UnlockExperimentalVMOptions \
               -XX:+UseCGroupMemoryLimitForHeap \
               -XX:+UseG1GC"

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
