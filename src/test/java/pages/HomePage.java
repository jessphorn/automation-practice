package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.JSONReader;

public class HomePage {

    private WebDriver driver;

    private final String HOME_VALIDATION_DATA = "src/test/resources/validation-data/homepage.json";

    String url;
    String title;

    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]")
    WebElement myAcctDD;
    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a")
    WebElement loginLink;

    public HomePage(WebDriver wd) throws Exception {
	driver = wd;
	initialize();
    }

    private void initialize() throws Exception {
	PageFactory.initElements(driver, this);
	url = JSONReader.getTestData(HOME_VALIDATION_DATA, "url");
	title = JSONReader.getTestData(HOME_VALIDATION_DATA, "title");
    }

    public LoginPage navigateToLogin() throws Exception {
	LoginPage login = null;
	Actions action = new Actions(driver);
	action.moveToElement(myAcctDD).perform();
	loginLink.click();
	login = new LoginPage(driver);
	new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.titleIs(login.title));
	return login;
    }

    public void returnHome() {
        driver.get(url);;
    }
}
