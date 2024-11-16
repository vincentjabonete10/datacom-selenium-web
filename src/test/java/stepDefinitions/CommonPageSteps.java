package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.CommonPage;
import utilities.Base;
import java.io.IOException;

public class CommonPageSteps extends Base {

    private WebDriver driver;
    private CommonPage commonPage;

    @Given("the user opens datacom web application")
    public void openApplication() throws IOException {
        driver = initializerDriver();
        driver.get(getAppUrl());
        commonPage = new CommonPage(driver);
    }

    @Then("the user should see {string} as a {string}")
    public boolean textValidation(String text, String selector) {
        switch(selector) {
            case "header":
                selector = "h1";
                break;
            case "link":
                selector = "a";
                break;
            case "p":
                selector = "p";
                break;
            case "span":
                selector = "span";
                break;
            case "label":
                selector = "label";
                break;
            case "small":
                selector = "small";
                break;
            default:
                selector = "*";
        }
        return commonPage.textSelectorStringBy(text, selector).isDisplayed();
    }
}