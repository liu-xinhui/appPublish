FROM openjdk:8-jdk-alpine
MAINTAINER liunewshine@qq.com

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && mkdir -p /my-app
WORKDIR /my-app

EXPOSE 8060

ADD ./target/appPublish.jar ./
CMD java -Djava.security.egd=file:/dev/./urandom -jar appPublish.jar
