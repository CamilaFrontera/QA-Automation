import Utility.DriverManager;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class testprimeraclase {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverManager.getDriver("chrome");

    @Test
    public void navigateToDemoblaze() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div#tbodyid > div:nth-child(1) >div > a")).click();
        Thread.sleep(3000);
        String laptopModel = driver.findElement(By.cssSelector("div#tbodyid > h2")).getText();
        System.out.println(laptopModel);
        String laptopPrice = driver.findElement(By.cssSelector("div#tbodyid > h3")).getText();
        Assert.assertTrue("Text not found!", laptopPrice.contains("$790"));
        System.out.println(laptopPrice);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        driver.quit();
    }
}