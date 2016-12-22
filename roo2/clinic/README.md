The [original clinic.roo](https://github.com/spring-projects/spring-roo/blob/master/runtime/classpath/src/main/resources/clinic.roo) was adapted to use with PostgreSQL.

At the `clinic` folder run this sequence of shell commands:

```sh
cd ~/dummy-java-spring/roo2/clinic  # or whatever
psql -h localhost -U postgres < clinic-p1.sql # take password and CREATE DATABASE
roo2 < clinic-p1.roo
nano src/main/resources/application.properties
```

At edit, as in the [hello2pg.md](https://github.com/ppKrauss/dummy-java-spring/blob/master/roo2/hello2pg.md), add the "create-drop" directive,

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.password=postgres
spring.datasource.url=jdbc\:postgresql\://localhost\:5432/northwind
spring.datasource.username=postgresql
spring.jpa.hibernate.naming.strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto=create-drop  ## add to create tables
```

So, continue

```sh
roo2 < clinic-p2.roo
```
