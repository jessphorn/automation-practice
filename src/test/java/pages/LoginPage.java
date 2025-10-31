package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.JSONReader;

public class LoginPage {

private WebDriver driver;

private final String LOGIN_VALIDATION_DATA = "src/test/resources/validation-data/loginpage.json";

String url;
String title;

@FindBy(linkText = "Forgotten Password")
WebElement forgotPwdBtn;
@FindBy(css = "input[value='Login']")
WebElement loginBtn;
@FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
WebElement loginError;
@FindBy(id = "input-password")
WebElement passwordBox;
@FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
WebElement retrievalSuccess;
@FindBy(id = "input-email")
WebElement usernameBox;

public LoginPage(WebDriver wd) throws Exception {
    driver = wd;
    initialize();
}

private void initialize() throws Exception {
    PageFactory.initElements(driver, this);
    url = JSONReader.getTestData(LOGIN_VALIDATION_DATA, "url");
    title = JSONReader.getTestData(LOGIN_VALIDATION_DATA, "title");
}

public boolean verifyLoginError(String expected) {
    return loginError.getText().contains(expected);
}

public boolean verifyOnLoginPage(String expected) {
    return driver.getCurrentUrl().equals(expected);
}

public boolean verifyPwdRetrievalSuccess(String expected) {
    return retrievalSuccess.getText().contains(expected);
}

public MyAccountPage login(String username, String password) throws Exception {
    MyAccountPage myAcct = null;
    usernameBox.clear();
    passwordBox.clear();
    usernameBox.sendKeys(username);
    passwordBox.sendKeys(password);
    loginBtn.click();
    myAcct = new MyAccountPage(driver);
    try {
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.titleIs(myAcct.title));
    } catch (Exception e) {
       myAcct = null;
    }
    return myAcct;
}

public ForgotPasswordPage navigateToForgotPassword() throws Exception {
    ForgotPasswordPage forgotPwd = null;
    forgotPwdBtn.click();
    forgotPwd = new ForgotPasswordPage(driver);
    try {
	new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions.titleIs(forgotPwd.title));
    } catch (Exception e) {
	forgotPwd = null;
    }
    return forgotPwd;
    
}
    
}
