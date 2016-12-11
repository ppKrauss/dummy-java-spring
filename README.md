# dummy-java-spring

This is another "JAVA Spring for dummies", a fast how-to for UBUNTU 16 LTS.

## Preparing UBUNTU

As [digitalocean.com/community/how-to-java-apt](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04):
```sh
add-apt-repository ppa:webupd8team/java
sudo apt-get update
apt install oracle-java8-installer
  #  interface for Oracle screems, final:
  #  Oracle JRE 8 browser plugin installed; Oracle JDK 8 installed
java -version  # not say any relevant thing...
update-alternatives --config java # and ENTER; shows /usr/lib/jvm/java-8-oracle/jre/bin/java


#MAVEN 3
apt install maven
mvn -version  # check
```

...
