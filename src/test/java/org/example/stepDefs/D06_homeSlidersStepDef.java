package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user click on first slider")
    public void firstSliderClick(){
        homePage.slider("0").click();
    }

    @Then("user will navigate to first slider product page")
    public void navigateToFirstSliderPage(){
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualUrl = Hooks.driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("user click on second slider")
    public void secondSliderClick(){
        homePage.slider("1").click();
    }

    @Then("user will navigate to second slider product page")
    public void navigateToSecondSliderPage(){
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        String actualUrl = Hooks.driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
