FROM openjdk:8-jdk-buster

RUN apt update && apt -y upgrade


#1. Download 2. Unzip 3. delete zip file
RUN wget -O /tmp/glassfish-5.0.0 https://ftp.snt.utwente.nl/pub/software/eclipse/glassfish/glassfish-5.1.0.zip && \
    unzip -o /tmp/glassfish-5.0.0 -d /usr/local && \
    rm -f /tmp/glassfish-5.0.0

EXPOSE 4848 8080 8181

ENV GLASSFISH_HOME=/usr/local/glassfish5/glassfish \
    DEPLOYMENT_DIR=${GLASSFISH_HOME}/domains/domain1/autodeploy \
    PATH=$PATH:/usr/local/glassfish5/glassfish/bin

WORKDIR ${GLASSFISH_HOME}/bin
CMD ["asadmin","start-domain","--verbose"]