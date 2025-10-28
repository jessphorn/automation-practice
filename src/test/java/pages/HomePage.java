package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.jackson.databind.JsonNode;
import utilties.JSONReader;
import utilties.WebElementFactory;

public class HomePage {

    private WebDriver driver;
    private JsonNode homePageLocators;
    private WebElementFactory factory;
    
    private final String HOME_LOCATORS = "src/test/resources/locators/homepage.json";
    private final String HOME_VALIDATION_DATA = "src/test/resources/validation-data/homepage.json";
    

    
    public HomePage(WebDriver wd) throws IOException {
        this.driver = wd;
        homePageLocators = JSONReader.readJsonFile(HOME_LOCATORS);
        factory = new WebElementFactory(driver);
    }
    
    public WebElement getElement(String elementName) throws Exception {
        String locateBy = JSONReader.getLocatedBy(homePageLocators, elementName);
        return factory.getWebElement(locateBy, JSONReader.getLocator(homePageLocators, elementName, locateBy));
    }
    
}
