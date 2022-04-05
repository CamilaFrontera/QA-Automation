package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseConfirmationPage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement confirmPurchase;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;
    @FindBy(xpath = "//p[contains(@class,'lead text-muted')]")
    WebElement text;
    WebDriver driver;

    public PurchaseConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkMessage(){
        return confirmPurchase.getText();
    }

    public String amount(){
        String txt = text.getText();
        String amount = txt.substring(20,23);
        return amount;
    }

    public String cardNumber(){
        String txt = text.getText();
        String card = txt.substring(41,47);
        return card;
    }

    public String name(){
        String txt = text.getText();
        String name = txt.substring(54,62);
        return name;
    }

    public void confirmPurchase(){okButton.click();}
}
