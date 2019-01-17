FROM alpine-jdk:base
MAINTAINER javaonfly
COPY files/UserServiceApplication.jar /opt/lib/
RUN mkdir /var/lib/config-repo
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/UserServiceApplication.jar"]
VOLUME /var/lib/config-repo
EXPOSE 9200