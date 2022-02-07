# Spring Apache Kafka
Spring for Apache Kafka Examples

This repository is to demonstrate the Apache Kafka with Spring for Apache Kafka

**Apache Kafka Workspace Setup**
Workspace setup is a 4 step process
1. Install Java 8 or higher and download the Apache Kafka distributution
2. Set the PATH variable for Apache Kafka
3. Make some changes in the Apache Kafka configurations so that it can run locally
4. Finally run Kafka

**Step#1**
-> Install Java 8 or Latest java which is supported by the Kafka version you want to user

-> Download the latest Apache Kafka from “https://kafka.apache.org/downloads”

-> Use the latest Kafka Binary downloads and latest Scala

**Step#2** 
**Installation steps for MAC OS**
-> Extract it to the home directory.

-> Set the Apache Kafka Home Path and bin path in the path variables.

-> Use the following steps to set the path

-> Execute the command from terminal under home directory “nano .zshrc”

-> Paste the below two lines and then save the file.

-> export APACHE_KAFKA_HOME=/Users/venugopal/kafka_2.13-3.0.0

-> export PATH=$PATH:$APACHE_KAFKA_HOME/bin

-> Close the terminal and open a new terminal and check the path.

-> echo $APACHE_KAFKA_HOME

**Step#3** **Config Changes**
Make some changes to the zookeeper.properties and server.properties under APACHE_KAFKA_HOME/config folder. Below are the changes

**zookeeper.properties**
Edit the APACHE_KAFKA_HOME/config/zookeeper.properties file and update the below property value.
dataDir=/Users/venugopal/kafka_2.13-3.0.0/data/zookeeper

**server.properties**
Edit the APACHE_KAFKA_HOME/config/server.properties file and update the below property value.
log.dirs=/Users/venugopal/kafka_2.13-3.0.0/data/kafka
listeners=PLAINTEXT://0.0.0.0:9092
advertised.listeners=PLAINTEXT://localhost:9092

**Step#4** **Run the Kafka**
Running Kafka is a two step process
First start the zookeeper and keep open the terminal
Second start the Kafka server and keep open the terminal
Open a third terminal and use the CLI

**Zookeeper**
zookeeper-server-start.sh $APACHE_KAFKA_HOME/config/zookeeper.properties

**Kafka server**
kafka-server-start.sh $APACHE_KAFKA_HOME/config/server.properties

