## Guide for installing DB and JDBC connection 
### Prerequisites
- Virtual Machine program (I used virtual box)
    - https://www.virtualbox.org/wiki/Downloads
    - VM setting
        - memory : 4096MB (2~4 recommended)
        - disk : 25GB (more than 16GiB recommended)
        - CPU : 1 (usually less than half of machine's CPU is selected)
- Ubuntu 22.04 image file (.iso)
    - https://releases.ubuntu.com/22.04/

> ERROR: Terminal opening error   
> (Vertualbox 'Unattended Install' related problem)
>    
> SOLUTION :
> Ubuntu Settings > Region & Language
> change 'English' to 'English(Canada)' and reboot

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
#### Install PostgreSQL
```
$ sudoapt-get install postgresql-14 postgresql-client-14
```
#### Execute PostgreSQL
Login with postgres account
```
$ sudo –i –u postgres
```
Execute psql terminal
```
$ psql

psql (14.9(Ubuntu 14.9-0ubuntu0.22.04.1))
Type "help" for help.

postgres=#
```
Make new account for user & Login with postgres account
```
(name)@ubuntu $ sudo -i -u postgres
postgres@ubuntu $
```
Create user account and db for 'me'
- username and db name should be same
```
$ createuser --interactive
...
$ createdb <name>
```
Logout
```
postgres@ubuntu $ exit
(name)@ubuntu $ 
```
(skip) password settings (access postgresql with yoomin account)   
yoomin=# ALTER USER yoomin1 WITH PASSWORD '****';


### Installing JDK

#### Install JDK for Ubuntu server
```
$ sudoapt install openjdk-8-jdk-headless
```
#### Download jdbc jar file
```
$ wget https://jdbc.postgresql.org/download/postgresql-42.6.0.jar
$ sudo mv postgresql-42.6.0.jar /usr/lib/jvm/java-8-openjdk-amd64/lib/
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

psql (14.9(Ubuntu 14.9-0ubuntu0.22.04.1))
Type "help" for help.

yoomin=# CREATE TABEL STUDENT
yoomin=# (
yoomin=#        ROLL integer NOT NULL Primary Key,
yoomin=#        NAME varchar(100) NOT NULL,
yoomin=#        SECTION varchar(2) NOT NULL,
yoomin=#        CREATED_DATE TIMESTAMP NOT NULL
yoomin=# );

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
