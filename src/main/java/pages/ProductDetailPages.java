package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ProductDetailPages extends BasePage {

    /// *Localizadores de la profe

    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By productPrice_Locator = By.cssSelector("div.product-price");
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");
    By toolBarCartButton = By.cssSelector("div.header-display-desktop div.showOnDesktop a span.sqs-cart-quantity");

    // Constructor de la clase
    public ProductDetailPages(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle(){
        return getText(productTitle_Locator);
    }

    public String getProductPrice(){
        return getText(productPrice_Locator);
    }

    public void selectSize(String size){
        selectByVisibleText(selectSize_Locator, size);
    }

    public void typeQuantity(int quantity){
        type(inputQuantity_Locator, String.valueOf(quantity));
        click(addToCartBtn_Locator);
    }

    public void clickAddToCart(){
        click(addToCartBtn_Locator);
    }


    
    
    
    
}
