package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import base.TestBase;
//import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeSuite
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
	}
	
	
	
	@Test (priority=1)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	@Test (priority=2)
	public void individual() throws Exception {
		if((prop.getProperty("lob")).equals("health")) {
			homePage.IU(prop.getProperty("lob"));
			}
			else if((prop.getProperty("lob")).equals("dental")){
				System.out.println("dental");
			}
	}
		
	
	
	
	
	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/
	

}

