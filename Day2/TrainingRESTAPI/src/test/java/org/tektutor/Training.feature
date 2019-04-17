Feature: Develop a REST API that supports CRUD operations.

   Scenario: Should be able to retrieve all training records
   
    Given there is a REST API that supports retrieve all training records
     When I invoked the url
     Then I expect all the training records from training table as response
    