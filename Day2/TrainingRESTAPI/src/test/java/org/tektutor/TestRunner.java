package org.tektutor;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features="src/test/java")
@RunWith(Cucumber.class)
public class TestRunner {

}