FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG JAR_FILEE
#COPY ${JAR_FILEE} app.jar
WORKDIR /app
ARG JAR_FILE=target/server7001.jar
ADD ${JAR_FILE} app.jar


#RUN echo "Asia/Shanghai” > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata

EXPOSE 7001

ENTRYPOINT ["java","-jar","app.jar"]