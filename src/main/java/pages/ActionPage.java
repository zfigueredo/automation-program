package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionPage extends BasePage{


    By textArea1_Locator = By.id("inputText");
    By textArea2_Locator = By.id("inputText2");

    By menu1Button_Locator = By.xpath("//button[normalize-space()='Menu 1']");
    By option1B_Button_Locator = By.xpath("//button[normalize-space()='Option 1B']");

    By selectedOption_Locator = By.id("output");

    public ActionPage() {

    }

    public String verifyKeysChord(String text){
        WebElement textArea = findElement(textArea1_Locator);
        textArea.clear();

        textArea.sendKeys(Keys.chord(Keys.SHIFT,text));
        return textArea.getAttribute("value");
    }

    public String verifyActionKeyboard(String text){
        WebElement textArea = findElement(textArea1_Locator);
        textArea.clear();

        Actions action = new Actions(driver);

        action.keyDown(Keys.SHIFT).sendKeys(textArea,text).keyUp(Keys.SHIFT).build().perform();

        return textArea.getAttribute("value");
    }

    public String verifyActionCopyPaste(String text){

        WebElement textArea1 = findElement(textArea1_Locator);
        textArea1.clear();
        WebElement textArea2 = findElement(textArea2_Locator);
        textArea2.clear();

        Actions action = new Actions(driver);
        //Escribimos en mayúsculas con SHIFT presionado
        action.keyDown(Keys.SHIFT)
                .sendKeys(textArea1, text)
                .keyUp(Keys.SHIFT).perform();

        //Seleccionamos con CTRL+A y copiamos con CTRL+C
        action.click(textArea1)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

        // Pegamos en el segundo textarea
        action.click(textArea2)
                .keyDown(Keys.CONTROL)
                .sendKeys(textArea2,"v")
                .keyUp(Keys.CONTROL)
                .perform();

        return textArea2.getAttribute("value");
    }

    public String selectMenuOption1B(){
        WebElement menu1Btn = findElement(menu1Button_Locator);
        WebElement option1B = findElement(option1B_Button_Locator);
        Actions action = new Actions(driver);
        action.moveToElement(menu1Btn).moveToElement(option1B).click().perform();
        return getText(selectedOption_Locator);
    }




}
