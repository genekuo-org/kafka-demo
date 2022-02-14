# Source Code for Kafka Demo

## Notes

Here are some notes regarding the source code:

### Requirements
This project was built with the following versions:

1. Java 11
2. Apache Maven 3.6.x.
We tried to provide [Maven Wrapper](https://github.com/takari/maven-wrapper), so you don't need to install Maven yourself hopefully.

### How to build

Run following command in the root of this project to build all examples:

    ./mvnw verify

Run following command in the root of this project to build specific example.
For example, to build only examples from Chapter 12 run:

    ./mvnw --projects 1-producer verify

### IDE setup

1. We have used Eclipse for our IDE. To set up for eclipse run mvn eclipse:eclipse from the base directory of this repo. Or, you can Import->Existing Maven Projects.


### Installing, Running, and Stopping Kafka

### Running the examples

Most of the example programs can be run from within an IDE or from the command line. Make sure that your ZooKeeper and Kafka Brokers are up and running before you can run any of the examples.

The examples will usually write out to topics and print to the console.

### Shell Scripts

They include:

* `starteverything.sh` //This will start your ZooKeeper and Kafka Brokers (you will still have to go through the first time setup with Appendix A before using this.)
* stopeverything.sh // Will stop ZooKeeper and your brokers
* portInUse.sh // If you get a port in use error on startup, this script will kill all of the processes using those ports
## Important Notice

* Apache, Apache Kafka, and Kafka are trademarks of the Apache Software Foundation.
