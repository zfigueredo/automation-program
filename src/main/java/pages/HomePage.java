package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{

    //Header Links Localizadores
    By qsCreditCardLink_Locator = By.cssSelector("a[href='/qualitystream-credit-cards']");
    By headerYoutubeIcon_Locator = By.cssSelector(
            "div.header-actions-action.header-actions-action--social a[aria-label='YouTube']");
    By coursePageLink_Locator = By.cssSelector("a[href='/formpage']");

    //Filter Localizadores
    By bottomsLocator = By.xpath("//a[@href='/shop/bottoms']");
    By topsLocator = By.xpath("//a[@href='/shop/tops']");
    By allTopLocator = By.xpath("//a[@href='/shop']");
    By saleLink_Locator = By.cssSelector("a[href='/shop/sale']");


    //Product Links Localizadores
    By productLinkList_Locator = By.cssSelector("a.grid-item-link.product-lists-item");

    //Footer Localizador
    By qualityStreamLogo_Locator = By.xpath(
            "//img[contains(@src,'website_logo_transparent_background.png')]//img[contains(@src,'website_logo_transparent_background.png')]"
    );
    By footerLinksList_Locator = By.cssSelector("footer a");

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

//Methods

    public void clickOnCoursesLink(int index){
        click(coursePageLink_Locator);
    }

    public void clickOnProductLink(int index){
        List<WebElement> productLinks = findElements(productLinkList_Locator);
        if (index < productLinks.size())
            productLinks.get(index).click();
    }

    public boolean isQSCreditCardsLinksDisplayed(){
        boolean isDisplayed = isDisplayed(qsCreditCardLink_Locator);
        System.out.println("Is CC link displayed "+isDisplayed);
        return isDisplayed;
    }

   /* public boolean isShopSpecificItemLinksDisplayed(){
        boolean isDisplayed = isDisplayed(specificItemLink_Locator);
        System.out.println("Is item link displayed "+isDisplayed);
        return isDisplayed;
    }*/

    public void clickOnQSCreditCardsLink(){
        click(qsCreditCardLink_Locator);
    }

    public boolean isHeaderYTIconIsDisplayed(){
        boolean isDisplayed = isDisplayed(headerYoutubeIcon_Locator);
        System.out.println("Is CC link displayed "+isDisplayed);
        return isDisplayed;
    }

    public boolean allFilter(){
        boolean topFilterLinkPresent = isDisplayed(topsLocator);
        boolean bottomFilterLinkPresent = isDisplayed(bottomsLocator);
        boolean saleFilterLinkPresent = isDisplayed(saleLink_Locator);

        System.out.println("topFilterLinkPresent "+topFilterLinkPresent);
        System.out.println("bottomFilterLinkPresent "+bottomFilterLinkPresent);
        System.out.println("saleFilterLinkPresent "+saleFilterLinkPresent);
        return topFilterLinkPresent && bottomFilterLinkPresent && saleFilterLinkPresent;
    }


}
