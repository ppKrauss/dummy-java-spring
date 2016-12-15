This is a variation of [roo_hello.md](roo_hello.md), using PostgreSQL as persistence. Let's call *hello2pg*, the database and the project.

# Preparing

```
cd ~
mkdir hello2pg 
cd hello2pg
```

**Preparing Roo**: as [roo_hello.md](roo_hello.md) preare and use Roo v2, creating the terminal command `roo2`.

**Preparing PostgreSQL**:  suppose standard PostgreSQL user "postgres" with password "postgres". Use `psql -h localhost -U postgres` 
```sql
CREATE DATABASE hello2bd
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

Run `roo2` and use the database "hello2bd":

```
project setup --topLevelPackage com.foo2
jpa setup --provider HIBERNATE --database POSTGRES --databaseName hello2bd
```

Here's a curious problem: do not adink try to include `--username`, even when  TAB say that you can... Run the above. 
It will say "Created ..." and ok... Open another terminal and edit (ex. using `nano`) the file `./src/main/resources/application.properties`

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc\:postgresql\://localhost\:5432/hello2bd
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
```
See that lines *username* and *password* was added.

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
