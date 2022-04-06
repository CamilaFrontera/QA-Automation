package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseModalPage {
    @FindBy(id = "orderModal")
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

    public void fillForm(String name, String country, String city, String creditCard, String month, String year){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        placeOrder.click();
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);
        inputCountry.sendKeys(country);
        inputCity.sendKeys(city);
        inputCC.sendKeys(creditCard);
        inputMonth.sendKeys(month);
        inputYear.sendKeys(year);
        purchaseButton.click();
    }





}
