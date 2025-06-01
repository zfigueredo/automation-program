package tests;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.ProductDetailPages;

@ExtendWith(ExtentReportExtension.class)
@Tag("ProductDetail_Regression")
public class ProductDetailsTest extends BaseTest {

    static HomePage homePage;
    static ProductDetailPages productDetailPages;

    @BeforeAll
    static void initPageObject() {
        homePage = new HomePage();
        productDetailPages = new ProductDetailPages();
        homePage.clickOnProductLink(3);
    }

    @Test
    void verifyProductTitleIsPresent() {
        String currentTitle = productDetailPages.getProductTitle();
        System.out.println("Product Title: " + currentTitle);
        Assertions.assertFalse(currentTitle.isEmpty(), "Product Title is not present");
    }

    @Test
    void verifyProductPriceIsPresent() {
        String currentPrice = productDetailPages.getProductPrice();
        System.out.println("Product Price: " + currentPrice);
        Assertions.assertFalse(currentPrice.isEmpty(), "Product Price is not present");
    }




}
