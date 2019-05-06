package pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath="//*[@id=\'Item2_UserName\']")
	WebElement username;
	
	
	@FindBy(xpath="//*[@type='password']")
	WebElement password;
	
	@FindBy(xpath=("//*[@id=\'SignIn\']"))
	WebElement loginbtn;
	
	@FindBy(xpath=("//span[@id='loginErrorMessage']"))
	WebElement invalid;
	
	@FindBy(css = "[id='showmenu']")
	WebElement showmenu;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		    	/*JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginbtn);*/
		    	
		return new HomePage();
	}
	public HomePage loginPasswordError(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd+"234");
		loginbtn.click();
		Assert.assertEquals(invalid.getText(),"Please enter valid credential");
		return new HomePage();
	}
	
	public HomePage loginTest() {
		Assert.assertTrue(showmenu.isDisplayed());
		return new HomePage();
	}
}
