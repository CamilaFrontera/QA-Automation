import DataProviders.DataProviders;
import Pages.*;
import Utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class demoblazePOM {
    final String URL = "https://www.demoblaze.com/index.html";
    WebDriver driver = DriverManager.getDriver();
    CategoriesPage categoriesPage;
    ProductsPage productsPage;
    ProductPage productPage;
    NavbarPage navbarPage;
    CartPage cartPage;
    PurchaseConfirmationPage purchaseConfirmationPage;
    PurchaseModalPage purchaseModalPage;

    @BeforeTest
    public void beforeTest(){
        driver.navigate().to(URL);
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickLaptop();
        productPage = new ProductPage(driver);
        productsPage = new ProductsPage(driver);
        navbarPage = new NavbarPage(driver);
        cartPage = new CartPage(driver);
        purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
        purchaseModalPage = new PurchaseModalPage(driver);
    }

    @Test(dataProvider = "purchaseForm", dataProviderClass = DataProviders.class)
    public void purchaseLaptop(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        productsPage.clickProduct(780,890);
        productPage.addToCart();
        String productModel = productPage.saveModel();
        String productPrice = productPage.savePrice();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        navbarPage.navigateToCart();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartPage.saveModel(), productModel);
        softAssert.assertEquals(cartPage.savePrice(),productPrice);
        softAssert.assertAll();
        cartPage.placeOrder();
        purchaseModalPage.fillForm(name, country,city,creditCard,month,year);
        softAssert.assertEquals(purchaseConfirmationPage.checkMessage(), "Thank you for your purchase!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Purchase']")));
        //softAssert.assertEquals(purchaseConfirmationPage.amount(), cartPage.savePrice());
        //softAssert.assertEquals(purchaseConfirmationPage.cardNumber(),creditCard);
        //softAssert.assertEquals(purchaseConfirmationPage.name(),name);
        softAssert.assertTrue(purchaseConfirmationPage.purchaseText().contains(cartPage.savePrice()));
        softAssert.assertTrue(purchaseConfirmationPage.purchaseText().contains(creditCard));
        softAssert.assertTrue(purchaseConfirmationPage.purchaseText().contains(name));
        purchaseConfirmationPage.confirmPurchase();
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
