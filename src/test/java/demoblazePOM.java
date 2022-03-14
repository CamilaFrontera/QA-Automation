import Pages.CategoriesPage;
import Pages.NavbarPage;
import Pages.ProductsPage;
import Pages.ProductPage;
import Utility.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoblazePOM {
    final String URL = "https://www.demoblaze.com/index.html";
    WebDriver driver = DriverManager.getDriver();
    CategoriesPage categoriesPage;
    ProductsPage productsPage;
    ProductPage productPage;
    NavbarPage navbarPage;

    @BeforeTest
    public void beforeTest(){
        driver.navigate().to(URL);
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickLaptop();
        productPage = new ProductPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void navigateToLaptop(){
        productsPage.selectProduct();
        productPage.saveModel();
        Assert.assertEquals("Sony vaio i5", productPage.saveModel());
        productPage.savePrice();
        productPage.addToCart();
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        navbarPage = new NavbarPage(driver);
        navbarPage.navigateToCart();

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
