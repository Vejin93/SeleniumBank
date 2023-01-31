package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {

    public WebDriver driver;

    public PageObjectModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements locators + identification
    @FindBy(id = "site-name")
    WebElement siteName;
    @FindBy(name = "uid")
    WebElement textUserID;
    @FindBy(name = "password")
    WebElement textPassword;
    @FindBy(name = "btnLogin")
    WebElement buttonLogin;

    public void setUserID(String idUser)
    {
        textUserID.sendKeys(idUser);
    }

    public void setPassword(String password)
    {
        textPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        buttonLogin.click();
    }

    public boolean checkSiteNamePresent()
    {
        boolean status = siteName.isDisplayed();
        return status;
    }
}
