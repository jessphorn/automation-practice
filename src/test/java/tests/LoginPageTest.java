package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import setup.BasePage;

public class LoginPageTest extends BasePage {
    
    HomePage home;
    LoginPage login;
    MyAccountPage myAcct;
    
    boolean loggedIn;
    
    WebDriver driver;

    @Before
    public void setUpScenario() throws Exception {
	setup("Edge", "https://ecommerce-playground.lambdatest.io/");
	driver = getDriver();
    }

    @Given("User is on Poco Mega Store login page {string}")
    public void goToLoginPage(String url) throws Exception {
        home = new HomePage(driver);
        login = home.navigateToLogin();
    }
    
    @When("User enters username as {string} and password as {string}")
    public void login(String username, String password) throws Exception {
        myAcct = login.login(username, password);
    }
    
    @Then("User should be able to login successfully and the My Account page opens")
    public void verifyLogin() {
        Assert.assertTrue(myAcct.verifyLogin());
        loggedIn = true;
    }
    
    @Then("User should be able to see errorMessage {string}")
    public void verifyErrorMessage(String expectedError) {
        Assert.assertTrue(login.verifyLoginError(expectedError));
        loggedIn = false;
    }
    
    @When("User enters username as {string} and password as {string} {int} times")
    public void attemptToLogin(String username, String password, int attempts) throws Exception {
	for(int i = 0; i < attempts; i++) {
	    login.login(username, password);
	}
    }
    
    @After
    public void tearDownScenario() {
	teardown();
    }
    
}
