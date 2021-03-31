Perry's Messaging Services

REST API to manage Messages. Create, List, Send, Edit, Delete.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

To install, run and see functionalities working in this project is necessary the following software:

JDK 11 or above
Maven
Spring
Eclipse
MySQL
Postman

Build

mvn clean install

How to Run the Perry's Messaging Services

Start as a Spring Boot Application


Running and see functionalities Working

Postman / Internet browser (GET, POST, PUT, DELETE)
http://localhost:8080/users
http://localhost:8080/messages
http://localhost:8080/users/others

Sample JSON on Postman

{
  "name": "Molly Wax",
  "cellPhone": "000 111 555"
}


{
    "messageContent": "TEST",
    "userSending": "1",
    "userReceiving": "2",
    "dateOfSent": "2021-03-30",
    "dateOfReception": "2021-03-30",
}

{
    "messageContent": "UPDATE TEST",
    "userSending": "1",
    "userReceiving": "2",
    "dateOfSent": "2021-03-30",
    "dateOfReception": "2021-03-30",
    "messageStatus": "LIKE"
}


Built With
Spring Framework
Maven - Dependency Management
JavaSE-11

Author
Cláudio Braga