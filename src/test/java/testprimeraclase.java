import Utility.DriverManager;
import Utility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.util.concurrent.TimeUnit;


public class testprimeraclase {
    private String url = "https://www.demoblaze.com/";
    private WebDriver driver = DriverManager.getDriver("chrome");

    @Test
    //creo método
    public void navigateToDemoblaze() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div#tbodyid > div:nth-child(1) >div > a")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.quit();
    }
}
//a[contains(text(),'Sony vaio i5')]
//a[contains(text(),'Laptops')]
