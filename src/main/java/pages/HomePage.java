package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(css = "[id='showmenu']")
	WebElement showmenu;
	
	
	@FindBy(id = "menu_Individual")
	WebElement menu;
	
	@FindBy(css = "[lob='Health']")
	WebElement Health;
	
public void test() {
	System.out.println("Hello");
	}
}
