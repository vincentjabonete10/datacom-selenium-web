package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    @FindBy(id = "cmp-mrkto-modal-thank-you") public WebElement contactUsButton;
    @FindBy(id = "FirstName") public WebElement firstNameField;
    @FindBy(id = "LastName") public WebElement lastNameField;
    @FindBy(id = "Email") public WebElement emailField;
    @FindBy(id = "Phone") public WebElement phoneNumberField;
    @FindBy(id = "Title") public WebElement jobTitleField;
    @FindBy(id = "Company") public WebElement companyNameField;
    @FindBy(id = "Country") public WebElement countryField;
    @FindBy(xpath = "//*[text()='How can we help you?']//following::*[@id='custom2']") public WebElement howCanWeHelpYouField;
    @FindBy(xpath = "//*[text()='Select a solution']//following::*[@id='Enquiry__c']") public WebElement selectSolutionField;
    @FindBy(xpath = "//*[text()='Message']//following::*[@id='How_can_we_help__c']") public WebElement messageField;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}