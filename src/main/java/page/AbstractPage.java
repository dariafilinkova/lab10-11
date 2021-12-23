package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage
{
    protected static WebDriver driver;
    protected abstract AbstractPage openPage();
    protected static int WAIT_TIMEOUT_SECONDS = 500;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public static WebElement findByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findByLocatorWithClickableCondition(By locator){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS*2)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> findAllByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean checkTextPresence(WebElement element, String text){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public String getElementText(By locator){
        WebElement element = findByLocator(locator);
        return element.getText();
    }

    public WebElement getFirstElement(By locator){
        List<WebElement> element = findAllByLocator(locator);
        return element.get(0);
    }
    public WebElement getSecondElement(By locator){
        List<WebElement> element = findAllByLocator(locator);
        return element.get(1);
    }

    public List<WebElement> getElementList(By locator){
        List<WebElement> element = findAllByLocator(locator);
        return element;
    }
}