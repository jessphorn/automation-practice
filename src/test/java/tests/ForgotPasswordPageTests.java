package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import setup.BasePage;

public class ForgotPasswordPageTests extends BasePage {

    ForgotPasswordPage forgotPwd;
    HomePage home;
    LoginPage login;
    
    WebDriver driver;
    
    @Before
    public void setUpScenario() throws Exception {
	setup("Edge", "https://ecommerce-playground.lambdatest.io/");
	driver = getDriver();
    }
    
    @Given("User is on Poco Mega Store Forgot Password page {string}")
    public void goToForgotPasswordPage(String url) throws Exception {
	home = new HomePage(driver);
	forgotPwd = home.navigateToForgotPassword();
	Assert.assertTrue(forgotPwd.verifyOnForgotPasswordPage(url));
    }
    
    @When("User enters email address as {string}")
    public void enterEmail(String email) throws Exception {
	login = forgotPwd.retrievePassword(email);
    }
    
    @Then("User should be able to see message {string}")
    public void verifyPwdRetrieval(String message) {
	if (login != null) {
	    Assert.assertTrue(login.verifyPwdRetrievalSuccess(message));
	} else {
	    Assert.assertTrue(forgotPwd.verifyPwdRetrievalError(message));
	}
    }
    
    @After
    public void tearDownScenario() {
	teardown();
    }
}
