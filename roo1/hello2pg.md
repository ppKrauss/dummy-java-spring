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

Now we can back to the first terminal running *roo* and continue,

`database reverse engineer --schema public --includeTables "test1"`

... hum... Errors:

```
Located add-ons that may offer this JDBC driver
2 found, sorted by rank; T = trusted developer; R = Roo 1.3 compatible
ID T R DESCRIPTION -------------------------------------------------------------
01 Y Y 9.1.0.901-1_0001 Postgres #jdbcdriver...
02 Y Y 9.1.0.901_0001 Postgres #jdbcdriver...
--------------------------------------------------------------------------------
[HINT] use 'addon info id --searchResultId ..' to see details about a search result
[HINT] use 'addon install id --searchResultId ..' to install a specific search result, or
[HINT] use 'addon install bundle --bundleSymbolicName TAB' to install a specific add-on version
JDBC driver not available for 'org.postgresql.Driver'
```
 Used 
 
 `sudo apt  install libpostgresql-jdbc-java libpostgresql-jdbc-java-doc`

but not change error ... see http://stackoverflow.com/a/13867021
