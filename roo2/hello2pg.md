This is a variation of [roo_hello.md](roo_hello.md), using PostgreSQL as persistence.... Execept by database connection, all script is the [spring.io/spring-roo/#running-from-shell](http://projects.spring.io/spring-roo/#running-from-shell) fast guide 10 lines example.

Let's call *hello2db*, the database and *Hello2pg* or *testRoo2Hello2pg* the project.

# Preparing

```sh
cd ~
mkdir testRoo2Hello2pg
cd testRoo2Hello2pg
```

**Preparing Roo**: as [roo_hello.md](roo_hello.md) preare and use Roo v2, creating the terminal command `roo2`.

**Preparing PostgreSQL**:  suppose standard PostgreSQL user "postgres" with password "postgres". Use `psql -h localhost -U postgres` 

```sql
CREATE DATABASE hello2db
WITH OWNER = postgres
        ENCODING = 'UTF8'
        TABLESPACE = pg_default
        LC_COLLATE = 'pt_BR.UTF-8'
        LC_CTYPE = 'pt_BR.UTF-8'
    CONNECTION LIMIT = -1
   TEMPLATE template0;
\q
```

## The project

Run `roo2` and use the database "hello2db":

```
project setup --topLevelPackage com.testroo2Hello2pg
jpa setup --provider HIBERNATE --database POSTGRES --databaseName hello2db --userName postgresql --password postgres
```

Here's a curious problem: sometimes run, sometimes `--username`and `--password` are not permited... If you have this curious problem, a reboot machine is a solution :-) ... Another solution is to run the above and wait: it will say "Created ...", it is ok... Open another terminal and edit (ex. using `nano`) the file `./src/main/resources/application.properties`

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc\:postgresql\://localhost\:5432/hello2db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto=create-drop
```
See that lines *username* and *password* was added.
Another importantant issue, that is perhaps a Roo v2 bug, is that you need to add (by hand) the magic line `spring.jpa.hibernate.ddl-auto=create-drop` (thanks to  [jcgarcia answer](http://stackoverflow.com/a/41180447)).

Now we can back to the first terminal running *roo* and continue,

```
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
Finesh with `mvn spring-boot:run`!
Go to your http://localhost:8080/timers/
