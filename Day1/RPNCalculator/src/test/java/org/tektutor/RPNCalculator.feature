Feature: Develop a RPN Calculator application which takes postfix math expression, evaluates
	 the math expression and returns the result.

    Scenario Outline: Test simple addition
	Given I have rpn calculator object
	When I invoke evaluate method with input <input>
	Then I expect the result as <expectedOutput> 

		Examples:

		|input          |	expectedOutput|
		| "10 12 +"	|	"22.0"	      |
		| "100 12 +"	|	"112.0"	      |

    Scenario Outline: Test simple subtraction 
	Given I have rpn calculator object
	When I invoke evaluate method with input <input>
	Then I expect the result as <expectedOutput> 

		Examples:

		|input          |	expectedOutput|
		| "10 12 -"	|	"-2.0"	      |
		| "100 12 -"	|	"88.0"	      |

    Scenario Outline: Test simple multiplication 
	Given I have rpn calculator object
	When I invoke evaluate method with input <input>
	Then I expect the result as <expectedOutput> 

		Examples:

		|input          |	expectedOutput|
		| "10 12 *"	|	"120.0"	      |
		| "100 12 *"	|	"1200.0"      |

    Scenario Outline: Test simple division 
	Given I have rpn calculator object
	When I invoke evaluate method with input <input>
	Then I expect the result as <expectedOutput> 

		Examples:

		|input          |	expectedOutput|
		| "100 5 /"	|	"20.0"	      |
		| "100 10 /"	|	"10.0"      |

    Scenario Outline: Test complex rpn math expression 
	Given I have rpn calculator object
	When I invoke evaluate method with input <input>
	Then I expect the result as <expectedOutput> 

		Examples:

		|input          	|	expectedOutput|
		| "5 10 * 100 20 / +"	|	"55.0"	      |
