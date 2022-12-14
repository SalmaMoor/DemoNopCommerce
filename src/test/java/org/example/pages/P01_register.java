package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {
    public P01_register(){
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerLink;

    @FindBy(id = "gender-male")
    public WebElement maleRadio;

    @FindBy(id = "gender-female")
    public WebElement femaleRadio;

    @FindBy(id = "FirstName")
    public WebElement firstNameTxt;

    @FindBy(id = "LastName")
    public WebElement lastNameTxt;

    @FindBy(name = "DateOfBirthDay")
    public  WebElement daySelector;

    @FindBy(name = "DateOfBirthMonth")
    public  WebElement monthSelector;

    @FindBy(name = "DateOfBirthYear")
    public  WebElement yearSelector;

    @FindBy(id = "Email")
    public WebElement emailTxt;

    @FindBy(id = "Password")
    public WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    public WebElement passwordConfirmTxt;

    @FindBy(id = "register-button")
    public WebElement registerBtn;

    @FindBy(className = "result")
    public WebElement resultMsg;
}
