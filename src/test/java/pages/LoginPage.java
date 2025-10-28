package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.jackson.databind.JsonNode;
import utilties.JSONReader;
import utilties.WebElementFactory;

public class LoginPage {

    private WebDriver driver;
    private JsonNode loginPageLocators;
    private WebElementFactory factory;
    
    private final String LOGIN_LOCATORS = "src/test/resources/locators/loginpage.json";
    private final String LOGIN_VALIDATION_DATA = "src/test/resources/validation-data/loginpage.json";
    
    WebElement loginBtn;
    WebElement loginError;
    WebElement passwordBox;
    WebElement usernameBox;
    

    public LoginPage(WebDriver wd) throws IOException {
        driver = wd;
        loginPageLocators = JSONReader.readJsonFile(LOGIN_LOCATORS);
        factory = new WebElementFactory(driver);
    }
    
    public WebElement getElement(String elementName) throws Exception {
        String locateBy = JSONReader.getLocatedBy(loginPageLocators, elementName);
        return factory.getWebElement(locateBy, JSONReader.getLocator(loginPageLocators, elementName, locateBy));
    }
    
}
