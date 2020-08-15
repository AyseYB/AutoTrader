package com.autoTrader.stepDefinitions;

import com.autoTrader.pages.AdvancedSearchPage;
import com.autoTrader.pages.AutoTraderPage;
import com.autoTrader.pages.Base;
import com.autoTrader.utilies.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class AutoTraderStepDefinitions extends Base {

    AutoTraderPage autoTraderPage = new AutoTraderPage();
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("Landing Page");
        String actualTitle = MyDriver.getDriver().getTitle();
        String expectedTitle = "Used and New Car Sales, Review - Autotrader";
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @Then("verify that {string} are present")
    public void verify_that_are_present(String expected) {
    autoTraderPage.verification(expected);
    }

    @Then("verify that search button is present")
    public void verify_that_search_button_is_present() {
        autoTraderPage.SearchButton();
    }

    @Then("verify that {string} and {string} is present")
    public void verify_that_and_is_present(String make , String model) {
         autoTraderPage.verifyMakeAndModel(make, model);
      Base.wait2seconds();
    }

    //second scenaio

    @Given("user click Advance Search on the home page")
    public void user_click_Advance_Search_on_the_home_page() {
        Base.clearCookies();
        advancedSearchPage.advancedSearchClick();

        Base.wait2seconds();

    }

    @Then("user enter {string} in the zipcode text box")
    public void user_enter_in_the_zipcode_text_box(String zipCode) {
        advancedSearchPage.zipCode(zipCode);

    }

    @Then("user select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
        advancedSearchPage.verifyClickCertifiedAndConvertible(string2);
    }

    @Then("user update year {string} to {string}")
    public void user_update_year_to(String from, String to) {
        advancedSearchPage.startDateAndEndDate(from, to);


    }

    @Then("selects {string} from Make, Model, and Trim")
    public void selects_from_Make_Model_and_Trim(String vehicle) {
        advancedSearchPage.selectVehicle(vehicle);

    }

    @Then("user click Search Button")
    public void user_click_Search_Button() {
        advancedSearchPage.clickSearchButton();

    }

    @Then("user verify that it is the result page")
    public void user_verify_that_it_is_the_result_page() {
        advancedSearchPage.verifyResultPage();
    }

    @Then("user verify that there is only {string} cars in the listing")
    public void user_verify_that_there_is_only_cars_in_the_listing(String car) {
        advancedSearchPage.verifyBMWListing(car);


    }

    @Then("display the number of the cars on the console")
    public void display_the_number_of_the_cars_on_the_console() {
        advancedSearchPage.verifyNumberOfBMW();
    }

    @Given("choose make as {string}")
    public void choose_make_as(String make) {
        MyDriver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        autoTraderPage.multipleChoice(make);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
