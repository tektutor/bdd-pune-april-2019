package org.tektutor;

public class NullMathOperation implements IMathOperation {

	public double evaluate ( double firstInput, double secondInput ) {
		System.out.println ("Perform all error handling including error log");
		return 0.0;
	}

}
