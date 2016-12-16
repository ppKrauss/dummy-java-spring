(UNDER CONSTRUCTION)

This is a variation of [hello2pg.md](hello2pg.md)...



# Preparing

```sh
cd ~
mkdir testRoo1Hello3pg 
cd testRoo1Hello3pg
```
... create a table as Model reference,

```sql
CREATE TABLE test1 (a integer DEFAULT 99 NOT NULL CHECK(a>1));   
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

...

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

