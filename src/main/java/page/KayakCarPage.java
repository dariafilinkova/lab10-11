package page;

import model.JourneyData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.JourneyCreator;


public class KayakCarPage extends AbstractPage {

    public static String PAGE_URL = "https://www.kayak.com/cars";

    private final By searchButton = By.xpath("//button[@title='Search cars']");
    private final By destination = By.xpath("//div[@aria-label='Pick-up location']");
    private final By enteredDestination= By.xpath("//input[@class='k_my-input' and @tabindex='-1']");
    private final By foundedDestination=By.xpath("//div[@class='JyN0-name-container']");


    public KayakCarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public KayakCarPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public KayakCarPage enterDestination(JourneyData journeyData) {
        WebElement inputDestination = findByLocatorWithClickableCondition(enteredDestination);
        inputDestination.sendKeys(journeyData.getDestination());
        return this;
    }

    public KayakCarPage search() {
        WebElement searchBtn = findByLocator(searchButton);
        searchBtn.click();
        return this;
    }

    private WebElement getElement(String xpath) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public KayakCarPage clickOnDestination() {
        WebElement path = findByLocatorWithClickableCondition(destination);
        path.click();
        return this;
    }

    public KayakCarPage clickOnEnteredDestination() {
        WebElement path = findByLocatorWithClickableCondition(foundedDestination);
        path.click();
        return this;
    }

    public KayakCarPage fillDestination(){
        JourneyData journeyData = JourneyCreator.journeyFromProperty();
        clickOnDestination();
        enterDestination(journeyData);
        clickOnEnteredDestination();
        return this;
    }
}
