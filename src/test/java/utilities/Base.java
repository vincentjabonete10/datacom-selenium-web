package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
    private final String propertiesPath = "//src//test//java//resources//data.properties";
    public static WebDriver driver;
    public static Scenario scenario;
    public static Properties prop;
    public static FileInputStream fis;
    public static  Boolean isHeaded = false;

    public WebDriver initializerDriver() throws IOException {
        Properties prop = getProperties();
        String browserName = prop.getProperty("browser");
        String appUrl = prop.getProperty("appUrl");

        if(browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            if(prop.getProperty("headless").equals("true") && !isHeaded) {
                options.addArguments("--headless=new");
            }

            driver = new ChromeDriver(options);
            driver.get(appUrl);
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        return driver;
    }

    public Properties getProperties() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(
                System.getProperty("user.dir") + propertiesPath);
        prop.load(fis);
        return prop;
    }

    public String getAppUrl() throws IOException {
        Properties prop = getProperties();
        return prop.getProperty("appUrl");
    }

    public void takeScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png;base64", screenshotName);
    }
}