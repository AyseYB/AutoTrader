package com.autoTrader.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/autoTrader/stepDefinitions",
        plugin = {
                "html:target/rerun-default-cucumber-reports",
                "json:target/cucumber_failure.json",

        }
)
public class FailedRunnerClass {
}
