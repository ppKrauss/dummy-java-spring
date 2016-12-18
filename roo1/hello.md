
Assuming environment UBUNTU 16 LTS with JAVA 8 and Spring already installed. For more details, see [dummy-java-spring](https://github.com/ppKrauss/dummy-java-spring).

The  [official tutorial spring-roo](http://projects.spring.io/spring-roo/#running-from-shell)  is for Roo version 2.0, and not run with v1.X scripts... So, this is an adaptation.

# Preparing

Check [Roo v1.X most recent version](http://projects.spring.io/spring-roo/#download-widget) and change below when need. 

Skip this step if you have *Roo1* installed. Summarizing and **executing all quickly via the terminal**:

```sh
mkdir sandbox # or whatever you like 
cd ~/sandbox
wget -c http://spring-roo-repository.springsource.org.s3.amazonaws.com/release/ROO/spring-roo-1.3.2.RELEASE.zip
unzip spring-roo-1.3.2.RELEASE.zip
mv spring-roo-1.3.2.RELEASE spring-roo-1.3.2
sudo ln -s ~/sandbox/spring-roo-1.3.2/bin/roo.sh /usr/bin/roo
rm *.zip  # optional
```

Preparing the demo... Needs only a fresh folder:
```
cd ~
mkdir testRoo1Hello1  # or whatever you like 
cd testRoo1Hello1
```

## Roo script for *testRoo1Hello1*!

Now just run the command `roo` and (giving ENTER one by one and waiting)

```
project --topLevelPackage   com.testRoo1Hello1
```
... If an error, run the command `download accept terms of use`... And redo the `project` command above. Coninuing:

```
jpa setup --provider HIBERNATE --database HYPERSONIC_IN_MEMORY
entity jpa --class ~.domain.Timer
field string --fieldName message --notNull
web mvc setup
web mvc controller --class ~.domain.Timer
quit
```  

Ok! Run Maven with `mvn spring-boot:run`... At terminal you see

```
: Started FooApplication in 8.403 seconds (JVM running for 8.917)
```
So, you can run http://localhost:8080 or http://localhost:8080/timers/ that is the application.

To shotdown the server, at the terminal press *^C* to kill, so it say "[INFO] BUILD SUCCESS ...Finished...".

## Abot translations from Roo2 to Roo1

Commenting the "translations" used (here each item is a Roo2 command),

 * `repository jpa --all`. Only removed,  no translation, no need. <br/>Spring Roo1 manages the data access layer using ActiveRecord... However, in Spring Roo2 the data access layer uses Spring Data Repositories. So in Spring Roo1 there's not an equivalent to repository `jpa` command. So just create an entity in Roo1.
 
 * `service --all`. Only removed,  no translation, no need. <br/>Again, Spring Roo1 not use it. Controllers uses entitiy methods directly to access to the database. Also, all the business logic have been implemented in controllers directly.

 * Comands for `THYMELEAF`:  `web mvc view setup` and `web mvc controller`. .. Not need any to replace?

 * `web mvc controller`: adapted .... correct?
 
For original samples, see `~/sandbox/spring-roo-1.3.2/samples`.

For more details, see [jcgarcia tips](http://stackoverflow.com/a/41199107/287948).
