package org.sunbird.testscripts;

import org.sunbird.page.FlagReviewerPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_210 extends BaseTest{
  @Test
  public void upForReview() throws Exception{
	  	  
	  //  Login as Reviewer
	  SignUp reviewerLogin = new SignUp();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace and click on upForReview
	  
	  FlagReviewerPage FlagReviewerPageObj = new FlagReviewerPage();
	  FlagReviewerPageObj.publishCourse();
	  

  }
}