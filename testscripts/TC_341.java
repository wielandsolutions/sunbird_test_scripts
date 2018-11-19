package org.sunbird.testscripts;

import org.sunbird.page.CreatorAnnouncementPage;
import org.sunbird.page.SignUp;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_341 extends BaseTest{
 @Test
 public void announcement_feature() throws Exception{
      SignUp orgAdminLogin = new SignUp();
      
      
      // Step1: Log in as Admin
      orgAdminLogin.userLogin(ADMIN);
      
      // Go to announcement Page
      CreatorAnnouncementPage announcementPage = new CreatorAnnouncementPage();
      announcementPage.navigateToAnnouncementInDropDownMenu();
      
      // Create announcement
      announcementPage.CreateAnnouncement();
      
      // Step2: Edit and resend the announcement      
      announcementPage.editAndResendAnnounccement();
      
      // Test Case done
    
 }
}