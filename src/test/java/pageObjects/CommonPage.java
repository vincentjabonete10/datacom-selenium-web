package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement textValidationString(String text) {
        return driver.findElement(By.xpath("//*[text()='"+ text +"']"));
    }

    public WebElement textSelectorStringBy(String text, String selector) {
        return driver.findElement(By.xpath("//"+ selector +"[text()='"+ text +"']"));
    }
}