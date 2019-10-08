# Kotlin Klub API

### Getting started

Requires [MySQL](https://www.mysql.com) v5.7.
Install MySQL and add to your path

```sh
$ brew services start mysql@5.7
$ echo 'export PATH="/usr/local/opt/mysql@5.7/bin:$PATH"' >> ~/.zshrc
```

Start MySQL
```sh
$ brew services start mysql@5.7
```

Set MySQL passsword to **mysql** 
Note: This is important as the application needs to know the password for the root user

```sh
$ mysql_secure_installation
```

Connect to MySQL shell (you will be prompted to use the password that was set above)
```sh
$ mysql -u root -p
```
While in the MySQL shell, create a database
```sh
mysql> create database kotlin_klub;
```
Optional: Download [Sequel Pro](https://www.sequelpro.com) for a MySQL GUI.

### Intellij

Open the project using the file menu. Intellij should start auto importing dependencies and create a run configuration. 

The gradle wrapper can also be used to import dependencies and run the app using:

```shµ
$ ./gradlew bootrun
```

Either using the Intellij run configuration or gradle, the app should be running on http://localhost:8070

Hit http://localhost:8070/version to verify