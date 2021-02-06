package neonomics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevPortalLoginPage {
    WebDriver driver;

    public DevPortalLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=("//input[@name='email']"))
    public WebElement UserName;

    @FindBy(xpath=("//input[@name='password']"))
    public WebElement Password;

    @FindBy(id="login-button")
    public WebElement Login;
}
