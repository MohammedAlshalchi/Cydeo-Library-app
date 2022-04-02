package com.cydeo.library.step_Definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginParameters_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String userName, String password) {
     loginPage.userInput.sendKeys(userName);
     loginPage.passwordInput.sendKeys(password);
     loginPage.singInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "dashboard";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        // System.out.println(actual);
        //Thread.sleep(2000);
        Assert.assertTrue(actual.contains(expected));
    }



    @And("there should be {int} users")
    public void thereShouldBeUsers(int int1) {
        int expectedUserNumber = int1;
      String expected = String.valueOf(expectedUserNumber);
        String actual = landingPage.userCount.getText();
        Assert.assertEquals(actual,expected);
    }
}
