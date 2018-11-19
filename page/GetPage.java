package org.sunbird.page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.pageobject.GetPageObjects;
import org.sunbird.pageobject.SignUpObjects;
import org.sunbird.pageobject.UploadOrgPageObjects;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class GetPage extends BaseTest{
	
	SignUpObjects signUpPage=PageFactory.initElements(driver, SignUpObjects.class);
	GetPageObjects getPageObjects = PageFactory.initElements(driver, GetPageObjects.class);
	UploadOrgPageObjects orgUploadPage=PageFactory.initElements(driver, UploadOrgPageObjects.class);
	CreatorUserPage creatorUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	Actions action = new Actions(driver);
	Random rand=new Random();

	public void verifyGetPageComponents() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to get page");
			GenericFunctions.assertIfElementExists1(driver, XPATH, orgUploadPage.Loginbutton);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Found login button: "+orgUploadPage.Loginbutton);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageSearch);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Found search context: "+getPageObjects.getPageSearch);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageGooglePlayIcon);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Found google play icon: "+getPageObjects.getPageGooglePlayIcon);
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is successfully able to verify Search, Login and Google Play icon on get page");	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to get page"+e.getLocalizedMessage());
		}
	}
	
	public void verifyGetPageDialCode() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to get page and search dial code");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPageObjects.getPageSearch.sendKeys(randomDialCode);
			getPageObjects.getPageSearch.sendKeys(Keys.ENTER);
			Assert.assertEquals(randomDialCode, getPageObjects.getPageDialCode.getText().substring(11, 17) , "Dial Codes Matching");
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageDialCode);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code in get page"+e.getLocalizedMessage());
		}
	}
	
	public void verifyGetPageGooglePlayStoreNavigation() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to google play store clickin on google play icon in get page");

			getPageObjects.getPageGooglePlayIcon.click();
			String getPageGPUrl = driver.getCurrentUrl();
			ExtentTestManager.getTest().log(LogStatus.INFO, "URL : "+getPageGPUrl);
			System.out.println("URL: "+getPageGPUrl);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code in get page"+e.getLocalizedMessage());
		}
	}
	
	public void verifyGetPageLoginScreenNavigation() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to login screen on clickin on login button in get page");
			orgUploadPage.Loginbutton.click();
			String getPageGPUrl = driver.getCurrentUrl();
			String getPageGPTitle = driver.getTitle();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Application is navigated to login URL : "+getPageGPUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Application has navigated to login page having title: "+getPageGPTitle);
			System.out.println("Application has navigated to login page having title: "+getPageGPTitle);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to login page on clicking on login button in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to login page on clicking on login button in get page"+e.getLocalizedMessage());
		}
	}
	
	public void verifyGetPageDialCodeComingSoon() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search with dial code which is not available");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPageObjects.getPageSearch.sendKeys(randomDialCode+"1234");
			getPageObjects.getPageSearch.sendKeys(Keys.ENTER);
			
			GenericFunctions.assertIfElementExists1(driver, XPATH, signUpPage.alertMessage);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Searched dial code in not available and "+signUpPage.alertMessage.getText());
			ExtentTestManager.getTest().log(LogStatus.INFO, "Searched dial code in not available and Content is coming soon");
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed in searching dial code");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed in searching dial code"+e.getLocalizedMessage());
		}
	}
	
	
	public void verifyGetPageDialCodeSearchResults() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search dial code again in search page");
			String randomDialCode1 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPageObjects.getPageSearch.sendKeys(randomDialCode1);
			getPageObjects.getPageSearch.sendKeys(Keys.ENTER);
			Assert.assertEquals(randomDialCode1, getPageObjects.getPageDialCode.getText().substring(11, 17) , "Iteration 1: Dial Codes Matching");
			getPageObjects.getPageSearch.clear();
			String randomDialCode2 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPageObjects.getPageSearch.sendKeys(randomDialCode2);
			getPageObjects.getPageSearch.sendKeys(Keys.ENTER);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageDialCode);
			Assert.assertEquals(randomDialCode2, getPageObjects.getPageDialCode.getText().substring(11, 17) , "Iteration 2: Dial Codes Matching");
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageDialCode);
			GenericFunctions.waitWebDriver(1500);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code again in search page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code again in search page"+e.getLocalizedMessage());
		}
	}

	public void verifyGetStartedPageExploreSunbird() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify page elements in explore sunbird page");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println(driver.getCurrentUrl());
			ExtentTestManager.getTest().log(LogStatus.INFO, "User navigated to "+driver.getCurrentUrl());
			GenericFunctions.assertIfElementExists1(driver, XPATH, orgUploadPage.Loginbutton);
			GenericFunctions.assertIfElementExists1(driver, ID, getPageObjects.idSearchBar);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.xEnterDialCode);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.xEnterDialCode.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.xLanguageChange);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.xLanguageChange.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPageObjects.iBoard);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.iBoard.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPageObjects.iMedium);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.iMedium.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPageObjects.iSubject);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.iSubject.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPageObjects.iClass);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.iClass.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.xBtnSubmit);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.xBtnSubmit.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.xBtnReset);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPageObjects.xBtnReset.getText());
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.assertIfAllElementsExists(driver,getPageObjects.xListOfContents);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify page elements in explore sunbird page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify page elements in explore sunbird page"+e.getLocalizedMessage());
		}
	}

	
	public void verifyContentSearchInExploreSunbird() throws InterruptedException
	{
		try
		{
			List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify respected search result on explore sunbird page");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			getPageObjects.idSearchBar.click();
			getPageObjects.idSearchBar.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			getPageObjects.idSearchBar.sendKeys(Keys.ENTER);
			GenericFunctions.waitWebDriver(1500);
			creatorUserPage.assertCourseFoundInSearch(objListOFTestDataForSunbird.get(0).getCourseName());
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify respected search result on explore sunbird page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify respected search result on explore sunbird page"+e.getLocalizedMessage());
		}
	}

	public void verifyLanguageChangeInExploreSunbird() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the the placeholder of all the fields on explore page are displaying according to the selected language");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.xLanguageChange);
			getPageObjects.xLanguageChange.click();
			//GenericFunctions.selectValueFromDropdown(driver, getPageObjects.xSelectHindiLanguage, "Hindi");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.xSelectHindiLanguage);
			getPageObjects.xSelectHindiLanguage.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertElementValueByWebElement(driver, XPATH, getPageObjects.xEnterDialCode_Hindi, HINDI_LABEL);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Field labels are displayed according to the selected language");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the the placeholder of all the fields on explore page are displaying according to the selected language");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the the placeholder of all the fields on explore page are displaying according to the selected language"+e.getLocalizedMessage());
		}
	}

	public void verifyDialCodeContentInExploreSunbird() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the user is able to get the content associated with the DIAL code ");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			getPageObjects.xEnterDialCode.click();
			String randomDialCode1 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPageObjects.getPageSearch.sendKeys(randomDialCode1);
			getPageObjects.xDivBtnSubmit.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPageObjects.getPageDialCode);
			GenericFunctions.assertIfAllElementsExists(driver, getPageObjects.reviewDialCodeRelatedContent);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to verify and get the content associated with the DIAL code searched");
			getPageObjects.reviewDialCodeRelatedContent.get(0).click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.assertIfAllElementsExists(driver,getPageObjects.xDialContentTitles);	
			getPageObjects.xDialContentTitles.get(0).click();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to check and access the content which was associated with the DIAL code searched");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the user is able to get and access the content associated with the DIAL code ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the user is able to get and access the content associated with the DIAL code "+e.getLocalizedMessage());
		}
	}


	public void verifyLoginNavigationFromExploreSunbird() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the clicking on Login button is navigating to the login page");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			orgUploadPage.Loginbutton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to navigate to the login page "+driver.getCurrentUrl());
			GenericFunctions.captureScreenshotOnValidation();
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the clicking on Login button is navigating to the login page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the clicking on Login button is navigating to the login page"+e.getLocalizedMessage());
		}
	}

	public void verifyContentParameterDisplay(WebElement locator1, WebElement locator2) throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the contents displayed according to the selected parameter in filter section");
			driver.get(APP_URL);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPageObjects.btnExploreSunbird);
			getPageObjects.btnExploreSunbird.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(locator1);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Contents are displayed according to the selected "+locator1.getText());
			locator1.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(locator2);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Contents are displayed according to the selected "+locator2.getText());
			locator2.click();
			GenericFunctions.waitWebDriver(1500);
			getPageObjects.xBtnSubmit.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			System.out.println("1");
			GenericFunctions.assertIfAllElementsExists(driver,getPageObjects.xListOfContents);
			System.out.println("2");
			getPageObjects.xBtnReset.click();
			System.out.println("4");
			GenericFunctions.waitWebDriver(3000);
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the contents displayed according to the selected "+locator1.getText()+" and "+
			locator2.getText()+" parameter in filter section");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the contents displayed according to the selected "+locator1.getText()+" and "+
			locator2.getText()+" parameter in filter section"+e.getLocalizedMessage());
		}
	}
	
}
