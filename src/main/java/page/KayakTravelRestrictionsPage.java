package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class KayakTravelRestrictionsPage extends AbstractPage{

    public static String PAGE_URL ="https://www.kayak.com/travel-restrictions";
    private final By emailField = By.xpath("//input[contains(@placeholder,'Enter your email address')]");
    private final By fieldSelectCountry = By.xpath("//input[contains(@placeholder,'Select countries')]");
    private final By allCountries = By.xpath("//input[contains(@id,'all-countries')]");
    private final By buttonGetAlerts = By.xpath("//button[contains(@class,'Iqt3')]");
    private final By messageAfterSending = By.xpath("//p[contains(@class,'u6rJ-card-text')]");

    public KayakTravelRestrictionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public KayakTravelRestrictionsPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public KayakTravelRestrictionsPage enterDestination(User user) {
        WebElement email = findByLocatorWithClickableCondition(emailField);
        email.sendKeys(user.getEmail());
        return this;
    }

    public KayakTravelRestrictionsPage clickToSelectCountry() {
        WebElement searchBtn = findByLocator(fieldSelectCountry);
        searchBtn.click();
        return this;
    }

    public KayakTravelRestrictionsPage selectAllCountries() {
        WebElement countries = findByLocator(allCountries);
        countries.click();
        return this;
    }
    public KayakTravelRestrictionsPage getAlerts() {
        WebElement buttonToGetAlerts = findByLocator(buttonGetAlerts);
        buttonToGetAlerts.click();
        return this;
    }

    public boolean hasMessageFromFrameAfterGettingAlert() {
        WebElement message = findByLocator(messageAfterSending);
        return message.isDisplayed();
    }



}
