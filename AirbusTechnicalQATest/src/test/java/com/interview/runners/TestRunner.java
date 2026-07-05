package com.interview.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    //Path to features folder
    features = "src/test/resources/features", 
    
    //path where step definition live
    glue = "com.interview.stepdefinitions", 

    //Tags to define a specific test to run
    //tags = "@ApplyRole",
    
   
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/report.html"
    },
    
    
    monochrome = true 
)
public class TestRunner {
    
}
