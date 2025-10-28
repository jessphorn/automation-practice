package utilties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementFactory {

    private WebDriver driver;
    
    public WebElementFactory (WebDriver wd) {
        driver = wd;
    }
  
    public WebElement getWebElement(String locateBy, String locator) throws Exception {
        WebElement element = null;
        switch (locateBy) {
        case "css selector":
            element = driver.findElement(By.cssSelector(locator));   
            break;
        case "id":
            element = driver.findElement(By.id(locator));
            break;
        case "link text":
            element = driver.findElement(By.linkText(locator));
            break;
        case "partial link text":
            element = driver.findElement(By.partialLinkText(locator));
            break;
        case "tag":
            element = driver.findElement(By.tagName(locator));
            break;
        case "name":
            element = driver.findElement(By.name(locator));
            break;
        case "class":
            element = driver.findElement(By.className(locator));
            break;
        case "xpath":
            element = driver.findElement(By.xpath(locator));
            break;
        default:
            throw new Exception("Not able to use locator");
            }
        return element;
    }
}
