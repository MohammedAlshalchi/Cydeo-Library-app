package com.cydeo.library.step_Definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

LoginPage loginPage = new LoginPage();
LandingPage landingPage = new LandingPage();
WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @Given("user is on the login page")

    public void user_is_on_the_login_page() {
//        String link = ConfigurationReader.getProperty("url");
//        Driver.getDriver().get(link);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        String username = ConfigurationReader.getProperty("TestLibrarian1");
        loginPage.userInput.sendKeys(username);

    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        String password = ConfigurationReader.getProperty("password3");
        loginPage.passwordInput.sendKeys(password);
        loginPage.singInButton.click();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() throws InterruptedException {
        String expected = "dashboard";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        // System.out.println(actual);
        //Thread.sleep(2000);
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }


    @When("user enters student username")
    public void userEntersStudentUsername() {
        String username = ConfigurationReader.getProperty("Test1Student");
        loginPage.userInput.sendKeys(username);
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        String password = ConfigurationReader.getProperty("password");
        loginPage.passwordInput.sendKeys(password);
        loginPage.singInButton.click();
    }

    @Then("user should see books")
    public void userShouldSeeBooks() {

        String expected = "books";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        // System.out.println(actual);
        //Thread.sleep(2000);
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();


    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountUsername) {
        BrowserUtils.waitForVisibility(landingPage.accountUsername,5);
   String actualAccountUsername = landingPage.accountUsername.getText();

   Assert.assertEquals(expectedAccountUsername,actualAccountUsername);

   Driver.closeDriver();

    }
}
