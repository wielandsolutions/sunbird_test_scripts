package org.sunbird.testscripts;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.page.CreatorAnnouncementPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_318 extends BaseTest{
 @Test
 public void announcement_feature() throws Exception{
      SignUp orgAdminLogin = new SignUp();
      
      
      // Step1: Log in as Admin
      orgAdminLogin.userLogin(ADMIN);
      
      // Step2: Go to announcements page and click on create announcement link.
      CreatorAnnouncementPage announcementPage = new CreatorAnnouncementPage();
      announcementPage.navigateToAnnouncementInDropDownMenu();
    
      
      /* Step3:
       *  Click on the "announcement type" drop down.
          Select the organization that has sent the announcement.
          Give the description of the announcement.
          Try to add any web link or URL at the add web/URL field.*/
      	GenericFunctions.waitWebDriver(3000);
      	announcementPage.CreateAnnouncementPopUp();
      
    
     
     // Test case done
      

      
      
 }
}