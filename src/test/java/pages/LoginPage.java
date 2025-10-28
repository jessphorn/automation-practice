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

@FindBy(css = "input[value='Login']")
WebElement loginBtn;
@FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
WebElement loginError;
@FindBy(id = "input-password")
WebElement passwordBox;
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

public MyAccountPage login(String username, String password) throws Exception {
    MyAccountPage myAcct = null;
    usernameBox.sendKeys(username);
    passwordBox.sendKeys(password);
    loginBtn.click();
    myAcct = new MyAccountPage(driver);
    new WebDriverWait(driver, Duration.ofMillis(20000)).until(ExpectedConditions.titleIs(myAcct.title));
    return myAcct;
}
    
}
