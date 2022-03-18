package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Scanner;

public class ProductPage {
    @FindBy(xpath = "//div//descendant::h2[@class='name']")
    WebElement productName;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement productPrice;
    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCart;
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String saveModel(){
        return productName.getText();
    }

    public String savePrice(){
        String  str = productPrice.getText();
        String price = str.replaceAll("[^0-9]", "");
        System.out.print(price);
        return price;
    }

    public void addToCart(){
        addToCart.click();
    }


}
