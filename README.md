# SPRING BOOT API COURSE FOR Alura Forum #

Project for Web API in Spring Boot at Alura Forum.

Course link: `https://cursos.alura.com.br/course/spring-boot-api-rest`.

# DEPENDENCIES #

Lombok: `https://projectlombok.org/`.

Springfox: `https://github.com/springfox/springfox`.

JJWT: `https://github.com/jwtk/jjwt`.

# DOCUMENTATION #

link: `http://localhost/swagger-ui/`.

# DATABASE #

This project is using h2 database to make it simple, but is using JPA, so you can use any database that you want.

Link for access h2: `http://localhost:8080/h2-console/`.

Only field you need change is `JDBC URL` and replacement to jdbc:h2:mem:alura-forum.

# POSTMAN #

I used Postman for documentation the API. I exported the collections and the environments in postman-collections 
folder. To import the collections, into Postman, just need go in import option, change to folder and select 
`postman-collection`.