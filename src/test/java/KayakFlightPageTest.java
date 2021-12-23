import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakFlightsPage;

public class KayakFlightPageTest extends CommonConditions {

    private final String EXPECTED_DESTINATION = "Paris, France (PAR)";

    //@Test //must be the 1st
    public void testChangeDestinations() {
        KayakFlightsPage flightsPage = new KayakFlightsPage(driver)
                .openPage()
                .fillDestinations()
                .changeDestinations();
        Assert.assertEquals(flightsPage.getTextFromDestinationFrom(),
                EXPECTED_DESTINATION);
    }
    //@Test
    public void testSameInputDestinations() {
        KayakFlightsPage flightsPage = new KayakFlightsPage(driver)
                .openPage()
                .fillSameDestinations()
                .clickOnSearchButton()
                ;
       // Assert.assertEquals(flightsPage.getTextFromDestinationFrom(),
         //       EXPECTED_DESTINATION);

    }
}
