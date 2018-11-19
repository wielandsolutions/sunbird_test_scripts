package org.sunbird.testscripts;

import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class TC_186 extends BaseTest {
  @Test
  public void questionSetPlugin() throws Exception {
	  
	  List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
	  objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
	  
	  // Login as creator
	  SignUp creatorLogin = new SignUp();
	  creatorLogin.userLogin(CREATOR);
	  
	  // Navigate to workspace and select resource under create section
	  CreatorUserPage CreatorUserPageObj = new CreatorUserPage();
	  CreatorUserPageObj.navigateToWorkspace(RESOURCE);
	  
	  // Select different questions
	  CreatorUserPageObj.createResourceTC_186(objListOFTestDataForSunbird);
	 
	  
  }
}
