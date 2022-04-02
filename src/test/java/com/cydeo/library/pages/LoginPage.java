package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement userInput ;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement singInButton;
}
