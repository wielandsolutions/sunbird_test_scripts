package org.sunbird.testscripts;

import org.sunbird.page.FlagReviewerPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_207 extends BaseTest{
  @Test
  public void upForReview() throws Exception{
	  
	  // Step 1 : Login as reviewer
	  SignUp reviewerLogin = new SignUp();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Step 2 : Go to Workspace < click on upForReview < Search content
	  FlagReviewerPage FlagReviewerPageObj = new FlagReviewerPage();
	  FlagReviewerPageObj.UpForReviewsearchContent();

  }
}
