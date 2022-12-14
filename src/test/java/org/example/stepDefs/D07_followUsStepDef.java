package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user clicks on facebook link")
    public void facebookLinkClick(){
        //1- click on facebook
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("facebook link will be opened in new tab")
    public void facebookLinkOpen() {
        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());

        //3- switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1: current URL: " + Hooks.driver.getCurrentUrl());

        //Assertion
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, homePage.expectedFacebookLink, "facebook follow failed");

        //4- switch from tab 1 to tab 0
//        Hooks.driver.switchTo().window(tabs.get(0));
//        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());

        //close tab
        Hooks.driver.close();

        // reload
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @When("user clicks on twitter link")
    public void twitterLinkClick(){
        //1- click on twitter
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("twitter link will be opened in new tab")
    public void twitterLinkOpen() {
        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        //3- switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1: current URL: " + Hooks.driver.getCurrentUrl());

        //Assertion
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, homePage.expectedTwitterLink, "twitter follow failed");

        //close tab
        Hooks.driver.close();

        // reload
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @When("user clicks on rss link")
    public void rssLinkClick(){
        //1- click on rss
        Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("rss link will be opened in new tab")
    public void rssLinkOpen(){
        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        //3- switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1: current URL: " + Hooks.driver.getCurrentUrl());

        //Assertion
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, homePage.expectedRssLink, "rss follow failed");

        //close tab
        Hooks.driver.close();

        // reload
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

    @When("user clicks on youtube link")
    public void youtubeLinkClick(){
        //1- click on youtube
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("youtube link will be opened in new tab")
    public void youtubeLinkOpen(){
        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        //3- switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1: current URL: " + Hooks.driver.getCurrentUrl());

        //Assertion
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, homePage.expectedYoutubeLink, "Youtube follow failed");

        //close tab
        Hooks.driver.close();

        // reload
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    }

}
