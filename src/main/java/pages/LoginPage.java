package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath="//*[@id=\'Item2_UserName\']")
	WebElement username;
	
	
	@FindBy(xpath="//*[@type='password']")
	WebElement password;
	
	@FindBy(xpath=("//*[@id=\'SignIn\']"))
	WebElement loginbtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginbtn);
		    	
		return new HomePage();
	}
}
