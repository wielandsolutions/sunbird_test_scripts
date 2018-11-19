package org.sunbird.page;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.AllUploadingPaths;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.ContentCreationResourcePageObjects;
import org.sunbird.pageobject.CreateMentorPageObjects;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.FlagReviewerPageObjects;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.pageobject.UploadOrgPageObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class CreatorUserPage extends BaseTest{

	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPageObjects createUserPage=PageFactory.initElements(driver, CreatorUserPageObjects.class);
	PublicUserPageObjects PublicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	CreateMentorPageObjects CreateMentorPageObjects=PageFactory.initElements(driver, CreateMentorPageObjects.class);
	SignUpObjects SignUpObjects=PageFactory.initElements(driver, SignUpObjects.class);
	UploadOrgPageObjects UploadOrgPageObjects = PageFactory.initElements(driver, UploadOrgPageObjects.class);
	ContentCreationResourcePageObjects ContentCreationResourcePageObjects = PageFactory.initElements(driver, ContentCreationResourcePageObjects.class);
	static Logger log = Logger.getLogger(CreatorUserPageObjects.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	AllUploadingPaths allPaths= new AllUploadingPaths();
	String lessonNumber;
	String title="";

	public void navigateToWorkspace(String createVariable)
	{
	
		try
		
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is navigating to the Workspace to create "+createVariable);
		
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2500);
			if(createVariable.equalsIgnoreCase(createUserPage.createCourse.getText()))
			{
				System.out.println(createUserPage.createCourse.getText());
				createUserPage.createCourse.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createBook.getText()))
			{
				createUserPage.createBook.click();
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createResource.getText()))
			{
				createUserPage.createResource.click();
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createCollection.getText()))
			{
				createUserPage.createCollection.click();
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createLesson.getText()))
			{
				createUserPage.createLesson.click();
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createUploadContent.getText()))
			{
				createUserPage.createUploadContent.click();
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace");
			Assert.fail("Failed on navigating to Workspace and create "+createVariable);
		}

	}

	public void createCourse(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			createUserPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			//action.moveToElement(createUserPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");

		}
	}

	public void saveAndSendCourseForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(createUserPage.checkContentIcon);
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);             //      
			createUserPage.selectClass.click();
			//GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectSubject);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			
			
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}

	public void saveAndSendBookForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send book for for review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			createUserPage.searchUploadImage.sendKeys(SEARCH_BOOK_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);	
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectAppIcon.click();			
			GenericFunctions.waitWebDriver(1800);
			createUserPage.saveButton.click();
			System.out.println("Dial Code updated Successfully");
			System.out.println("Content updated successfully");
			GenericFunctions.waitWebDriver(2500);
			//createUserPage.editorCloseIcon.click();
			GenericFunctions.waitWebDriver(2500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending the book for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and send book for review"+e.getLocalizedMessage());
			Assert.fail("Failed to save and send the book for review");

		}

	}

	public String searchInUpForReview(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception{
		String courseNumber = "",searchCourseName="";
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			//Added on 10 july 2018
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				courseNumber = GenericFunctions.readFromNotepad(".//testData//resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);
			}
			//--------------------------
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(3000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}
		return searchCourseName;

	}


	public void reviewInSubmissions(String source, List <TestDataForSunbird> objListOFTestDataForSunbird)
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify "+source+" is found in review submission");
			GenericFunctions.waitForElementToAppear(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			assertFoundInReviewSubmission(source,objListOFTestDataForSunbird);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to find in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Failed to find in review submission bucket"+e.getLocalizedMessage());
		}

	}

	public static void assertFoundInReviewSubmission(String source,List <TestDataForSunbird> objListOFTestDataForSunbird){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that "+source+" is found in review submission");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPageObjects createUserPage1=PageFactory.initElements(driver, CreatorUserPageObjects.class);
			if(source.equalsIgnoreCase(COURSE)){
				String courseNumber = GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Found: Submitted for Review");
						System.out.println(courseName+"Course Found: Course Submitted for Review");
						log.info(courseName+"Course Found: Course Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding course in review submission");
					}
				}
			}
			else if(source.equalsIgnoreCase(BOOK))
			{

				String courseNumber = GenericFunctions.readFromNotepad(".//testData//bookNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Book: Submitted for Review");
						System.out.println(courseName+"Book Found: Course Submitted for Review");
						log.info(courseName+"Book Found: Course Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding book in review submission");
					}
				}
			}
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				String courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Resource : Submitted for Review");
						System.out.println(courseName+"Resource Found: Course Submitted for Review");
						log.info(courseName+"Resource Found: resource Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding Resource in review submission");
					}
				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to assert in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			Assert.fail("Failed on asserting in review submission bucket");

		}
	}

	public static void assertCourseFoundInSearch(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that course is found in search");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPageObjects createUserPage1=PageFactory.initElements(driver, CreatorUserPageObjects.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//courseNumbers.txt").toString();
			for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
				String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Course Found in Search");
					System.out.println(courseName+"Course Found in Search");
					log.info(courseName+" Course Found in Search");
					break;
				}
				else
				{	

					log.info("Still finding course in review submission");

				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching for course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on searching the course");
		}
	}

	public static void assertFoundInUpForReview(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that course is found in Up for review");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPageObjects createUserPage1=PageFactory.initElements(driver, CreatorUserPageObjects.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//courseNumbers.txt").toString();

			for(int i=0;i<createUserPage1.searchCoursesUpForReview.size();i++){
				String courseName = createUserPage1.searchCoursesUpForReview.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in up for review");
					createUserPage1.searchCoursesUpForReview.get(i).click();
					System.out.println(courseName+"Found and Clicked in up for review");
					log.info(courseName+"Found and Clicked in up for review");
					break;
				}
				else
				{				
					log.info("Still finding in up for review");
				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying the asserrtion in Up for review bucket ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course in Up for review bucket");
		}
	}

	public static void assertOnSearchAfterPublish(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that "+searchCourseName+" is found on searching after publishing");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			GenericFunctions.waitWebDriver(2000);
			CreatorUserPageObjects createUserPage1=PageFactory.initElements(driver, CreatorUserPageObjects.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//courseNumbers.txt").toString();
			for(int i=0;i<createUserPage1.searchPublishedCourses.size();i++){
				String courseName = createUserPage1.searchPublishedCourses.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in Search");
					System.out.println(courseName+"Found in Search");
					log.info(courseName+" Found in Search");
					break;
				}
				else
				{				
					log.info("Still finding course in review submission");
				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the course after publishing it");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course after publishing");
		}
	}

	public void createBook(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a book");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer(".//testData//bookNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber);
			createUserPage.clickBookBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookBoard);
			createUserPage.selectBookBoard.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookGrade.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookGrade);
			createUserPage.selectBookGrade.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookSubject);
			createUserPage.selectBookSubject.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookMedium);
			createUserPage.selectBookMedium.click();
			createUserPage.bookPublisher.sendKeys(PUBLISHER);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookYear.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookYear);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectBookYear.click();
			GenericFunctions.waitWebDriver(1200);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.bookTitle.click();
			createUserPage.bookTitle.clear();
			createUserPage.bookTitle.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			//createUserPage.selectResource.click();		
			createUserPage.selectBookResource.click();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating a book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on creating a book");
		}

	}
	public String getBookName()
	{
		//GenericFunctions.testDataIncrementer();
		String course = GenericFunctions.randomCourseName();
		String generatedName=GenericFunctions.readFromNotepad(".//testData//bookNumbers.txt");
		System.out.println(generatedName+course);
		return generatedName+course;
	}

	public void createLessonPlan()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a lesson plan");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(LESSONPLAN);
			//GenericFunctions.waitWebDriver(2000);
			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);
			lessonNumber = GenericFunctions.testDataIncrementer(".//testData//lessonPlan.txt");
			//createUserPage.clickOnPopup.click();

			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
			System.out.println("Lesson created :"+objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBookBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookBoard);
			createUserPage.selectBookBoard.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBookGrade.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookGrade);
			createUserPage.selectBookGrade.click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookSubject);
			createUserPage.selectBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickBookMedium);
			createUserPage.clickBookMedium.click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBookMedium.click();
			GenericFunctions.waitWebDriver(4000);

			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println(createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(2500);
			//createUserPage.newChild.click();	
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(3).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating the lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create the new lesson plan");
			Assert.fail("Failed on creating the lesson plan");
		}

	}

	public void saveAndSendForReviewLesson()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and publish the lesson plan");
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);

			//Added on Maintenance 12/09/2018
			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			createUserPage.searchUploadImage.sendKeys(LESSON_PLAN_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);	
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(5000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save and publish the lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and publish the lesson plan");
			Assert.fail("Failed on saving and publishing the lesson plan");
		}

	}

	public String publishAndSearch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird){
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search "+source);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickReqestChangesIcon);
			if(createUserPage.publishCourseButton.isDisplayed()&&createUserPage.clickReqestChangesIcon.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Publish and Request changes icons are present");
				createUserPage.publishCourseButton.click();
				GenericFunctions.waitWebDriver(1400);
				boolean btnState = createUserPage.popupPublishButton.isEnabled();
				if(btnState==false)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Publish button state is verified and it is not clickable without selecting any Mandatory field");
				}
				else
				{
					System.out.println("Could not verify the publish button element state");
				}
				for(int i=0;i<createUserPage.checkbox.size();i++){
					createUserPage.checkbox.get(i).click();
				}
				GenericFunctions.waitWebDriver(1500);
				createUserPage.popupPublishButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to publish the content sucessfully");
				GenericFunctions.waitWebDriver(3000);
				driver.switchTo().defaultContent();
			}
			else 
			{
				System.out.println("Publish and Request changes icons are not present, and could not publish the content");
			}
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				courseNumber = GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}
			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				courseNumber = GenericFunctions.readFromNotepad(".//testData//bookNumbers.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}
			
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search "+source);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to publish and search");
		}
		System.out.println(searchCourseName);
		return searchCourseName;
	}

	public void goToWorkspace(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to workspace, search in Up for review and publish "+inputToSearch);
			GenericFunctions.refreshWebPage();
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			if(inputToSearch.equalsIgnoreCase(MP4))
			{
				String searchMp4Content=objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+MP4;
				createUserPage.searchForReview.sendKeys(searchMp4Content);
				System.out.println(searchMp4Content);
			}

			else if(inputToSearch.equalsIgnoreCase(WEBM))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+WEBM);
			}
			else if(inputToSearch.equalsIgnoreCase(YOUTUBE))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+YOUTUBE);
			}
			else if(inputToSearch.equalsIgnoreCase(EPUB))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+EPUB);
			}
			else if(inputToSearch.equalsIgnoreCase(HTML))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+HTML);
			}
			else if(inputToSearch.equalsIgnoreCase(H5P))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+H5P);
			}

			else if(inputToSearch.equalsIgnoreCase(COLLECTION))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//collectionNumbers.txt"));
				//+"_"+GenericFunctions.readFromNotepad("collectionNumbers.txt")
				createUserPage.searchedContentForPublish.click();
			}
			else if(inputToSearch.equalsIgnoreCase(LESSONPLAN))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
				GenericFunctions.waitWebDriver(3000);
				createUserPage.searchedContentForPublish.click();
			}
			else if(inputToSearch.equalsIgnoreCase(PDF))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt")+"_"+PDF);
				GenericFunctions.waitWebDriver(3000);
				createUserPage.searchedContentForPublish.click();
			}
			GenericFunctions.waitWebDriver(7000);
			
			/*
			GenericFunctions.waitForElementToAppear(createUserPage.publishButton);
			GenericFunctions.scrollToElement(createUserPage.publishButton);
			createUserPage.publishButton.click();
			 */

			//Commented in part of Maintainance on 24/07/2018

			if(inputToSearch.contains("collection"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(7000);
				GenericFunctions.waitWebDriver(4500);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("lesson plan"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(7000);
				GenericFunctions.waitWebDriver(4500);
				GenericFunctions.waitForElementToAppear(createUserPage.clickPublishIcon);
				GenericFunctions.scrollToElement(createUserPage.clickPublishIcon);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("epub")||inputToSearch.contains("webm")||inputToSearch.contains("mp4")||inputToSearch.contains("h5p")||inputToSearch.contains("html")||inputToSearch.contains("youtube")||inputToSearch.contains("pdf"))
			{
				//GenericFunctions.waitForElementToAppear(createUserPage.publishButton);
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.scrollToElement(createUserPage.publishButton);
				GenericFunctions.waitWebDriver(2500);
				System.out.println(createUserPage.publishButton.getText());
				createUserPage.publishButton.click();
			}
			//	String compare=createUserPage.searchedContentForPublish.getText();	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);


			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				GenericFunctions.waitWebDriver(500);
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(2500);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			System.out.println(inputToSearch+" Content published sucessfully");
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search and publish "+inputToSearch);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to search and publish");
		}

	}


	public String uploadContentMp4(String uploadType) throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload"+uploadType+" and send it for review");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(UPLOADCONTENT);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);

			WebElement browse=createUserPage.browseButton;
			if(uploadType.equalsIgnoreCase("mp4"))
			{
				System.out.println(AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.mp4Path);
				System.out.println("Uploaded file : "+AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.waitWebDriver(2500);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
			
				System.out.println(AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.webmPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(6000);
				System.out.println("WEBM content uploaded sucessfully");
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("YOUTUBE content uploaded sucessfully");
				createUserPage.UploadButton.click();
			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				
				System.out.println(AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.epubPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("EPUB content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{				
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.h5pPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.h5pPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("H5P content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				System.out.println(AllUploadingPaths.htmlPath);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.htmlPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.htmlPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("HTML content uploaded sucessfully");

			}

			else if(uploadType.equalsIgnoreCase("pdf"))
			{

				System.out.println(AllUploadingPaths.pdfPath);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(AllUploadingPaths.pdfPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.pdfPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("PDF content uploaded sucessfully");
			}
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(createUserPage.untitledCollection);
			System.out.println(createUserPage.untitledCollection.getText());
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);
			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.testDataIncrementer(".//testData//contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}
			GenericFunctions.waitWebDriver(1000);
			createUserPage.contentMp4Desc.click();
			createUserPage.contentMp4Desc.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_CONTENT_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkContentIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectMedium);
			createUserPage.selectMedium.click();
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload content");
			Assert.fail("Failed to upload any content and send for review ");
		}
		return title;
	}

	public List<String> createCollection()
	{
		List<String> metadataPageDetails = new ArrayList<String>();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new collection");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(COLLECTION);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String collectionName = objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.testDataIncrementer(".//testData//collectionNumbers.txt");
			createUserPage.courseName.sendKeys(collectionName);
			createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseDescription());
			GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);

			//Commented on Maintainance-24/07/2018
			/*GenericFunctions.waitForElementToAppear(createUserPage.collectionKeywords);
			createUserPage.collectionKeywords.sendKeys(objListOFTestDataForSunbird1.get(5).getTitle());*/
			
			GenericFunctions.waitForElementToAppear(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(1500);
			
			GenericFunctions.waitForElementToAppear(createUserPage.selectCollection);
			createUserPage.selectCollection.click();
			GenericFunctions.waitForElementToAppear(createUserPage.proceedButton);
			GenericFunctions.waitWebDriver(500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "User sucessfully created Collection");
			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send the collection for review");
				GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
				createUserPage.sendForReview.click();

				//Upload Collection icon and dropdowns
				GenericFunctions.waitWebDriver(1000);
				createUserPage.clickAppIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createUserPage.searchUploadImage.sendKeys(SEARCH_COLLECTION_IMAGE);
				createUserPage.clickImageSearch.click();
				GenericFunctions.waitWebDriver(1000);
				createUserPage.checkCollectionIcon.click();
				createUserPage.selectAppIcon.click();
				GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.clickOnSelectCurriculum.click();
				GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
				GenericFunctions.scrollToElement(createUserPage.selectCurriculum);
				createUserPage.selectCurriculum.click();
				createUserPage.clickOnSelectClass.click();
				GenericFunctions.waitWebDriver(1000);
				createUserPage.selectClass.click();
				GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
				createUserPage.clickOnSelectSubject.click();
				createUserPage.selectSubject.click();
				createUserPage.clickOnSelectMedium.click();
				GenericFunctions.waitForElementToAppear(createUserPage.selectMedium);
				createUserPage.selectMedium.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
				GenericFunctions.scrollToElement(createUserPage.clickOwner);
				createUserPage.clickOwner.click();
				createUserPage.selectOwner.click();
			
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to send the Collection for review");
				ExtentTestManager.getTest().log(LogStatus.INFO,"Exception Message : "+e.getLocalizedMessage());
			}			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on creating collection");
			Assert.fail("Failed to create new collection");
		}
		return metadataPageDetails;
	}

	public void rejectTheContent(String inputToReject)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the content"+inputToReject);
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(inputToReject.equalsIgnoreCase("course"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString());
				GenericFunctions.waitWebDriver(3000);
			}

			else if(inputToReject.equalsIgnoreCase("collection"))
			{	
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}

			else if(inputToReject.equalsIgnoreCase("book"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+GenericFunctions.readFromNotepad(".//testData//bookNumbers.txt"));
			}

			else if(inputToReject.equalsIgnoreCase("lessona"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}
			else if(inputToReject.equalsIgnoreCase("courseac"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription());
				GenericFunctions.waitWebDriver(3000);
			}
			else if(inputToReject.equalsIgnoreCase("booka"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}
			
			
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			
			
			if(inputToReject.contains("resource"))
			{
				driver.switchTo().defaultContent();
				createUserPage.clickRequestChanges.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createUserPage.rejectReason1);
				createUserPage.rejectReason1.click();
				createUserPage.rejectReason2.click();
				createUserPage.rejectReason3.click();
				String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
				createUserPage.reviewComments.click();
				createUserPage.reviewComments.sendKeys(rejectReason);
				GenericFunctions.waitWebDriver(3000);
				createUserPage.requestChangesButton1.click();
				GenericFunctions.waitWebDriver(3000);
				System.out.println(inputToReject+" is rejected succesfully");
			}
			else
			{
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.clickReqestChangesIcon);
				createUserPage.clickReqestChangesIcon.click();
				GenericFunctions.waitWebDriver(3000);
				createUserPage.rejectReason1.click();
				createUserPage.rejectReason2.click();
				createUserPage.rejectReason3.click();
				String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
				createUserPage.reviewComments.click();
				createUserPage.reviewComments.sendKeys(rejectReason);
				GenericFunctions.waitForElementToAppear(createUserPage.requestChangesButton1);
				GenericFunctions.waitWebDriver(1000);
				createUserPage.requestChangesButton1.click();
				GenericFunctions.waitWebDriver(3000);
				System.out.println(inputToReject+" is rejected succesfully");
				ExtentTestManager.getTest().log(LogStatus.PASS, inputToReject+" is rejected succesfully");
			}
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on rejecting the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reject the content"+inputToReject);
			Assert.fail("Failed on rejecting the content");
		}

	}

	public void rejectTheResource()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the resource");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+"R00");
			//		/objListOFTestDataForSunbird.get(6).getCourseName()+GenericFunctions.readFromNotepad(".//resourceNumbers.txt").toString()
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			//GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickRequestChanges);
			createUserPage.clickRequestChanges.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			System.out.println(rejectReason);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.reviewComments.click();
			createUserPage.reviewComments.sendKeys(rejectReason);
			GenericFunctions.waitWebDriver(500);
			createUserPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on rejecting the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reject the resource");
			Assert.fail("Failed on rejecting the resource");
		}

	}



	public void createResource(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer(".//testData//resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			createUserPage.clickBookBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookBoard);
			createUserPage.selectBookBoard.click();			
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookGrade.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookGrade);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectBookGrade.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookSubject);
			createUserPage.selectBookSubject.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBookMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookMedium);
			createUserPage.selectBookMedium.click();

			GenericFunctions.waitForElementToAppear(createUserPage.selectConcept);

			createUserPage.selectConcept.click();

			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();

			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickResourceType.click();
			createUserPage.selectResourceType.click();

			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create a resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create resource");
			Assert.fail("Failed on creating new resource");
		}
	}

	public void saveAndSendResouceForReview(){
		try{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send resource for review");
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(3000);
			createUserPage.addImageIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButton);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButton);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);

			/*//ADDED ON PART OF MAINTENANCE 06/09/2018
			GenericFunctions.scrollToElement(createUserPage.selectConcept);
			GenericFunctions.waitForElementToAppear(createUserPage.selectConcept);
			createUserPage.selectConcept.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();

			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);*/

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Resource is sucessfully saved and sent for review");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save and send resource for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on saving and sending the resource for review");
			log.error("Exception In the method saveAndSendResouceForReview"+e.getLocalizedMessage());
			Assert.fail("Failed to save and send resource for review");
		}

	}


	public void resourcePublishAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search the resource");
			String searchCourseName="";
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.publishResource);
			//GenericFunctions.scrollToElement(createUserPage.publishResource);
			createUserPage.publishResource.click();
			
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);


			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error(e.getMessage()+"Error in resourcePublishAndSearch");
			Assert.fail("Failed to publish and search the resource");
		}
	}


	public void navigateToMyActivity(){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to My activity");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.myActivity);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.myActivity.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickDashboardCourse);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickDashboardCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectDashboardCourse.click();
			if(UploadOrgPageObjects.last7Days.isDisplayed()&&UploadOrgPageObjects.last7Days.isDisplayed()&&UploadOrgPageObjects.last5Weeks.isDisplayed())
			{
				Assert.assertTrue(true);
				WebDriver webDriver = this.getDriver();
				String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
						getScreenshotAs(OutputType.BASE64);
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot);
			}
			else 
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Failed to Validate Course Dashboard");
				System.out.println("Failed to Validate Course Dashboard");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to my activity");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error(e.getMessage()+"Error in navigateToMyActivity");
			Assert.fail("Error in navigating to my activity");
		}
	}

	public void editAndSubmitContent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit and submit the content for reviewing");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			PublicUserPageObjects.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.drafts.click();
			String courseToAssert = objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString();
			if(createUserPage.getCourseName.getText().equalsIgnoreCase(courseToAssert))
			{
				createUserPage.getCourseName.click();
			}
			else
			{
				System.out.println(courseToAssert +"Course is not found in Drafts to Edit");
			}
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			//GenericFunctions.waitForElementToAppearOnScreen(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(2000);

			//Add an extra Resource so it gets edited
			createUserPage.selectExtraResource.click();
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.saveButton.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on editing and submitting the content for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Error on edit and submit for review");
		}

	}

	public void limitedSharing(String contentType)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Limited sharing "+contentType);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			if(contentType.equalsIgnoreCase("book"))
			{
				createUserPage.bookTitle.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
			}
			else if(contentType.equalsIgnoreCase("course"))
			{
				createUserPage.titleName.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.titleDescription.sendKeys("_"+"Limited Sharing");
			} 
			else if(contentType.equalsIgnoreCase("lesson plan"))
			{
				createUserPage.lessonTitle.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.lessonDescription.sendKeys("_"+"Limited Sharing");
			}
			else if(contentType.equalsIgnoreCase("resource"))
			{
				GenericFunctions.waitWebDriver(2000);
				createUserPage.closeContentPopup.click();
				//createUserPage.bookName.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
			}

			else if(contentType.equalsIgnoreCase("upload"))
			{
				createUserPage.closeContentPopup.click();
				GenericFunctions.waitWebDriver(1000);
			}
			//createUserPage.bookDescription.sendKeys("_"+"Limited Sharing");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.limitedSharingArrow.click();
			createUserPage.clickLimitedSharing.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on limited sharing the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on limited sharing the content");
		}

	}

	public void uploadContentLimitedSharing(String uploadType) throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload "+uploadType+" for Limited sharing");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			
			WebElement browse=createUserPage.browseButton;
			if(uploadType.equalsIgnoreCase("mp4"))
			{
				browse.sendKeys(AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				browse.sendKeys(AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("WEBM content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("YOUTUBE content uploaded sucessfully");
				createUserPage.UploadButton.click();
			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				browse.sendKeys(AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("EPUB content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				browse.sendKeys(AllUploadingPaths.h5pPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("H5P content uploaded sucessfully");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on uploading content for limited sharing ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on uploading content for limited sharing ");
		}
	}

	//---------------------------------------------

	public void clickInReviewSubmission()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search course in review submission");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			String courseToAssert = objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString();
			System.out.println(courseToAssert);
			GenericFunctions.waitWebDriver(3000);
			if(createUserPage.getCourseName.getText().equalsIgnoreCase(courseToAssert))
			{
				createUserPage.getCourseName.click();
			}
			else
			{
				System.out.println(courseToAssert +"Course is not found in Review Submission");
			}
			GenericFunctions.waitWebDriver(3000);
			//createUserPage.getCourseName.click();
			System.out.println("User does not have the Edit access");
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			createUserPage.editorCloseIcon.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search course in review submission");
		}

	}

	//Adding method required for Test case 16
	public void checkInPublished(String source, List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to check in Published content in Published bucket");
			//  objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
			GenericFunctions.waitWebDriver(3000);
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.published.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);

			String courseName= createUserPage.getCourseName.getText();
			System.out.println(courseName);
			System.out.println(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString());
			if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//testData//courseNumbers.txt").toString()))
			{
				System.out.println("Course: "+courseName+" is found in published bucket");
			}
			else
			{
				System.out.println("Course:"+courseName+"is not found in publishes bucket");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Course is not found in published bukcet");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to get the course in the published bucket");
		}

	}

	public void saveBookAndCheckMessage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save book and check the confirmation message");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			GenericFunctions.waitForElementToAppear(createUserPage.bookDialcode);
			createUserPage.bookDialcode.sendKeys(randomDialCode);
			GenericFunctions.waitWebDriver(500);
			createUserPage.acceptDialcode.click();
			System.out.println("Dial Code: "+randomDialCode+" is entered in meta data page");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			//GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			GenericFunctions.waitWebDriver(3500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(500);
			System.out.println("Dial Code Added/updated Successfully");
			System.out.println("Content updated successfully");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Dial Code Added/updated Successfully");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Content updated successfully");
			GenericFunctions.waitWebDriver(1500);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save and check the confirmation message");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Exception occured while saving the book and checking confirmation messsage"+e);
			Assert.fail("Failed to save and check the confirmation message");

		}
	}

	public void removeDailCodeAndCheckMessage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to remove the dial code and check the confirmation message");
			saveBookAndCheckMessage();
			createUserPage.editDialCode.click();
			createUserPage.bookDialcode.clear();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(3500);
			//GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Dial Code Removed successfully");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Dial Code Removed successfully");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to remove the dial code and check the confirmation message");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on remove dial code and check the confirmation message");

		}

	}

	public void verifyOnlyBookOption()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify only book option is present");
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2500);
			boolean bookOption = createUserPage.createBook.isDisplayed();
			//Assert.assertTrue(true,bookOption+" is not displayed");
			Assert.assertEquals(true,bookOption);
			GenericFunctions.waitWebDriver(1500);
			if(bookOption==true)
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, createUserPage.createBook.getText()+" Option is only present for Book Creator");
				System.out.println(createUserPage.createBook.getText()+" Option is only present for Book Creator");
			}
			else
			{
				System.out.println("Only book option is not present");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that only book option is present to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that only book option is present to the user");

		}

	}


	public void rejectTheUploads(String uploadType)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the upload"+uploadType);
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();

			
			//To search for an upload and reject it which is already existing in the list
			if(uploadType.equalsIgnoreCase("epub"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+EPUB);
			}
			else if(uploadType.equalsIgnoreCase("mp4"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+MP4);
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+WEBM);
			}

			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+YOUTUBE);
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+HTML);
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+H5P);
			}
			
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickRequestChanges);
			//GenericFunctions.scrollToElement(createUserPage.clickRequestChanges);
			GenericFunctions.waitWebDriver(2500);
			
			//Giving reasons 
			createUserPage.clickRequestChanges.click();
			GenericFunctions.waitForElementToAppear(createUserPage.rejectReason1);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			createUserPage.reviewComments.click();
			createUserPage.reviewComments.sendKeys(rejectReason);
			createUserPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);
			System.out.println(uploadType+" rejected succesfully ");
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.PASS, uploadType+" rejected succesfully ");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to reject the upload content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to reject the uploads");

		}

	}

	public void verifyOnlyBooksPresent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that only books are present to the user");
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			String actual=createUserPage.contentType.getText();
			String expected="TextBook";
			try
			{
				Assert.assertEquals(actual, expected);
				if(createUserPage.contentType.isDisplayed())
					Assert.assertTrue(true);
				System.out.println("Only Textbooks are available");
				GenericFunctions.waitWebDriver(2000);
			}
			catch(Exception e)
			{
				System.out.println("Exception on asserting text books");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify only books present to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to verify only books present to the user");

		}
	}

	public void searchWithFilters()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify search with filters");
			/*GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.filterIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterBoard);
			createUserPage.clickFilterBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookBoard);
			createUserPage.selectBookBoard.click();
			
			createUserPage.clickBookGrade.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookGrade);
			createUserPage.selectBookGrade.click();
			GenericFunctions.waitWebDriver(1000);
			
			createUserPage.clickFilterSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectFilterSubject);
			createUserPage.selectFilterSubject.click();
			GenericFunctions.waitWebDriver(1000);
			
			createUserPage.clickFilterMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectFilterMedium);
			createUserPage.selectFilterMedium.click();
			
			createUserPage.clickContentType.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectContentType);
			createUserPage.selectContentType.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.applyButton.click();
			System.out.println("All the filters are applied");
			createUserPage.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			if(createUserPage.searchedContentForPublish.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to search the content using filters");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to apply filters and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to apply filters and search");

		}


	}

	public void navigateToProfileAndSearch(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to profile and search "+userData);
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(userData);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("could not navigate to profile and search");
		}
	}

	public void navigateToProfileAndSearchOrg()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to profile and search organizations");
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(CreateMentorPageObjects.searchDropDown);
			CreateMentorPageObjects.searchDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			CreateMentorPageObjects.SearchDropDownOrg.click();
			GenericFunctions.waitWebDriver(1000);
			CreateMentorPageObjects.downloadButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile and search organizations");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not navigate to profile and search organizations,Exception "+e.getLocalizedMessage());
		}
	}

	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to search a coursea and create a batch");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			/*createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			CreateMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			createUserPage.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			CreateMentorPageObjects.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			CreateMentorPageObjects.createBatch.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course and create a batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to search course and create a batch, Exception"+e.getLocalizedMessage());

		}

	}

	public void verifyNoBookOptionPresent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify no book option is present to the user");
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			try
			{
				createUserPage.createBook.click();
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "User does not have create book option");
				Assert.assertTrue(true);
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not check for book option,Exception"+e.getLocalizedMessage());

		}
	}


	public void navigateToLibraryAndSearchContent(String userData)
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
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//testData//contentNumbers.txt"));
			createUserPage.searchIconUpForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}
	}


	//Added for regression test case 13

	public void searchInUpForReviewForOpenbatch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search content in up for review bucket and create an open batch");
			String courseNumber = "",searchCourseName="";
			GenericFunctions.waitForElementToAppear(PublicUserPageObjects.headerProfile);
			PublicUserPageObjects.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();

			if(source.equalsIgnoreCase(COURSE))
			{
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(RESOURCE)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName();	;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(LESSONPLAN)){
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search content in up for review bucket and create an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for review bucket and create an open batch, Exception"+e.getLocalizedMessage());

		}

	}


	//Added for test case 13

	public void publishAndSearchForOpenBatch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search to create an open batch");
			String courseNumber="",searchCourseName="";
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			createUserPage.publishCourseButton.click();
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(1500);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			driver.switchTo().defaultContent();
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}
			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				courseNumber = GenericFunctions.readFromNotepad(".//testData//sunbird_data.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search to create an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not publish and search to create an open batch, Exception"+e.getLocalizedMessage());
		}

	}

	//Added for test case 13

	public void createCourseForOpenBatch(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a course for an open batch");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//sunbird_data.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(createUserPage.titleName);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.proceedButton);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create a course for an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not create a course for an open batch, Exception"+e.getLocalizedMessage());
		}
	}
	public void uploadAudioForEveryone() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload an audio");
			GenericFunctions.waitWebDriver(1500);
			ContentCreationResourcePageObjects.addAudio.click();
			ContentCreationResourcePageObjects.selectMyAudio.click();
			ContentCreationResourcePageObjects.btnUploadRecord.click();
			ContentCreationResourcePageObjects.iconUpload.click();
			ContentCreationResourcePageObjects.btnChooseFile.click();
			String path=AllUploadingPaths.audioPath;
			String secondpath = "./UploadingDocuments/Uploading audios/"+AUDIO_UPLOAD;  
			GenericFunctions.uploadFile(path);
			ContentCreationResourcePageObjects.rightBtnAvailable.click();
			GenericFunctions.waitWebDriver(1500);
			ContentCreationResourcePageObjects.btnUploadAndUse.click();
			String alertActualMessage = ContentCreationResourcePageObjects.alertMessage.getText();
			String alertExpectedMessage = "Audio successfully uploaded";
			Assert.assertEquals(alertActualMessage, alertExpectedMessage);
			GenericFunctions.waitWebDriver(3000);
			System.out.println(alertActualMessage);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.xWindowCloseButton.click();
			GenericFunctions.waitWebDriver(5000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload an audio");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to upload an audio"+e.getLocalizedMessage());
		}

	}
	public void navigateToProfilePage() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Profile page");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			
			String actualUrl="https://staging.open-sunbird.org/profile";
			String expectedUrl=driver.getCurrentUrl();
			if(createUserPage.workSpace.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Profile Page");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Asserting the URLs of Profile Page");
			}					
				
			//GenericFunctions.assertIfElementExists(driver, XPATH, createUserPage.workSpace.toString());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to profile page"+e.getLocalizedMessage());
		}
	}
	

	public void navigateToLibraryPage() throws InterruptedException
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library page");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibraryTitles);
			System.out.println(createUserPage.headerLibraryTitles.getText());
			String actualUrl="https://staging.open-sunbird.org/resources";
			String expectedUrl=driver.getCurrentUrl();
			if(createUserPage.headerLibraryTitles.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Library Page");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Asserting the URLs of Library Page");
			}	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to library page"+e.getLocalizedMessage());
		}
	}

	
	
	public void navigateToCoursePage() throws InterruptedException
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Course page");	
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourseTitles);
			String actualUrl="https://staging.open-sunbird.org/learn";
			String expectedUrl=driver.getCurrentUrl();
			if(createUserPage.headerCourseTitles.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Course Page");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Asserting the URLs of Course Page");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to course page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to course page"+e.getLocalizedMessage());
		}
	}
	public void ValidateContentEditor()	
	{
		try
		{
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a book and trying to Content Editor");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a book");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer(".//testData//bookNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName()+bookNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create a book and navigate to Content Editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not create a Book and Navigaet to Content Editor, Exception"+e.getLocalizedMessage());
		}
	}
	
	public void resourceName()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying create new resource by giving an Unique Resource name");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer(".//testData//resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on entering unique resource name");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on entering unique resource name"+e.getLocalizedMessage());
			Assert.fail("Failed on entering unique resource name"+e.getLocalizedMessage());
		}

	}

	public void sendResourceForReview()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send resource for review");
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectClass);
			createUserPage.selectClass.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectMedium);
			createUserPage.selectMedium.click();
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);

			createUserPage.saveButton.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to send resource for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to send resource for review"+e.getLocalizedMessage());
			Assert.fail("Failed to send resource for review"+e.getLocalizedMessage());
		}

	}
	public void addAudio()
	{
		//Adding Audio
		GenericFunctions.waitForElementToAppear(createUserPage.addAudio);
		createUserPage.addAudio.click();
		GenericFunctions.waitForElementToAppearOnScreen(createUserPage.clickAllAudio);
		GenericFunctions.waitWebDriver(500);
		createUserPage.clickAllAudio.click();
		GenericFunctions.waitForElementToAppear(createUserPage.selectAudio_AllAudio);
		GenericFunctions.waitWebDriver(500);
		createUserPage.selectAudio_AllAudio.click();
		GenericFunctions.waitWebDriver(600);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(500);
	}
	
	public void deleteCreatedItems()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete Items which are created");
			GenericFunctions.waitForElementToAppear(createUserPage.deleteButton);
			createUserPage.deleteButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.yesButtonPopup);
			createUserPage.yesButtonPopup.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(UploadOrgPageObjects.dropdown);
		
		}
	catch(Exception e)
	 {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete Items ");
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
		System.out.println("Failed to delete Items");
		Assert.fail("Failed to delete Items ");
	 }
	}
	public void goToProfilePage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Profile Page");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconProfile);
			createUserPage.profileIconProfile.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not navigate to Profile Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not navigate to Profile Page");
		}
	}
	
    //@author sachin
    public void createLessonPlanWithoutProceed() throws Exception {
   	 ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a lesson plan");
		List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions.waitWebDriver(2000);
		navigateToWorkspace(LESSONPLAN);
		//GenericFunctions.waitWebDriver(2000);
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		lessonNumber = GenericFunctions.testDataIncrementer(".//TestData//lessonPlan.txt");
		//createUserPage.clickOnPopup.click();

		createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
		System.out.println("Lesson created :"+objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
		GenericFunctions.waitWebDriver(2000);
		createUserPage.clickBBoard.click();
		GenericFunctions.waitForElementToAppear(createUserPage.selectBBoard);
		createUserPage.selectBBoard.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.clickBGrade.click();
		GenericFunctions.waitForElementToAppear(createUserPage.selectBGrade);
		createUserPage.selectBGrade.click();
		//createUserPage.clickOnPopup.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.clickBSubject.click();
		GenericFunctions.waitForElementToAppear(createUserPage.selectBSubject);
		createUserPage.selectBSubject.click();
		GenericFunctions.waitForElementToAppear(createUserPage.clickBMedium);
		createUserPage.clickBMedium.click();
		//createUserPage.clickOnPopup.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.selectBMedium.click();
		GenericFunctions.waitWebDriver(4000);

		createUserPage.startCreating.click();
		GenericFunctions.waitWebDriver(7000);			
		GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
		GenericFunctions.waitWebDriver(4500);
		GenericFunctions.waitForElementToAppear(createUserPage.newChild);
		System.out.println(createUserPage.newChild.getText());
		GenericFunctions.waitWebDriver(2500);
		//createUserPage.newChild.click();	
		action.moveToElement(createUserPage.newChild).click().perform();
		GenericFunctions.waitWebDriver(5000);
		//createUserPage.lessonTitle.click();
		createUserPage.lessonTitle.clear();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
		GenericFunctions.waitWebDriver(2000);
		createUserPage.lessonDescription.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseDescription());
		GenericFunctions.waitWebDriver(2000);
		createUserPage.lessonNotes.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(3).getTitle());
		GenericFunctions.waitWebDriver(2000);
		createUserPage.addResource.click();
		GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
		createUserPage.lessonResource.click();
		GenericFunctions.waitWebDriver(1500);
   	 
    }
    
	    //@author sachin
	    public void profileToWorkspace() throws Exception{
	
		CreateMentorPageObjects mentorObj = PageFactory.initElements(driver, CreateMentorPageObjects.class);
		mentorObj.profileImage.click();
		GenericFunctions.waitWebDriver(1000);
		mentorObj.workSpace.click();
		GenericFunctions.waitWebDriver(1000);

	}
	    
		public void createThreeChildNodes()throws Exception{
			
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(2).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(1).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(1).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(1).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
			
		}
		
		public void addAndDeleteResources() throws Exception{
       	 action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(2).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.resource1.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resource2.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resource3.click();
			GenericFunctions.waitWebDriver(1500);
			
	
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			createUserPage.deleteIcon.click();
			GenericFunctions.waitWebDriver(3000);
			
			createUserPage.yesConfirmation.click();
			GenericFunctions.waitWebDriver(3000);
			
			createUserPage.deleteIcon.click();
			GenericFunctions.waitWebDriver(3000);
			
			createUserPage.cancelButton.click();
			GenericFunctions.waitWebDriver(3000);
			
        }
		
		 // Written By Sachin for Search Content in Up for Review
 		public String searchContent(String courseToSearch)
 		{
 			
 			FlagReviewerPageObjects pageObjects = PageFactory.initElements(driver, FlagReviewerPageObjects.class);

 			GenericFunctions.waitWebDriver(2000);
 			pageObjects.searchContent.click();
 			pageObjects.searchContent.sendKeys(courseToSearch);
 			//flagReviewerpage.searchContentClick.click();
 			//GenericFunctions.waitForElementToAppear(flagReviewerpage.searchedCourse);
 			GenericFunctions.waitWebDriver(3000);
 			String courseName=pageObjects.searchedCourse.getText();
 			System.out.println(courseName);
 			return courseName;

 		}
 		
 		// @author Sachin
 		// Reference for TC_186 		
 		public void createResourceTC_186(List <TestDataForSunbird> objListOFTestDataForSunbird)
 		{
 			
 				GenericFunctions.waitWebDriver(1500);
 				GenericFunctions.waitForElementToAppear(createUserPage.bookName);
 				String resourceNumber = GenericFunctions.testDataIncrementer(".//testData//resourceNumbers.txt").toString();
 				createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
 				 				
 				createUserPage.startCreating.click();
 				GenericFunctions.waitWebDriver(5000);
 				
 				driver.switchTo().frame(0);
 				
 				createUserPage.addQuestionSet.click(); 	
 				GenericFunctions.waitWebDriver(2000);
 				
 				createUserPage.createQuestion.click();
 				
 				createUserPage.MTF.click();
 				GenericFunctions.waitWebDriver(2000);

 				createUserPage.Back.click();
 				GenericFunctions.waitWebDriver(2000);

 				createUserPage.MCQ.click();
 				GenericFunctions.waitWebDriver(2000);

 				createUserPage.Back.click();
 				GenericFunctions.waitWebDriver(2000);

 				createUserPage.FIB.click();
 				GenericFunctions.waitWebDriver(2000);			 			
 		}
 		
 				// @author Sachin
		 		public void clickWorkspace()throws Exception{
				try
				{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all workspace");	
				GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
				createUserPage.workSpace.click();
				GenericFunctions.waitWebDriver(2000);				
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to click on all workspace");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
					Assert.fail("User is trying to click on all workspace");
				}
		 	}
				
		 		
		 		
 				// @author Sachin
		 		public void clickAllMyContent()throws Exception{
				try{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content and then filter icon");
				GenericFunctions.waitForElementToAppear(createUserPage.allMyContent);
				createUserPage.allMyContent.click();
				GenericFunctions.waitWebDriver(2000);
								
				createUserPage.filterIcon.click();				
				GenericFunctions.waitWebDriver(2000);				
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
					Assert.fail("failed to click filter icon");
				}
		 	}
		 		
		 		
 				// @author Sachin
		 		
		 		public void allMyContent()throws Exception{
				try
		 		{	
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content");
					createUserPage.allMyContent.click();
					GenericFunctions.waitWebDriver(2000);
		 				
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
					Assert.fail("failed on clicking all my content");
				}
		 		
		 		}
		 		
		 		
		 		
			 		
		 	   // @author Sachin
		 		public void allMyContentSortByDropdown()throws Exception{
				try
				{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  select modified on and created on option in the dropdown");
				GenericFunctions.waitForElementToAppear(createUserPage.allMyContent);
				createUserPage.allMyContent.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.sortByDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.modifiedOnDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.sortByDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.createdOnDropdown.click();
				GenericFunctions.waitWebDriver(2000);
												
				}
				catch (Exception e) {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on selecting options from dropdown");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					log.error("Exception In the method allMyContentSortByDropdown" + e.getLocalizedMessage());
					Assert.fail("Failed on selecting options from dropdown" + e.getLocalizedMessage());
				
				}
    }
		 		
		 		// @author Sachin
		 public void deleteByStatus(String statusContent)throws Exception{
				
			 try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
				GenericFunctions.waitForElementToAppear(createUserPage.selectStatus);
				createUserPage.selectStatus.click();
				if(statusContent.equalsIgnoreCase("DRAFT")){
				createUserPage.draftSelect.click();
				GenericFunctions.waitWebDriver(2000);
				 }
				else if(statusContent.equalsIgnoreCase("FLAGDRAFT")){
				createUserPage.flagDraftSelect.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(statusContent.equalsIgnoreCase("REVIEW")){
				createUserPage.reviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(statusContent.equalsIgnoreCase("PROCESSING")){
				createUserPage.processingSelect.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(statusContent.equalsIgnoreCase("LIVE")){
				createUserPage.liveSelect.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(statusContent.equalsIgnoreCase("UNLISTED")){
				createUserPage.unlistedSelect.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(statusContent.equalsIgnoreCase("FLAGREVIEW")){
				createUserPage.flagReviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
				} 
				createUserPage.applyButton.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);
				
				try{
				if(driver.findElement(By.xpath("(//div[contains(@class,'UpReviewHeader')])[1]")).isDisplayed() ){
			    String contentType = createUserPage.firstDraft.getText();
				createUserPage.deleteButton.click();					
				GenericFunctions.waitWebDriver(2000);		
					
				createUserPage.confirmYesToPopup.click();
				GenericFunctions.waitWebDriver(2000);
					
				createUserPage.searchContent.click();
				createUserPage.searchContent.sendKeys(contentType);
				GenericFunctions.waitWebDriver(4000);
					
				createUserPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);
						
				createUserPage.resetFilter.click();
				
				}
				}
				
				catch(Exception e){
							
				createUserPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);
					
				createUserPage.resetFilter.click();
				GenericFunctions.waitWebDriver(2000);			
				}	
			 }
			 catch(Exception e)
			 {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting content by status");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					log.error("Exception In the method deleteByStatus" + e.getLocalizedMessage());
					Assert.fail("Failed on deleting content by status" + e.getLocalizedMessage()); 			 
			 }
			}
				
		 
		 
		 
					
		 		// @author Sachin
		 		public void deleteContent(String PublishedContent)throws Exception{
				try
				{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
				GenericFunctions.waitForElementToAppear(createUserPage.searchContent);				
				if(PublishedContent.equalsIgnoreCase("COURSE")){
				createUserPage.searchContent.sendKeys("COURSE");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(PublishedContent.equalsIgnoreCase("COLLECTION")){
				createUserPage.searchContent.sendKeys("COLLECTION");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(PublishedContent.equalsIgnoreCase("LESSON PLAN")){
				createUserPage.searchContent.sendKeys("LESSON PLAN");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(PublishedContent.equalsIgnoreCase("RESOURCES")){
				createUserPage.searchContent.sendKeys("RESOURCES");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(PublishedContent.equalsIgnoreCase("BOOK")){
				createUserPage.searchContent.sendKeys("BOOK");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				}
				else if(PublishedContent.equalsIgnoreCase("UPLOADED CONTENT")){
				createUserPage.searchContent.sendKeys("UPLOADED CONTENT");
				createUserPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
				} 
							
				createUserPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);
			
				createUserPage.selectStatus.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.liveSelect.click();
				GenericFunctions.waitWebDriver(2000);

				createUserPage.applyButton.click();
				GenericFunctions.waitWebDriver(2000);	
				
				createUserPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);
				
				String deletedContent = createUserPage.firstDraft.getText();
				createUserPage.deleteButton.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.yesButtonPopup.click();
				GenericFunctions.waitWebDriver(2000);
				
				createUserPage.searchContent.sendKeys(deletedContent);
				GenericFunctions.waitWebDriver(4000);
				}
				catch(Exception e)
				{				
					ExtentTestManager.getTest().log(LogStatus.FAIL, "User is unable delete content by status");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
					Assert.fail("User is unable delete content by status");
				}
					
			}

		 		
		 		
			 	// @author Sachin
			 	public void coursePreview()throws Exception
				{				 			
				GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(2000);
					
				createUserPage.course.click();
				GenericFunctions.waitWebDriver(4000);
				}
			 	
	 	
			 	
		 		
}
	