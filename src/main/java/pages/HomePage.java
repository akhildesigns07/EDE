package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import commonfunctions.elementWait;

public class HomePage extends TestBase {
	
	
	
	@FindBy(css = "[id='showmenu']")
	WebElement showmenu;
	
	@FindBy(xpath = "//*[@id='menu_Individual']")
	WebElement headerIndividual;
	
	@FindBy(id = "menu_Individual")
	WebElement menu;
	
	@FindBy(css = "[lob='Health']")
	WebElement Health;
	
	@FindBy(xpath = "//*[@class='menu_wth_text']")
	WebElement headerMenu;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
public void IU(String lob) throws Exception {

	
	elementWait.ajaxLoaderWait(5, "Ajax loader at IU", driver);
	Thread.sleep(100);
	headerMenu.click();
	elementWait.ajaxLoaderWait(5, "Ajax loader at IU", driver);
	elementWait.ElementtobeClickable(driver, headerIndividual, 2);
	headerIndividual.click();
	elementWait.ajaxLoaderWait(5, "Ajax loader", driver);
	Health.click();
	
	
	}
}
