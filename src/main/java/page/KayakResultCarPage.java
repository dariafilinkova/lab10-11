package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KayakResultCarPage extends AbstractPage {

    private final By listOfCars = By.xpath("//div[@class='jo6g']");
    private static final Logger logger = LogManager.getLogger();

    public KayakResultCarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public KayakResultCarPage openPage() {
        logger.info("click search");
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public List<WebElement> getListOfCars() {
        return getElementList(listOfCars);
    }
}
