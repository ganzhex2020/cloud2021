FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG JAR_FILEE
#COPY ${JAR_FILEE} app.jar
WORKDIR /app
ARG JAR_FILE=target/order80.jar
ADD ${JAR_FILE} app.jar

EXPOSE 80
#RUN echo "Asia/Shanghai” > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata
ENTRYPOINT ["java","-jar","app.jar"]