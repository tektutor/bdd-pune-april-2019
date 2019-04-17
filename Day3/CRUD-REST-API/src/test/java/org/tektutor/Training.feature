Feature: Develop a REST API that supports CRUD operations.

   Scenario: Should be able to retrieve all training records
   
     Given there is a REST API that supports retrieve all training records at "http://192.168.2.156:8080/tektutor-crud-api-1.0.0/rest/trainings/all"
     When I invoked the REST endpoint with GET method
     Then I expect the response code as "200"
     And I expect all the training records from training table as response
   
   Scenario: Should be able to retrieve a specific training record
   
     Given there is a REST API that supports retrieving a specific training record at "http://192.168.2.156:8080/tektutor-crud-api-1.0.0/rest/trainings/1"
     When I invoked the REST endpoint with GET method
     Then I expect the response code as "200"
     And  I expect a single training record with id matching "1" as response
     And  I expect the name of the training to be "Docker"
     And I expect the duration of the training to be "2 days"