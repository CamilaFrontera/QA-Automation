import Pages.CategoriesPage;
import Pages.NavbarPage;
import Pages.ProductsPage;
import Pages.ProductPage;
import Utility.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoblazePOM {
    final String URL = "https://www.demoblaze.com/index.html";
    WebDriver driver = DriverManager.getDriver();
    CategoriesPage categoriesPage;
    ProductsPage productsPage;
    ProductPage productPage;
    NavbarPage navbarPage;


    @Test
    public void navigateToLaptop(){
        driver.navigate().to(URL);
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickLaptop();
        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
        productPage = new ProductPage(driver);
        productPage.saveModel();
        Assert.assertEquals("Sony vaio i5", productPage.saveModel());
        productPage.savePrice();
        productPage.addToCart();
        productsPage.dismissAlert();
        navbarPage = new NavbarPage(driver);
        navbarPage.navigateToCart();
        driver.quit();
    }
}
