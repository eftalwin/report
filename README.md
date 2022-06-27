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

create a default row in 'user' ->  username 'admin' and password 'admin123'.


Webpage urls:-
------------------------
Homepage - localhost:8081
New user registeration-> localhost:8081/register
To login -> localhost:8081/login
To view Incidents reports-> localhost:8081/all
To add Incidents reports -> localhost:8081/newincident
To view My reports-> localhost:8081/myincidnets
To update Incidents reports-> localhost:8081/update/{id}
To delete Incidents reports-> localhost:8081/delete/{id}
