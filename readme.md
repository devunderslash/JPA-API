**Project Setup**

Spring Boot JPA web application using Java8, Tomcat9 and mySQL8. 


To run the application pop the following into your terminal whilst in Root project folder:

docker-compose up --build

Navigate to localhost:8080 which will allow you to use the HAL Browser to use CRUD functions to GET, POST and PUT.

If HAL does not run automatically, try http://localhost:8080/browser/index.html#/. 

Alternatively you can use your desired means of testing such as Postman, or go straight Browser.

API Calls:

- GET http://localhost:8080/organisations
- GET http://localhost:8080/organisations/{id}

COMING SOON - 

- GET http://localhost:8080/organisations/{id}/applications
- Query and Sort Functionality
- DB Script for data pre-population




