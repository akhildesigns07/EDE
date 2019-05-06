package testcases;

import org.testng.annotations.Test;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
	
	
	
	@Test
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	@Test
	public void check() {
		homePage.test();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}

