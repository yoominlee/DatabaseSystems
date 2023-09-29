# DatabaseSystems

## First sub-project
: database installation and JDBC connection establishment   
(related files: /jdbc_connection/*)

### Prerequisites
- Virtual Machine program (I used virtual box)
    - https://www.virtualbox.org/wiki/Downloads
    - VM setting
        - memory : 4096MB (2~4 recommended)
        - disk : 25GB (more than 16GiB recommended)
        - CPU : 1 (usually less than half of machine's CPU is selected)
- Ubuntu 22.04 image file (.iso)
    - https://releases.ubuntu.com/22.04/

> terminal opening error   
> (Vertualbox 'Unattended Install' related problem)
> 

### Installing PostgreSQL

#### Update registered packaging lists
```
$ sudo apt-get update
```

#### PostgreSQL version upgrade
```
$ sudosh-c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release-cs)-pgdgmain" > /etc/apt/sources.list.d/pgdg.list
$ wget--quiet -O -https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudoapt-key add --
$ sudo apt update
```





execute example:

```
$ javac First.java
$ java First
Hello, DB!
```
: Test JAVA after installing JDK

```
$ psql

```

```
$ javac -cp ':/usr/lib/jvm/java-8-openjdk-amd64/lib/postgresql-42.6.0.jar' PostgresWithJDBCConnection.java
$ java -cp ':/usr/lib/jvm/java-8-openjdk-amd64/lib/postgresql-42.6.0.jar' PostgresWithJDBCConnection
Connection established successfully
$ javac -cp ':/usr/lib/jvm/java-8-openjdk-amd64/lib/postgresql-42.6.0.jar' PostgresWithJDBCInsert.java
$ java -cp ':/usr/lib/jvm/java-8-openjdk-amd64/lib/postgresql-42.6.0.jar' PostgresWithJDBCInsert
record inserted successfully
$ psql
psql (14.9(Ubuntu 14.9-0ubuntu0.22.04.1))
Type "help" for help.

yoomin=# select * from student;
 roll |  name  | section |      created_date 
------+--------+---------+-------------------------
    6 | Arnold | A       | 2023-09-29 10:55:33.812
yoomin=# exit
```

- yoomin is name for ubuntu user, postgreSQL user and database in postgreSQL
- 
