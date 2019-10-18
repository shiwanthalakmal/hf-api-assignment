package com.hellofresh.api.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/hellofresh/api/features"},
        glue = {"com.hellofresh.api.base", "com.hellofresh.api.step_definitions"},
        format = {"pretty", "json:target/cucumber.json"},
        tags = {"@Smoke"},
        monochrome = true
)
public class TestRunner {
}
