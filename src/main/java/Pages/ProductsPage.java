package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage {
    @FindBy(linkText = "Sony vaio i5")
    WebElement firstProduct;
    WebDriver driver;

    //constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void selectProduct(){
        firstProduct.click();
    }

    public void dismissAlert(){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }



}