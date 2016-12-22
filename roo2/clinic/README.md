psql -h localhost -U postgres

```sql
CREATE DATABASE northwind
WITH OWNER = postgres
        ENCODING = 'UTF8'
        TABLESPACE = pg_default
        LC_COLLATE = 'pt_BR.UTF-8'
        LC_CTYPE = 'pt_BR.UTF-8'
    CONNECTION LIMIT = -1
   TEMPLATE template0;
\q
```

```sh
roo2 < clinic-p1.roo
nano src/main/resources/application.properties
roo2 < clinic-p2.roo
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
