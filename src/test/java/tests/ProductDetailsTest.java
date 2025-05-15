package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductDetailPages;

public class ProductDetailsTest extends BaseTest {

    HomePage homePage;
    ProductDetailPages productDetailPages;

    @BeforeEach
    void initPageObject() {
        homePage = new HomePage();
        productDetailPages = new ProductDetailPages();
    }

    @Test
    void verifyProductTitleIsPresent() {
        homePage.clickOnProductLink(3);
        String currentTitle = productDetailPages.getProductTitle();
        System.out.println("Product Title: " + currentTitle);
        Assertions.assertFalse(currentTitle.isEmpty(), "Product Title is not present");
    }

    @Test
    void verifyProductPriceIsPresent() {
        homePage.clickOnProductLink(3);
        String currentPrice = productDetailPages.getProductPrice();
        System.out.println("Product Price: " + currentPrice);
        Assertions.assertFalse(currentPrice.isEmpty(), "Product Price is not present");
    }




}
