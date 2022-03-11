package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoblazeHomePage {
    @FindBy(linkText = "Laptops")
    WebElement laptops;
    @FindBy(linkText = "Sony vaio i5")
    WebElement firstProduct;
    WebDriver driver;

    //constructor
    public DemoblazeHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(){
        laptops.click();
        firstProduct.click();

    }
}
