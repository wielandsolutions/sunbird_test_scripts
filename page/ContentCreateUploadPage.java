package org.sunbird.page;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.ContentCreateUploadPageObjects;
import org.sunbird.pageobject.CreateMentorPageObjects;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ContentCreateUploadPage extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPageObjects createUserPage=PageFactory.initElements(driver, CreatorUserPageObjects.class);
	PublicUserPageObjects publicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	CreateMentorPageObjects createMentorPageObjects=PageFactory.initElements(driver, CreateMentorPageObjects.class);
	ContentCreateUploadPageObjects contentCreatePage = PageFactory.initElements(driver, ContentCreateUploadPageObjects.class);
	CreatorUserPage createrUserPageObj = new CreatorUserPage();
	SignUpObjects signUpPage=PageFactory.initElements(driver, SignUpObjects.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String eurl="https://staging.open-sunbird.org/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";

	public void verifyUploadContentPopupDisplay()
	{
		try 
		{
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the upload content popup display");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);

			/*GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);*/

			WebElement browse = contentCreatePage.browseButton;
			System.out.println(browse.getText());
			if(browse.isDisplayed()&&createUserPage.enterUrl.isDisplayed()&&createUserPage.UploadButton.isDisplayed()&&contentCreatePage.closeEditor.isDisplayed())
			{

				String aurl=driver.getCurrentUrl();
				System.out.println(aurl);
				Assert.assertEquals(aurl, eurl,"The given url is not matching with the expected");
				Assert.assertTrue(true);
			}
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);


			createUserPage.UploadButton.click();
			GenericFunctions.waitWebDriver(5000);





			System.out.println(objListOFTestDataForSunbird1.get(10).getCourseName());



		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify upload content popup");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not verify the upload content popup, Exception"+e.getLocalizedMessage());
		}
	}
	public void verifyFileUpload()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save the content and verify the close button display");

			contentCreatePage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(5000);

			contentCreatePage.uploadContent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE1);
			GenericFunctions.waitWebDriver(5000);

			createUserPage.UploadButton.click();

			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			if(createUserPage.closeButton.isDisplayed()){
				createUserPage.closeButton.click();
			}



			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(2000);

		}catch(Exception e) {}

		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the close button");

	}	



	/*public void navigateToLibraryAndSearchContent(String userData)
	{
		try	
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content");	
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			createUserPage.searchedContent.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.copy.click();			
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}

	}*/
	public void reviewUploadContent()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go to up for review and verify the upload");
			List<TestDataForSunbird>objListOfTestDataForSunbird1 =null;
			objListOfTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();



		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content, Exception Message:Exception\"+e.getLocalizedMessage()");

		}
	}
	public void navigateToLibraryAndSearchContent()
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content"); 
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.copy.click();
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content, Exception Message:Exception\"+e.getLocalizedMessage()");

		}
	}


	public void saveAndSendUploadContentForReview()throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send u for review");
			List<TestDataForSunbird>objListOFTestDataForSunbird= null;
			objListOFTestDataForSunbird=ReadTestDataFromExcel.getTestDataForSunbird("testdatatestcoursename");

			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);

			/*
				createUserPage.uploadAndUseButton.click();
				GenericFunctions.waitWebDriver(2000);
				createUserPage.yesRadioButton.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.chooseFileButton.click();
				GenericFunctions.waitWebDriver(1500);
				String path = System.getProperty("user.dir")+"\\TestData\\UploadingDocuments\\Upload Document Contents\\"+SEARCH_CONTENT_IMAGE;
				System.out.println("Uploaded image : "+path);
				//log.info("Uploaded file name: "+path);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.uploadFile(path);
				GenericFunctions.waitWebDriver(2500);
				createUserPage.uploadAndUseButtonRight.click();
				GenericFunctions.waitWebDriver(1800);
			 */

			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_CONTENT_IMAGE);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			//GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.concept.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);

			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(10).getCourseName());
			System.out.println(objListOFTestDataForSunbird.get(10).getCourseName());

			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.selectFunction.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(5000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}

	public void uploadContent_Pdf_MP4_WEBMHP5()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload MP4");
			List<TestDataForSunbird>objListOFTestDataForSunbird = null;
			objListOFTestDataForSunbird=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcoursename");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentCreatePage.browseButton);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.browseButton.click();

			Thread.sleep(5000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To upload MP4");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on uploading a mp4");
		}

	}
	public void verifyThatEditDetailsPageIsDisplayed()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get edit Detail Page is Displaying and Continuation of the test case number 129");
			//List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			String upload =GenericFunctions.testDataIncrementer("./TestData/uploadNumbers.txt");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			createUserPage.UploadButton.click();
			GenericFunctions.waitWebDriver(5000);							
			contentCreatePage.editDetailsLink.click();
			GenericFunctions.waitWebDriver(5000);
			System.out.println("The Edit details page is displaying");
			GenericFunctions.waitWebDriver(5000);
			//				contentCreatePage.checkAppIcon.isDisplayed();
			//		
			//				GenericFunctions.waitWebDriver(5000);
			//				contentCreatePage.editDetailsHeading.isDisplayed();
			//				GenericFunctions.waitWebDriver(5000);
			//				contentCreatePage.title.isDisplayed();
			//				
			if(contentCreatePage.checkAppIcon.isDisplayed()&&contentCreatePage.editDetailsHeading.isDisplayed()&&contentCreatePage.title.isDisplayed())
			{
				contentCreatePage.checkAppIcon.click();

				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with the test case 129");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the board,medium,class,subject in the topic page.");
				/*
					GenericFunctions.waitWebDriver(2000);
					createUserPage.uploadAndUseButton.click();
					GenericFunctions.waitWebDriver(2000);
					createUserPage.yesRadioButton.click();
					GenericFunctions.waitWebDriver(1500);
					createUserPage.chooseFileButton.click();
					GenericFunctions.waitWebDriver(1500);
					String path = System.getProperty("user.dir")+"\\TestData\\UploadingDocuments\\Upload Document Contents\\"+SEARCH_COURSE_IMAGE;
					System.out.println("Uploaded image : "+path);
					//log.info("Uploaded file name: "+path);
					GenericFunctions.waitWebDriver(3000);
					GenericFunctions.uploadFile(path);
					GenericFunctions.waitWebDriver(2500);
					createUserPage.uploadAndUseButtonRight.click();
				 */

				GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
				GenericFunctions.waitWebDriver(1000);
				createUserPage.searchUploadImage.sendKeys(SEARCH_COURSE_IMAGE);
				GenericFunctions.waitWebDriver(1200);
				createUserPage.clickImageSearch.click();
				GenericFunctions.waitWebDriver(5000);
				contentCreatePage.checkContentIcon.click();

				GenericFunctions.waitForElementToAppear(createUserPage.selectAppIcon);
				contentCreatePage.selectAppIcon.click();

				GenericFunctions.waitWebDriver(2500);
				GenericFunctions.waitForElementToAppear(contentCreatePage.uploadContentName);
				contentCreatePage.uploadContentName.clear();
				GenericFunctions.waitWebDriver(2500);
				contentCreatePage.uploadContentName.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription()+upload);







				GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
				GenericFunctions.waitWebDriver(5000);

				createUserPage.clickOnSelectCurriculum.click();

				GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);			
				GenericFunctions.waitWebDriver(2000);
				createUserPage.selectCurriculum.click();

				GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
				createUserPage.clickOnSelectClass.click();
				GenericFunctions.waitWebDriver(1000);
				createUserPage.selectClass.click();
				GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
				//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
				//createUserPage.clickOnHeaderSubject.click();
				GenericFunctions.waitWebDriver(1200);

				GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
				GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
				createUserPage.clickOnSelectSubject.click();
				GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
				createUserPage.selectSubject.click();
				GenericFunctions.waitWebDriver(1200);

				createUserPage.clickOnSelectMedium.click();
				GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
				GenericFunctions.waitWebDriver(1200);
				createUserPage.selectMedium.click();
				GenericFunctions.waitWebDriver(1200);

				contentCreatePage.selectConcept.click();					
				GenericFunctions.waitWebDriver(1500);
				contentCreatePage.searchConcept1.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
				GenericFunctions.waitWebDriver(1500);
				createUserPage.conceptChooseAll.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.doneButton.click();
				GenericFunctions.waitWebDriver(1500);
				contentCreatePage.selectTopic.click();
				GenericFunctions.waitWebDriver(1500);
				contentCreatePage.doneButton1.click();

				GenericFunctions.waitWebDriver(1500);
				createUserPage.saveButton.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.closeButton.click();
			/*	createUserPage.closeButton.click();
				//GenericFunctions.switchToFrame(contentCreatePage.closeEditor.iFrame);
				GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
				GenericFunctions.waitWebDriver(5000);

				
				createUserPage.limitedSharingArrow.click();
				GenericFunctions.waitWebDriver(5000);
				createUserPage.clickLimitedSharing.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(contentCreatePage.clickonLimitedPublishing);
				contentCreatePage.clickonLimitedPublishing.click();
				GenericFunctions.waitWebDriver(5000);
				
				contentCreatePage.clickOnShare.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(contentCreatePage.linkdata);
				
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.uploadFile(A_HOME_URL);
				*/
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
				createUserPage.sendForReview.click();
				GenericFunctions.waitWebDriver(5000);
				createUserPage.saveButton.click();
				GenericFunctions.waitWebDriver(1500);
				
				
				
				
			
			}
	
				
				
				
//				
//				String url1=contentCreatePage.linkdata.getText();
//				GenericFunctions.waitWebDriver(5000);
//				System.out.println(url1);
//				
//				contentCreatePage.closeShareLink.click();
//				GenericFunctions.waitWebDriver(5000);
//			
//				

//				driver=new ChromeDriver();
//				Thread.sleep(5000);
//				driver.get(url1);
//			    GenericFunctions.waitWebDriver(5000);
//				
				
			
				
				
				
				
//				createUserPage.editorCloseIcon.click();
//				GenericFunctions.waitWebDriver(5000);

				//GenericFunctions.waitWebDriver(5000);
			



		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to display the edit details page");
		}
	}

	public void allUploadsContent()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the saved upload content in all upload section.");
			GenericFunctions.waitWebDriver(3000);
//			Alert alert = driver.switchTo().alert();
//			alert.accept();		

			GenericFunctions.waitWebDriver(5000);
			String eupload="CourseA DescriptionC";
			String aupload=	createUserPage.reviewCourseName.getText();



			GenericFunctions.waitForElementToAppear(createUserPage.reviewCourseName);
			createUserPage.reviewCourseName.isDisplayed();
			
			Assert.assertEquals(aupload, eupload, "The user is not getting the course in all upload");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.reviewCourseName);
			createUserPage.reviewCourseName.click();
			GenericFunctions.waitWebDriver(5000);

			System.out.println(createUserPage.reviewCourseName);






		}catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not in all uploads after saving");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to display the upload content in all uploads");
		}
	}
	
	
	public void reviewSubmissionPage()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in review submision page.");
			List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.reviewSubmission);
			contentCreatePage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.reviewCardView.isDisplayed();
			GenericFunctions.waitWebDriver(5000);
			String areview =contentCreatePage.reviewCardView.getText();
			
			String ereview="CourseA DescriptionC";
			
			Assert.assertEquals(areview, ereview, "The expected result should match with actual result");
			
			
			System.out.println(areview);
			
			
		}catch(Exception e)
		{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
		Assert.fail("Failed to display the upload content in review submission page");
		
	
	}
		
		
}
	public void navigateToUpForReview()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
			List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.profileIcon);
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchBox);
			contentCreatePage.searchBox.sendKeys("CourseA DescriptionC091");			
			contentCreatePage.contentupload.isDisplayed();			
			GenericFunctions.waitWebDriver(5000);
			String auploadcontent=contentCreatePage.contentupload.getText();
			System.out.println(auploadcontent);			
			String euploadcontent="CourseA DescriptionC93";	
			Assert.assertEquals(auploadcontent, euploadcontent, "The expected result should matching with final result");
			contentCreatePage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);
			
			
		}catch(Exception e)
		{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
		Assert.fail("Failed to display the upload content in review submission page");
		
	
		
		}
		
	}
	
	
	public void clickOnSortBy()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to sort by updated date");
			List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitWebDriver(5000);
			
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchBox);
			contentCreatePage.searchBox.sendKeys("CourseA DescriptionC053");
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.updatedOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.createdOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent1=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.nameaz.click();
			String updatedoncontent2=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			
			
			
			
		}catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not sort");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to display the content sort by date");
	}
}
	
	
	public void showFilter(){
		{
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to filter the content based on curriculum,grades,medium,subjects,content types");
				List<TestDataForSunbird>objListOFTestDatForSunbird=null;
				objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
				GenericFunctions.waitWebDriver(5000);
				
				contentCreatePage.profileIcon.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
				contentCreatePage.workspace1.click();
				GenericFunctions.waitWebDriver(5000);
				contentCreatePage.upforreview.click();
				GenericFunctions.waitWebDriver(5000);
				
				contentCreatePage.showfilter.click();
				GenericFunctions.waitWebDriver(1200);
				/*contentCreatePage.selectBoard.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectRajasthan.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.gradeLevel.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectClass9.click();
				GenericFunctions.waitWebDriver(1200);*/
				contentCreatePage.selectSubject.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectMathematics.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectMedium.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectHindi.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectContentType.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectCollection.click();
				GenericFunctions.waitWebDriver(1200);
				GenericFunctions.waitForElementToAppear(contentCreatePage.clickOnApplyButton);
				contentCreatePage.clickOnApplyButton.click();
				GenericFunctions.waitWebDriver(5000);
				
				contentCreatePage.status.click();
				GenericFunctions.waitWebDriver(5000);
				
				String acontentName=contentCreatePage.contentFiltered.getText();
				
				System.out.println(acontentName);
				
				Assert.assertEquals(acontentName, "1234566 sbj", "The actual and expected are equal");
								
				
			}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not filtering with based on curriculum,grades,medium,subjects,content types,");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to filter the topic based on curriculum,grades,medium,subjects,content types ");
		}
	}
	}
	
	public void navigateToUpForReview1()
	{
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
		List<TestDataForSunbird>objListOFTestDatForSunbird=null;
		objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions.waitWebDriver(5000);
		GenericFunctions.waitForElementToAppear(contentCreatePage.profileIcon);
		contentCreatePage.profileIcon.click();
		GenericFunctions.waitWebDriver(5000);
		GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
		contentCreatePage.workspace.click();
		GenericFunctions.waitWebDriver(5000);
		contentCreatePage.upforreview.click();
		GenericFunctions.waitWebDriver(5000);
		contentCreatePage.contentupload.isDisplayed();
		
		GenericFunctions.waitWebDriver(5000);
		contentCreatePage.contentupload.click();
	
		GenericFunctions.scrollToElement(contentCreatePage.publishButton);
		contentCreatePage.publishButton.click();
		GenericFunctions.waitWebDriver(5000);
		
		for(int i=0;i<contentCreatePage.checkbox.size();i++){
			contentCreatePage.checkbox.get(i).click();
		}
		
		contentCreatePage.publishButton1.click();
		
		GenericFunctions.waitWebDriver(5000);
		
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to display the content in review submission page");
		}
		
	}
	
	public void publishedContent()
	{
		try {
			
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the content");
				List<TestDataForSunbird>objListOFTestDatForSunbird=null;
				objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.profileIcon.click();
				GenericFunctions.waitWebDriver(1200);
				GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
				contentCreatePage.workspace1.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.published.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.contentPublished.click();
				GenericFunctions.waitWebDriver(5000);
				
				
				
				
			
		}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the published section");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
		Assert.fail("Failed to display the content in published section");
	}
	
	
}
	
	public void requestChanges()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User  is trying to send the request changes for all upload content");
			List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(contentCreatePage.profileIcon);
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentupload.isDisplayed();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentupload.click();
			
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.scrollToElement(contentCreatePage.requestChanges);
			contentCreatePage.requestChanges.click();
			
			for(int i=0;i<contentCreatePage.checkbox.size();i++){
				contentCreatePage.checkbox.get(i).click();
			}
			
			contentCreatePage.requestChangesComment.sendKeys("Changes it");
			GenericFunctions.waitWebDriver(5000);
			
			contentCreatePage.requestChangesBlueButton.click();
			GenericFunctions.waitWebDriver(5000);
		
			
			
			
			
			
		}catch(Exception e)
		{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "The reviewer rejects the uploaded content ");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
		Assert.fail("Failed to get  the request changes for upload content");
		
	}
	
}
	public void alluploads()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
			List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace1.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.allUploads.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentPublished.click();
			
			GenericFunctions.waitForElementToAppear(contentCreatePage.reviewerSuggestion);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreatePage.reviewerSuggestion);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.reviewerSuggestion.click();
			GenericFunctions.waitWebDriver(5000);
		   if( contentCreatePage.reviewerSuggestionTitle.isDisplayed())
		   {
			   System.out.println("This test case pass");
		   }
			
			
			
			
			
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is not able to see the upload content in the all uploads section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Failed to get the upload content in all upload section");
			
		}
		
	}
	
		
	
	}
	

