package org.sunbird.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.pageobject.UploadOrgPageObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class SignUp extends BaseTest
{ 
	static Logger log = Logger.getLogger(SignUp.class.getName());

	public void signUpUser() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Sign up to the application");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
			int count = objListOFTestDataForSunbird.size();

			for(int i=0; i<count; i++){
				SignUpObjects objSignUp=PageFactory.initElements(driver, SignUpObjects.class);
				objSignUp.Sbtn.click();
				objSignUp.Un.sendKeys(objListOFTestDataForSunbird.get(i).getUsername());
				objSignUp.Pw.sendKeys(objListOFTestDataForSunbird.get(i).getPassword());
				objSignUp.FName.sendKeys(objListOFTestDataForSunbird.get(i).getFirstName());
				objSignUp.LName.sendKeys(objListOFTestDataForSunbird.get(i).getLastName());
				objSignUp.Phone.sendKeys(objListOFTestDataForSunbird.get(i).getPhone());
				objSignUp.Email.sendKeys(objListOFTestDataForSunbird.get(i).getEmail());
				GenericFunctions generic=PageFactory.initElements(driver, GenericFunctions.class);
				String locator = "//i[@class='dropdown icon']";
				driver.findElement(By.xpath(locator)).click();
				String locDrop ="//div[@class='menu transition visible']//div[@class='item']";
				generic.selectValueFromDropdown(driver, locDrop, "Kannada");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Sign up to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application"+e.getLocalizedMessage());
		}

	}

	public void userLogin(String userRole) throws InterruptedException
	{

		UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
		List <TestDataForSunbird> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is loging into the application as "+userRole);
			GenericFunctions.waitForElementToAppear(orgUploadPage.loginButton);
			orgUploadPage.loginButton.click();
			if(userRole.equalsIgnoreCase("ADMIN"))
			{   
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
				System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
						objListOFTestDataForSunbird.get(5).getPassword());
				log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
						objListOFTestDataForSunbird.get(5).getPassword());
			}
			else if(userRole.equalsIgnoreCase("CREATOR")){
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(0).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(0).getPassword());
			}
			else if(userRole.equalsIgnoreCase("REVIEWER")){
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(1).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(1).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(1).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(1).getPassword());
			}
			else if(userRole.equalsIgnoreCase("MENTOR")){
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(2).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(2).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(2).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(2).getPassword());
			}
			else if(userRole.equalsIgnoreCase("FLAGREVIEWER")){
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(4).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(4).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(4).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(4).getPassword());
			}     
			else if(userRole.equalsIgnoreCase("PUBLICUSER")){
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(6).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(6).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(6).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(6).getPassword());
			}
			else if(userRole.equalsIgnoreCase("PUBLICUSER1"))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(9).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(9).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(9).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(9).getPassword());
			}

			else if(userRole.equalsIgnoreCase("BOOKREVIEWER"))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(10).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(10).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
			}

			else if(userRole.equalsIgnoreCase("AUTOCREATOR"))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(12).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(12).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(12).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(12).getPassword());
			}
			else if(userRole.equalsIgnoreCase("A_CONTENT_CREATOR"))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(28).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(28).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(28).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(28).getPassword());
			}
			else if(userRole.equalsIgnoreCase(BOOKCREATOR))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(20).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(20).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(20).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(20).getPassword());
			}
			else if(userRole.equalsIgnoreCase(MENTOR_S))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(24).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(24).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(24).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(24).getPassword());
			}
			else if(userRole.equalsIgnoreCase(REVIEWER_S))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(25).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(25).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(25).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(25).getPassword());
			}
			else if(userRole.equalsIgnoreCase(PUBLICUSER_S))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(23).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(23).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(23).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(23).getPassword());
			}
			else if(userRole.equalsIgnoreCase(MENTORS_S))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(26).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(26).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(26).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(26).getPassword());
			}
			else if(userRole.equalsIgnoreCase(PUBLICUSERS_S))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(27).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(27).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(27).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(27).getPassword());
			}
			else if(userRole.equalsIgnoreCase(CONTENT_CREATOR))
			{
				orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(29).getUsername());
				orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(29).getPassword());
				log.info("UN"+objListOFTestDataForSunbird.get(29).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(29).getPassword());
			}

			else{
				log.error("User info not found");
			}

			//orgUploadPage.clickLogin.click();
			orgUploadPage.clickLogin1.click();
			GenericFunctions.waitWebDriver(2000);
		}



		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to login to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to login to the application"+e.getLocalizedMessage());
		}
	}


	public void userLogout()throws Exception{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to logout from the application");
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(2000);
			System.out.println("User Logout");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User could not logout from the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to logout from the application"+e.getLocalizedMessage());
		}

	}
	
	//Merged from Ajith-25/09/2018
	public void checkUserDataExists() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying whether the currently creating data has existed or not");		
			SignUpObjects objSignUp=PageFactory.initElements(driver, SignUpObjects.class);
			objSignUp.alertMessage.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Alert Message: "+objSignUp.alertMessage.getText());
			System.out.println(objSignUp.alertMessage.getText());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Single Sign up to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application"+e.getLocalizedMessage());
		}

	}
	
	//Merged from Ajith-25/09/2018
	public void singleSignUpUser() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Single User is trying to Sign up to the application");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
			
			SignUpObjects objSignUp=PageFactory.initElements(driver, SignUpObjects.class);
				objSignUp.Sbtn.click();
				objSignUp.Un.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
				objSignUp.Pw.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
				objSignUp.FName.sendKeys(objListOFTestDataForSunbird.get(0).getFirstName());
				objSignUp.LName.sendKeys(objListOFTestDataForSunbird.get(0).getLastName());
				objSignUp.Phone.sendKeys(objListOFTestDataForSunbird.get(0).getPhone());
				objSignUp.Email.sendKeys(objListOFTestDataForSunbird.get(0).getEmail());
				GenericFunctions generic=PageFactory.initElements(driver, GenericFunctions.class);
				String locator = "//i[@class='dropdown icon']";
				driver.findElement(By.xpath(locator)).click();
				String locDrop ="//sui-select-option[@class='item']/span[2]";
				generic.selectValueFromDropdown(driver, locDrop, "English");
				objSignUp.Email.click();
				GenericFunctions.waitWebDriver(2000);
				objSignUp.Sbtn.click();
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Single Sign up to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application"+e.getLocalizedMessage());
		}

	}
	
	//Merged from Ajith-25/09/2018
	public void bulkSignUpUser() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Bulk Sign up to the application");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
			int count = objListOFTestDataForSunbird.size();

			for(int i=0; i<count; i++){
				SignUpObjects objSignUp=PageFactory.initElements(driver, SignUpObjects.class);
				objSignUp.Sbtn.click();
				objSignUp.Un.sendKeys(objListOFTestDataForSunbird.get(i).getUsername());
				objSignUp.Pw.sendKeys(objListOFTestDataForSunbird.get(i).getPassword());
				objSignUp.FName.sendKeys(objListOFTestDataForSunbird.get(i).getFirstName());
				objSignUp.LName.sendKeys(objListOFTestDataForSunbird.get(i).getLastName());
				objSignUp.Phone.sendKeys(objListOFTestDataForSunbird.get(i).getPhone());
				objSignUp.Email.sendKeys(objListOFTestDataForSunbird.get(i).getEmail());
				GenericFunctions generic=PageFactory.initElements(driver, GenericFunctions.class);
				String locator = "//i[@class='dropdown icon']";
				driver.findElement(By.xpath(locator)).click();
				String locDrop ="//sui-select-option[@class='item']/span[2]";
				generic.selectValueFromDropdown(driver, locDrop, "English");
				objSignUp.Email.click();
				GenericFunctions.waitWebDriver(3000);
				objSignUp.Sbtn.click();
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Bulk Sign up to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application"+e.getLocalizedMessage());
		}

	}
}


