package org.sunbird.testscripts;

import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreateMentorPage;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.FlagReviewerPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class TC_292 extends BaseTest {
  @Test
  public void openBatchCreation() throws Exception{
	  
	  // Login as Mentor
      SignUp mentorLogin = new SignUp();
      mentorLogin.userLogin(MENTOR);

      // Click on Workspace
      CreatorUserPage CreatorUserPage = new CreatorUserPage();
      CreatorUserPage.navigateToWorkspace(COURSE);
      
      // Create course
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		CreatorUserPage.createCourse(objListOFTestDataForSunbird);
		
	  // Save and send course for review
		CreatorUserPage.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
	  // Logout 
		mentorLogin.userLogout();
		
	  // Login back as Reviewer to Publish the course
	    mentorLogin.userLogin(REVIEWER);
		
	  // Publish the course
		FlagReviewerPage FlagReviewerPage = new FlagReviewerPage();
		FlagReviewerPage.publishCourse();
		
	  // Logout
		mentorLogin.userLogout();
		
	  // Login as Course mentor
		 mentorLogin.userLogin(MENTOR);
		 
	  // Search for course created and create batch
		 CreatorUserPage.navigateToCourseSearchAndCreateBatch();
		 
	  // Now as course mentor search for the created course on Course page
	  // 7. Click on create batch--> Select open batch
		 CreateMentorPage mentorPage = new CreateMentorPage();
		 mentorPage.createOpenBatch();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
  }
}
