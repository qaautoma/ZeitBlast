package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.qa.orangehrm.stepdefinitions",
		"ApplicationHooks" }, plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = true)
public class MyTestRunner extends AbstractTestNGCucumberTests {

}