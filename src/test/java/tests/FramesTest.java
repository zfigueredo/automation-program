package tests;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ActionPage;
import pages.HomePage;
import pages.WebElementsTestPage;

import java.time.Duration;

@ExtendWith(ExtentReportExtension.class)
public class FramesTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(FramesTest.class);

    static HomePage homePage;
    static WebElementsTestPage webElementTestPage;

    @BeforeAll
    static void init() {
        homePage = new HomePage();
        webElementTestPage = new WebElementsTestPage();
        homePage.clickOnWebElementTestLink();
        webElementTestPage.clickOnFramesLink();
    }

    @Test
    void testMultiFrame() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Switch to frames using name.
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        WebElement rightText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        String text = rightText.getText().trim();

        logger.info("text: "+text);

        Assertions.assertEquals("QUALITYSTREAM\nRIGHT-FRAME",text, "Right frame text is not correct");

        //Regresar al frame principal
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftText = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        String text_leftFrame = leftText.getText().trim();

        logger.info("text_leftFrame: "+text_leftFrame);

        Assertions.assertEquals("QUALITYSTREAM\nLEFT-FRAME",text_leftFrame, "Left frame text is not correct");

        driver.switchTo().defaultContent();

        Assertions.assertEquals("Nested Frames Example",driver.getTitle(),"We are not in the main frame");
    }
}
