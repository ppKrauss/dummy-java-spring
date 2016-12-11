# dummy-java-spring

This is another "JAVA Spring for dummies", using some [convention over configuration](https://en.wikipedia.org/wiki/Convention_over_configuration) principles to focus on standard and most popular uses. It is also a fast "how-to for UBUNTU 16 LTS".  

# General conventions 
Conventions or project decisions. 
* System (server): **UBUNTU 16 LTS**
* Java version: **Oracle Java8**
* Dependency management system ([build_automation](https://en.wikipedia.org/wiki/Build_automation)): **Maven 3.3**
* SQL:  **PostgreSQL 9.6+** (for JSONb, etc.)
* Spring: **Spring v4**,  [Spring boot](https://projects.spring.io/spring-framework/)
* Spring-client: **AngularJS Material**

# Installing 
Supposing "fresh" system, without any pre-installed tools.

## Preparing UBUNTU

As [digitalocean.com/community/how-to-java-apt](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04):
```sh
sudo apt install git
cd ~
git clone https://github.com/ppKrauss/dummy-java-spring.git
cd  dummy-java-spring
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt install oracle-java8-installer
  #  interface for Oracle license terms, final:
  #  Oracle JRE 8 browser plugin installed; Oracle JDK 8 installed
java -version  # not say any relevant thing, eg. "Java(TM) SE Runtime Environment (build 1.8.0_111-b14)"
update-alternatives --config java # and ENTER; shows /usr/lib/jvm/java-8-oracle/jre/bin/java

#MAVEN 3
sudo apt install maven
mvn -version  # check
```

## Preparing server
... ?

## Preparing Spring

See [Installing Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html) and [Building a RESTful Web Service](http://spring.io/guides/gs/rest-service/)

`mvn package # at dummy-java-spring folder`

See [maven.apache.org/maven-in-five-minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)...
