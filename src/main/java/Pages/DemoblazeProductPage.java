package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoblazeProductPage {
    @FindBy(xpath = "//div//descendant::h2[@class='name']")
    WebElement productName;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement productPrice;
    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCart;
    @FindBy(id = "cartur")
    WebElement cartTab;
    WebDriver driver;

    //constructor
    public DemoblazeProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String saveModel(){
        return productName.getText();
    }
    public String savePrice(){
        return productPrice.getText();
    }

    public void addToCart(){
        addToCart.click();
    }

    public void dismissAlert(){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void navigateToCart(){
        cartTab.click();
    }
}