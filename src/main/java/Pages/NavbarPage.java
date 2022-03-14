package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarPage {
    @FindBy(id = "cartur")
    WebElement cartTab;
    WebDriver driver;

    public NavbarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void navigateToCart(){
        cartTab.click();
    }
}
