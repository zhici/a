import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
    WebDriver driver;
//    执行测试代码前执行的操作
    @Before
    public void setUp() throws Exception {
        //加载浏览器驱动
        System.setProperty("webdriver.chrome.driver","C:/webDriver/chromedriver.exe");
        driver =new ChromeDriver();
    }
//    测试代码
//    测试用例一
    @Test
    public void bingtest(){
//        获取网站地址
        driver.get("https://cn.bing.com/?FORM=BEHPTB");
        System.out.println("Home page Title:"+driver.getTitle());
//       WebElement element =driver.findElement(By.id("sb_form_q")); //id定位搜索框
//        WebElement element = driver.findElement(By.cssSelector("#sb_form_q"));//用cssSelector定位
        WebElement element = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));//用xpath定位
        element.sendKeys("selenium");
        element.submit();
        Assert.assertEquals("selenium - 国内版 Bing",driver.getTitle());
    }
//    测试用例二
    @Test
    public void jdtest(){
        driver.get("https://www.jd.com/?cu=true&utm_source=buy.jiegeng.com&utm_medium=tuiguang&utm_campaign=t_1000159524_&utm_term=c86408f2a87c497f90f17cb068e7acf6");
        System.out.println("Home page Title:"+driver.getTitle());
        WebElement element = driver.findElement(By.xpath("//*[@id=\"key\"]"));
        element.sendKeys("ipad");
        element.submit();
        Assert.assertEquals("京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！",driver.getTitle());
    }
//    测试用例三
    @Test
    public void Outlooktest(){
        driver.get("https://outlook.live.com/owa/?WT.mc_id=O16_BingHP?mkt=zh-CN");
        System.out.println("Home page title:"+driver.getTitle());
        WebElement element = driver.findElement(By.cssSelector("body > header > div > aside > div > nav > ul > li:nth-child(2) > a"));
        element.click();
        Assert.assertEquals("Outlook - 来自 Microsoft 的免费个人电子邮件和日历",driver.getTitle());
    }

//    执行测试代码后的操作
    @After
    public void setdown () throws Exception{
        Thread.sleep(10000);
        driver.quit();
    }
}
