package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
    WebDriver driver;
    @FindBy(linkText = "Laptops")
    WebElement laptops;


    //constructor
    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLaptop(){
        laptops.click();
    }
}
