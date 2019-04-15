package org.tektutor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.MediaType;

@Path("rpncalculator")
public class RPNCalculatorController {

	private RPNCalculator rpnCalculator = new RPNCalculator();

	@
	public double evaluate( String rpnMathExpression ) {

		return rpnCalculator.evaluate();
	}

}


