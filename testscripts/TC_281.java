package org.sunbird.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.pageobject.CreatorUserPageObjects;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_281 extends BaseTest {
CreatorUserPageObjects createUserPage= PageFactory.initElements(driver, CreatorUserPageObjects.class);
  @Test
  public void allMyContent() throws Exception {
	  
	  SignUp creator = new SignUp();
	  creator.userLogin(CREATOR);
	  
		// Click on workspace
	  CreatorUserPage CreatorUserPageObj = new CreatorUserPage();
	  CreatorUserPageObj.clickWorkspace();
		
		// Click on allMyContent
	  CreatorUserPageObj.allMyContent();
		
		// Click on allMyContent and select sortBy dropdown options
	  CreatorUserPageObj.allMyContentSortByDropdown();
  
  }
}
