package commonfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class elementWait {

	
	public static void visitblityofElement(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void presenceofElement(WebDriver driver, By byelement, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.presenceOfElementLocated(byelement));
	}

	public static void ElementtobeClickable(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void ajaxLoaderWait(int sleeptime, String comments, WebDriver driver) throws Exception{
		
		
		try {
			do{
				Thread.sleep(sleeptime);
				System.out.println(comments);
			}
			
			while(driver.findElement(By.cssSelector(".ajax_loader")).isDisplayed());
		} catch (Exception e) {
			
		}
	}

}