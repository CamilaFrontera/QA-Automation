import Pages.*;
import Utility.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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

    @Test
    public void purchaseLaptop(){
        productsPage.selectProduct();
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Product model test started.");
        softAssert.assertEquals(productPage.saveModel(), "Sony vaio i5");
        softAssert.assertEquals(productPage.savePrice(), "790");
        System.out.println("Product model test completed.");
        softAssert.assertAll();
        productPage.addToCart();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        navbarPage.navigateToCart();
        cartPage.placeOrder();
        purchaseModalPage.fillForm();
        softAssert.assertEquals(purchaseConfirmationPage.checkMessage(), "Thank you for your purchase!");
        purchaseConfirmationPage.confirmPurchase();

    }


    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
