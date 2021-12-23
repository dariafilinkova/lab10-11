import org.testng.Assert;
import org.testng.annotations.Test;
import page.KayakStaysPage;

public class KayakStaysPageTest extends CommonConditions {
   // @Test
    public void findStayWithoutDate() {
        KayakStaysPage staysPage = new KayakStaysPage(driver)
                .openPage()
                .clickOnSearchButton();
        Assert.assertTrue(staysPage.appearErrorFragment());
    }
}
