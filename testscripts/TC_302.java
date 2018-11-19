package org.sunbird.testscripts;

import org.sunbird.page.CreateMentorPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_302 extends BaseTest{
	@Test
	public void rootOrg() throws Exception {
		
		  // Login as Mentor
	      SignUp mentorLogin = new SignUp();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
		  CreateMentorPage CreateMentorPage = new CreateMentorPage();
		  CreateMentorPage.navigateToWorkspaceAndSelectBatches("Upcoming Batches");
		
		  // Update Upcoming Batch		
		  CreateMentorPage.navigateToCourseSearchAndUpdate();
		  
	}
}
