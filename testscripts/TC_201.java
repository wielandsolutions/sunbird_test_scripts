package org.sunbird.testscripts;

import org.sunbird.page.PublicUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_201 extends BaseTest {

	@Test
	public void memberSearchInBatch() throws Exception {

		// Login as creator
		SignUp UserLogin = new SignUp();
		UserLogin.userLogin(CREATOR);

		// Click on workspace
		PublicUserPage PublicUserPage = new PublicUserPage();
		PublicUserPage.clickWorkspace();
		
		// Fill details and click start creating
		PublicUserPage.createLessonPlanpopUp();
		
		// Create three child nodes
		PublicUserPage.createChildNodes();						  
	}
}