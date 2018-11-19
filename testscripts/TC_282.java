package org.sunbird.testscripts;

import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_282 extends BaseTest {
	public void allMyContent() throws Exception {
		
		// Login as Creator
		SignUp creator = new SignUp();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		CreatorUserPage CreatorUserPageObj = new CreatorUserPage();
		CreatorUserPageObj.clickWorkspace();
		
		// Click on AllMyContent
		CreatorUserPageObj.clickAllMyContent();
		
		// Select DRAFT, delete and search		
		CreatorUserPageObj.deleteByStatus("DRAFT");
		
		// Select FLAGDRAFT, delete and search
		CreatorUserPageObj.deleteByStatus("FLAGDRAFT");
		
		// Select REVIEW, delete and search
		CreatorUserPageObj.deleteByStatus("REVIEW");
		
		// Select PROCESSING, delete and search
		CreatorUserPageObj.deleteByStatus("PROCESSING");
		
		// Select UNLISTED, delete and search
		CreatorUserPageObj.deleteByStatus("UNLISTED");
		
		// Select FLAGREVIEW, delete and search
		CreatorUserPageObj.deleteByStatus("FLAGREVIEW");
		
		// Select FLAGREVIEW, delete and search
		CreatorUserPageObj.deleteByStatus("LIVE");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}