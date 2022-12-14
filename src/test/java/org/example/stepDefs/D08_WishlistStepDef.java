package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user click on wishlist button of product 'HTC One M8 Android L 5.0 Lollipop'")
    public void clickOnProduct(){
        System.out.println("Element: "+ homePage.selectedItemWishBtn.getAccessibleName());
        homePage.selectedItemWishBtn.click();
    }

    @Then("success message 'The product has been added to your wishlist' with green background color")
    public void successMsg(){
        SoftAssert soft = new SoftAssert();

        // ---------- First Assertion -------------- Success message is displayed "The product has been added to your wishlist"
        System.out.println("First Assertion");

        String expectedMsg = "The product has been added to your wishlist";
        String actualMsg = homePage.successBar.getText();

        System.out.println("msg: "+actualMsg);

        soft.assertTrue(actualMsg.contains(expectedMsg), "First Assertion true");

        // --------- second Assertion --------- background color is green rgba(75, 176, 122, 1), #4bb07a
        System.out.println("second Assertion");

        String backgroundColor = homePage.successBar.getCssValue("background-color");
        System.out.println("background-color: "+ backgroundColor);

        soft.assertEquals(backgroundColor,"rgba(75, 176, 122, 1)");

        //Assert All
        soft.assertAll();
    }

    @And("wait until this success message with green color to disappear")
    public void msgDisappear(){
        //explicit wait
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.successBar));
    }

    @When("click on 'Wishlist' button on the top of the page")
    public void clickOnWishlistBtn(){
        homePage.wishListBtn.click();
    }

    @Then("Quantity value should bigger than 0")
    public void qtyChanged(){
        int qty = Integer.parseInt(homePage.qty.getAttribute("value"));
        System.out.println("qty = "+qty);
        //-----Assert qty > 0
        Assert.assertTrue(qty > 0, "quantity = " + qty);
    }
}
