package com.example.demoats;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@TestItems",
        features = {"src/test/resources/features"},
        glue = {"com.example.demoats", "com/selenium/stepDefinitions"}
)
public class RunnerBestie extends AbstractTestNGCucumberTests {
}
