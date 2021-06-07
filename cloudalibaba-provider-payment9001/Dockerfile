FROM openjdk:8-jdk-alpine
#VOLUME /tmp
WORKDIR /app
ARG JAR_FILE=target/payment9001.jar
ADD ${JAR_FILE} app.jar
#ADD target/payment8002.jar payment8002.jar
#RUN java -Djarmode=layertools -jar app.jar extract && rm app.jar

#RUN echo "Asia/Shanghai” > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata


EXPOSE 9001

ENTRYPOINT ["java","-jar","app.jar"]