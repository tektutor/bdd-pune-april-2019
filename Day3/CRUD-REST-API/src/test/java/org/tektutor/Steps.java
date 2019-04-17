package org.tektutor;

import static org.junit.Assert.assertEquals;

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

    @Given("there is a REST API that supports retrieve all training records")
    public void there_is_a_REST_API_that_supports_retrieve_all_training_records() {
        endpointURL = "http://localhost:8080/rest/trainings";

        RestAssured.baseURI = endpointURL;
		this.request = RestAssured.given();
		this.request.header( "Content-Type", "application/json" );
    }

    @When("I invoked the url")
    public void i_invoked_the_url() {
		this.response = request.get();
		this.actualResponseCode = this.response.getStatusCode();
    }

    @Then("I expect all the training records from training table as response")
    public void i_expect_all_the_training_records_from_training_table_as_response() {
    //    assertEquals ( 200, actualResponseCode );
    }

}