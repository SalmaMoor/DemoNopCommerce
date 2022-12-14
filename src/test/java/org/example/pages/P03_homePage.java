package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    public String expectedFacebookLink;
    public String expectedTwitterLink;
    public String expectedRssLink;
    public String expectedYoutubeLink;
   public P03_homePage(){
        PageFactory.initElements(Hooks.driver, this);
        expectedFacebookLink = "https://www.facebook.com/nopCommerce";
        expectedTwitterLink = "https://twitter.com/nopCommerce";
        expectedRssLink = "https://demo.nopcommerce.com/new-online-store-is-open";
        expectedYoutubeLink = "https://www.youtube.com/user/nopCommerce";
    }

    @FindBy(id = "customerCurrency")
    public WebElement currencySelector;

    @FindBy(css = "span[class=\"price actual-price\"]")
    public List<WebElement> itemPrice;

    @FindBy(id = "small-searchterms")
    public WebElement searchTxt;

    @FindBy(className = "button-1")
    public WebElement searchBtn;

    @FindBy(className = "product-title")
    public List<WebElement> searchItems;

    @FindBy(className = "product-item")
    public  WebElement productItem;

    @FindBy(css = "div[class=\"sku\"] > span[class=\"value\"]")
    public WebElement productSku;

    @FindBy(id = "q")
    public WebElement searchKeywordTxt;

    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li")
    public List<WebElement> mainLinks;

    public List<WebElement> subCategoryLinks(int selectedCategory){
        return Hooks.driver.findElements(By.
                xpath("(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li"));
    }

    @FindBy(className = "page-title")
    public WebElement pageTitle;

    public WebElement slider(String number){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"nivo-controlNav\"]>a[rel=\""+number+"\"]"));
    }

    @FindBy(css = "div[class=\"product-item\"][data-productid=\"18\"]>div[class=\"details\"]>div[class=\"add-info\"]>div[class=\"buttons\"]> button[class=\"button-2 add-to-wishlist-button\"]")
    public WebElement selectedItemWishBtn;

    @FindBy(css = "div[id=\"bar-notification\"]>div[class=\"bar-notification success\"]")
    public WebElement successBar;

    @FindBy(css = "span[class=\"wishlist-label\"]")
    public WebElement wishListBtn;

    @FindBy(className = "qty-input")
    public WebElement qty;
}
