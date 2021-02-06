package neonomics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperPortalPage {
    WebDriver driver;

    public DeveloperPortalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="new-application-button")
    public WebElement NewApplication;

    @FindBy(id="eAppName")
    public WebElement ApplicationName;

    @FindBy(id="eAppDesc")
    public WebElement ApplicationDescription;

    @FindBy(id="next-button")
    public WebElement Next;

    @FindBy(xpath="(//input[@type='checkbox'])[1]")
    public WebElement AccountData;

    @FindBy(xpath="(//input[@type='checkbox'])[2]")
    public WebElement PaymentInitiation;

    @FindBy(id="genId")
    public WebElement GenetareIDs;


}



