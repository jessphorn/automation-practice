package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import setup.BasePage;

public class TestListeners extends BasePage implements ITestListener {
 
    WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        driver = getDriver();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./screenshot/" + result.getName() + result.id() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
