package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    public static WebDriver driver;
    public static String browser;
    public static String driverPath = "src/main/resources/Drivers/";

    public static WebDriver getDriver(String chrome) {
        browser = PropertiesFile.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
            driver = new EdgeDriver();
        }
        return driver;
    }
}