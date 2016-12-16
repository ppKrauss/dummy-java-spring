
Assuming environment UBUNTU 16 LTS with JAVA 8 and Spring already installed. For more details, see [dummy-java-spring](https://github.com/ppKrauss/dummy-java-spring).

The  [official tutorial spring-roo](http://projects.spring.io/spring-roo/#running-from-shell)  is for Roo version 2.0, and not run with v1.X scripts... So, this is an adaptation.

# Preparing

Check [Roo v1.X most recent version](http://projects.spring.io/spring-roo/#download-widget) and change below when need. Summarizing and **executing all quickly via the terminal**:

```sh
mkdir sandbox # or whatever you like 
cd ~/sandbox
wget -c http://spring-roo-repository.springsource.org.s3.amazonaws.com/release/ROO/spring-roo-1.3.2.RELEASE.zip
unzip spring-roo-1.3.2.RELEASE.zip
mv spring-roo-1.3.2.RELEASE spring-roo-1.3.2
sudo ln -s ~/sandbox/spring-roo-1.3.2/bin/roo.sh /usr/bin/roo
rm *.zip  # optional
```

The demo,
```
cd ~
mkdir hello 
cd hello
```
## script *hello*!

Now just run the command `roo` and (giving ENTER one by one and waiting)

```
project setup --topLevelPackage com.foo
jpa setup --provider HIBERNATE --database HYPERSONIC_IN_MEMORY
entity jpa --class ~.domain.Timer
field string --fieldName message --notNull
repository jpa --all
service --all
web mvc setup
web mvc view setup --type THYMELEAF
web mvc controller --all --responseType THYMELEAF
web mvc controller --all --pathPrefix /api
quit
```
Ok! Run Maven with `mvn spring-boot:run`... At terminal you see  
```
: Started FooApplication in 8.403 seconds (JVM running for 8.917)
```
So, you can run http://localhost:8080 or http://localhost:8080/timers/ that is the application.

To shotdown the server, at the terminal press *^C* to kill, so it say "[INFO] BUILD SUCCESS ...Finished...".
