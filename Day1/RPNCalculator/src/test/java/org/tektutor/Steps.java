package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import static org.junit.Assert.*;

public class Steps {
	
	private RPNCalculator rpnCalculator;
	private double actualResult,expectedResult;

	@Given("I have rpn calculator object")
	public void i_have_rpn_calculator_object() {
		rpnCalculator = new RPNCalculator();
		actualResult = expectedResult = 0.0;
	}

	@When("I invoke evaluate method with input {string}")
	public void i_invoke_evaluate_method_with_input(String rpnMathExpression) {
		actualResult = rpnCalculator.evaluate ( rpnMathExpression );
	}

	@Then("I expect the result as {string}")
	public void i_expect_the_result_as(String strExpectedResult) {
		expectedResult = Double.parseDouble ( strExpectedResult );

		assertEquals ( expectedResult, actualResult, 0.0001 );
	}
}
