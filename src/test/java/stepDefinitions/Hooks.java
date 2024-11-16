package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Base;

import java.io.IOException;

public class Hooks extends Base {
    @Before
    public void setup(Scenario scenario) throws IOException {
        Base.scenario = scenario;
        Base.prop = getProperties();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(!prop.getProperty("debugging").equals("true")) {
            try {
                String screenshotName = scenario.getName();
                if (scenario.isFailed()) {
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png;base64", screenshotName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}