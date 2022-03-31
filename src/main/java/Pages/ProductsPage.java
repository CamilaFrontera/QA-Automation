package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ProductsPage {
    @FindBy(linkText = "Sony vaio i5")
    WebDriver driver;

    //constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickProduct(int minPrice, int maxPrice){
        getProductInRange(minPrice, maxPrice).findElement(By.xpath(".//preceding-sibling::h4")).click();
    }

    public WebElement getProductInRange(int minAmount, int maxAmount){
        int price;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //esperar a que sean visibles los links
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook Pro")));
        //array de elementos que vamos a encontrar que contengan $
        List<WebElement> pricesElements = driver.findElements(By.xpath("//h5[contains(text(), '$')]"));
        //limpiamos lo que recibimos y comparamos los precios.
        for(WebElement priceElement: pricesElements){
            price = Integer.parseInt(priceElement.getText().replace("$",""));
            if(minAmount <= price && price <= maxAmount){
                return priceElement;
            }
        }
        return null;
    }
}