package org.sunbird.testscripts;

import org.sunbird.page.FlagReviewerPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_208 extends BaseTest{
  @Test
  public void upForReview() throws Exception{
	  
	  // Login as reviewer
	  SignUp reviewerLogin = new SignUp();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace < click on upForReview < Search content
	  FlagReviewerPage FlagReviewerPageObj = new FlagReviewerPage();
	  FlagReviewerPageObj.UpForReviewSortBy();
	  
	    
  }
}
