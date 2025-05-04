package Example1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class CssSelectorStrategiesTest extends BaseTest2 {

    @Test
    void testTagName() {
        By tagName = By.cssSelector("input");
        WebElement element = driver.findElement(tagName);
        Utility.printElementInfo("Input Name", element);
    }

    //tag name y un atributo
    @Test
    void testTagNameAttr() {
        By inputName_Locator = By.cssSelector("input[type]");
        WebElement element = driver.findElement(inputName_Locator);
        Utility.printElementInfo("inputName_Locator", element);
    }

    //tag name y un atributo con valor
    @Test
    void testTagNameAttrValor() {
        By inputEmail_Locator = By.cssSelector("input[type = 'email']");
        WebElement element = driver.findElement(inputEmail_Locator);
        Utility.printElementInfo("inputEmail_Locator", element);
    }

    //Encontrar el Id usando el numeral
    @Test
    void testId() {
        By inputEmail_Locator = By.cssSelector("#email");
        WebElement element = driver.findElement(inputEmail_Locator);
        Utility.printElementInfo("inputEmail_Locator", element);
    }

    //tag + id usando #
    @Test
    void testTagId() {
        By inputEmail_Locator = By.cssSelector("input#email");
        WebElement element = driver.findElement(inputEmail_Locator);
        Utility.printElementInfo("inputEmail_Locator", element);
    }

    //class usando .
    @Test
    void testClass() {
        By image_Locator = By.cssSelector(".thumbnail");
        WebElement element = driver.findElement(image_Locator);
        Utility.printElementInfo("image_Locator", element);
    }

    //tag y class usnado .
    @Test
    void testTagClass() {
        By image_Locator = By.cssSelector("img.thumbnail");
        WebElement element = driver.findElement(image_Locator);
        Utility.printElementInfo("image_Locator", element);
    }

    //usando * -->cualquier elemento
    @Test
    void testAnyElement() {
        By label_Locator = By.cssSelector("*[class='label']");
        WebElement element = driver.findElement(label_Locator);
        Utility.printElementInfo("label_Locator", element);
    }

    //usando hijos directos dentro de un div Relacion Padre e hijo
    @Test
    void testFatherSon() {
        By form_Locator = By.cssSelector("div>form");
        WebElement element = driver.findElement(form_Locator);
        Utility.printElementInfo("form_Locator", element);
    }

    //usando hermanos directos Relacion de hermanos
    @Test
    void testSiblings() {
        By table_Locator = By.cssSelector("form+table");
        WebElement element = driver.findElement(table_Locator);
        Utility.printElementInfo("table_Locator", element);
    }

    //Partial match Ends with - $=
    @Test
    void testEndsWith() {
        By Btn_AdicionarCurso_Locator = By.cssSelector("button[type$='ton']");
        WebElement element = driver.findElement(Btn_AdicionarCurso_Locator);
        Utility.printElementInfo("Btn_AdicionarCurso_Locator", element);
    }

    //Partial match que empiece with - ^
    @Test
    void testStartsWith() {
        By inputName_Locator = By.cssSelector("*[name^='nam']");
        WebElement element = driver.findElement(inputName_Locator);
        Utility.printElementInfo("inputName_Locator", element);
    }

    //Macheo parcial de una palabra, que contenga la palabra  ~=
    @Test
    void testContainsWord() {
        By checkbox_Java_Locator = By.cssSelector("*[value~='Java']");
        WebElement element = driver.findElement(checkbox_Java_Locator);
        Utility.printElementInfo("checkbox_Java_Locator", element);
    }

    //logical OR (,)  input,*[type='email']
    @Test
    void testLogicalOr() {
        By inputName_Locator = By.cssSelector("input,*[type='email']");
        WebElement element = driver.findElement(inputName_Locator);
        Utility.printElementInfo("inputName_Locator", element);
    }

    //Using Not funtion
    @Test
    void testNotFuntion() {
        By inputLastName_Locator = By.cssSelector("input:not([id='name'])");
        WebElement element = driver.findElement(inputLastName_Locator);
        Utility.printElementInfo("inputLastName_Locator", element);
    }

    //Using varios atributos con valores input[id='tex'][name='lastName']
    @Test
    void testMultipleAttrValor() {
        By inputLastName_Locator = By.cssSelector("input[id='tex'][name='lastName']");
        WebElement element = driver.findElement(inputLastName_Locator);
        Utility.printElementInfo("inputLastName_Locator", element);
    }

    /*Using varios atributos sin valore input[type][name]
    @Test
    void testMultipleAttrValor() {
        By inputLastName_Locator = By.cssSelector("input[id='tex'][name='lastName']");
        WebElement element = driver.findElement(inputLastName_Locator);
        Utility.printElementInfo("inputLastName_Locator", element);
    }*/








}
