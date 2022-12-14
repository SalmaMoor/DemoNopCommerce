package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();

    @Given("^user writes product as \"([^\"]*)\"$")
    public void writeProductName(String productName) {
        homePage.searchTxt.sendKeys(productName);
        //homePage.searchKeyword = productName;
    }

    @When("user clicks on search button")
    public void SearchBtnClick() {
        homePage.searchBtn.click();
    }

    @Then("list of products appear")
    public void listOfProductsSearch() {
        SoftAssert soft = new SoftAssert();
        //--------First Assertion ------ url contains "https://demo.nopcommerce.com/search?q="
        String expectedUrl = "https://demo.nopcommerce.com/search?q=";
        String actualUrl = Hooks.driver.getCurrentUrl();
        soft.assertTrue(actualUrl.contains(expectedUrl));
        //--------Second Assertion -----
        System.out.println("search keyword: "+homePage.searchKeywordTxt.getAttribute("value"));
        for (int i = 0; i < homePage.searchItems.size(); i++) {
            soft.assertTrue(homePage.searchItems.get(i).getText().toLowerCase().
                    contains(homePage.searchKeywordTxt.getAttribute("value").toLowerCase()));
        }
        //--------Third Assertion ------ current url contains search keyword
        soft.assertTrue(actualUrl.contains(homePage.searchKeywordTxt.getAttribute("value")));

        soft.assertAll();
    }

    @Then("one product appears and user click on product")
    public void clickOnProduct() throws InterruptedException {
        String sku = homePage.searchKeywordTxt.getAttribute("value");
        System.out.println("sku: "+sku);
        homePage.productItem.click();
        Assert.assertTrue(homePage.productSku.getText().toLowerCase().
                contains(sku.trim().toLowerCase()));
    }
}
