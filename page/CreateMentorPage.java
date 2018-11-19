package org.sunbird.page;

import java.awt.Robot;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.CreateMentorPageObjects;
import org.sunbird.pageobject.CreatorAnnouncementPageObjects;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class CreateMentorPage extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	CreateMentorPageObjects createMentorPageObjects = PageFactory.initElements(driver, CreateMentorPageObjects.class);
	CreatorAnnouncementPageObjects createAnnouncementPage = PageFactory.initElements(driver,
			CreatorAnnouncementPageObjects.class);
	PublicUserPageObjects publicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	SignUpObjects signUpPage = PageFactory.initElements(driver, SignUpObjects.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPageObjects.class.getName());
	CreatorUserPageObjects createUserPage = PageFactory.initElements(driver, CreatorUserPageObjects.class);
	Actions action = new Actions(driver);
	Random rand = new Random();
	// String announcementType="Order";
	List<TestDataForSunbird> objListOFTestDataForSunbird = null;
	String batchStatus = "Previous Batches";
	String courseName;
	String startDate;
	String endDate;

	public void navigateToMyActivityInDropDownMenu() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to My Activity in drop down menu");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.myActivityInDropdown.click();
			GenericFunctions.waitWebDriver(1500);
			createMentorPageObjects.SearchCourseDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.firstCourseDropdownitem.click();
			createMentorPageObjects.rightArrowIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.leftArrowIcon.click();

		}
		catch (Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to My activity");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToMyActivityInDropDownMenu" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to My activity, Exception : " + e.getLocalizedMessage());
		}
	}

	public void navigateToCourseAndSearch(String courseName) throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section and search course");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(courseName);// objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section and search course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearch" + e.getLocalizedMessage());
			Assert.fail(
					"Failed on navigating to Course section and search course, Exception : " + e.getLocalizedMessage());

		}
	}

	public void navigateToCourseAndSearchForOpenBatch(String courseName) throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify navigate to Course section, search course and create open batch");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(courseName);// objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//openBatchData.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed on navigating to Course section, search course and create batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForOpenBatch" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "
					+ e.getLocalizedMessage());

		}
	}

	public void navigateToCourseAndSearchForOpenBatch() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify navigate to Course section, search course and create open batch");
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.readFromNotepad(".//TestData//sunbird_data.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed on navigating to Course section, search course and create batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForOpenBatch" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "
					+ e.getLocalizedMessage());
		}
	}

	public void navigateToCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		//String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify update the batch");
			GenericFunctions.waitWebDriver(1500);

			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, createMentorPageObjects.batchForm);
			createMentorPageObjects.nameOfBatch.clear();
			createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.aboutBatch.clear();
			createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			createMentorPageObjects.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.endDate.clear();
			createMentorPageObjects.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
			createMentorPageObjects.mentorsInBatch.click();
			createMentorPageObjects.updateMentorInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.mentorsInBatch.click();
			
			createMentorPageObjects.updateMembersInBatch.click();
			createMentorPageObjects.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			createMentorPageObjects.updateMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);						
			createMentorPageObjects.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed on updating the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the course : "
					+ e.getLocalizedMessage());
		}

	}

	public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to navigate to Worskpace and select batch " + batchType);

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPageObjects.workSpace);
			createMentorPageObjects.workSpace.click();	
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.batchesDropDown.click();
			GenericFunctions.waitWebDriver(1500);
			if (batchType.equalsIgnoreCase("Ongoing Batches")) {
				GenericFunctions.waitForElementToAppear(createMentorPageObjects.ongoingBatches);
				createMentorPageObjects.ongoingBatches.click();
				GenericFunctions.waitWebDriver(1500);
				System.out.println("Ongoing batches");
			} else if (batchType.equalsIgnoreCase("Upcoming Batches")) {
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.upcomingBatches.click();
				System.out.println("upcoming batches");
			} else if (batchType.equalsIgnoreCase("Previous Batches")) {
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.previousBatches.click();
				GenericFunctions.waitWebDriver(5000);
				System.out.println("Previous batches");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToWorkspaceInDropDownMenu" + e.getMessage());
			Assert.fail(
					"Failed on navigating to Workspace and selecting batch, Exception : " + e.getLocalizedMessage());
		}
	}

	public void checkForAuthenticUserAndEdit() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search authentic user and edit");
			GenericFunctions generic = new GenericFunctions();
			CreateMentorPageObjects createMentorPageObjects = PageFactory.initElements(driver,
					CreateMentorPageObjects.class);
			String personName = createMentorPageObjects.profileNameInUserSearch.getText();
			System.out.println(personName);
			boolean elementStatus = generic.isElementPresent(createMentorPageObjects.editIconInUserProfileSearch);
			if (elementStatus == true) {

				System.out.println("authenticPerson");
				createMentorPageObjects.editIconInUserProfileSearch.click();
				GenericFunctions.waitWebDriver(1000);
				for (int k = 0; k < createMentorPageObjects.selectRoleCheckboxL.size(); k++) {
					if (createMentorPageObjects.selectRoleCheckboxL.get(k).isEnabled()) {
						createMentorPageObjects.selectRoleCheckboxL.get(k).click();
						break;
					} else {
						k++;
					}

				}
				createMentorPageObjects.updateButtonInUserProfile.click();
				String msg = createMentorPageObjects.successfulMessage.getText();
				System.out.println(msg);
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method checkForAuthenticUserAndEdit" + e.getMessage());
			Assert.fail("Failed on searching authentic user and edit" + e.getLocalizedMessage());
		}
	}

	public void checkForUnauthenticUserAndEdit() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search Unauthentic user and edit");
			GenericFunctions generic = new GenericFunctions();
			CreateMentorPageObjects createMentorPageObjects = PageFactory.initElements(driver,
					CreateMentorPageObjects.class);
			String personName = createMentorPageObjects.profileNameInUserSearch.getText();
			System.out.println(personName);
			boolean elementStatus = generic.isElementPresent(createMentorPageObjects.editIconInUserProfileSearch);
			if (elementStatus == true) {
				System.out.println("UnauthenticPerson" + "edit button is unavailable");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method checkForUnauthenticUserAndEdit" + e.getMessage());
			Assert.fail("Failed on searching unauthentic user and edit" + e.getLocalizedMessage());
		}
	}

	public void enrollForOpenBatch() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to enroll for an open batch");

			boolean enrollButton = createMentorPageObjects.resumeCourse.isDisplayed();
			if (enrollButton == false) {
				createMentorPageObjects.enrollForOpenBatch.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.enrollForCourse.click();
				Assert.assertTrue(true);
				System.out.println("Enrolled for the course sucessfully");

			} else {
				System.out.println("User is already enrolled to the course");
				/*
				 * createMentorPageObjects.enrollForOpenBatch.click();
				 * GenericFunctions.waitWebDriver(1000);
				 * createMentorPageObjects.enrollForCourse.click();
				 */
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enroll for an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method enrollForOpenBatch" + e.getMessage());
			Assert.fail("Failed to enroll for an open batch, Exception" + e.getLocalizedMessage());
		}
	}

	public void navigateToElement() throws InterruptedException {

		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to element");
			for (WebElement ele : createMentorPageObjects.courseImg) {
				GenericFunctions.waitWebDriver(1000);
				// courseName = ele.getText();
				ele.click();
				// System.out.println(courseName);
				GenericFunctions.switchToFrame(driver, createMentorPageObjects.batchForm);
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.calendarStartDate.click();
				startDate = createMentorPageObjects.calendarStartDate.getText();
				System.out.println(startDate);
				createMentorPageObjects.calendarEndDate.click();
				endDate = createMentorPageObjects.calendarEndDate.getText();
				System.out.println(endDate);
				System.out.println("bingo");
				createMentorPageObjects.closeButton.click();
				// CreateMentorPage createMentorPageObj =new CreateMentorPage();
				GenericFunctions.waitWebDriver(1000);
				// createMentorPageObjects.batchesDropDown.click();
				// GenericFunctions.waitWebDriver(1000);
				// createMentorPageObjects.previousBatches.click();
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to element");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToElement" + e.getMessage());
			Assert.fail("Failed to navigate to element, Exception" + e.getLocalizedMessage());
		}
		// }
		// catch(Exception e)
		// {
		// log.error("Exception In the method
		// navigateToElement"+e.getMessage());

		// }
	}

	public String createInviteOnlyBatch() throws InterruptedException, Exception {
		String savedCourseName = null;
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());// +GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			savedCourseName = createMentorPageObjects.getCourseName.getText();
			System.out.println(savedCourseName);
			// createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.getCourseName.click();
			GenericFunctions.waitWebDriver(3000);
			createMentorPageObjects.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			//GenericFunctions.switchToFrame(driver, createMentorPageObjects.batchForm);
			//GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchName.txt"));
			createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			/*
			 * createMentorPageObjects.startDate.sendKeys(
			 * objListOFTestDataForSunbird.get(8).getTitle());
			 * createMentorPageObjects.endDate.sendKeys(
			 * objListOFTestDataForSunbird.get(8).getTitleDescription());
			 */

			// Added on 31/07/2018
			createMentorPageObjects.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			createMentorPageObjects.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			// createMentorPageObjects.mentorsInBatch.sendKeys(objListOFTestDataForSunbird.get(9).getCourseName());
			createMentorPageObjects.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.mentorDropdown.click();
			createMentorPageObjects.membersInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			// createMentorPageObjects.membersInBatch.sendKeys("test batch
			// person");
			// GenericFunctions.scrollToElement(createMentorPageObjects.selectMemberInBatch);
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.suborgUser6InBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.memberDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.aboutBatch.click();
			GenericFunctions.waitWebDriver(3000);
			// GenericFunctions.waitWebDriver(1000);
			// for(int i=1;i<=7;i++)
			// {
			// robot.keyPress(KeyEvent.VK_TAB);
			// robot.keyRelease(KeyEvent.VK_TAB);
			// }
			// GenericFunctions.waitWebDriver(1000);
			//
			// robot.keyPress(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(1000);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(3000);

			createMentorPageObjects.buttonCreate.click();
			createMentorPageObjects.successfulMessage.click();
			System.out.println("Batch Created");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		return savedCourseName;

	}

	public void createOpenBatch() throws InterruptedException, Exception {

		try {
			// GenericFunctions.waitWebDriver(1500);
			// createUserPage.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// createUserPage.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// createMentorPageObjects.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			createMentorPageObjects.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPageObjects.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//sunbird_data.txt"));
			createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			createMentorPageObjects.openBatch.click();
			createMentorPageObjects.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			createMentorPageObjects.mentorsInBatch.click();
			createMentorPageObjects.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			createMentorPageObjects.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			createMentorPageObjects.testBookReviewerInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			
			// GenericFunctions.waitWebDriver(1000);
			// for(int i=1;i<=7;i++)
			// {
			// robot.keyPress(KeyEvent.VK_TAB);
			// robot.keyRelease(KeyEvent.VK_TAB);
			// }
			// GenericFunctions.waitWebDriver(1000);
			//
			// robot.keyPress(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(1000);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(3000);

			createMentorPageObjects.buttonCreate.click();
			// createMentorPageObjects.successfulMessage.click();
			System.out.println("Batch Created");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch" + e.getMessage());
			Assert.fail("Failed to create open batch, Exception" + e.getLocalizedMessage());

		}
	}

	public void createInviteOnlyBatchForSuborg() throws InterruptedException, Exception {

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to create invite only batch for Sub Organization");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());// +GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
			createMentorPageObjects.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPageObjects.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchName.txt"));
			createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			createMentorPageObjects.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.startDateCalendar.click();
			GenericFunctions.waitWebDriver(500);
			createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			createMentorPageObjects.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			// createMentorPageObjects.mentorsInBatch.sendKeys(objListOFTestDataForSunbird.get(9).getCourseName());
			createMentorPageObjects.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.mentorDropdown.click();
			GenericFunctions.waitWebDriver(500);
			createMentorPageObjects.membersInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			// createMentorPageObjects.membersInBatch.sendKeys("test batch
			// person");
			// GenericFunctions.scrollToElement(createMentorPageObjects.selectMemberInBatch);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions generic = new GenericFunctions();
			boolean elementPresent = generic.isElementPresent(createMentorPageObjects.orgAdminInBatch);
			if (elementPresent == false) {
				System.out.println("Batch not Created");
			} else {
				System.out.println("Batch is created");
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch for Sub Organization");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatchForSuborg" + e.getMessage());
			Assert.fail("Failed to create invite only batch for Sub Organization, Exception" + e.getLocalizedMessage());

		}
	}

	public void viewCourseStats() {
		try {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to view the course stats");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.viewCourseStat.click();
			GenericFunctions.waitWebDriver(2000);
			if (createMentorPageObjects.courseStatMessage.isDisplayed()) {
				System.out.println(createMentorPageObjects.courseStatMessage + " User could not check course stats");
			} else if (createMentorPageObjects.courseStatMessage.isDisplayed() == false) {
				System.out.println("Batch is not created to the course");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to view the course stats");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method viewCourseStats" + e.getMessage());
			Assert.fail("Failed to view the course stat, Exception" + e.getLocalizedMessage());

		}
	}

	public void navigateToLibraryAndSearchForCollection() throws InterruptedException {
		List<TestDataForSunbird> objListOFTestDataForSunbird = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"User is trying to navigate to library and search the collection");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName() + "_"
					+ GenericFunctions.readFromNotepad(".//TestData//collectionNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library and search the collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForCollection " + e.getMessage());
			Assert.fail("Failed to navigate to library and search the collection" + e.getLocalizedMessage());

		}

	}

	public void navigateToLibraryAndSearchForLessonPlan() throws InterruptedException {
		List<TestDataForSunbird> objListOFTestDataForSunbird = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"User is trying to navigate to library and search the lesson plan");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()
					+ GenericFunctions.readFromNotepad(".//TestData//lessonPlan.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}

		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to navigate to library and search the lesson plan" + "");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForLessonPlan " + e.getMessage());
			Assert.fail("Failed to navigate to library and search the lesson plan" + e.getLocalizedMessage());

		}
	}

	public void navigateToLibraryAndSearchForBook() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"User is trying to navigate to library and search for Book");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.filterSearch.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()
					+ GenericFunctions.readFromNotepad("./bookNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPageObjects.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library and search for Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook " + e.getMessage());
			Assert.fail("Failed to navigate to library and search for Book" + e.getLocalizedMessage());
			System.out.println("Exception in the method navigateToLibraryAndSearchForBook " + e);
		}
	}

	// @author Sachin
	public void invokingCreatingResource() throws Exception {
		CreatorUserPage publicUserObj = new CreatorUserPage();
		publicUserObj.createResource(objListOFTestDataForSunbird);
	}

	// @author Sachin
	public void createLessonPlanWithoutProceed() throws Exception {
		CreatorUserPage publicUserObj = new CreatorUserPage();
		publicUserObj.createLessonPlanWithoutProceed();

	}
	// @author Sachin
	public void editDetails() throws Exception {
		ContentCreationResourcePage contentUserObj = new ContentCreationResourcePage();
		contentUserObj.editResourceDetails();
	}
	// @author Sachin
		public void createLessonplan() throws Exception {
		CreatorUserPage publicUserObj = new CreatorUserPage();
		publicUserObj.createLessonPlan();
	}
	    public void invokingSaveAndSendLessonPlanForReview()throws Exception{
	    	ContentCreationResourcePage publicObj = new ContentCreationResourcePage();
	    	publicObj.saveAndSendLessonPlanForReview();	
	    }
	    
	    
	    
	    // @author Sachin
		public void createInviteBatch() throws InterruptedException, Exception {
			Robot robot = new Robot();
		    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
									
			try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
				
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(createMentorPageObjects.latestCourse);
				createMentorPageObjects.latestCourse.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPageObjects.addIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
						+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
				createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

				createMentorPageObjects.startDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.startDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
				
				createMentorPageObjects.mentorsInBatch.click();
				GenericFunctions.waitWebDriver(1000);				
				createMentorPageObjects.suborgMentor2InBatch.click();
				createMentorPageObjects.mentorsInBatch.click();
				
				GenericFunctions.waitWebDriver(1000);								
				createMentorPageObjects.mentorDropdown.click();
				createMentorPageObjects.membersInBatch.click();
				createMentorPageObjects.mentorDropdown.click();
				GenericFunctions.waitWebDriver(1500);	
				
				createMentorPageObjects.buttonCreate.click();
				GenericFunctions.waitWebDriver(4000);
				//createMentorPageObjects.successfulMessage.click();
				System.out.println("Batch Created");

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
				Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
			}
			

		}
	    
	    
		
	    // @author Sachin
		public void createInviteBatchwithStartDate() throws InterruptedException, Exception {
			Robot robot = new Robot();
		    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
									
			try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
				
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(createMentorPageObjects.latestCourse);
				createMentorPageObjects.latestCourse.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPageObjects.addIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
						+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
				createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

				createMentorPageObjects.startDate.sendKeys("15 November 2018");
				GenericFunctions.waitWebDriver(1000);

				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
				
				createMentorPageObjects.mentorsInBatch.click();
				GenericFunctions.waitWebDriver(1000);				
				createMentorPageObjects.suborgMentor2InBatch.click();
				createMentorPageObjects.mentorsInBatch.click();
				
				GenericFunctions.waitWebDriver(1000);								
				createMentorPageObjects.mentorDropdown.click();
				createMentorPageObjects.membersInBatch.click();
				createMentorPageObjects.mentorDropdown.click();
				GenericFunctions.waitWebDriver(4000);	
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPageObjects.buttonCreate);
				createMentorPageObjects.buttonCreate.click();
				//createMentorPageObjects.successfulMessage.click();
				System.out.println("Batch Created");

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
				Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
			}
			

		}
	    
	    
	    
		
	    // @author Sachin
		public void createInviteBatchFutureStartDate() throws InterruptedException, Exception {
			Robot robot = new Robot();
		    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
									
			try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
				
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(createMentorPageObjects.latestCourse);
				createMentorPageObjects.latestCourse.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPageObjects.addIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPageObjects.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
						+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
				createMentorPageObjects.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

				createMentorPageObjects.startDate.sendKeys("1 January 2019");
				GenericFunctions.waitWebDriver(1000);

				GenericFunctions.waitWebDriver(1000);
				createMentorPageObjects.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
				
				createMentorPageObjects.mentorsInBatch.click();
				GenericFunctions.waitWebDriver(1000);				
				createMentorPageObjects.suborgMentor2InBatch.click();
				createMentorPageObjects.mentorsInBatch.click();
				
				GenericFunctions.waitWebDriver(1000);								
				createMentorPageObjects.mentorDropdown.click();
				createMentorPageObjects.membersInBatch.click();
				createMentorPageObjects.mentorDropdown.click();
				GenericFunctions.waitWebDriver(4000);	
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPageObjects.buttonCreate);
				createMentorPageObjects.buttonCreate.click();
				//createMentorPageObjects.successfulMessage.click();
				System.out.println("Batch Created");

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
				Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
			}
			

		}
	    
	    
		
	    // @author Sachin
		public void verifyCreatedBatch() throws InterruptedException, Exception {									
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Created Batch");
			createMentorPageObjects.workSpace.click();	
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPageObjects.batchesDropDown.click();
			GenericFunctions.waitWebDriver(1500);
			} 
	    catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on validating the correct batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
				Assert.fail("failed on validating the correct batch, Exception" + e.getLocalizedMessage());
			}
			

		}
	    
	    
	    
	    
}
