The original clinic.roo (at distribuition's */samples* folder) was adapted to use with PostgreSQL.

Run this sequence of shell commands:

```sh
cd ~/dummy-java-spring/roo2/clinic  # or whatever
psql -h localhost -U postgres < step1.sql # take password and CREATE DATABASE
roo < step1.roo
nano src/main/resources/META-INF/spring/database.properties
```

At edit, as in the [hello2pg.md](https://github.com/ppKrauss/dummy-java-spring/blob/master/roo2/hello2pg.md), add the "create-drop" directive,

```
database.driverClassName=org.postgresql.Driver
database.url=jdbc\:postgresql\://localhost\:5432/clinic
database.username=postgresql
database.password=postgres

spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto=create-drop
```

So, continue

```sh
roo < step2.roo
```
