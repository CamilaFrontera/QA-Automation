import Utility.DriverManager;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testprimeraclase {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverManager.getDriver("chrome");

    @Test
    public void navigateToDemoblaze() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();


        driver.findElement(By.cssSelector("div.list-group > :nth-child(3)")).click();

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Sony vaio i5'])[1]"))).click();

        String laptopModel = driver.findElement(By.cssSelector("div#tbodyid > h2")).getText();
        System.out.println(laptopModel);

        String laptopPrice = driver.findElement(By.cssSelector("div#tbodyid > h3")).getText();
        Assert.assertTrue("El precio encontrado es diferente al esperado ($790).", laptopPrice.contains("$790"));
        System.out.println(laptopPrice);

        driver.findElement(By.linkText("Add to cart")).click();

        wait.until(ExpectedConditions.alertIsPresent()).dismiss();

        driver.quit();
    }

}



