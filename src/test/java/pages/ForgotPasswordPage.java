package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.JSONReader;

public class ForgotPasswordPage {

    private WebDriver driver;

    private final String FORGOT_PWD_VALIDATION_DATA = "src/test/resources/validation-data/forgotpasswordpage.json";

    String url;
    String title;
    
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/button")
    WebElement continueBtn;
    @FindBy(id = "input-email")
    WebElement emailBox;
    @FindBy(xpath = "//*[@id=\"account-forgotten\"]/div[1]")
    WebElement retrievalError;
    
    public ForgotPasswordPage(WebDriver wd) throws Exception {
	driver = wd;
	initialize();
    }
    
    private void initialize() throws Exception {
	PageFactory.initElements(driver, this);
	url = JSONReader.getTestData(FORGOT_PWD_VALIDATION_DATA, "url");
	title = JSONReader.getTestData(FORGOT_PWD_VALIDATION_DATA, "title");
    }

    public boolean verifyOnForgotPasswordPage(String expected) {
	return driver.getCurrentUrl().equals(expected);
    }
    
    public boolean verifyPwdRetrievalError(String expected) {
	return retrievalError.getText().contains(expected);
    }
    
    public LoginPage retrievePassword(String email) throws Exception {
	LoginPage login = null;
	emailBox.clear();
	emailBox.sendKeys(email);
	continueBtn.submit();
	login = new LoginPage(driver);
	try {
	    new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.titleIs(login.title));
	} catch (Exception e) {
	    login = null;
	}
	return login;
    }
}
