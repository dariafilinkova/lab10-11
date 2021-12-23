import model.JourneyData;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakTravelRestrictionsPage;
import service.JourneyCreator;
import service.UserCreator;

public class KayakTravelPageTest extends CommonConditions{

    @Test
    public void sendMessageOnEmail() throws InterruptedException {
        User user = UserCreator.withCredentialsFromProperty();
        KayakTravelRestrictionsPage messageAfterSending = new KayakTravelRestrictionsPage(driver)
                .openPage()
                .enterDestination(user)
                .clickToSelectCountry()
                .selectAllCountries()
                .getAlerts();
        Assert.assertTrue(messageAfterSending.hasMessageFromFrameAfterGettingAlert());
    }
}
