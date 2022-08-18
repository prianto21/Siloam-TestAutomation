package com.soliam;

import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@Listeners({ ExtentITestListenerClassAdapter.class })
@CucumberOptions(features = "src/test/resources/Features", glue = "com.soliam", plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber2021.json" }, monochrome = true)
public class RunnerFiles extends AbstractTestNGCucumberTests {

}
