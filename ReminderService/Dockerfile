FROM alpine-jdk:base
MAINTAINER javaonfly
COPY files/ReminderServiceApplication.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/ReminderServiceApplication.jar"]
EXPOSE 9500