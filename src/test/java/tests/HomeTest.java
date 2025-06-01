package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;

@ExtendWith(ExtentReportExtension.class)
public class HomeTest extends BaseTest {

    static HomePage homepage;

    @BeforeAll
   static void initPageObject() {
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
