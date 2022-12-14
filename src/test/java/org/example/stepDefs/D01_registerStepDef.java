package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {
        //click on register link
        register.registerLink.click();
    }

    @And("user select gender type")
    public void ChooseGenderType(){
        register.maleRadio.click();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$") //"automation", "tester"
    public void enterName(String firstName, String lastName){
        register.firstNameTxt.clear();
        register.firstNameTxt.sendKeys(firstName);

        register.lastNameTxt.clear();
        register.lastNameTxt.sendKeys(lastName);
    }

    @And("user enter date of birth")
    public void enterDateOfBirth(){
        Select selectDay = new Select(register.daySelector);
        selectDay.selectByIndex(10);
        Select selectMonth = new Select(register.monthSelector);
        selectMonth.selectByIndex(10);
        Select selectYear = new Select(register.yearSelector);
        selectYear.selectByValue("1990");
    }

    @And("^user enter email \"(.*)\" field$") //"test@example.com"
    public void enterEmail(String email){
        register.emailTxt.clear();
        register.emailTxt.sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void enterPassword(String password, String passwordConfirm){
        register.passwordTxt.clear();
        register.passwordTxt.sendKeys(password);

        register.passwordConfirmTxt.clear();
        register.passwordConfirmTxt.sendKeys(passwordConfirm);
    }

    @When("user clicks on register button")
    public void clickRegisterBtn(){
        register.registerBtn.click();
    }

    @Then("success message is displayed")
    public void registerSuccess(){
        SoftAssert soft = new SoftAssert();

        // ---------- First Assertion -------------- assertion on Success message is displayed "Your registration completed"
        System.out.println("First Assertion");

        String expectedResult = "Your registration completed";
        String actualResult = register.resultMsg.getText();

        soft.assertTrue(actualResult.contains(expectedResult), "register First Assertion true");

        // --------- second Assertion --------- assertion on the color of this message is green rgba(76, 177, 124, 1), #4cb17c
        System.out.println("register second Assertion");

        String color = register.resultMsg.getCssValue("color");
        System.out.println(color);

        soft.assertEquals(color,"rgba(76, 177, 124, 1)");

        //Assert All
        soft.assertAll();
    }
}
