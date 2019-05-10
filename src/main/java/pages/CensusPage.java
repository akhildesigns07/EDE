package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CensusPage extends TestBase {

	@FindBy(xpath = "//*[@id='ZipCode']")
	WebElement zipcode;
	
	@FindBy(xpath="//*[@id='CoveredMembers_0__DateOfBirth']")
	WebElement dateofbirth;
	
	@FindBy(xpath = "//*[@class='row margin_bottom_0px censuslist Applicantcensus showncensus']//*[@class='col s12 m3 l3'][1]//*[@class='select-wrapper']")
	WebElement genderDropDown;
	
	@FindBy(xpath = "//*[@id='CoveredMembers_0__Gender']/preceding-sibling::ul//*[contains(text(),'Male')]")
	WebElement genderMale;
	
	@FindBy (xpath = "//*[@id='CoveredMembers_0__Gender']/preceding-sibling::ul//*[contains(text(),'Female')]")
	WebElement genderFemale;
	
	@FindBy (id = "SubsidyEstimation_HouseholdIncome")
	WebElement houseHoldIncome;
	
	
	public CensusPage() {
		PageFactory.initElements(driver, this);
	}
	
	public EnrollmentPage IUquote(String zip,String dob,String gender,String householdincome) throws Exception {
		Thread.sleep(2000);
		System.out.println("zipcode"+zip);
		//zipcode.click();
		zipcode.sendKeys(zip);
		genderDropDown.click();
		if(gender.equals("male")){
			genderMale.click();
		}
		else{
			genderFemale.click();
		}
		Thread.sleep(2000);
		dateofbirth.sendKeys(dob);
		if(!householdincome.isEmpty()){
			houseHoldIncome.sendKeys(householdincome);
		}
		
		return new EnrollmentPage();
	}

	
}
