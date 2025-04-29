package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QSCreditCardsPage extends BasePage{

    //Links Localizador
    By inputPassword_Locator = By.name("password");

    //Credit Cards Localizadores
    By diamondCC_Locator = By.xpath("//img[contains(@src,'QStream+Diamond+Credit+Card1.png')]");
    By goldenCC_Locator = By.xpath("//img[contains(@src,'QStream+Golden+Credit+Card1.png')]");
    By platinumCC_Locator = By.xpath("//img[contains(@src,'QStream+Platinum+Credit+Card1.png')]");

    //Form Localizador
    By selectCCType_Locator = By.id("cardType");
    By creditCardDetailsLabels_Locator = By.id("cardDetails");//Me sirve tamb para obtener el interes de las CC
    By purchaseAmountInput_Locator = By.id("purchaseAmount");
    By purchaseButton_Locator = By.xpath("//button[normalize-space()='Realizar Compra']");
    By buyButton_Locator = By.xpath("//button[normalize-space()='Realizar Pago']");
    By paymentAmountInput_Locator = By.id("paymentAmount");
    By IncludeInterestCheckbox_Locator = By.id("includeInterest");

    //Labels Localizator
    By balanceLabel_Locator = By.id("balance");
    By interestLabel_Locator = By.id("interest");
    By totalBalanceLabel_Locator = By.id("totalBalance");

    //Constructor de la clase
    public QSCreditCardsPage(WebDriver driver) {
        super(driver);
    }

    public void enterPassword(){
       // waitForElementToBeClickable(inputPassword_Locator); lo que agrego la profe

        if(isDisplayed(inputPassword_Locator)){
            String password= "qa123";
            type(inputPassword_Locator,password);
            submit(inputPassword_Locator);
        }else{
            System.out.println("Password input was not present");
        }

    }

    public boolean areCreditCardPresent(){
            boolean diamondCD = isDisplayed(diamondCC_Locator);
            System.out.println("Is Diamond CC Present:"+diamondCD);

            boolean goldenCD = isDisplayed(goldenCC_Locator);
            System.out.println("Is Golden CC Present:"+goldenCD);

            boolean platinumCD = isDisplayed(platinumCC_Locator);
            System.out.println("Is Platinum CC Present:"+platinumCD);

            return diamondCD && goldenCD && platinumCD;
        }

    public void selectCreditCard(String creditCardType){
            Select select = new Select(findElement(selectCCType_Locator));
            select.selectByValue(creditCardType);
        }

    public String creditDetailsUpdate(){
        String details = getText(creditCardDetailsLabels_Locator);
        System.out.println("Credit Card details: "+details);
        return details;

        }

    }

