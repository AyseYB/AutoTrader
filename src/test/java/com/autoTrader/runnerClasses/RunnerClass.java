package com.autoTrader.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  //C:\Users\yekel\IdeaProjects\AutoTrader\src\test\resources\features
        glue = "com/autoTrader/stepDefinitions",//C:\Users\yekel\IdeaProjects\AutoTrader\src\test\java\com\autoTrader\stepDefinitions\AutoTraderStepDefinitions
        dryRun = false,
        //tags = "@unit_test",
        plugin = {
               "html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class RunnerClass {
}
