package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "not @IgnoreMe", features = {"src/test/resources/features"}, 
glue = {"tests"}, plugin = {})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    
}
