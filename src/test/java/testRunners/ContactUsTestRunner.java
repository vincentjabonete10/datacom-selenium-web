package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features/ContactUs.feature",
        glue="stepDefinitions",
        plugin = {"pretty",
                "junit:target/cucumber-reports/Datacom - ContactUs Feature.xml",
                "json:target/cucumber-reports/Datacom - ContactUs Feature.json",
                "html:target/cucumber-reports/Datacom - ContactUs Feature.html"
        },
        publish = true,
        monochrome = true
)

public class ContactUsTestRunner extends AbstractTestNGCucumberTests {
}