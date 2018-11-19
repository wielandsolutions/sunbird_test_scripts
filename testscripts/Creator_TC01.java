/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/11/2018
* Purpose: Create a New Course and validate it
*/


package org.sunbird.testscripts;

import java.util.List;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;


public class Creator_TC01 extends BaseTest
{
	
	
	@Test(priority=1, groups={"Creator Group"})
	public void courseCreationTestCase01() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		SignUp creatorLogin = new SignUp();
		CreatorUserPage creatorUserPage = new CreatorUserPage();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPage.navigateToWorkspace(COURSE);
		
		//Step3: Create new Course
		creatorUserPage.createCourse(objListOFTestDataForSunbird);
		
		//Step4: Save and Send for Review
		creatorUserPage.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(2000);
		
		GenericFunctions.refreshWebPage();
	
		//Step5: Check for course in review submissions 
		creatorUserPage.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		//Step8: Search the course which was submitted for review
		
		GenericFunctions.waitWebDriver(2000);
		creatorUserPage.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Publish the Course
		creatorUserPage.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(2000);
		
		//Reject the course
		creatorUserPage.rejectTheContent("COURSEAC");
		
		//Step9: Logout as Reviewer
		creatorLogin.userLogout();
		
	}
	

	

}
