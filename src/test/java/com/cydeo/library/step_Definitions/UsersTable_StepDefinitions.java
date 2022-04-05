package com.cydeo.library.step_Definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UserPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class UsersTable_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    UserPage userPage = new UserPage();


    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
       loginPage.userInput.sendKeys(ConfigurationReader.getProperty("TestLibrarian1"));
       loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password3"));
       loginPage.singInButton.click();
    }


    @Given("I click on {string} link")
    public void i_click_on_link(String string) {
loginPage.userButton.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String>expectedColumnNames) {
        List<String>actualColumnNames = BrowserUtils.getElementsText(userPage.tableHeaders);
           // System.out.println(actualColumnNames);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);
}



}
