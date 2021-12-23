import model.JourneyData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakCarPage;
import page.KayakResultCarPage;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
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
}
