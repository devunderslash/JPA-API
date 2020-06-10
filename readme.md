# SpringBoot JPA API with Java8, Tomcat9 and MySQL8 on Docker

## Project Set-up

To run the application pop the following into your terminal whilst in Root project folder:

docker-compose up --build

Navigate to localhost:8080 which will allow you to use the HAL Browser to use CRUD functions to GET and POST.

If HAL does not run automatically, try http://localhost:8080/browser/index.html#/. 

Alternatively you can use your desired means of testing such as Postman, or go straight Browser.

**THAT'S IT!**


## What is This?

The following project is used to Demo JPA with One-To-Many, One-To-One entity types with GET functionality. The Entities used are:
* Organisation (has)
* Application (on)
* Platform

This project is as minimal as possible through using the JPA CRUDRepository to do all the dirty work. That said creating queries cannot be avoided if specific information is requested via @GetMappings.


## Further Details

**API Calls**

Use the following for GET, POST and PUT

- GET http://localhost:8080/organisations
- GET http://localhost:8080/organisations/{id}

- POST http://localhost:8080/organisations
`{
  "name": "<Organisation Name>",
  "applications": [{
      "name": "<App Name>",
      "platform": {
        "name": "<Platform Name>"
      }
    }]
}`

- PUT http://localhost:8080/organisations
`{
  "name": "<UpdateHere>",
  "applications": [{
      "name": "<Update Here>",
      "platform": {
        "name": "<Update Here>"
      }
    }]
}`


**MySQL setup**

The current solution uses MySQL, with your desired data browser (MySQLWorkbench used for solution) you can see the saved data via the following connection details:
- Standard TCP/IP
- HostName: 127.0.0.1
- Port: 3306
- Username: contrast-user
- Pass: isaythebestwords (Favourite Donald quote of all time!)

Overall SQL Query needed to bring back info (`/organisations`):

``
select og.id as id, og.name as OrgName, ap.org_fk as OrgId, ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName
from contrastdb.orgs as og
JOIN contrastdb.apps as ap
JOIN contrastdb.plats as pt
ON og.id = ap.org_fk
AND ap.app_fk = pt.id;
``

To bring back information on just One Org (`/organisations/{id}`) then add the following:

To bring back information on just the applications (`/organisations/{id}/applications`) for a single Org then add the following with Org number as id:

``
select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName
from contrastdb.orgs as og
JOIN contrastdb.apps as ap
JOIN contrastdb.plats as pt
ON og.id = ap.org_fk
AND ap.app_fk = pt.id
WHERE og.id = 3;
``

If you would like to sort these then you would add the following(ASC for alphabetical Ascending and DESC for the opposite):

``
select  ap.id as AppID, ap.name as AppName, pt.id as PlatID, ap.app_fk as PlatAppID, pt.name as PlatName
from contrastdb.orgs as og
JOIN contrastdb.apps as ap
JOIN contrastdb.plats as pt
ON og.id = ap.org_fk
AND ap.app_fk = pt.id
WHERE og.id = 1
ORDER BY ap.name ASC;
``

## COMING SOON - 

- GET http://localhost:8080/organisations/{id}/applications
- Query and Sort Functionality

## FUTURE Features

- Adminer add to Docker-compose for MySQL viewing in browser


## OTHER

- JetBrains IntelliJ used for development





