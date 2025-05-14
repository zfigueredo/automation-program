package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    //Objetos de la clase
    WebDriver driver;
    WebDriverWait wait;

    private static final int TIMEOUT = 10;

   //Constructor de la clase
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public WebElement findElement(By locator){
        waitForElementToBePresent(locator);//preguntar tamb a la profe
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        waitForElementToBePresent(locator);
        return driver.findElements(locator);
    }

    public String getText(By locator){
        return findElement(locator).getText();
    }

    public boolean isDisplayed(By locator){
        try {
            // condicion para asegurar que el elemento esta visible
            // preguntar a la profe.
            waitForElementToBeVisible(locator);
           return findElement(locator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void navigate(String url){driver.get(url);}

    public void selectByVisibleText(By locator, String text){
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value){
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(By locator, int index){
        WebElement element = findElement(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }


    public void acceptAlert(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendKeysToAlert(String msg){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(msg);
        alert.accept();
    }

    public String getAlertText(){
        waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToNewWindows(String originalHandle){
        waitForNewWindow();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle: allWindows){
            System.out.println("handle: "+handle);
            if(!handle.equals(originalHandle)){
                driver.switchTo().window(handle);
            }
        }

    }

    public void waitForeAlertToBePresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForAlertToBePresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForNewWindow(){
        wait.until((ExpectedCondition<Boolean>)
                d -> d !=null && d.getWindowHandles().size()>1);
    }

    public void waitForElementToBePresent(By locator){
       wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public void waitForElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void type(By locator, String text){
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void submit(By locator){
        WebElement element = findElement(locator);
        element.submit();
    }

    //metodos agregado por la profe porque cuando le abre su pagina se ve pequenna y hay cosas que se overlap
    public void scrollIntoViewAndClick(WebElement element){
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }

    public void scrollIntoViewAndClick(By locator){
        waitForElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
        js.executeScript("arguments[0].click()",element);
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
