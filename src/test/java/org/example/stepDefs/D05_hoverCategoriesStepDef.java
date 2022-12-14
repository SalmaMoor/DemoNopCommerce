package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();
    private int selectedCategory;
    private int selectedSubCategory;

    @Given("There are many main categories and User choose one of them")
    public void chooseCategory() {
        int count = homePage.mainLinks.size();
        int min = 0;
        int max = count-1;
        selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @And("user hover selected category")
    public void hoverSelectedCategory() throws InterruptedException {
        Actions actions=new Actions(Hooks.driver);
        actions.moveToElement(homePage.mainLinks.get(selectedCategory)).perform();
        Thread.sleep(2000);

        selectedCategory = selectedCategory + 1;
        // minimize implicit wait to not waste time if it's empty
        Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    }

    @When("user select subcategory if Exist and click on it Or click category if subcategory does not exist")
    public void clickSubcategory(){
        if(!homePage.subCategoryLinks(selectedCategory).isEmpty()) {
            int min = 0;
            int max = homePage.subCategoryLinks(selectedCategory).size() - 1;
            selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            homePage.subCategoryLinks(selectedCategory).get(selectedSubCategory).click();
        }
        else {
            homePage.mainLinks.get(selectedCategory - 1).click();
        }
    }

    @Then("page clicked will be opened")
    public void subcategoryPageOpen() {
        if(!homePage.subCategoryLinks(selectedCategory).isEmpty()) {
            SoftAssert soft = new SoftAssert();
            //assert on url
            soft.assertTrue(Hooks.driver.getCurrentUrl().trim().toLowerCase().
                    contains(homePage.subCategoryLinks(selectedCategory).
                    get(selectedSubCategory).getText().trim().toLowerCase()), "url assert");
            //assert on page title
            soft.assertTrue(homePage.pageTitle.getText().trim().toLowerCase().contains(
                    homePage.subCategoryLinks(selectedCategory).get(selectedSubCategory).getText().trim().toLowerCase()));
            soft.assertAll();
        }
        else {
            // assert on page title
            Assert.assertEquals(homePage.pageTitle.getText().trim().toLowerCase(),
                    homePage.mainLinks.get(selectedCategory - 1).getText().trim().toLowerCase(),"title assert");
        }

        // reset it to the initial value
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

}
