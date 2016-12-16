(UNDER CONSTRUCTION)

This is a variation of [hello.md](hello.md), using PostgreSQL as persistence.... Execept by database connection, all script is the [spring.io/spring-roo](http://projects.spring.io/spring-roo/#running-from-shell) fast guide 10 lines example.

Let's call *hello2db* the database and *hello2pg* the project.

# Preparing

```sh
cd ~
mkdir testRoo1Hello2pg 
cd testRoo1Hello2pg
```

**Preparing Roo**: as [hello.md](hello.md) preare and use Roo v1, creating the terminal command `roo`.

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

Run `roo` and use the database "hello2db":

```
project --topLevelPackage   com.testRoo1Hello2pg
jpa setup --provider HIBERNATE --database POSTGRES --databaseName hello2db --userName postgresql --password postgres
```
The last command generates a warning "Please update your database details in src/main/resources/META-INF/spring/database.properties", so, let's  update: add  in another terminal (ex. with `nano`) the second block of `spring.jpa` lines:

```
database.driverClassName=org.postgresql.Driver
database.url=jdbc\:postgresql\://localhost\:5432/hello2db
database.username=postgresql
database.password=postgres

spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto=create-drop
```
....
