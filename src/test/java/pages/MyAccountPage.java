package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tools.jackson.databind.JsonNode;
import utilties.JSONReader;
import utilties.WebElementFactory;

public class MyAccountPage {

    private WebDriver driver;
    private JsonNode myAcctPageLocators;
    private WebElementFactory factory;

    private final String MY_ACCT_LOCATORS = "src/test/resources/locators/myaccountpage.json";
    private final String MY_ACCT_VALIDATION_DATA = "src/test/resources/validation-data/myaccountpage.json";
    
    public MyAccountPage(WebDriver wd) throws IOException {
        driver = wd;
        myAcctPageLocators = JSONReader.readJsonFile(MY_ACCT_LOCATORS);
        factory = new WebElementFactory(driver);
    }
    
    public WebElement getElement(String elementName) throws Exception {
        String locateBy = JSONReader.getLocatedBy(myAcctPageLocators, elementName);
        return factory.getWebElement(locateBy, JSONReader.getLocator(myAcctPageLocators, elementName, locateBy));
    }
    
}
