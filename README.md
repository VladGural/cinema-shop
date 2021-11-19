## About this project
In this project I want to show my skills in Java, Hibernate, Spring Core, Spring Web and Spring 
Security.

This project simulates common ticket-purchase apps, authentication is supported.<br>
You can test the application by using the following url
[https://tranquil-eyrie-87870.herokuapp.com/](https://tranquil-eyrie-87870.herokuapp.com/)

Completed structure of project is described below

![pic](Hibernate_Cinema_Uml.png)

- Configure role access to specific resources for `ADMIN` and for `USER` looks like.

`POST` /register - `ALL`<br>
`GET` /cinema-halls - `USER`/`ADMIN`<br>
`POST` /cinema-halls - `ADMIN`<br>
`GET` /movies - `USER`/`ADMIN`<br>
`POST` /movies - `ADMIN`<br>
`GET` /movie-sessions/available - `USER`/`ADMIN`<br>
`POST` /movie-sessions - `ADMIN`<br>
`PUT` /movie-sessions/{id} - `ADMIN`<br>
`DELETE` /movie-sessions/{id} - `ADMIN`<br>
`GET` /users/by-email - `ADMIN`<br>
`PUT` /shopping-carts/movie-sessions - `USER`<br>
`GET` /shopping-carts/by-user - `USER`<br>
`GET` /orders - `USER`<br>
`POST` /orders/complete - `USER`<br>


* Firstly, in this application already exist two users

  Username `"vlad@gmail.com"` Password `"1234"` with role `ADMIN` 

  Username `"user@gmail.com"` Password `"1234"` with role `USER`

  Yoy can register new users using `Post` request to url `/register` with body like
~~~
  {
    "email": "UserName@gmail.com",
    "password": "1234",
    "repeatPassword": "1234"
  }
~~~

  You also can receive user using `Get` request to url `/users/by-email?email=vlad@gmail.com`
  You should have role `ADMIN`


* You can add new Movie using `Post` request to url `/movies` with body like
~~~
  {
  "title": "Name of Movie",
  "description": "About this movie"
  }
~~~
  You should have role `ADMIN` 

  You also can receive all movies using `Get` request to url `/movies`
  You should have role `ADMIN` or `USER`


* You can add new CinemaHall using `Post` request to url `/cinema-halls` with body like
~~~
  {
  "capacity": 100,
  "description": "About this Hall"
  }
~~~
  You should have role `ADMIN`

  You also can receive all cinema halls using `Get` request to url `/cinema-halls`
  You should have role `ADMIN` or `USER`


* You can add new Movie Sessions using `Post` request to url `/movie-sessions` with body like
~~~
  {
  "movieId": 1,
  "cinemaHallId": 1,
  "showTime": "20.11.2021 17:00"
  }
~~~
  You should have role `ADMIN`

  You also can update Movie Session using `Put` request to url `/movie-sessions/{id}` with body like
~~~
  {
  "movieId": 2,
  "cinemaHallId": 1,
  "showTime": "20.11.2021 20:00"
  }
~~~
  You should have role `ADMIN`

  You also can delete Movie Session using `Delete` request to url `/movie-sessions/{id}`
  You should have role `ADMIN`

  You also can receive all available Movie Session using `Get` request to url 
  `/movie-sessions/available?movieId=1&date=20.11.2021`
  You should have role `ADMIN` or `USER`


* You can add new Movie Sessions (Ticket) to your Shopping-Cart using `Put` request to url
  `/shopping-carts/movie-sessions?movieSessionId=1`
  You should have role `USER`

  You also can receive information from your Shopping-Cart using `Get` request to url
  `/shopping-carts/by-user`
  You should have role `USER`


* You can complete your Order using `Post` request to url `/orders/complete`
  You should have role `USER`

  You also can receive information about your Orders using `Get` request to url `/orders`
  You should have role `USER` 


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
* You should install MySQL or another DB

* Fork this project and clone it.

* Now there is dependency "MySQL DB" in `pom.xml`.
~~~
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.22</version>
</dependency>
~~~
If you have another DB, you should change this dependency to better fit your DB.

* Also, in the file `src/main/resources/db.properties` you should fill correct values in these 
  fields
~~~
    db.driver = "**DRIVER_NAME**";
    db.url = "**URL**";
    db.user = "**USER**";
    db.password = "**PASSWORD**";
~~~

* We can run this application without installing Tomcat by using next command
~~~
mvn clean package
java -jar target/dependency/webapp-runner.jar target/*.war
~~~


