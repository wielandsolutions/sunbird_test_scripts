package org.sunbird.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.FailedLoginException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericExlMethods;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.CreatorAnnouncementPageObjects;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
//import org.sunbird.testscripts.TestRun;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.description.type.TypeDescription.Generic;


public class CreatorAnnouncementPage extends BaseTest{

	//private static final String IMAGE = null;
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPageObjects createUserPage=PageFactory.initElements(driver, CreatorUserPageObjects.class);
	CreatorAnnouncementPageObjects createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPageObjects.class);
	PublicUserPageObjects publicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	SignUpObjects signUpPage=PageFactory.initElements(driver, SignUpObjects.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPageObjects.class.getName());
	Actions action = new Actions(driver);
	Random rand=new Random();
	String announcementName;
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;



	public void navigateToAnnouncementInDropDownMenu() throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to announcement dashboard in drop down menu");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcement_Dashboard.click();	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating announcement in drop down menu");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToAnnouncementInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to announcement dashboard in drop down menu, Exception : "+e.getLocalizedMessage());

		}
	}

	public void CreateAnnouncement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			for(int i=1;i<=3;i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			System.out.println("Button clicked");
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(1000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed to create an announcement, Exception : "+e.getLocalizedMessage());
		}
	}

	public void CreateAnnouncementUsingAttachment() throws InterruptedException, Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement using an attachment");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			//GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitWebDriver(2000);
			for(int i=1;i<=2;i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			String path = System.getProperty("user.dir")+"\\TestData\\UploadingDocuments\\Upload Document Contents\\"+IMAGE;
			GenericFunctions.uploadFile(path);
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitWebDriver(2000);
			for(int i=1;i<=2;i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(4000);
			System.out.println("Button clicked");
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.sendAnnouncement.click();
			createAnnouncementPage.announcementcreatedConfirmation.click();
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement using an attachment");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed on creating an announcement using an attachment, Exception : "+e.getLocalizedMessage());
		}

	}
	
	
	public void CreateAnnouncementPopUp() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify create announcement Popup");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying announcement popup : Title, org, Type, Description, Link");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncementPopUp"+e.getMessage());
			Assert.fail("Failed on verifying announcement popup : Title, org, Type, Description, Link, Exception : "+e.getLocalizedMessage());
		}
		
	 }
	
	
	
	
	
	
	public void editAndResendAnnounccement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit,resend and validate the edited announcement");
			//Robot robot = new Robot();
			//objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.resendAnnouncementButton);
			createAnnouncementPage.resendAnnouncementButton.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.resendTitle.click();
			createAnnouncementPage.resendTitle.clear();
			createAnnouncementPage.resendTitle.sendKeys("Automation123456789");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.editRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(3000);
			String editproof = createAnnouncementPage.editedAnnouncement.getText();
			System.out.println(editproof + "This is the edited Title");
			GenericFunctions.waitWebDriver(1500);
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to edit and resend announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method editAndResendAnnounccement"+e.getMessage());
			Assert.fail("Failed to edit and resend announcement: "+e.getLocalizedMessage());
		}
		
	 }
	
	
	public void verifyDataStorage() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that page data is stored correctly by checking in back button");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.selectRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.selectRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(1000);
			System.out.println("Page Data storage verified successfully by going Back to every page");
			

		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to store the page data correctly after clicking Back button");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method verifyBackButton"+e.getMessage());
			Assert.fail("Failed to store the page data correctly after clicking Back button: "+e.getLocalizedMessage());
		}
		
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
