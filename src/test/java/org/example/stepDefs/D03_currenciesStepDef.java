package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuro(){
        Select selector = new Select(homePage.currencySelector);
        selector.selectByIndex(1);
        //selector.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fbuild-your-own-computer");
    }

    @Then("Euro Symbol \\(€) is shown on the four products displayed in Home page")
    public void verifyEuroSymbol() {
        SoftAssert soft = new SoftAssert();

        for(int i = 0; i < homePage.itemPrice.size(); i++){
            String text = homePage.itemPrice.get(i).getText();
            soft.assertTrue(text.contains("€"), "item index " + i + " does not contain €");
        }
        soft.assertAll();
    }
}
