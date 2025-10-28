package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.JSONReader;

public class MyAccountPage {

    private WebDriver driver;

    private final String MY_ACCT_VALIDATION_DATA = "src/test/resources/validation-data/myaccountpage.json";

    String url;
    String title;

    public MyAccountPage(WebDriver wd) throws Exception {
        driver = wd;
        initialize();
    }

    private void initialize() throws Exception {
        PageFactory.initElements(driver, this);
        url = JSONReader.getTestData(MY_ACCT_VALIDATION_DATA, "url");
        title = JSONReader.getTestData(MY_ACCT_VALIDATION_DATA, "title");
    }   

    public boolean verifyLogin() {
        return driver.getTitle().equals(title);
    }
}
