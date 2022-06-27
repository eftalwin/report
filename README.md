<b>REST APIs for creating, editing and deleting Incident Reports related to an
application running in production</b>

Access the deployed web application at: http://localhost:8081

Clone the repository:

$ git clone https://github.com/eftalwin/report.git


Incident Management System (CRUD web application)
==============================================================

Configurations:-
------------------------

Spring Boot
Spring MVC
Spring Data JPA
ThymeLeaf
MySQL
Java 17
Postman


Setup:-
--------

create a database name as 'incidentreport' .


Postman REST API:-
-------------------

POST METHOD
-----------

*localhost:8081/report/add
{
"creator":"Mariam",
"title":"error in updating",
"assignee":"Ben",
"status":"NEW"
}

*localhost:8081/report/adduser
{
   "id": 1,
   "userName": "admin",
   "password": "admin"
}

GET METHOD
-----------
*To get all users ->  localhost:8081/report/alluser
*To get all all incidents -> localhost:8081/report/all
*To get single incident -> localhost:8081/report/find/{id}
*To get incident by creator -> localhost:8081/report/creator/{name}

UPDATE METHOD
-------------

*To update incident report -> localhost:8081/report/update/{id}
*To update user -> localhost:8081/report/updateuser/{id}

DELETE METHOD
-------------

*To delete incident -> localhost:8081/report/delete/{id}
*To delete user -> localhost:8081/report/deleteuser/{id}



Webpage urls:-
------------------------
* Homepage - localhost:8081
* New user registeration-> localhost:8081/register
* To login -> localhost:8081/login
* To view Incidents reports-> localhost:8081/all
* To add Incidents reports -> localhost:8081/newincident
* To view My reports-> localhost:8081/myincidnets
* To update Incidents reports-> localhost:8081/update/{id}
* To delete Incidents reports-> localhost:8081/delete/{id}