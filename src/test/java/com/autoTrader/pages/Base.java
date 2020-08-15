package com.autoTrader.pages;

import com.autoTrader.utilies.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public Base(){
        PageFactory.initElements(MyDriver.getDriver(),this);
    }

    public static void clearCookies(){
        //delete all the cookies
        MyDriver.getDriver().manage().deleteAllCookies();
    }

    public void scrollDown(WebElement link){
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)MyDriver.getDriver();
        javascriptExecutor.executeScript("argument[0].scrollIntoView(true)", link);
    }

    public static void wait2seconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
