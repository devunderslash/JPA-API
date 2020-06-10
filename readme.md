**Project Setup**

Spring Boot JPA web application using Java8, Tomcat9 and mySQL8. 


To run the application pop the following into your terminal whilst in Root project folder:

docker-compose up --build

Navigate to localhost:8080 which will allow you to use the HAL Browser to use CRUD functions to GET and POST.

If HAL does not run automatically, try http://localhost:8080/browser/index.html#/. 

Alternatively you can use your desired means of testing such as Postman, or go straight Browser.

API Calls:

- GET http://localhost:8080/organisations
- GET http://localhost:8080/organisations/{id}

- POST http://localhost:8080/organisations
{
  "name": "<Organisation Name>",
  "applications": [{
      "name": "<App Name>",
      "platform": {
        "name": "<Platform Name>"
      }
    }]
}

- PUT http://localhost:8080/organisations
{
  "name": "<UpdateHere>",
  "applications": [{
      "name": "<Update Here>",
      "platform": {
        "name": "<Update Here>"
      }
    }]
}


The current solution uses MySQL, with your desired data browser (MySQLWorkbench used for solution) you can see the saved data via the following connection details:

-- Standard TCP/IP
-- HostName: 127.0.0.1
-- Port: 3306
-- Username: contrast-user
-- Pass: isaythebestwords (Favourite Donald quote of all time!)


COMING SOON - 

- GET http://localhost:8080/organisations/{id}/applications
- Query and Sort Functionality

FUTURE Features

-Adminer add to Docker-compose for MySQL viewing in browser





