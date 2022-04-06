package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PurchaseConfirmationPage {
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement confirmPurchase;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    WebElement text;
    WebDriver driver;

    public PurchaseConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(confirmPurchase));
        return confirmPurchase.getText();
    }

    public String purchaseText(){
      return text.getText();
    }

    public void confirmPurchase(){okButton.click();}
}