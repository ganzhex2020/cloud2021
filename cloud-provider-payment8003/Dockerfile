FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG JAR_FILEE
#COPY ${JAR_FILEE} app.jar
ADD target/payment8003.jar payment8003.jar


#RUN echo "Asia/Shanghai” > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata

EXPOSE 8003

ENTRYPOINT ["java","-jar","/payment8003.jar"]