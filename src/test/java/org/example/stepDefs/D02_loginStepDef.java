package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goLoginPage(){
        login.loginLink.click();
    }

    @And("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void enterData(String type, String email, String password) throws InterruptedException {
        login.loginSteps(email, password);
    }

    @When("user press on login button")
    public void loginBtnClick() throws InterruptedException {
        login.loginBtn.click();
        //login.passwordTxt.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("user login to the system successfully")
    public void successLogin(){
        SoftAssert soft = new SoftAssert();

        // ---------- First Assertion -------------- getCurrentUrl and verify it equals https://demo.nopcommerce.com/
        System.out.println("login First Assertion");

        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = Hooks.driver.getCurrentUrl();

        soft.assertEquals(actualUrl, expectedUrl, "login First Assertion true");

        // --------- second Assertion --------- "My account" tab isDisplayed
        System.out.println("login second Assertion");

        boolean display = login.myAccount.isDisplayed();
        soft.assertTrue(display, "login second assertion true");

        //Assert All
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void FailedLogin(){
        SoftAssert soft = new SoftAssert();

        // ---------- First Assertion -------------- error message contains "Login was unsuccessful."
        System.out.println("invalid login First Assertion");

        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.";
        String actualMsg = login.errorMsg.getText();

        soft.assertTrue(actualMsg.contains(expectedMsg));

        // --------- second Assertion --------- - the color of this message is red "#e4434b"
        System.out.println("invalid login second Assertion");

        String color = login.errorMsg.getCssValue("color");
        System.out.println(color);

        soft.assertEquals(color,"#e4434b");

        //Assert All
        soft.assertAll();
    }
}
