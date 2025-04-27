package Class1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QSAboutTest {
    @Test
    void verifyAboutPage() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

        By aboutLink_Locator = By.xpath("//div[@class='header-nav-item header-nav-item--collection']//a[@href='/about']");
        By aboutImage_Locator = By.xpath("//img[contains(@src, 'IMG_0481.JPG')]");

        driver.findElement(aboutLink_Locator).click();
        String expectedUrl = "https://www.qualitystream-practice.com/about";
        String currentUrl = driver.getCurrentUrl();

        System.out.println( "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);

        Assertions.assertEquals(expectedUrl, currentUrl, "Failed: Current URL is not the expected one " +
                "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);

        boolean is_ImagePresent = driver.findElement(aboutImage_Locator).isDisplayed();

        System.out.println("isImagePresent: "+is_ImagePresent);

        Assertions.assertTrue(is_ImagePresent, "Failed: About image was not present");

        driver.quit();

    }

    @Test
    void tarea1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

        By bottomsLocator = By.xpath("//a[@href='/shop/bottoms']");
        driver.findElement(bottomsLocator).click();
        //Actions action = new Actions(driver);--esto es para estudiar luego, con esto hago scroll
        //action.scrollToElement(driver.findElement(bottomsLink_Locator)).performance();

        String expectedUrl = "https://www.qualitystream-practice.com/shop/bottoms";
        String currentUrl = driver.getCurrentUrl();
        System.out.println( "CurrentUrl:"+currentUrl+ " Expected:"+expectedUrl);
        Assertions.assertEquals(expectedUrl, currentUrl, "Failed: Current URL is not the expected one " +
                "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);

        Thread.sleep(2000);
        driver.navigate().back();


        By topsLocator = By.xpath("//a[@href='/shop/tops']");
        driver.findElement(topsLocator).click();

        expectedUrl = "https://www.qualitystream-practice.com/shop/tops";
        currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl, "Failed: Current URL is not the expected one " +
                "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);
        Thread.sleep(2000);

        By allTopLocator = By.xpath("//a[@href='/shop']");
        driver.findElement(allTopLocator).click();
        //Actions action = new Actions(driver);--esto es para estudiar luego, es para hacer scroll en la pagina
        //action.scrollToElement(driver.findElement(bottomsLink_Locator)).perform();

        expectedUrl = "https://www.qualitystream-practice.com/shop";
        currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl, "Failed: Current URL is not the expected one " +
                "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);
        Thread.sleep(2000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));--para estudiar uego, esto es otra forma de usar la espera
        //wait.until(ExpectedConditions.presenceOfElementLocated(xxxxxx));

        driver.quit();
    }

    @Test
    void tarea1Adv() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();

        // click en bottoms
        String expectedUrl = "https://www.qualitystream-practice.com/shop/bottoms";
        this.hacerClickEnLink(driver, "//a[@href='/shop/bottoms']", expectedUrl);

        Thread.sleep(2000);
        driver.navigate().back();

        expectedUrl = "https://www.qualitystream-practice.com/shop/tops";
        this.hacerClickEnLink(driver, "//a[@href='/shop/tops']", expectedUrl);

        Thread.sleep(2000);

        expectedUrl = "https://www.qualitystream-practice.com/shop";
        this.hacerClickEnLink(driver, "//a[@href='/shop']", expectedUrl);

        Thread.sleep(2000);
        driver.quit();
    }

    void hacerClickEnLink(WebDriver driver, String elementPath, String expectedUrl) {
        By bottomsLocator = By.xpath(elementPath);
        driver.findElement(bottomsLocator).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println( "CurrentUrl:"+currentUrl+ " Expected:"+expectedUrl);
        Assertions.assertEquals(expectedUrl, currentUrl, "Failed: Current URL is not the expected one " +
                "CurrentUrl:"+currentUrl+ "Expected:"+expectedUrl);
    }
}
