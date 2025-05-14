package tests;

import Example1.BaseTest2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;
import pages.HomePage;
import pages.WebElementsTestPage;

import java.time.Duration;

public class HandlingElementsTest extends BaseTest2 {

    HomePage homePage;
    WebDriverWait wait;
    WebElementsTestPage webElementsTestPage;
    private AlertsPage alertsPage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver);
        alertsPage = new AlertsPage(driver);
        homePage.clickOnWebElementTestLink();
        webElementsTestPage = new WebElementsTestPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void openNewWindow() {

        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window handle:"+originalHandle);
        Assertions.assertNotNull(originalHandle,"Original handle was null");

        webElementsTestPage.clickOnNewWindow();
        webElementsTestPage.switchToNewWindows(originalHandle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL"+currentURL);
        Assertions.assertTrue(currentURL.contains("quality-stream.com/productos"), "New window URL is not correct");

        //Cerrar la nueva ventana y volver a la original

        driver.close();
        driver.switchTo().window(originalHandle);

        String originalURL = driver.getCurrentUrl();
        System.out.println("originalURL: "+originalURL);
        Assertions.assertTrue(originalURL.contains("qualitystream-practice.com/webelements-test"),"Original window url is not correct");



    }


    @Test
    void openNewTab() {
        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window handle:"+originalHandle);
        Assertions.assertNotNull(originalHandle,"Original handle was null");

        webElementsTestPage.clickOnNewTab();
        webElementsTestPage.switchToNewWindows(originalHandle);
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL"+currentURL);
        Assertions.assertTrue(currentURL.contains("https://www.youtube.com/c/QualityStream"), "New tab URL is not correct");

        //Cerrar el nuevo tab y volver a la original

        driver.close();
        driver.switchTo().window(originalHandle);

        String originalURL = driver.getCurrentUrl();
        System.out.println("originalURL: "+originalURL);
        Assertions.assertTrue(originalURL.contains("qualitystream-practice.com/webelements-test"),"Original window url is not correct");


    }

    @Test
    void alertBoxTest() {
        webElementsTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeAlertBox();
        String expectedText = "Hola! I am an alert box!";
        String alertText = alertsPage.getAlertText();
        System.out.println("expectedText: "+expectedText+" | alertText: "+alertText);
        alertsPage.acceptAlert();
        Assertions.assertTrue(expectedText.equals(alertText),"Alert text is not correct");
    }

    @Test
    void cancelAlertTest() {
        webElementsTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.dismissAlert();

        String expectedText = "Cancelaste la alerta";
        String currentText = alertsPage.get_ConfirmAlertText();
        System.out.println("expectedText: "+expectedText+" | currentText: "+currentText);
        Assertions.assertTrue(expectedText.equals(currentText),"Current text is not correct");
    }

    @Test
    void confirmAlertTests() {
        webElementsTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypeConfirm();
        alertsPage.acceptAlert();
        String expectedText = "Aceptaste la alerta";
        String currentText = alertsPage.get_ConfirmAlertText();
        System.out.println("expectedText: "+expectedText+" | currentText: "+currentText);
        Assertions.assertTrue(expectedText.equals(currentText),"Current text is not correct");

    }

    @Test
    void promptAlertTest() {
        webElementsTestPage.clickOnAlertsLink();
        alertsPage.clickOnAlert_TypePrompt();
        alertsPage.sendKeysToAlert("QualityStream");
        String expectedText = "Hola QS! Como estas hoy?";
        String currentText = alertsPage.get_PromptAlertText();
        System.out.println("expectedText: "+expectedText+" | currentText: "+currentText);
        Assertions.assertTrue(expectedText.equals(currentText),"Prompt text is not correct");
    }

    @Test
    void handleCookies() {

        for (Cookie cookie : driver.manage().getCookies())
        {
            /*if(cookie.getName().equals("crumb"))
                driver.manage().deleteCookie(cookie);*/
            System.out.println("--------------- Cookie Info ---------------");
            System.out.println("Name:" + cookie.getName());
            System.out.println("Value:" + cookie.getValue());
            System.out.println("Domain:" + cookie.getDomain());
            System.out.println("Path:" + cookie.getPath());
            System.out.println("Secure?:" + cookie.isSecure());
            System.out.println("HTTP only?:" + cookie.isHttpOnly());
            System.out.println("Full text:" + cookie);
        }
    }
}
