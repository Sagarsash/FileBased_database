# FileBased_database
FileBased Database is a simple Spring Boot application that provides a file-based storage solution for managing tabular data. The project includes functionality to create tables, insert data, and execute database statements. Additionally, it integrates with Redis to save and retrieve results efficiently.

## Project Structure
The project consists of the following main components:

src/main/java: Java source code containing the database logic and Spring Boot application. Main.java: Initial Java implementation for file-based database. DatabaseController.java: Spring Boot controller to handle requests and interact with the database. src/main/resources: application.properties: Configuration file for Spring Boot application. Dockerfile: Instructions for building a Docker image. pom.xml: Maven project configuration file.

## Setup Prerequisites
Java Development Kit (JDK) Maven Docker Redis Server Postman application(optional)

running the application
//Build the project using Maven: //command mvn clean install

build the docker
//command docker-compose up --build

check the conatiner is runinng
//command docker ps

if docker conatiner is running in background
we can create table and insert values inside the table by two ways

## using curl command
### Create Table(run this in project directory terminal)
curl -X POST -H "Content-Type: application/json" -d '{"tableName": "employee_details", "columns": [{"name": "name", "type": "varchar"}, {"name": "age", "type": "int"}]}' http://localhost:8080/createTable (above i am trying to create employee table with two colums with string and int datatypes )

#### inserting data into the table
curl -X POST -H "Content-Type: application/json" -d '{"tableName": "employee_details", "values": ["sagar", 23]}' http://localhost:8080/insertData (so here i am trying to run curl command to insert the data into the employee_details table )

#### using postman application open the postman application and select http option ,select POST (for this specific project we can use http://localhost:8080/createTable ), go to the body and select raw and paste the below code to craete a table
#### create a table
{ "tableName": "Home", "columns": [ { "name": "name", "type": "varchar" }, { "name": "age", "type": "int" } ] } for above its creating a table name home and taking the column names and its data types

#### insert data into the table
select raw and paste the below code to create a table { "tableName": "Home", "values": [ { "name": "john", "age": "22" }, { "name": "mark", "age": 40 }, { "name": "sagar", "age": 34 }, { "name": "sash", "age": 25 } ] }

### endpoint execution
after creating the table and inserting the table use below command to find the output of endpoint curl -X GET -H "Content-Type: application/json" http://localhost:8080/executeStatements -d '["your_statement_1", "your_statement_2"]'

### get the result of redis
open redis server and redis.cli, //make sure its running //then use below command to get the result 127.0.0.1:6379> GET result_key if it return success then its been created or inserted succesfully else it would return failure using this write me a good read me file


### FileBased Database
FileBased Database is a simple Spring Boot application that provides a file-based storage solution for managing tabular data. The project includes functionality to create tables, insert data, and execute database statements. Additionally, it integrates with Redis to save and retrieve results efficiently.

### Prerequisites
Java Development Kit (JDK)
Maven
Docker
Redis Server
Postman application (optional)
Project Structure
The project consists of the following main components:

src/main/java: Java source code containing the database logic and Spring Boot application.
Main.java: Initial Java implementation for file-based database.
DatabaseController.java: Spring Boot controller to handle requests and interact with the database.
src/main/resources:
application.properties: Configuration file for Spring Boot application.
Dockerfile: Instructions for building a Docker image.
pom.xml: Maven project configuration file.
Running the Application
### Building the project using Maven
#### Command:
mvn clean install
### Building the Docker image
#### Command:
docker-compose up --build
### Checking if the Docker container is running
#### Command:
docker ps

### Creating Tables and Inserting Data
You can create tables and insert values inside the table by two ways:

#### Using curl command

curl -X POST -H "Content-Type: application/json" -d '{"tableName": "employee_details", "columns": [{"name": "name", "type": "varchar"}, {"name": "age", "type": "int"}]}' http://localhost:8080/createTable

##### Inserting data into the table:
curl -X POST -H "Content-Type: application/json" -d '{"tableName": "employee_details", "values": ["sagar", 23]}' http://localhost:8080/insertData

##### Using Postman application
##### Create a table:
{
  "tableName": "Home",
  "columns": [
    { "name": "name", "type": "varchar" },
    { "name": "age", "type": "int" }
  ]
}
##### Insert data into the table:
{
  "tableName": "Home",
  "values": [
    { "name": "john", "age": "22" },
    { "name": "mark", "age": 40 },
    { "name": "sagar", "age": 34 },
    { "name": "sash", "age": 25 }
  ]
}
### Executing Endpoints
After creating the table and inserting the table, use the following command to find the output of the endpoint:
#### Command:

curl -X GET -H "Content-Type: application/json" http://localhost:8080/executeStatements -d '["your_statement_1", "your_statement_2"]'
## Getting the Result from Redis
Open the Redis server and Redis CLI, make sure it's running, and then use the following command to get the result:
127.0.0.1:6379> GET result_key
If it returns success, then it's been created or inserted successfully; otherwise, it would return failure.
