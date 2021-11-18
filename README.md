## About this project
In this project I want to show my skills in Java, Hibernate, Spring core Spring Web and Spring 
Security.
~~~
Completed structure of project is described below



*Firstly, in this application already exist 
two 




two ysers
- Username "vlad@gmail.com" Password "1234" with role ADMIN
- Username "user@gmail.com" Password "1234" with role USER
Yoy can register new users using Post method to url /register with body like

 



*Inside the application, you can create new Drivers, Manufacturers, Cars, and add Drivers to Cars.
*You can also view list of existing Drivers, Manufacturers, and Cars.
*You can delete Drivers, Manufacturers, and Cars.
*Application doesn't allow you to create Drivers with same License Numbers 
(License Number must be in particular format) or Manufacturers with same names.
~~~    
You can test the application by using the following url
[https://tranquil-eyrie-87870.herokuapp.com/](https://tranquil-eyrie-87870.herokuapp.com/)

## Technologies which I used
Project is created with:
```
* Java 11
* MySQL
* Maven
* Hibernate
* Spring (Core, Web, Security)
* Tomcat 9.0.50 (to run app locally. But you can run this app without installing Tomcat, see below)
```

## Setup
You should install MySQL or another DB

Fork this project and clone it.

Now there is dependency "MySQL DB" in `pom.xml`.
~~~
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.22</version>
</dependency>
~~~
If you have another DB, you should change this dependency to better fit your DB.

Also, in the file `src/main/resources/db.properties` you should fill correct values in these fields
~~~
    db.driver = "**DRIVER_NAME**";
    db.url = "**URL**";
    db.user = "**USER**";
    db.password = "**PASSWORD**";
~~~

We can run this application without installing Tomcat by using next command
~~~
mvn clean package
java -jar target/dependency/webapp-runner.jar target/*.war
~~~


