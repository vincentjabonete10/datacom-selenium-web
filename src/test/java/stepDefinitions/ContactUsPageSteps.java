package stepDefinitions;

import org.junit.Assert;
import utilities.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.CommonPage;
import pageObjects.ContactUsPage;

public class ContactUsPageSteps extends Base {

    private final CommonPage commonPage;
    private final ContactUsPage contactUsPage;

    public ContactUsPageSteps() {
        commonPage = new CommonPage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @And("the user fill out all required field")
    public void theUserFillOutAllRequiredField() throws InterruptedException {
        contactUsPage.firstNameField.sendKeys("Adrian");
        contactUsPage.lastNameField.sendKeys("Mercado");
        contactUsPage.emailField.sendKeys("adrianMercado@gmail.com");
        contactUsPage.phoneNumberField.sendKeys("09245134135");
        contactUsPage.jobTitleField.sendKeys("QA Automation Engineer");
        contactUsPage.companyNameField.sendKeys("BPO Outsourcing");
        contactUsPage.countryField.click();
        commonPage.textValidationString("Philippines").click();
        contactUsPage.howCanWeHelpYouField.click();
        commonPage.textValidationString("Consult with an expert").click();
        contactUsPage.selectSolutionField.click();
        commonPage.textValidationString("Advisory & consulting").click();
        contactUsPage.messageField.sendKeys("Awesome Team");
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheSubmitButton(String text) throws InterruptedException {
        Thread.sleep(3000);
        commonPage.textValidationString(text).click();
        takeScreenshot("Clicked " + text);
    }

    @When("the user validate the {string} page")
    public void theUserValidateThePage(String text) {
        commonPage.textValidationString(text).isDisplayed();
        takeScreenshot("Displayed page: " + text);
    }

    @When("the user clicks the Contact us button")
    public void theUserClicksContactUsButton() {
        contactUsPage.contactUsButton.click();
        takeScreenshot("Clicked Contact Us Button");
    }

    @Then("the {string} css element should be {string} for {string} label")
    public boolean theCssElementShouldBe(String css, String value, String text) {

        String cssValue = commonPage.textValidationString(text).getCssValue(value);
        System.out.println(cssValue);
        Assert.assertEquals(css, cssValue);
        takeScreenshot("Validated CSS Value");
        return true;
    }
}