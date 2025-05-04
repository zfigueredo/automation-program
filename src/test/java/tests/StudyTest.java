package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import pages.StudyPage;


// Test para hacer la tarea de product details
/*public class StudyTest extends BaseTest {
    StudyPage productPage;

    @BeforeEach
    void initPageObject() {
        productPage = new StudyPage(driver);
        productPage.navigate("https://www.qualitystream-practice.com/shop/p/lounge-tunic-/-blue-k8a8z");
        productPage.navigate("https://www.qualitystream-practice.com/cart");
        productPage.navigate("https://www.qualitystream-practice.com/shop/p/lounge-tunic-/-blue-k8a8z");
    }

    @Test
    @DisplayName("Studying Pod")
    void verify() {
        // get current cart total amount of items
        int cartTotalItemsBeforeTest = 0;
        // set size
        productPage.setSize(2);
        // set qty
        int addedQuantity = 3;
        productPage.setQty(addedQuantity);
        // click
        productPage.clickAddToCartButton();

        // assert
        int cartTotalItemsAfterTest = productPage.getCartTotalItems();
        Assertions.assertEquals(cartTotalItemsBeforeTest + addedQuantity, cartTotalItemsAfterTest);
        System.out.println("The quantity amount of the Cart was updated " + cartTotalItemsAfterTest);
    }
}*/
