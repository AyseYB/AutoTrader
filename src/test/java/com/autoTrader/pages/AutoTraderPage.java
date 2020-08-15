package com.autoTrader.pages;

import com.autoTrader.utilies.MyDriver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoTraderPage  extends Base{

    //to initialize @findBy annotations
    public AutoTraderPage(){
        PageFactory.initElements(MyDriver.getDriver(), this);
    }

    /**
     * Locators
     */
    @FindBy(xpath = "//button[contains(text(),'Browse by Make')]")
    public WebElement browseByMake;

    @FindBy(xpath = "//button[contains(text(),'Browse by Style')]")
    public WebElement browseByStyle;

    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advancedSearch;

    @FindBy(id= "search")
    public WebElement searchButton;

    @FindBy(xpath = "//select[@id='makeCode']")
    public WebElement makeElement;

    @FindBy(id = "ModelCode")
    public WebElement modelElement;

    //verification browseByMake, browseByStyle, browseBy, AdvanceSearch
    public void verification(String expected){
        if(expected.equals(browseByMake.getText())){
            String actual = browseByMake.getText();
            Assert.assertEquals(expected, actual);
        }else if(expected.equals(browseByStyle.getText())){
            String actual = browseByStyle.getText();
            Assert.assertEquals(expected,actual);
        }else {
            String actual = advancedSearch.getText();
            Assert.assertEquals(expected, actual);
        }
    }


//    public void verification(String expected){
//        if(expected.equals("Browse by Make")){
//            String actual = browseByMake.getText();
//            Assert.assertEquals(expected, actual);
//        }else if(expected.equals("Browse by Style")){
//            String actual = browseByStyle.getText();
//            Assert.assertEquals(expected,actual);
//        }else {
//            String actual = advancedSearch.getText();
//            Assert.assertEquals(expected, actual);
//        }
//    }


    //verifying the Search Buttton is enabled
    public void SearchButton(){
        Assert.assertTrue(searchButton.isEnabled());
    }

    //verifying the Make and Model dropdowns are visible
    public void verifyMakeAndModel(String make, String model){
        Assert.assertTrue(makeElement.isEnabled());
        Assert.assertTrue(modelElement.isEnabled());
    }

    public void multipleChoice(String model){
        makeElement.sendKeys(model);
    }
}
