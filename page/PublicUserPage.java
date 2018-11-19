package org.sunbird.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.GetExcelFileData;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.FlagReviewerPageObjects;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.pageobject.UploadOrgPageObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class PublicUserPage extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	UploadOrgPageObjects OrgUploadPage=PageFactory.initElements(driver, UploadOrgPageObjects.class);
	PublicUserPageObjects publicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	CreatorUserPageObjects createUserPage= PageFactory.initElements(driver, CreatorUserPageObjects.class);
	FlagReviewerPageObjects flagReviewerPageObjects=PageFactory.initElements(driver, FlagReviewerPageObjects.class);
	static Logger log = Logger.getLogger(UploadOrg.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
	GenericFunctions genereicFunction = new GenericFunctions();
	Actions action = new Actions(driver);
	Random rand = new Random();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	PublicUserPageObjects publicUserObj = PageFactory.initElements(driver, PublicUserPageObjects.class);

	public void publicLogin(String username,String password) throws Exception 
	{

		int count = objListOFTestDataForSunbird.size();
		OrgUploadPage.Loginbutton.click();
		OrgUploadPage.username.sendKeys(username);
		OrgUploadPage.password.sendKeys(password);
		System.out.println(username+" "+password);
		OrgUploadPage.clickLogin.click();
		GenericFunctions.waitWebDriver(2000);
		log.info("Login Sucessfull");

	}

	public void changePassword() throws Exception
	{
		String aTitle=driver.getTitle();
		String eTitle="Update Password";

		try
		{
			if(aTitle.equalsIgnoreCase(eTitle))
			{	
				log.info("Page title is matching");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the update password page is displayed");
				if(publicUserPageObjects.newPassword.isDisplayed()&&publicUserPageObjects.confirmPassword.isDisplayed()&&publicUserPageObjects.passwordMessage.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true);
					log.info("Update password Page is displayed");
					System.out.println("Update password Page is displayed");
					GenericFunctions.waitWebDriver(3000);
					System.out.println(publicUserPageObjects.passwordMessage.getText()+" message confirms Update password page is displayed");
				}

				//Assert.assertTrue(true);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying Login and changing the password");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Page not matched");
			Assert.fail("Failed on verify Login and changing the Password");
		}
	}

	public void forgotPassword() throws Exception 
	{
		try
		{
			GenericFunctions.waitForPageToLoad(OrgUploadPage.Loginbutton);
			//Click login button on Home Page
			OrgUploadPage.Loginbutton.click();
			GenericFunctions.waitWebDriver(2000);
			//Click Forgot password link
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the forgot password functionality");
			publicUserPageObjects.forgotPasswordLink.click();
			GenericFunctions.waitWebDriver(3000);

			//Enter the Username, email or registered phone number
			publicUserPageObjects.enterUsername.sendKeys(TEST_MAIL_ID);
			//genereicFunction.waitWebDriver(2000);
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.forgotSubmit.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForPageToLoad(publicUserPageObjects.getMailConfirmation);
			if(publicUserPageObjects.getMailConfirmation.isDisplayed())
			{
				String getMessage=publicUserPageObjects.getMailConfirmation.getText();
				log.info(getMessage);
				System.out.println(getMessage);
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(2000);
				publicUserPageObjects.backToApplicationLink.click();
				GenericFunctions.waitWebDriver(2000);

			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying Forgot password functionality");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Problem in Resetting Password");
			Assert.fail("Failed on verifying forgot password");
		}
	}
	public void homePageTodo() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify home page TO-DO section");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerHome);
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(A_HOME_URL,driver.getCurrentUrl(),"Home page title is not matching");
			GenericFunctions.waitWebDriver(2000);
			if(publicUserPageObjects.toDo.isDisplayed())
			{
				System.out.println("TO DO :"+publicUserPageObjects.toDoCount.getText());
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true);
				log.info("Verified To Do Section in Home page");
				System.out.println("Verified To Do Section in Home page");
			}
			else
			{
				System.out.println("To Do section is not dsiaplyed");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying TO DO section in home page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify To Do Section");
			Assert.fail("Failed on verifying TO DO section on Home page");
		}
	}

	public void courseSearch() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the course search");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerCourses);
			publicUserPageObjects.headerCourses.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.searchBar.sendKeys(SEARCH_COURSE);
			publicUserPageObjects.clickSearch.click();
			GenericFunctions.waitWebDriver(3000);
			//String getSearch=publicUserPageObjects.searchedResults.getText().substring(4,11);

			if(publicUserPageObjects.showResults.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Course :"+publicUserPageObjects.searchedCourses1.getText());
				System.out.println(publicUserPageObjects.showResults.getText()+" for "+SEARCH_COURSE);
				js.executeScript("scroll(0, 250);");
				GenericFunctions.waitWebDriver(2000);
				js.executeScript("scroll(0, -250);");
				GenericFunctions.waitWebDriver(5000);

			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not search the course");
			Assert.fail("Failed on searching the courses");
		}
	}

	public void librarySearch() throws Exception
	{
		Robot robot = new Robot();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerLibrary);
			publicUserPageObjects.headerLibrary.click();

			for(int i=0;i<searchInput.length;i++)
			{	
				GenericFunctions.waitWebDriver(6000);
				publicUserPageObjects.searchBar.clear();
				publicUserPageObjects.searchBar.sendKeys(searchInput[i]);
				publicUserPageObjects.clickSearch.click();
				GenericFunctions.waitWebDriver(4000);
				/*if(publicUserPageObjects.searchedInputResult.isDisplayed())
				{	
					Assert.assertTrue(true);

					if(publicUserPageObjects.searchedResults.isDisplayed())
					{
						System.out.println("Getting results "+publicUserPageObjects.searchedResults.getText()+ " are the input"+searchInput[i]);
						GenericFunctions.waitWebDriver(3000);
						publicUserPageObjects.searchBar.clear();
					}

				}*/
				if(publicUserPageObjects.showResults.isDisplayed())
				{
					Assert.assertTrue(true);
					System.out.println("Searched result :"+publicUserPageObjects.searchedCourses1.getText());
					System.out.println(publicUserPageObjects.showResults.getText()+" for "+searchInput[i]);
					js.executeScript("scroll(0, 250);");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, -250);");
					GenericFunctions.waitWebDriver(5000);
					Assert.assertTrue(true);

				}
				else
				{
					System.out.println("Results are not displayed for the inputs");
				}
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library and getting the results");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not search and get the results in the library");
			Assert.fail("Failed on searching in the library");
		}

	}
	public void courseSearchFilter() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the course search by applying filters");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerCourses);
			publicUserPageObjects.headerCourses.click();
			//Search a course 
			//publicUserPageObjects.searchBar.clear();
			publicUserPageObjects.searchBar.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			publicUserPageObjects.filterIcon.click();
			//Then apply filters
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.clickFilterSubject);
			publicUserPageObjects.clickFilterBoard.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterBoard);
			publicUserPageObjects.selectFilterBoard.click();

			/*createUserPage.clickOnSelectClass.click();
		GenericFunctions.waitWebDriver(1000);
		createUserPage.selectClass.click();*/


			publicUserPageObjects.clickFilterSubject.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterSubject);
			publicUserPageObjects.selectFilterSubject.click();
			GenericFunctions.waitWebDriver(1500);

			GenericFunctions.waitWebDriver(1500);
			publicUserPageObjects.clickFilterMedium.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterMedium);
			publicUserPageObjects.selectFilterMedium.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.clickConcepts.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.clickApply.click();
			GenericFunctions.waitWebDriver(2000);
			/*boolean noResult=publicUserPageObjects.noResultsFound.getTagName() != null;
		if(noResult==false)
		{*/
			js.executeScript("scroll(0, 250);"); 	
			GenericFunctions.waitWebDriver(2000);
			js.executeScript("scroll(0, -250);");
			GenericFunctions.waitWebDriver(3000);
			Assert.assertTrue(true);
			System.out.println("Filter are applied ");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching courses by applying filters ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not apply filters and search the courses");
			Assert.fail("Failed on searching courses by applying filters");
		}


	}

	public void librarysearchFilter() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search by applying filters");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			wait.until(ExpectedConditions.visibilityOf(publicUserPageObjects.headerLibrary));
			String randomContent = (CONTENT_TYPE[new Random().nextInt(CONTENT_TYPE.length)]);

			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerLibrary);
			publicUserPageObjects.headerLibrary.click();
			GenericFunctions.waitWebDriver(1500);
			publicUserPageObjects.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.clickFilterBoard.click();
			GenericFunctions.waitWebDriver(3000);
			publicUserPageObjects.selectFilterBoard.click();
			GenericFunctions.waitWebDriver(2000);

			publicUserPageObjects.clickFilterClass.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterClass);
			publicUserPageObjects.selectFilterClass.click();
			GenericFunctions.waitWebDriver(1500);
			publicUserPageObjects.clickFilterSubject.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterSubject);
			publicUserPageObjects.selectFilterSubject.click();
			GenericFunctions.waitWebDriver(1500);
			publicUserPageObjects.clickFilterMedium.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.selectFilterMedium);
			publicUserPageObjects.selectFilterMedium.click();
			GenericFunctions.waitWebDriver(1500);
			/*publicUserPageObjects.clickGradeFilter.click();
	    	publicUserPageObjects.selectFilterGrade.click();
	    	GenericFunctions.waitWebDriver(2000);*/

			publicUserPageObjects.clickContentTypes.click();
			GenericFunctions.waitWebDriver(2000);


			driver.findElement(By.xpath(randomContent)).click();

			GenericFunctions.waitWebDriver(3000);	
			publicUserPageObjects.clickConcepts.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);
			/*String searchContent = publicUserPageObjects.contentType.getText();
	    	System.out.println(searchContent);
		    publicUserPageObjects.headerLibrary.click();
	     	publicUserPageObjects.searchBar.sendKeys(searchContent);
	    	//publicUserPageObjects.searchBar.sendKeys(Keys.ENTER);
	    	publicUserPageObjects.clickSearch.click();
	    	GenericFunctions.waitWebDriver(2000);*/
			publicUserPageObjects.clickApply.click();

			GenericFunctions.waitWebDriver(6000);
			int allElements = publicUserPageObjects.clearAllFilters.size();


			if(publicUserPageObjects.searchedCourses1.isDisplayed())
			{
				System.out.println(publicUserPageObjects.searchedCourses1.getText());
				js.executeScript("scroll(0, 250);"); 	
				GenericFunctions.waitWebDriver(2000);
				js.executeScript("scroll(0, -250);");
				GenericFunctions.waitWebDriver(3000);
				Assert.assertTrue(true);
				System.out.println("Filter are applied ");
			}
			else
			{

				for(WebElement ele:publicUserPageObjects.clearAllFilters)
				{	
					GenericFunctions.waitWebDriver(2000);
					//WebElement option=publicUserPageObjects.clearAllFilters.get(i);
					String elementText=ele.getText();
					System.out.println(elementText);
					ele.click();	
				}
				GenericFunctions.waitWebDriver(2000);
				System.out.println("Results are not displayed for applied filters, Removed filters");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library by applying filters ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not apply filters and search in the library");
			Assert.fail("Failed on searching library by applying filters");
		}

	}

	public void updateProfileImage() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the update profile image");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(publicUserPageObjects.imageEditIcon).click().perform();
			String path = System.getProperty("user.dir")+"\\TestData\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_PROFILE_PIC;
			System.out.println("Uploaded file name: "+path);
			log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path);
			GenericFunctions.waitWebDriver(3000);
			Assert.assertTrue(true,"Profile picture updated succesfully");
		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating profile image");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not upload profile image");
			Assert.fail("Failed on updating profile image");
		}
		/*publicUserPageObjects.imageEditIcon.click();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.uploadFile(UPLOAD_PROFILE_PIC);
		GenericFunctions.waitWebDriver(3000);
		System.out.println("profile pic updated");*/
	}

	public void userSearch() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the user search in the profile page");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			GenericFunctions.waitWebDriver(3000);
			for(int i=0;i<SEARCH_USERS.length;i++)
			{	
				GenericFunctions.waitWebDriver(6000);
				publicUserPageObjects.searchBar.sendKeys(SEARCH_USERS[i]);
				publicUserPageObjects.searchBar.sendKeys(Keys.ENTER);
				GenericFunctions.waitWebDriver(4000);
				if(publicUserPageObjects.searchedInputResult.isDisplayed())
				{	
					js.executeScript("scroll(0, 450);");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, -200);");
					js.executeScript("scroll(0, -250);");
					Assert.assertTrue(true);
					System.out.println("Getting results :"+publicUserPageObjects.searchedInputResult.getText()+ " are the input :" +SEARCH_USERS[i]);
					GenericFunctions.waitWebDriver(3000);
					publicUserPageObjects.searchBar.clear();
					
				}
				else
				{
					System.out.println(publicUserPageObjects.searchedInputResult+"element is not displayed");
				}


			}
		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the users");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not search users");
			Assert.fail("Failed on searching Users in profile page");
		}

	}

	public void searchOrgs() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying search Organizations search in Profile page");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			GenericFunctions.waitWebDriver(3000);
			for(int i=0;i<SEARCH_ORG.length;i++)
			{	

				GenericFunctions.waitWebDriver(6000);
				publicUserPageObjects.searchBar.sendKeys(SEARCH_ORG[i]);
				publicUserPageObjects.searchBar.sendKeys(Keys.ENTER);
				GenericFunctions.waitWebDriver(4000);
				if(publicUserPageObjects.searchedInputResult.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					//js.executeScript("arguments[0].scrollIntoView();",publicUserPageObjects.lastButton);

					js.executeScript("window.scrollTo(document.body.scrollHeight,500)");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("arguments[0].scrollIntoView();",publicUserPageObjects.lastButton);
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("window.scrollTo(document.body.scrollHeight,-500)");
					js.executeScript("arguments[0].scrollIntoView();",publicUserPageObjects.headerProfile);
					/*js.executeScript("scroll(0, 300);");
				GenericFunctions.waitWebDriver(1000);
				js.executeScript("scroll(0, 300);");
				GenericFunctions.waitWebDriver(2000);
				js.executeScript("scroll(0, -300);");
				js.executeScript("scroll(0, -300);");*/
					Assert.assertTrue(true);
					System.out.println("Getting results "+publicUserPageObjects.searchedInputResult.getText()+ " are the input" +SEARCH_USERS[i]);
					GenericFunctions.waitWebDriver(3000);
					publicUserPageObjects.searchBar.clear();
				}
				else
				{
					System.out.println(publicUserPageObjects.searchedInputResult+"element is not displayed");
				}

			}
		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the Organizations");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not search Organizations");
			Assert.fail("Failed on searching Organizations in profile page");
		}

	}

 void profileInformationUpdate() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying profile information update");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetprofileaddress");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			//GenericFunctions.waitForElementToAppear(publicUserPageObjects.profileContributions);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			if(createUserPage.workSpace.isDisplayed())
			{

				//Edit profile summary
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update profile summary");
				publicUserPageObjects.summaryEditButton.click();
				publicUserPageObjects.summaryText.sendKeys(SUMMARY_EDIT);
				publicUserPageObjects.summarySave.click();

				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(publicUserPageObjects.experienceAddButton);
				//Add or edit experience
				publicUserPageObjects.experienceAddButton.click();
				publicUserPageObjects.eOccupationField.sendKeys(EXP_OCCUPATION);
				GenericFunctions.waitWebDriver(1500);
				publicUserPageObjects.eDesignationField.sendKeys(EXP_DESIGNATION);
				publicUserPageObjects.eOrganizationField.sendKeys(EXP_ORG);

				//

				/*Select select = new Select(publicUserPageObjects.eClickSubjectDropdown);
				select.selectByVisibleText("Bengali");*/

				publicUserPageObjects.eClickSubjectDropdown.click();
				GenericFunctions.waitForElementToAppear(publicUserPageObjects.eSelectSubjectDropdown);
				publicUserPageObjects.eSelectSubjectDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				publicUserPageObjects.eSelectRadioButton.click();

				/*publicUserPageObjects.eClickJoinDate.click();
				GenericFunctions.waitWebDriver(1000);
				((JavascriptExecutor) driver).executeScript(
	                    "document.getElementsByClassName('ui celled center aligned unstackable table seven column day')[0].setAttribute('value', '2018-07-19')");
				publicUserPageObjects.eSelectJoinDate.click();*/
				GenericFunctions.waitWebDriver(2500);
				publicUserPageObjects.summarySave.click();



				//Add or Edit address
				GenericFunctions.waitWebDriver(3000);
				String address=publicUserPageObjects.checkAddressStatus.getText();
				if(address!=null)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update profile address");
					GenericFunctions.scrollToElement(publicUserPageObjects.addressEditButton);
					GenericFunctions.waitWebDriver(1500);
					publicUserPageObjects.addressEditButton.click();
					publicUserPageObjects.addressLine1.clear();
					publicUserPageObjects.addressLine1.sendKeys(objListOFTestDataForSunbird1.get(1).getAddressLane1());
					publicUserPageObjects.addressLine2.clear();
					publicUserPageObjects.addressLine2.sendKeys(objListOFTestDataForSunbird1.get(1).getAddressLane2());
					publicUserPageObjects.aCity.clear();
					publicUserPageObjects.aCity.sendKeys(objListOFTestDataForSunbird1.get(1).getCity());
					publicUserPageObjects.aState.clear();
					publicUserPageObjects.aState.sendKeys(objListOFTestDataForSunbird1.get(1).getState());
					publicUserPageObjects.aCountry.clear();
					publicUserPageObjects.aCountry.sendKeys(objListOFTestDataForSunbird1.get(1).getCountry());
					publicUserPageObjects.aZipcode.clear();
					publicUserPageObjects.aZipcode.sendKeys(objListOFTestDataForSunbird1.get(1).getPincode());
					publicUserPageObjects.summarySave.click();
					GenericFunctions.waitWebDriver(2000);


					//Edit educational Details
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update profile educational details");
					GenericFunctions.scrollToElement(publicUserPageObjects.educationEditButton);
					GenericFunctions.waitForElementToAppear(publicUserPageObjects.educationEditButton);
					publicUserPageObjects.educationEditButton.click();
					publicUserPageObjects.eDegree.clear();
					publicUserPageObjects.eDegree.sendKeys(objListOFTestDataForSunbird1.get(1).getDegree());
					GenericFunctions.waitWebDriver(1000);
					publicUserPageObjects.ePercentage.clear();
					publicUserPageObjects.ePercentage.sendKeys(objListOFTestDataForSunbird1.get(1).getPercentage());
					GenericFunctions.waitWebDriver(1000);
					publicUserPageObjects.eGrade.clear();
					publicUserPageObjects.eGrade.sendKeys(objListOFTestDataForSunbird1.get(1).getGrade());
					GenericFunctions.waitWebDriver(1000);
					publicUserPageObjects.eInstitution.clear();
					publicUserPageObjects.eInstitution.sendKeys(objListOFTestDataForSunbird1.get(1).getInstitution());
					GenericFunctions.waitWebDriver(1000);
					publicUserPageObjects.eBoard.clear();
					publicUserPageObjects.eBoard.sendKeys(objListOFTestDataForSunbird1.get(1).getBoard());
					GenericFunctions.waitWebDriver(1000);

					//YOP is not handled
					//publicUserPageObjects.eYOP.clear();
					GenericFunctions.waitWebDriver(1500);
					publicUserPageObjects.summarySave.click();

					GenericFunctions.waitWebDriver(3500);
					GenericFunctions.scrollToElement(publicUserPageObjects.skillAddButton);

					//Add Skills
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update profile skill set");
					publicUserPageObjects.skillAddButton.click();
					GenericFunctions.waitForElementToAppear(publicUserPageObjects.addSkillsHeader);

					action.moveToElement(publicUserPageObjects.addSkills);
					action.click();
					action.sendKeys(objListOFTestDataForSunbird1.get(1).getSkills());
					action.build().perform();

					/*publicUserPageObjects.addSkills.click();
					publicUserPageObjects.addSkills.sendKeys("java");*///objListOFTestDataForSunbird1.get(1).getSkills()
					//WebElement addSkill=genereicFunction.waitForElementToAppear(publicUserPageObjects.addSkills, 2000);
					//System.out.println(addSkill+ "element is visible");
					//publicUserPageObjects.selectSkills.sendKeys(objListOFTestDataForSunbird1.get(1).getSkills());
					//addSkill.click();


					GenericFunctions.waitWebDriver(2000);
					publicUserPageObjects.addSkillsHeader.click();
					publicUserPageObjects.finishButton.click();
					//genereicFunction.selectValueFromDropdown(driver, "//sui-multi-select[@name='skills']", "java");
					GenericFunctions.waitWebDriver(3000);

					GenericFunctions.scrollToElement(publicUserPageObjects.additionalInfoEdit);
					GenericFunctions.waitWebDriver(2000);

					//Edit additional Information
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update profile additional information");
					publicUserPageObjects.additionalInfoEdit.click();
					publicUserPageObjects.aFirstName.clear();
					publicUserPageObjects.aFirstName.sendKeys(objListOFTestDataForSunbird1.get(1).getAfirstName());
					publicUserPageObjects.aLastName.clear();
					publicUserPageObjects.aLastName.sendKeys(objListOFTestDataForSunbird1.get(1).getAlastName());
					publicUserPageObjects.aLocation.clear();
					publicUserPageObjects.aLocation.sendKeys(objListOFTestDataForSunbird1.get(1).getCurrentlocation());
					publicUserPageObjects.summarySave.click();
					GenericFunctions.waitWebDriver(3000);
					Assert.assertTrue(true);
					System.out.println("Profile information updated sucesfully");
				}
				else
				{
					System.out.println("cannot update profile information");
				}



				/*catch(Exception e)
			{
				System.out.println("exception occured during updating profile"+e);
			}*/
			}
		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating profile information");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not update profile information");
			Assert.fail("Failed on updating profile information");
		}

	}



	public void skillEndorsement(String username)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to endorse the skill set");
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			GenericFunctions.waitWebDriver(1000);
			publicUserPageObjects.searchBar.sendKeys(username);
			publicUserPageObjects.clickSearch.click();
			GenericFunctions.waitWebDriver(3000);
			String endorseUser=publicUserPageObjects.getResultsUsername.getText();
			if(username.equalsIgnoreCase(endorseUser))
			{
				GenericFunctions.waitWebDriver(2000);
				publicUserPageObjects.getResultsUsername.click();
				GenericFunctions.waitWebDriver(2500);
				GenericFunctions.scrollToElement(publicUserPageObjects.viewMoreSkills);
				GenericFunctions.waitWebDriver(1500);
				publicUserPageObjects.viewMoreSkills.click();
				GenericFunctions.waitWebDriver(3000);
				publicUserPageObjects.endorsementIcon.click();
				GenericFunctions.waitWebDriver(2500);
				String endorseSize=publicUserPageObjects.endorsementCount.getText();
				int size = Integer.parseInt(endorseSize);
				System.out.println(size);
				if(size!=0)
				{
					GenericFunctions.waitWebDriver(1500);
					Assert.assertTrue(true);
					GenericFunctions.refreshWebPage();
					GenericFunctions.waitWebDriver(1500);
					System.out.println("Skills endorsed sucessfully");
				}
				else 
				{
					System.out.println("Skills are not endorsed");
				}

			}
			else
			{
				System.out.println("Username did not match to endorse the skill");
			}
		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on endorsing skill set");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not endorse skill");
			Assert.fail("Failed on endorsing skill set");
		}

	}

	//Need not be added as the Flag Icon feature is removed from the application
	public void contentFlag()
	{

		List <TestDataForSunbird> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions.waitForElementToAppearOnScreen(publicUserPageObjects.headerCourses);
		//Enter course name in the search bar
		publicUserPageObjects.headerCourses.click();
		publicUserPageObjects.searchBar.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
		publicUserPageObjects.clickSearch.click();
		GenericFunctions.waitWebDriver(3000);

		//get and print the list size of all the courses
		System.out.println(publicUserPageObjects.searchedCourses.size());

		//Converting the list type to String [] type
		String [] eleAray= new String[publicUserPageObjects.searchedCourses.size()];
		int i=0;
		for(WebElement text:publicUserPageObjects.searchedCourses)
		{
			System.out.println(eleAray[i]=text.getText());
			i++;
		}

		String randomCourseSearch = (eleAray[new Random().nextInt(eleAray.length)]);
		GenericFunctions.waitWebDriver(3000);
		publicUserPageObjects.searchBar.clear();
		publicUserPageObjects.searchBar.sendKeys(randomCourseSearch);
		publicUserPageObjects.clickSearch.click();
		GenericFunctions.waitWebDriver(3000);
		/*if(randomCourseSearch.equalsIgnoreCase(publicUserPageObjects.courseToBeClicked.getText()))
		{
			System.out.println("Clicked course: "+randomCourseSearch);
			publicUserPageObjects.courseToBeClicked.click();

		}*/

		if(publicUserPageObjects.courseResumeButton.isDisplayed())
		{
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(publicUserPageObjects.courseResumeButton);
			publicUserPageObjects.courseResumeButton.click();
		}

		/*for(WebElement listEle:publicUserPageObjects.searchedCourses)
		{
			String listEleTextFormat = listEle.getText();
			System.out.println(listEleTextFormat);
		}
		 */		

		//String[] objectArray=(String[]) publicUserPageObjects.searchedCourses.toArray();
		//System.out.println(objectArray);
		//System.out.println(objectArray[rand.nextInt(objectArray.length)]);


	}

	public String addSkill()
	{
		String username="";
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add the skill set");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetprofileaddress");

			GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerProfile);
			publicUserPageObjects.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			GenericFunctions.waitWebDriver(3500);
			GenericFunctions.scrollToElement(publicUserPageObjects.skillAddButton);

			//Add Skills
			publicUserPageObjects.skillAddButton.click();
			GenericFunctions.waitForElementToAppear(publicUserPageObjects.addSkillsHeader);
			action.moveToElement(publicUserPageObjects.addSkills);
			action.click();
			GenericFunctions.waitWebDriver(2000);
			action.sendKeys(objListOFTestDataForSunbird1.get(1).getSkills()+GenericFunctions.testDataIncrementer(".//TestData//TestIds.txt"));
			action.build().perform();
			publicUserPageObjects.addSkill.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserPageObjects.addSkillsHeader.click();
			publicUserPageObjects.finishButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(publicUserPageObjects.getUsername);
			username=publicUserPageObjects.getUsername.getText();

		}
		catch(Exception e )
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on adding the skill set");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not add skill");
			Assert.fail("Failed on adding skill set");
		}
		return username;
	}
		// @author Sachin for the below method filterSearch :
		public void filterSearch()throws Exception{
			
			
			publicUserObj.filterBoardDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.selectFilterBoard.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.clickMediumDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.selectFilterEnglish.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.filterSubjectDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.subjectEnglish.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.clickApply.click();
			GenericFunctions.waitWebDriver(4000);
			publicUserObj.reset.click();
			GenericFunctions.waitWebDriver(4000);

			// After resetting this will select different set of elements in the respective dropdowns
			
			publicUserObj.filterBoardDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.selectFilterBoard.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.clickMediumDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.selectFilterEnglish.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.filterSubjectDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			publicUserObj.subjectMathematics.click();
			GenericFunctions.waitWebDriver(4000);
			publicUserObj.clickApply.click();
			GenericFunctions.waitWebDriver(4000); 
		}
		
		        // @author Sachin for the below method filterSearch :
				public void mainCourse()throws Exception
				{					
				GenericFunctions.waitForElementToAppear(publicUserPageObjects.headerCourses);	
				publicUserObj.headerCourses.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Kept pending as filter is not functioning on the website
				}
				
				
				
				// @author Sachin for the below method search in library :
				public void searchInLibrary()throws Exception{
				try
				{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "To search Lesson Plan in Library and copy it");	
				GenericFunctions.waitWebDriver(2000);
				publicUserObj.headerLibrary.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(publicUserObj.mainSearch);				
				publicUserObj.mainSearch.sendKeys("Lesson Plan");
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(publicUserObj.mainSearchIcon);		
				publicUserObj.mainSearchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(publicUserObj.lessonPlan);				
				publicUserObj.lessonPlan.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(publicUserObj.copyLessonPlan);				
				publicUserObj.copyLessonPlan.click();
				GenericFunctions.waitWebDriver(4000);
				}
				catch(Exception e)
				{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching LessonPlan in library and copying it");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
				Assert.fail("Failed on searching LessonPlan in library and copying it, Exception : " + e.getLocalizedMessage());	
				}
		}
				
				
				
				
				// @author Sachin : click on workspace 
				public void clickWorkspace()throws Exception{
				try
				{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace");
				GenericFunctions.waitForElementToAppear(publicUserObj.profileIcon);
				publicUserObj.profileIcon.click();
				GenericFunctions.waitWebDriver(2000);
				publicUserObj.workSpace.click();
				GenericFunctions.waitWebDriver(2000);
					
				}
				catch (Exception e) 
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
					Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage());
				}
        }
				
				// @author Sachin fill all the details and click on start creating :
				public void createLessonPlanpopUp()throws Exception{	
				try{
					ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace");
					publicUserObj.LessonPlan.click();
					GenericFunctions.waitWebDriver(2000);
					
					String LessonPlanTitle = "TestAutomationqwerty";
					publicUserObj.LessonPlanNamePlaceHolder.click();
					publicUserObj.LessonPlanNamePlaceHolder.sendKeys(LessonPlanTitle);				
					GenericFunctions.waitWebDriver(1000);					
					publicUserObj.startCreatingButton.click();
					GenericFunctions.waitWebDriver(2000);
				    }
				  catch(Exception e)
				    {
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
						log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
						Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage()); 
				    }
		}
				
				
				// @author Sachin fill all the details and click on start creating :
				public void createChildNodes()throws Exception
				{	
					driver.switchTo().frame(0);
					// Creating 1st child node
					GenericFunctions.waitForElementToAppearOnScreen(publicUserObj.newChildButton);
					publicUserObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.childUnitTitle.click();
					publicUserObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.childUnitTitle.sendKeys("AutomationTitle1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.descriptionPlaceHolder.sendKeys("Description1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.addNotesPlaceHolder.click();
					publicUserObj.addNotesPlaceHolder.sendKeys("Notes1");
					
					publicUserObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					// Creating 2nd child node					
					
					publicUserObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.childUnitTitle.click();
					publicUserObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.childUnitTitle.sendKeys("AutomationTitle2");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.descriptionPlaceHolder.click();
					publicUserObj.descriptionPlaceHolder.sendKeys("Description2");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.addNotesPlaceHolder.click();
					publicUserObj.addNotesPlaceHolder.sendKeys("Notes2");
					
					publicUserObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					
					// Creating 3d child node					
					
					publicUserObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.childUnitTitle.click();
					publicUserObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.childUnitTitle.sendKeys("AutomationTitle3");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.descriptionPlaceHolder.click();
					publicUserObj.descriptionPlaceHolder.sendKeys("Description3");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.addNotesPlaceHolder.click();
					publicUserObj.addNotesPlaceHolder.sendKeys("Notes3");
					
					publicUserObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.proceedButton.click();
					GenericFunctions.waitWebDriver(3000);										
					
				}
				
				
				// @author Sachin Lesson Plan with three resources  :
				public void lessonPlanWithThreeResources()throws Exception
				{	
					// Creating 1st child node
					driver.switchTo().frame(0);
					GenericFunctions.waitForElementToAppearOnScreen(publicUserObj.newChildButton);
					publicUserObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.childUnitTitle.click();
					publicUserObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.childUnitTitle.sendKeys("AutomationTitle1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.descriptionPlaceHolder.click();
					publicUserObj.descriptionPlaceHolder.sendKeys("Description1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.addNotesPlaceHolder.click();
					publicUserObj.addNotesPlaceHolder.sendKeys("Notes1");
					
					publicUserObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
										
					publicUserObj.secondResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.thirdResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);					
					
					publicUserObj.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.firstResourcePreview.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.lessonPlanTitle.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.confirmDelete.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.closeDialog.click();
					GenericFunctions.waitWebDriver(2000);
					
				}
				
				
				// @author Sachin Lesson Plan with three resources  :
				public void createChildNode()throws Exception
				{	
					// Creating 1st child node
					driver.switchTo().frame(0);
					GenericFunctions.waitForElementToAppearOnScreen(publicUserObj.newChildButton);
					publicUserObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.childUnitTitle.click();
					publicUserObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.childUnitTitle.sendKeys("AutomationTitle1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.descriptionPlaceHolder.click();
					publicUserObj.descriptionPlaceHolder.sendKeys("Description1");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.addNotesPlaceHolder.click();
					publicUserObj.addNotesPlaceHolder.sendKeys("Notes1");
					
					publicUserObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
				}
	
				
				// @author Sachin Lesson Plan with three resources  :
				public void editDetailsAndSave()throws Exception
				{	
					
					publicUserObj.editDetails.click();
					GenericFunctions.waitWebDriver(1000);	
					
					publicUserObj.editDetailsTitle.click();
					publicUserObj.editDetailsTitle.clear();
					publicUserObj.editDetailsTitle.sendKeys("AUTOMATION123");
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsDescription.click();
					publicUserObj.editDetailsDescription.clear();
					publicUserObj.editDetailsDescription.sendKeys("Description1");
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsKeyword.click();
					publicUserObj.editDetailsKeyword.sendKeys("Keyword1");
					GenericFunctions.waitWebDriver(1000);					
					
//					publicUserObj.editDetailsCurriculum.click();
//					GenericFunctions.waitWebDriver(4000);
//					GenericFunctions.waitForElementToAppear(publicUserObj.editDetailsRajasthan);
//					publicUserObj.editDetailsRajasthan.isSelected();
//					GenericFunctions.waitWebDriver(1000);
					
					Select curriculum = new Select(driver.findElement(By.xpath("(//input[@class='search'])[1]")));
					curriculum.selectByIndex(-1);
					publicUserObj.editDetailsClass.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsClass10.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsSubject.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsMathematics.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsMedium.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsHindi.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsAudience.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsInstructor.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsOwner.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsTestAutoOrg.click();
					GenericFunctions.waitWebDriver(1000);
					
					publicUserObj.editDetailsSave.click();
					GenericFunctions.waitWebDriver(1000);					
					
				}
				
				// In reference to TC_205				
				// @author Sachin Lesson Plan with three resources  :
				
				public void saveEnactPublicSharing()throws Exception
				{						
					publicUserObj.save.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.limitedSharing.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.lessonPlanCreated.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.trash.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.yesDelete.click();
					GenericFunctions.waitWebDriver(2000);
				}
				
				public void saveLessonPlanAndSendForReview()throws Exception
				{						
					publicUserObj.save.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendForReview.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendaddImage.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendThumbnail1.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendSelect.click();
					GenericFunctions.waitWebDriver(2000);					
			
					publicUserObj.sendEditDetailsTitle.click();
					publicUserObj.sendEditDetailsTitle.clear();
					publicUserObj.sendEditDetailsTitle.sendKeys("AutoTitle");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendEditDetailsDescription.click();
					publicUserObj.sendEditDetailsDescription.sendKeys("AutoDescription");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendKeywords.click();
					publicUserObj.sendKeywords.sendKeys("AutoKeyword");
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendCurriculum.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendRajasthan.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendClass.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendClass10.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendSubject.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendScience.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendMedium.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendEnglish.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendAudience.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendInstructor.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendOwner.click();
					GenericFunctions.waitWebDriver(2000);
					
					publicUserObj.sendTestContentcreator.click();
					GenericFunctions.waitWebDriver(2000);

					publicUserObj.sendSave.click();
					GenericFunctions.waitWebDriver(2000);
										
				}
				
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}

