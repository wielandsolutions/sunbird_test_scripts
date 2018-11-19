package org.sunbird.testscripts;

import org.sunbird.page.PublicUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_205 extends BaseTest {
	@Test
	public void lessonPlan() throws Exception {

		// Login as Creator
		SignUp login = new SignUp();
		login.userLogin(CREATOR);

		// Click on workspace
		PublicUserPage PublicUserPageObj = new PublicUserPage();
		PublicUserPageObj.clickWorkspace();
		  
		// Fill details and click start creating
		PublicUserPageObj.createLessonPlanpopUp();
		
		// Create ChildNode and click on proceed
		PublicUserPageObj.createChildNode();
		
		// Save Lesson plan and send for review
		PublicUserPageObj.saveLessonPlanAndSendForReview();				
	}    
}