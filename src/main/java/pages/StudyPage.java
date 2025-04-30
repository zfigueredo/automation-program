package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*public class StudyPage extends BasePage {
    By selectSizeLocator = By.cssSelector("select[aria-label='Select Size']");
    By inputQtyLocator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartButtonLocator = By.cssSelector("div.sqs-add-to-cart-button");
    By toolBarCartButton = By.cssSelector("div.header-display-desktop div.showOnDesktop a span.sqs-cart-quantity");

    public StudyPage(WebDriver driver) {
        super(driver);
    }

    public void setSize(int size) {
        Select select = new Select(findElement(selectSizeLocator));
        select.selectByValue(String.valueOf(size));
    }

    public void setQty(int qty) {
        type(inputQtyLocator, String.valueOf(qty));
    }

    public void clickAddToCartButton() {
//        click(addToCartButtonLocator);

        WebElement element = driver.findElement(addToCartButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public int getCartTotalItems() {
        waitForElementToBePresent(toolBarCartButton);
        return Integer.parseInt(getText(toolBarCartButton));
    }

    public String getProductTitle() {
        // Arrange: Localizar el elemento del título del producto
        By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");

        // Action: Obtener el texto del elemento
        return getText(productTitle_Locator);
    }




}*/
