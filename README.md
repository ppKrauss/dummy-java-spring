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
Avoid to use a pre-defined `pow.xml` whille you is a dummy ;-)
Create your `pom.xml` from http://start.spring.io/  
in a folder `myproject` and run it (in the folder) with 
   `mvn install`
Result in something like,

```
...
[INFO] Installing /home/peter/dummy-java-spring/myproject/pom.xml to ...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 17.878 s
[INFO] ...
```

## Preparing your IDE
Convention: Atom, Eclipse or IntelliJ IDEA. 

Installing Idea. 

1. Go at [jetbrains.com/idea](http://www.jetbrains.com/idea/) and press "Download", and select eg. "Ultimate", and download it as "Linux without JDK",

2. [download-thanks linuxWithoutJDK](http://www.jetbrains.com/idea/download/download-thanks.html?platform=linuxWithoutJDK)

3. at downloaded folder you have something like `ideaIU-2016.3-no-jdk.tar.gz`, so ...

# Next steps

... See [Installing Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html) and [Building a RESTful Web Service](http://spring.io/guides/gs/rest-service/)

`mvn package # at dummy-java-spring folder`

See [maven.apache.org/maven-in-five-minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)...

# ROO!

The [Spring Roo project](http://projects.spring.io/spring-roo/) is the best! [Roo1.3.X is stable](http://projects.spring.io/spring-roo/#download-widget), and [Roo v2-RC1](https://jira.spring.io/browse/ROO/?selectedTab=com.atlassian.jira.jira-projects-plugin:summary-panel) is near!

For you, a dummy, see how to start with **Roo2**

* [hello.md](roo2/hello.md), the 10-lines oficial Roo2 test-and-demo script. 

* [hello2pg.md](roo2/hello2pg.md) for PostgreSQL persistence.

* [hello3pg.md](roo2/hello3pg.md) for Roo's `database reverse engineer` ([docs.spring's Chapter 9](http://docs.spring.io/spring-roo/reference/html/base-dbre.html)), your first test-and-demo for SQL reengineering.

To test Roo v1, the same adapted for **Roo1** env,

* [hello.md](roo1/hello.md), an adaptation for Roo1, of the 10-lines oficial Roo2 test-and-demo script. 

* [hello2pg.md](roo1/hello2pg.md) for PostgreSQL persistence.

* [hello3pg.md](roo1/hello3pg.md) for Roo's `database reverse engineer`.
