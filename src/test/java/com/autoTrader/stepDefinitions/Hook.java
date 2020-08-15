package com.autoTrader.stepDefinitions;

import com.autoTrader.utilies.ConfigurationReader;
import com.autoTrader.utilies.MyDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before
    public void setUp(){
        System.out.println("######## setUp ##########");
        MyDriver.getDriver().manage().window().maximize();
        MyDriver.getDriver().get(ConfigurationReader.getProperty("Url"));
    }

    @After
    public void tearDown(Scenario scenario){
        //if test fails -->
        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) MyDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.embed(screenshot, "image/png", scenario.getName());
        }


        System.out.println("############ close driver #################");
       // MyDriver.closeDriver();
    }

}
