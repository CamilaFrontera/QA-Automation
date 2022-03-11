import Pages.DemoblazeHomePage;
import Pages.DemoblazeProductPage;
import Utility.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoblazePOM {
    final String URL = "https://www.demoblaze.com/index.html";
    WebDriver driver = DriverManager.getDriver();
    DemoblazeHomePage demoblazeHomePage;
    DemoblazeProductPage demoblazeProductPage;


    @Test
    public void navigateToLaptop(){
        driver.navigate().to(URL);
        demoblazeHomePage = new DemoblazeHomePage(driver);
        demoblazeHomePage.selectProduct();
        demoblazeProductPage = new DemoblazeProductPage(driver);
        demoblazeProductPage.saveModel();
        demoblazeProductPage.savePrice();
        demoblazeProductPage.addToCart();
        Assert.assertEquals("Sony vaio i5", demoblazeProductPage.saveModel());
        demoblazeProductPage.dismissAlert();
        demoblazeProductPage.navigateToCart();
        driver.quit();
    }
}
