package src.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import src.PageFactory.testfireHomePage;
import src.PageFactory.testfireLogin;

import java.util.concurrent.TimeUnit;

public class TesttfirewitPF {

    WebDriver driver;
    testfireLogin objLogin;
    testfireHomePage objHomePage;



    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:/webDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.driver.get("http://demo.testfire.net/login.jsp");
    }

    @Test(
            priority = 0
    )
    public void test_Home_Page_Appear_Correct() {
        this.objLogin = new testfireLogin(this.driver);
//        String loginPageTitle = this.objLogin.getLoginTitle();
//        Assert.assertTrue(loginPageTitle.toLowerCase().contains("Online Banking Login"));
        this.objLogin.loginTotestfire("admin", "admin");
        this.objHomePage = new testfireHomePage(this.driver);
        Assert.assertTrue(this.objHomePage.getHomePageDashboardUserName().toLowerCase().contains("Congratulations! "));
    }
}
