package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

public class KayakStaysPage extends AbstractPage {

    public static String BASE_URL = "https://www.kayak.com/stays";
    private static final Logger logger = LogManager.getLogger();
    private final By searchButton = By.xpath("//button[@aria-label=\"Search\"]");
    private static By errorFragment = By.xpath("//div[@class=\"dDYU-body\"]");

    public KayakStaysPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public KayakStaysPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public KayakStaysPage clickOnSearchButton() {
        WebElement searchBtn = findByLocator(searchButton);
        searchBtn.click();
        return new KayakStaysPage(driver);
    }

    public boolean appearErrorFragment() {
        WebElement errorWindow = findByLocator(errorFragment);
        if (errorWindow.isDisplayed()) {
            logger.info("Error window was opened successfully");
            return true;
        } else return false;
    }

}


