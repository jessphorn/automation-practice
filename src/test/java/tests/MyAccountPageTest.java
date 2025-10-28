package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import setup.BasePage;

public class MyAccountPageTest extends BasePage {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void loginTestPositive() throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage login = home.navigateToLogin();
        MyAccountPage myAcct = login.login("jtest@email.com", "test123");
        Assert.assertTrue(myAcct.verifyLogin());
    }
    
}
