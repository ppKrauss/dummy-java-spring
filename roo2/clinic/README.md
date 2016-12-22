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

roo2 < clinic-p1.roo
nano ... edit database setings

roo2 < clinic-p2.roo
