package tests;

import Config.BrowserType;
import Config.DriverManager;
import Config.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        driver.get("https://www.qualitystream-practice.com/");
    }

    @AfterAll
    static void tearDown() {
        DriverManager.quitDriver();
    }
}
