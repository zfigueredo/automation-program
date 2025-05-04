package Example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitJSExampleTest extends BaseTest2 {

    By dowloadLink_Locator = By.cssSelector("a[href*='/s/This-is-a-file-to-test-Downloads.txt']");

    @Test
    void testImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18));
        boolean result = driver.findElement(dowloadLink_Locator).isDisplayed();
    }

    @Test
    void testExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(dowloadLink_Locator));

                Assertions.assertTrue(link.isDisplayed(), "link was not present");

    }

    @Test
    void testFluentWait() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement link = wait.until(
                driver -> driver.findElement(dowloadLink_Locator)
        );
        Assertions.assertTrue(link.isDisplayed(), "Link was not present");
    }
}
