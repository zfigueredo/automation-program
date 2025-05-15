package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    HomePage homepage;

    @BeforeEach
    void initPageObject() {
        homepage = new HomePage();
    }

    @Test
    void verifyQSCreditCardsLink() {
        homepage.isQSCreditCardsLinksDisplayed();
        assertTrue(homepage.isQSCreditCardsLinksDisplayed(), "Credit Card link is not present");
    }

    @Test
    void verifyHeaderYtIcon() {
        assertTrue(homepage.isHeaderYTIconIsDisplayed(),"Youtube icon is in the header is not present");
    }

    @Test
    void verifyHomePageFilter() {
        assertTrue(homepage.allFilter(),"Filter are not present");
    }
}
