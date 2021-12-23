import model.JourneyData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakCarPage;
import page.KayakResultCarPage;
import service.JourneyCreator;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class KayakCarsPageTest extends CommonConditions {

    @Test
    public void testSearchCarWithoutEnteringDate() {
        KayakCarPage carPage = new KayakCarPage(driver)
                .openPage()
                .fillDestination()
                .search();
        List <WebElement> listOfCars = new KayakResultCarPage(driver)
                .openPage()
                .getListOfCars();
        assertThat(listOfCars,not(empty()));
    }

    /*@Test
    public void searchTicketsOnWayTripTest() throws InterruptedException {
        JourneyData journeyData = JourneyCreator.journeyFromProperty();
        KayakCarPage carsPage = new KayakCarPage(driver)
                .search()
                .enterDestination(journeyData);
    }*/
                /*.inputDeparturePlace(testLocations.getDeparturePlace())
                .clickOnDestinationPlace()
                .inputDestination(testLocations.getDestinationPlace())
                .clickOnOneWayButton()
                .clickOnCalendarButton()
                .clickOnDepartDateButton()
                .clickOnSearchButton();

        String resultAirportName = resultPage.getAirportName();
        System.out.println(resultAirportName);
        Assert.assertEquals(EXPECTED_AIRPORT, resultAirportName);
    }*/

}
