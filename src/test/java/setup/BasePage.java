package setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BasePage {
    
    private WebDriver driver;
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public void setup(String browser, String url) throws Exception {
        switch(browser) {
        case "Chrome":
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
            driver = new ChromeDriver();
            break;
        case "Edge":
            System.setProperty("webdriver.chrome.driver", "drivers//msedgedriver.exe");
            driver = new EdgeDriver();
            break;
        case "Firefox":
            System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
            driver = new FirefoxDriver();
            break;
        default:
            throw new Exception("No such driver available");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }
    
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
