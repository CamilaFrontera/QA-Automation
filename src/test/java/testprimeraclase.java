import Utility.DriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testprimeraclase {
    private String url = "http://www.google.com.ar";
    private WebDriver driver = DriverManager.getDriver("chrome");

    @Test
    //creo método
    public void navigateToDemoblaze(){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        //Encontramos el buscador
        WebElement inputSearch = driver.findElement(By.className("gLFyf"));
        //sendKeys para escribir algo en Selenium
        inputSearch.sendKeys("demoblaze", Keys.ENTER);
        //click en el primer enlace que nos lleva a Demoblaze.com
        driver.findElement(By.xpath("//h3[normalize-space()='STORE']")).click();
        driver.quit();
    }
}
