package org.sunbird.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.page.PublicUserPage;

import org.sunbird.page.SignUp;
import org.sunbird.pageobject.PublicUserPageObjects;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_203 extends BaseTest {
  @Test
  public void lessonPlan()throws Exception {
	  
	  // Login as Creator
	  SignUp login = new SignUp();
	  login.userLogin(CREATOR);
	  
	  // Click on workspace
	  PublicUserPage PublicUserPage = new PublicUserPage();
	  PublicUserPage.clickWorkspace();
	  
	  // Fill details and click start creating
	  PublicUserPage.createLessonPlanpopUp();
	  
	  // Create ChildNode and click on proceed
	  PublicUserPage.createChildNode();
	  
	  // Edit details and save
	  PublicUserPageObjects publicUserPageObjects = PageFactory.initElements(driver, PublicUserPageObjects.class);
	  PublicUserPage.editDetailsAndSave();
	  publicUserPageObjects.editDetails.click();
	  GenericFunctions.waitWebDriver(2000);

	  // Test Case Done
  }
}