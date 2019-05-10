package testcases;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CensusPage;
import pages.EnrollmentPage;
import pages.HomePage;
import pages.LoginPage;


public class CensusPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CensusPage censusPage;
	EnrollmentPage enrollmentPage;
	String sheetName="IU";
	public CensusPageTest(){
		super();
	}
	/*@DataProvider(name = "TestData")

	public Object[][] getTestData(Method method) {
		return util.TestUtility.getDataFromExcelFile(method.getName(),sheetName);
		
	
	}*/
	
	
		
	@BeforeSuite
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
		censusPage = new CensusPage();
		
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
	//@Test(dataProvider = "TestData", description = ""/*,retryAnalyzer=Retry.class*/)
	@Test (priority=3)
	//@Test(priority=3)
	public void IU() throws Exception {
		//System.out.println("zip="+zip);
		enrollmentPage = censusPage.IUquote(prop.getProperty("zip"),prop.getProperty("dob"),prop.getProperty("gender"),prop.getProperty("HHI"));
		
		
	
	}

}
