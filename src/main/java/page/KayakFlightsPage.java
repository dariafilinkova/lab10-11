package page;

import model.JourneyData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import service.JourneyCreator;

public class KayakFlightsPage extends AbstractPage {
    private static final String PAGE_URL = "https://www.kayak.com/flights";
    private static final Logger logger = LogManager.getLogger();

    private final By changeNumberOFAdultsButton = By.xpath("//div[@role='button' and @tabindex='0' and  @class='S9tW S9tW-pres-default']");
    private final By numberOFAdults = By.xpath("//div[@class='bCGf']//button[contains(@aria-label,'Decrement')]");
    private final By errorMessage = By.xpath("//span[@class='cAWq-message']");

    private final By inputDestinationFrom = By.xpath("//div[@class='vvTc-item-value']");
    private final By chosenDestinationFrom = By.xpath("//li[contains(@aria-label,'Lisbon, Portugal')]");
    private final By fieldDestinationFrom = By.xpath("//input[@class='k_my-input']");
    private final By fieldDestinationTo = By.xpath("//input[@class='k_my-input' and @placeholder='To?']");
    private final By chosenDestinationTo = By.xpath("//li[contains(@aria-label,'Paris, France')]");
    private final By chosenDestinationToSameAsFrom = By.xpath("//li[contains(@aria-label,'Lisbon, Portugal')]");
    private final By changeButton = By.xpath("//div[contains(@class,'jqOP')]");
    private final By inputDestinationTo = By.xpath("//div[contains(text(),'To?')]");
    private final By destinationAfterClickingChange = By.xpath("//div[@class='vvTc-item-value']");
    private final By searchButton = By.xpath("//button[contains(@aria-label,'Search')]");
    private final By errorFragment = By.xpath("//div[@class='IGR4-error']");


    public KayakFlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public KayakFlightsPage openPage() {
        logger.info("was opened flightCar");
        driver.get(PAGE_URL);
        return this;
    }

    public KayakFlightsPage clickOnChangeAdults() {
        logger.info("click change number of adults");
        WebElement searchBtn = findByLocatorWithClickableCondition(changeNumberOFAdultsButton);
        searchBtn.click();
        return this;
    }

    public KayakFlightsPage clickOnChosenDestinationFrom() {
        WebElement destinationFrom = findByLocatorWithClickableCondition(chosenDestinationFrom);
        destinationFrom.click();
        return this;
    }

    public KayakFlightsPage clickOnChosenDestinationTo() {
        WebElement destinationTo = findByLocatorWithClickableCondition(chosenDestinationTo);
        destinationTo.click();
        return this;
    }

    public KayakFlightsPage clickDestinationTo() {
        WebElement destinationTo = findByLocatorWithClickableCondition(inputDestinationTo);
        destinationTo.click();
        return this;
    }

    public KayakFlightsPage incrementNumberOfAdults() {
        WebElement searchBtn = findByLocatorWithClickableCondition(numberOFAdults);
        searchBtn.click();
        return this;
    }

    public String getTextFromErrorMessage() {
        return getElementText(errorMessage);
    }

    public KayakFlightsPage clickDestinationFrom() {
        WebElement destination = getFirstElement(inputDestinationFrom);
        destination.click();
        return this;
    }

    public KayakFlightsPage enterDestinationFrom(JourneyData journeyData) {
        WebElement destination = findByLocatorWithClickableCondition(fieldDestinationFrom);
        destination.sendKeys(journeyData.getDestination());
        return this;
    }

    public KayakFlightsPage enterDestinationTo(JourneyData journeyData) {
        WebElement destination = findByLocatorWithClickableCondition(fieldDestinationTo);
        destination.sendKeys(journeyData.getDestination());
        return this;
    }

    public KayakFlightsPage clickOnChosenDestinationToSameAsFrom() {
        WebElement destinationTo = findByLocatorWithClickableCondition(chosenDestinationToSameAsFrom);
        destinationTo.click();
        return this;
    }

    public KayakFlightsPage changeDestinations() {
        WebElement changeBtn = findByLocatorWithClickableCondition(changeButton);
        changeBtn.click();
        return this;
    }

    public KayakFlightsPage fillDestinations() {
        JourneyData journeyData = JourneyCreator.journeyFromProperty();
        JourneyData journeyDataTo = JourneyCreator.journeyFromPropertyTo();
        clickDestinationFrom();
        enterDestinationFrom(journeyData);
        clickOnChosenDestinationFrom();
        clickDestinationTo();
        enterDestinationTo(journeyDataTo);
        clickOnChosenDestinationTo();
        return this;
    }

    public String getTextFromDestinationFrom() {
        return getElementText(destinationAfterClickingChange);
    }

    public KayakFlightsPage fillSameDestinations() {
        JourneyData journeyData = JourneyCreator.journeyFromProperty();
        clickDestinationFrom();
        enterDestinationFrom(journeyData);
        clickOnChosenDestinationFrom();
        clickDestinationTo();
        enterDestinationTo(journeyData);
        clickOnChosenDestinationToSameAsFrom();
        return this;
    }

    public KayakFlightsPage clickOnSearchButton() {
        logger.info("click search");
        WebElement searchBtn = findByLocatorWithClickableCondition(searchButton);
        searchBtn.click();
        return this;
    }

    public String getTextFromErrorFragment() {
        return getElementText(errorFragment);
    }

}
