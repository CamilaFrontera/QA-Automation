package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "(//td[normalize-space()='790'])[1]")
    WebElement productPriceCart;
    @FindBy(xpath = "(//td[normalize-space()='Sony vaio i5'])[1]")
    WebElement productModelCart;
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrder;
    WebDriver driver;

    public String saveModel(){return productModelCart.getText();
    }

    public String savePrice(){return productPriceCart.getText();}

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void placeOrder(){
        placeOrder.click();
    }
}
