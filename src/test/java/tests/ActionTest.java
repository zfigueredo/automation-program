package tests;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ActionPage;
import pages.HomePage;
import pages.WebElementsTestPage;

@ExtendWith(ExtentReportExtension.class)
@Tag("Action_Regression")
public class ActionTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(ActionTest.class);
    static HomePage homePage;
    static WebElementsTestPage webElementTestPage;
    static ActionPage actionPage;

    @BeforeAll
    static void init() {
        homePage = new HomePage();
        webElementTestPage = new WebElementsTestPage();
        actionPage = new ActionPage();
        homePage.clickOnWebElementTestLink();
        webElementTestPage.clickOnHoverOverMenuLink();
    }

    @Test
    void testKeysChord() {

        String text = actionPage.verifyKeysChord("qualitystream");
        logger.info("text:"+text);

        Assertions.assertTrue(text.equals("QUALITYSTREAM"),"Keys chord failed");
    }

    @Test
    public void testActionKeyboard() {

        String value = actionPage.verifyActionKeyboard("testing");
        logger.info("value: "+value);

        Assertions.assertTrue(value.equals("TESTING"), "Actions method failed");
    }

    @Test
    public void testActionCopyPaste(){

        String value = actionPage.verifyActionCopyPaste("test automation");
        logger.info("value:" + value);
        Assertions.assertTrue(value.equals("TEST AUTOMATION"), "Actions method failed");

    }

    @Test
    public void testHoverOver(){

        String value = actionPage.selectMenuOption1B();
        logger.info("value:" + value);
        Assertions.assertTrue(value.equals("You clicked: Option 1B"), "Actions method failed");

    }



}
