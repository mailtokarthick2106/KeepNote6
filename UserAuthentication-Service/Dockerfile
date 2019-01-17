FROM alpine-jdk:base
MAINTAINER javaonfly
COPY files/UserAuthenticationServiceApplication.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/UserAuthenticationServiceApplication.jar"]
EXPOSE 9500