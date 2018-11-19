package org.sunbird.testscripts;

import org.sunbird.page.PublicUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_200 extends BaseTest {

	@Test
	public void memberSearchInBatch() throws Exception {

		
		// Step 1: Login with valid creator credential
		SignUp UserLogin = new SignUp();
		UserLogin.userLogin(CREATOR);

		// Step 2: 
		PublicUserPage publicUserPage = new PublicUserPage();
		publicUserPage.searchInLibrary();
		

	}
}
