package org.sunbird.testscripts;

import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_289 extends BaseTest{
	public void Mentor() throws Exception{
		
	// Login as mentor
	SignUp creator = new SignUp();
	creator.userLogin(CREATOR);
	
	// Preview any course
	
	CreatorUserPage creatorUserPage = new CreatorUserPage();
	creatorUserPage.coursePreview();
	
	}

}
