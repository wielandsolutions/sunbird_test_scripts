package org.sunbird.testscripts;

import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_287 extends BaseTest {
	public void allMyContent() throws Exception {

		SignUp creator = new SignUp();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		CreatorUserPage CreatorUserPageObj = new CreatorUserPage();
		CreatorUserPageObj.clickWorkspace();
		
		// Click filter icon
		CreatorUserPageObj.allMyContent();
				
		// Delete published BOOK
		CreatorUserPageObj.deleteContent("BOOK");
		
		// Test case done

	}
}