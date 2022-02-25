package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    public static WebDriver driver;
    public static String browser;

    //devuelve la instancia del driver que usamos
    public static WebDriver getDriver(String chrome) {
        browser = PropertiesFile.getProperty("browser");
        if (browser.equals("chrome")) {
            //necesario setearlo para utilizar el driver
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
            //Instanciamos chromeDriver
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        return driver;
    }
}
