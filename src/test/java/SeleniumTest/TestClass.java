package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pageObjectModel.PageObjectModel;

import java.time.Duration;

public class TestClass {

    WebDriver driver;
    PageObjectModel pageObjectModel;

    @BeforeClass
    void setup()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.demo.guru99.com/V4/index.php");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void testNameSite()
    {
        pageObjectModel = new PageObjectModel(driver);
        Assert.assertEquals(pageObjectModel.checkSiteNamePresent(),true);
    }

    @Test(priority = 2)
    void testLogin()
    {
        pageObjectModel = new PageObjectModel(driver);

        pageObjectModel.setUserID("mngr474834");
        pageObjectModel.setPassword("YhAdagu");
        pageObjectModel.clickLogin();

        Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
    }

}
