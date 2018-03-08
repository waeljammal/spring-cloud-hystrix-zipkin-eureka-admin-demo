FROM openjdk:8u151-jre-alpine
MAINTAINER Wael Jammal <waeljammal@msn.com>

EXPOSE 8080

ENV JAVA_OPTS="-XX:MaxRAMFraction=1 \
               -XX:+UnlockExperimentalVMOptions \
               -XX:+UseCGroupMemoryLimitForHeap \
               -XX:+UseG1GC"

ADD ./target/*.jar app.jar
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.0.0/wait /wait
RUN chmod +x /wait
CMD /wait && java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
