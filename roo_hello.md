
Assuming environment UBUNTU 16 LTS with JAVA 8 and Spring already installed. For more details, see [dummy-java-spring](https://github.com/ppKrauss/dummy-java-spring).


# Preparing

The  [official tutorial spring-roo/#running-from-shell](http://projects.spring.io/spring-roo/#running-from-shell)  is for Roo version 2.0, and not run with v1.X scripts... 
So, get [Roo 2.0 browsing here](http://projects.spring.io/spring-roo/#download-widget). Tip: write to  `~/sandbox`.

Summarizing and **executing all quickly via the terminal**:

```sh
cd ~/sandbox
wget -c http://spring-roo-repository.springsource.org.s3.amazonaws.com/milestone/ROO/spring-roo-2.0.0.M3.zip
unzip spring-roo-2.0.0.M3.zip
mv spring-roo-2.0.0.M3 spring-roo-2.0.0
sudo ln -s ~/sandbox/spring-roo-2.0.0/bin/roo.sh /usr/bin/roo2
rm *.zip  # optional
```

The demo,
```
cd ~
mkdir hello 
cd hello
```
Now just run the command `roo2` and (giving ENTER one by one and waiting)

## script *hello*!

Now just run the command `roo2` and (giving ENTER one by one and waiting)

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

To shotdown the server, at the terminal press ^C to kill, so it say "[INFO] BUILD SUCCESS ...Finished...".
