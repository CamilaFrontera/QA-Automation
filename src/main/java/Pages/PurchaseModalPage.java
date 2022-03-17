package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseModalPage {
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrder;
    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "country")
    WebElement inputCountry;
    @FindBy(id = "city")
    WebElement inputCity;
    @FindBy(id = "card")
    WebElement inputCC;
    @FindBy(id = "month")
    WebElement inputMonth;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement purchaseButton;
    WebDriver driver;


    public PurchaseModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillForm(){
        inputName.sendKeys("test");
        inputCountry.sendKeys("test");
        inputCity.sendKeys("test");
        inputCC.sendKeys("test");
        inputMonth.sendKeys("test");
        inputYear.sendKeys("test");
        purchaseButton.click();

    }
}
