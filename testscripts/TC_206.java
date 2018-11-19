package org.sunbird.testscripts;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.page.FlagReviewerPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_206 extends BaseTest {
 @Test
  		public void upForReview() throws Exception{
	  		  
	 		  // Step 1 : Login as reviewer
			  SignUp reviewerLogin = new SignUp();			  			 
			  reviewerLogin.userLogin(REVIEWER);
			  
			  GenericFunctions.waitWebDriver(2000);
			  
			  // Step 2 : Go to workspace and click on upForReview
			  FlagReviewerPage FlagReviewerPageObj = new FlagReviewerPage();
			  FlagReviewerPageObj.reviewerUpForReview();
	  	  
    }
}
