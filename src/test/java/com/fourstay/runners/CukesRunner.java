package com.fourstay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//this line tells Junit to run this tests as a Cucumber test
@RunWith(Cucumber.class)
//we need to tell cucumber which feature file we want to run.
@CucumberOptions(
		plugin={"html:target/cucumber", "json:target/report.json"},
	    //run this feature under the fuature file.
		features="src/test/resources/com/fourstay/features",
		glue="com/fourstay/step_definitions",
		tags="@DiceSearch",
		dryRun=false
		)
public class CukesRunner {
	
}
