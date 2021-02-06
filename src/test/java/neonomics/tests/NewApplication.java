package neonomics.tests;
import neonomics.pages.DevPortalLoginPage;
import neonomics.pages.DeveloperPortalPage;
import neonomics.utilities.ConfigReader;
import neonomics.utilities.TestBase;
import org.apache.hc.core5.http.ContentType;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.Set;


public class NewApplication extends TestBase {

    @Test

    public void loginDevPorTest () throws InterruptedException {

    driver.get("https://www.neonomics.io/");
    WebElement loginLink = driver.findElement(By.linkText("Developer Portal"));
    loginLink.click();

    String currentWindow = driver.getWindowHandle();
    Set<String> windows = driver.getWindowHandles();
    for (String handle : windows) {
        if(!currentWindow.equals(handle)){
            driver.switchTo().window(handle);
        }
    }
        DevPortalLoginPage devPortalLogin=new DevPortalLoginPage(driver);
        devPortalLogin.UserName.sendKeys(ConfigReader.getProperty("username"));
        devPortalLogin.Password.sendKeys(ConfigReader.getProperty("password"));
        devPortalLogin.Login.click();

        DeveloperPortalPage developerPortalPage=new DeveloperPortalPage(driver);
        developerPortalPage.NewApplication.click();
        developerPortalPage.ApplicationName.sendKeys("Test Application");
        developerPortalPage.ApplicationDescription.sendKeys("The user needs to get all accounts from a given bank.");
        developerPortalPage.Next.click();
        developerPortalPage.AccountData.click();
        developerPortalPage.PaymentInitiation.click();
        //developerPortalPage.GenetareIDs.click();



    }
}
