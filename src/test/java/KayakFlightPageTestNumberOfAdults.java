import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakFlightsPage;

public class KayakFlightPageTestNumberOfAdults extends CommonConditions{
    private final String EXPECTED_ERROR_MESSAGE = "Searches need at least 1 traveler";

    @Test
    public void testNullNumberOfAdults() {
        KayakFlightsPage flightsPage = new KayakFlightsPage(driver)
                .openPage()
                .clickOnChangeAdults()
                .incrementNumberOfAdults();
        Assert.assertEquals(flightsPage.getTextFromErrorMessage(),
                EXPECTED_ERROR_MESSAGE);
    }
}
