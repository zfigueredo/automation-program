package Example1;

import Config.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.io.File;
import java.time.Duration;

public class WaitJSExampleTest extends BaseTest2 {

    By dowloadLink_Locator = By.cssSelector("a[href*='/s/This-is-a-file-to-test-Downloads.txt']");
    By upload_Locator = By.id("photo");


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

    //Probando que se puede hacer con JavaScript
    @Test
    void testLoginWithJExecutor() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('a[href=\"/loginpage\"]').click();");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        jse.executeScript("arguments[0].scrollIntoView()", username);
        jse.executeScript("arguments[0].click()", username);

        jse.executeScript("document.getElementsByName('username')[0].value = 'qualitystream’");
        jse.executeScript("document.getElementsByName('password')[0].value = 'testing123’’");
        jse.executeScript("document.getElementsByName('login')[0].click;");

        wait.until(driver -> driver.getCurrentUrl().contains("/formpage"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/formpage"), "Wrong page");
    }

    @Test
    void testDownload() throws InterruptedException {

        //Utility.clearDownloadFolder(Configuration.DOWNLOAD_PATH);

        File downloadDir = new File(Configuration.DOWNLOAD_PATH);
        File[] previousFiles = downloadDir.listFiles();

        int count;
        if (previousFiles != null) {
            count = previousFiles.length;
        } else {
            count = 0;
        }

        driver.findElement(dowloadLink_Locator).click();
        //boolean fileDownload = Utility.waitForNewFile(downloadDir, 10, count); // wait up to 10 seconds
        Thread.sleep(2000);

        File[] afterDownloadFiles = downloadDir.listFiles();

        Assertions.assertTrue(afterDownloadFiles.length > count, "Files was not download successfully");
    }

    @Test
    void testUploadFile() {
        String picturePath = (System.getProperty("user.dir") + "/src/main/files/Profile Placeholder.png");

        File file = new File(picturePath);

        driver.findElement(upload_Locator).sendKeys(file.getAbsolutePath());

        boolean imageUploaded = false;
        try {
            String src = driver.findElement(By.id("thumbnail")).getDomAttribute("src");
            imageUploaded = !src.isEmpty();
        } catch (Exception e) {
            System.out.println("Image was not uploaded correctly");
            e.printStackTrace();
        }

        Assertions.assertTrue(imageUploaded, "Image was not uploaded correctly");

    }

}


