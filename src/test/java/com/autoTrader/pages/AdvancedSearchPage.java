package com.autoTrader.pages;

import com.autoTrader.utilies.MyDriver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.datatable.dependency.difflib.myers.MyersDiff;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvancedSearchPage extends Base {

    /**
     * Locators and methods
     */
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advancedSearch;

    public void advancedSearchClick(){
        MyDriver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        advancedSearch.click();
    }
//======================================================
    @FindBy(xpath = "//input[@placeholder='ZIP Code']")
    public WebElement enterZipCode;

    public void zipCode(String zipCode){
        MyDriver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        enterZipCode.sendKeys("30004");
    }
//=========================================================
    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;

    public void verifyClickCertifiedAndConvertible(String a){
        if(a.equalsIgnoreCase(selectCertified.getText())){
            selectCertified.click();
        }else {
            WebElement link = selectConvertible;
            scrollDown(link);
            selectConvertible.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//====================================================

    @FindBy(xpath = "//select[@name='startYear']")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[@name='endYear']")
    public WebElement selectTo;

    public void startDateAndEndDate(String from, String to){
        MyDriver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Select select = new Select(selectFrom);
        select.deselectByValue(from);

        Select select1 = new Select(selectTo);
        select1.deselectByValue(to);
        Base.wait2seconds();
    }

    //=========================================================

    @FindBy(xpath = "//select[@name='makeFilter0']")
    public WebElement selectBMW;

    public void selectVehicle(String vehicle){
        Select select = new Select(selectBMW);
        select.selectByValue(vehicle);
        Base.wait2seconds();
    }

    //=======================================================

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
    public WebElement clickSearchButton;

    public void clickSearchButton(){
        WebElement link = clickSearchButton;
        scrollDown(link);
        clickSearchButton.click();
        Base.wait2seconds();
    }


    /**
     * After search
     */
    @FindBy(xpath = "//h1[contains(text(),'Certified BMW Convertibles for Sale in Alpharetta, GA')]")
    public WebElement userInPage;

    public void verifyResultPage(){
        String expected ="Certified BMW Convertibles for Sale in Alpharetta, GA (with Photos) - Autotrader";
        String actual = userInPage.getText();
        Assert.assertEquals(expected, actual);
        Base.wait2seconds();
    }


    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;

    public void verifyBMWListing(String car){
        //Storing all the results in list and compairing all the results not contains BMW
        List<WebElement> list = MyDriver.getDriver().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
        int count = 0;
        int nonBMwCount = 0;
        for (WebElement each : list){
            if(!each.getText().contains(car)){
                System.out.println("we found non BMW listing" + nonBMwCount);
            }
            count++;
        }
        System.out.println("we found" + count + "BMW listing and this is the only BMW listing");
    }

    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;

    //counting how many listing result displayed
    public void verifyNumberOfBMW(){
        List<WebElement> list = MyDriver.getDriver().findElements(By.xpath("//div[contains(@data-cmp,'inventoryListing')]"));
        System.out.println("NUmber of BMW listed in the result page is : " + list.size());

        int actual = list.size();
        String expected = MyDriver.getDriver().findElement(By.xpath("//div[@class='results-text-container text-size-200']")).getText();
        System.out.println(expected);

        String[] arr = expected.split(" ");
        //System.out.println(arr[2]);
        int expectedResult = Integer.parseInt(arr[2]);
        Assert.assertEquals("Assertion failed", expectedResult, actual);
    }
}
