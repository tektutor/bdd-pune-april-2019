package org.tektutor;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

	private String endpointURL;
	private RequestSpecification request;
	private Response response;
	private int expectedResponseCode, actualResponseCode;
	
	private int id;
	private String name;
	private String duration;

    public Steps() {
    }

    @Given("there is a REST API that supports retrieve all training records at {string}")
    public void there_is_a_REST_API_that_supports_retrieve_all_training_records_at(String url) {
        endpointURL = url;
    }

    @Given("there is a REST API that supports retrieving a specific training record at {string}")
    public void there_is_a_REST_API_that_supports_retrieving_a_specific_training_record_at(String url) {
      endpointURL = url;
    }
    
    @When("I invoked the REST endpoint with GET method")
    public void i_invoked_the_REST_endpoint() {
      RestAssured.baseURI = endpointURL;
      this.request = RestAssured.given();
      this.request.header( "Content-Type", "application/json" );
      this.response = request.get();
    }
    
    @Then("I expect the response code as {string}")
    public void i_expect_the_response_code_as(String strExpectedResponseCode) {  
      actualResponseCode = response.getStatusCode();
      int expectedResponseCode  = Integer.parseInt(strExpectedResponseCode);
      assertEquals ( expectedResponseCode, actualResponseCode );
    }
    
    @Then("I expect a single training record with id matching {string} as response")
    public void i_expect_a_single_training_record_with_id_matching_as_response(String strId) {

      Training training = response.body().as(Training.class);

      int expectedId = Integer.parseInt(strId);
      int actualId = training.getId();

      assertEquals( expectedId, actualId );

    }

    @Then("I expect all the training records from training table as response")
    public void i_expect_all_the_training_records_from_training_table_as_response() {
      
      Training[] listOfTrainings = response.body().as(Training[].class);

      int actualCount = listOfTrainings.length;

      Training training = null;
      for ( int index = 0; index < actualCount; ++index ) {
          training = listOfTrainings[index];
          assertEquals ( index+1, training.getId() );
          assertFalse  ( training.getName().isEmpty() );
          assertFalse  ( training.getDuration().isEmpty() );
      }

    }

    @Then("I expect the name of the training to be {string}")
    public void i_expect_the_name_of_the_training_to_be(String name) {
      Training training = response.body().as(Training.class);

      String expectedTrainingName = name;
      String actualTrainingName = training.getName();

      assertEquals( expectedTrainingName, actualTrainingName );
    }

    @Then("I expect the duration of the training to be {string}")
    public void i_expect_the_duration_of_the_training_to_be(String duration) {
      Training training = response.body().as(Training.class);

      String expectedTrainingDuration = duration;
      String actualTrainingDuration = training.getDuration();

      assertEquals( expectedTrainingDuration, actualTrainingDuration );
    }

}