#parent-child REST API application

This is a simple implementation of parent-child REST application providing REST API to create new parent objects (with or without children).

It also provides APIs to retrieve parents by id and also update individual parents and children.

## Install

    mvn clean package

## Run the app

     java -jar target/parent-child-0.0.1-SNAPSHOT.jar

## Run the tests

    mvn clean test
    
# REST API

The REST API to the example app is described below.

## Create a new Parent

### Request

`POST /parents/`

    curl -i -H 'Content-Type: application/json' -d '{"title": "Mrs", "firstName": "Jane", "lastName": "Doe", "emailAddress":"jane.doe@gohenry.co.uk", "dateOfBirth": "1990-06-03", "gender": "female"}' http://localhost:8080/parents
### Response

    HTTP/1.1 201 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 22 Aug 2019 15:01:53 GMT
    
    {
      "personId" : 6,
      "statusMessage" : "Parent Created Successfully"
    }

## Get a specific Parent

### Request

`GET /parents/id`

     curl -i -H 'Accept: application/json' http://localhost:8080/parents/1
### Response

    HTTP/1.1 200 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 22 Aug 2019 15:00:17 GMT
    
    {
      "id" : 1,
      "title" : "Mr",
      "firstName" : "Donald",
      "lastName" : "Trump",
      "emailAddress" : "donald@trump.com",
      "dateOfBirth" : "1955-06-23",
      "gender" : "male",
      "secondName" : "president",
      "children" : [ {
        "id" : 3,
        "firstName" : "Ivanka",
        "lastName" : "Trump",
        "emailAddress" : "ivanka@trump.com",
        "dateOfBirth" : "1984-11-09",
        "gender" : "female",
        "secondName" : ""
      }, {
        "id" : 4,
        "firstName" : "Danny",
        "lastName" : "Trump",
        "emailAddress" : "danny@trump.com",
        "dateOfBirth" : "1986-05-16",
        "gender" : "male",
        "secondName" : ""
      } ]
    }

## Get a non-existent Parent

### Request

`GET /parents/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/parents/-1

### Response

    HTTP/1.1 404 
    Content-Type: application/json;charset=UTF-8
    Content-Length: 33
    Date: Thu, 22 Aug 2019 15:05:47 GMT
    
    Could not find parent with id: -1

## Create new Parent with children

### Request

`POST /parents/`

    curl -i -H 'Content-Type: application/json' -d '{"title": "Mrs", "firstName": "Jane", "lastName": "Doe", "emailAddress":"jane.doe@gohenry.co.uk", "dateOfBirth": "1990-06-03", "gender": "female","secondName": "", "children": [ { "firstName": "Janet", "lastName": "Doe","emailAddress": "janet.doe@gohenry.co.uk", "dateOfBirth": "2010-05-22","gender": "female", "secondName": "" }, { "firstName": "Jason", "lastName":"Doe", "emailAddress": "jason.doe@gohenry.co.uk", "dateOfBirth": "2008-12-05","gender": "male", "secondName": "" } ]}' http://localhost:8080/parents
### Response

    HTTP/1.1 201 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 22 Aug 2019 15:09:20 GMT
    
    {
      "personId" : 7,
      "statusMessage" : "Parent Created Successfully"
    }

## Update Parent

### Request

`PUT /parents/{id}`

    curl -i -H 'Content-Type: application/json' -X PUT -d '{"title": "Mrs", "firstName": "Janet", "lastName": "Dover", "emailAddress":"janet.dover@gohenry.co.uk", "dateOfBirth": "1990-06-03", "gender": "female"}' http://localhost:8080/parents/7

### Response

    HTTP/1.1 200 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 22 Aug 2019 15:14:27 GMT
    
    {
      "personId" : 7,
      "statusMessage" : "Parent Updated Successfully"
    }

## Update Child

### Request

`PUT /children/{id}`

    curl -i -H 'Content-Type: application/json' -X PUT -d '{"firstName": "Little", "lastName": "Johnny", "emailAddress":"johnny@little.com", "dateO: "male"}' http://localhost:8080/children/3
### Response

    HTTP/1.1 200 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 22 Aug 2019 15:22:45 GMT
    
    {
      "personId" : 3,
      "statusMessage" : "Child Updated Successfully"
    }
    
##Integration Tests

Integration Tests are written using Zerocode library to achieve quicker and more complete test scenario coverages
[zerocode](https://github.com/authorjapps/zerocode)
