(UNDER CONSTRUCTION)

This is a variation of [hello2pg.md](hello2pg.md)...

# Preparing

```sh
cd ~
mkdir testRoo1Hello3pg 
cd testRoo1Hello3pg
```
... create two test tables, using `psql -h localhost -U postgres hello2db`, 

```sql
CREATE TABLE test1 (
	a integer DEFAULT 99 NOT NULL CHECK(a>1), 
	hellomum text, -- for search the string "hellodad" in a grep of generated java
	UNIQUE(a)  -- to be referenced as PK, need it.
);   

CREATE TABLE test2 (
	id serial NOT NULL PRIMARY KEY, 
	a integer NOT NULL REFERENCES test1(a) ON DELETE CASCADE, 	
	hellodad text, -- for search the string "hellodad" in a grep of generated java 
	jpure JSON,   -- some exoctic types, for test the "power of recognition" in Root.
	jbin JSONb, 
	xtext xml
);
```

## The project

Run `roo` and use the database "hello2db":

```
project --topLevelPackage   com.testRoo1Hello2pg
jpa setup --provider HIBERNATE --database POSTGRES --databaseName hello2db --userName postgres --password postgres
database reverse engineer --schema public --includeTables "test1 test2"
quit
```
There are a JAVA code! See it at the generated folder `src/... `  or a dump [here at Wiki](https://github.com/ppKrauss/dummy-java-spring/wiki/Generated-codes-for-testRoo1Hello3pg), to compare your results.

## WORKAROUNDS

### After `jpa setup` some handle config 

The `jpa setup` command generates a warning *"Please update your database details in src/main/resources/META-INF/spring/database.properties"*, so, let's  update: add  in another terminal (ex. with `nano`) the second block of `spring.jpa` lines:

```
database.driverClassName=org.postgresql.Driver
database.url=jdbc\:postgresql\://localhost\:5432/hello2db
database.username=postgresql
database.password=postgres

spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto=create-drop
```

### Errors  at `database reverse engineer`
After try to generate code with  `database reverse engineer --schema public --includeTables "test1 test2"`

is possible errors, in a first Roo use. This is a dump of the message:

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
So, [as remembered by jcgarcia here](http://stackoverflow.com/a/41199193/287948), *"... if your read the message, you could check that you are able to use the following command to install the Postgres JDBC driver into the OSGi context"*. Let's use also some knowledge about it:

* `addon info id --searchResultId 01` list info of the PostgreSQL Driver, confirming that it's ID is 01.

* `addon install id --searchResultId 01`  will in fact install the driver (!)

* `addon install bundle --bundleSymbolicName 01` or `addon install bundle --bundleSymbolicName postgresql-jdbc4` ... error .. but ok... is working....

Now you can do the Roo command,
```
database reverse engineer --schema public --includeTables "test1 test2"
```
