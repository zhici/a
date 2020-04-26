package src.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class testfireLogin {
    WebDriver driver;
    @FindBy(id="uid")
    WebElement usertestfireName;

    @FindBy(id="passw")
    WebElement passwordtestfire;

//    @FindBy(name="btnSubmit")
//    WebElement titleText;

    @FindBy(name="btnSubmit")
    WebElement login;

    public testfireLogin(WebDriver driver){
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }
    //Set user name in textbox
    public void setUserName(String strUserName){
        usertestfireName.sendKeys(strUserName);
        usertestfireName.submit();
    }
    public void setPassword(String strPassword){
        passwordtestfire.sendKeys(strPassword);
        passwordtestfire.submit();
    }
    public void clickLogin(){
        login.click();
    }
    public void loginTotestfire(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();

    }
}
