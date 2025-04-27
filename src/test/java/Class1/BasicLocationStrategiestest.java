package Class1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class BasicLocationStrategiestest extends BaseTest2{

    @Test
    void testId() {
        By inputName_Locator = By.id("name");
        WebElement element = driver.findElement(inputName_Locator);
                Utility.printElementInfo("Input name", element);
    }

    @Test
    void testName() {
        By inputEmail_Locator = By.id("email");
        WebElement element = driver.findElement(inputEmail_Locator);
        Utility.printElementInfo("Input email", element);
    }

    @Test
    void testclassName() {
        By imageThumbnail_Locator = By.className("thumbnail");
        WebElement element = driver.findElement(imageThumbnail_Locator);
        Utility.printElementInfo("ImageThumbnail", element);
    }

    @Test
    void testTagName() {
        By table_Locator = By.tagName("table");
        //Para obtener una lista de links
        //List<WebElement> linkList = driver.findElemens(By.tagName("a"));
        WebElement element = driver.findElement(table_Locator);
        Utility.printElementInfo("table_Locator", element);
    }

    @Test
    void testLinkTex() {
        By appointmentLink_Locator = By.linkText("Go to Appointment Page");
        WebElement element = driver.findElement(appointmentLink_Locator);
        Utility.printElementInfo("appointmentLink_Locator", element);
    }

    @Test
    void testPartialLinkTex() {
        By appointmentLink_Locator = By.partialLinkText("Go to");
        WebElement element = driver.findElement(appointmentLink_Locator);
        Utility.printElementInfo("appointmentLink_Locator", element);
    }










}
