package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login(){
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement emailTxt;

    @FindBy(id = "Password")
    public WebElement passwordTxt;

    @FindBy(css = "div[class = \"buttons\"] > button[type = \"submit\"]")
    public WebElement loginBtn;

    @FindBy(className = "ico-account")
    public WebElement myAccount;

    @FindBy(className = "message-error")
    public WebElement errorMsg;

    public void loginSteps(String email, String password) throws InterruptedException {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        Thread.sleep(3000);
    }
}
