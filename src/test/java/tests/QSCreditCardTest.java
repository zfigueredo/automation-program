package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.QSCreditCardsPage;

public class QSCreditCardTest extends BaseTest {
    HomePage homepage;
    QSCreditCardsPage creditCardsPage;

    @BeforeEach
    void initPageObject() throws InterruptedException {
        homepage = new HomePage(driver);
        homepage.clickOnQSCreditCardsLink();

        System.out.println(driver.getCurrentUrl());
        creditCardsPage = new QSCreditCardsPage(driver);
        creditCardsPage.enterPassword();
    }

    @Test
    void areCreditCardsImagesPresent() {
        Assertions.assertTrue(creditCardsPage.areCreditCardPresent(),
                "Credit Card Images are not present");
    }

    @Test
    @DisplayName("Is the Diamond interest updated?")
    void selectionDiamondCC() {
        // seleccionar la tarjeta diamond
        creditCardsPage.selectCreditCard("diamond");
        // verificar que el texto se actualiza
        Assertions.assertEquals("Interés: 18.81% Anual Fee: $550", creditCardsPage.creditDetailsUpdate());
        System.out.println("The Diamond CC interest is update successfully");
    }

    @Test
    @DisplayName("Is the Golden interest updated?")
    void selectionGoldenCC() {
        creditCardsPage.selectCreditCard("golden");
        Assertions.assertEquals("Interés: 20.31% Anual Fee: $350", creditCardsPage.creditDetailsUpdate());
        System.out.println("The Golden CC interest is update successfully");
    }

    @Test
    @DisplayName("Is the Platinum interest updated?")
    void selectionPlatinum() {
        creditCardsPage.selectCreditCard("platinum");
        Assertions.assertEquals("Interés: 22.58% Anual Fee: $150", creditCardsPage.creditDetailsUpdate());
        System.out.println("The Platinum CC interest is update successfully");
    }
}
