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
    WebDriver driver;

    public PurchaseConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkMessage(){
        return confirmPurchase.getText();
    }

    public void confirmPurchase(){
        okButton.click();
    }
}
