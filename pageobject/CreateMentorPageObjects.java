package org.sunbird.pageobject;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class CreateMentorPageObjects {
	
	WebDriver driver;

	public CreateMentorPageObjects(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	//@FindBy(xpath="//i[@class='dropdown icon']")
	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	public WebElement SearchCourseDropdown;
	
	@FindBy(xpath="//sui-select-option[@class='item selected']")
	public WebElement firstCourseDropdownitem;
	
	@FindBy(xpath="//i[@class='right arrow icon']")
	public WebElement rightArrowIcon;
	
	@FindBy(xpath="(//input[@formcontrolname='enrollmentType'])[2]")
	public WebElement openBatch;
	
	//Updated on 20 Aug 2018
	//@FindBy(xpath="//button[text()='Enroll	']")
	@FindBy(xpath="//button[contains(text(),'Enroll')]")
	public WebElement enrollForOpenBatch;
	
	@FindBy(xpath="//span[text()='ENROLL TO COURSE']")
	public WebElement enrollForCourse;
	
	@FindBy(xpath="//i[@class='left arrow icon']")
	public WebElement leftArrowIcon;
	
	@FindBy(xpath="//a[contains(text(),'Course Batches')]")
	public WebElement courseBatches;
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[3]")
	public WebElement batchesDropDown;
	
	//@FindBy(xpath="//i[@class='ui remove icon']")
	@FindBy(xpath="//h5[@class='ui right floated basic icon circular button margin-auto mouse-pointer']")
	public WebElement closeBatchIcon;
	
	@FindBy(xpath = "(//span[contains(.,'Ongoing Batches')])[2]")
	public WebElement ongoingBatches;
	
	@FindBy(xpath="//span[contains(text(),'Previous Batches')]")
	public WebElement previousBatches;
	
	@FindBy(xpath="//span[contains(.,'Upcoming Batches')]")
	public WebElement upcomingBatches;
	
	//@FindBy(xpath="//div[@class='required field']/label")
	@FindBy(xpath="//label[contains(text(),'NAME OF BATCH')]")
	public WebElement batchForm;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement calendarEndDate;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement calendarStartDate;
	
	@FindBy(xpath="//span[@class='batch-content-description']")
	public List<WebElement> courseContent;
	
	@FindBy(xpath="//i[@class='ui remove icon']")
	public WebElement closeButton;
	
	@FindBy(xpath="//div[contains(text(),'DOWNLOAD')]")
	public WebElement downloadButton;
	
	@FindBy(xpath="//i[@class='dropdown icon']")
	public WebElement searchDropDown;
	
	
	@FindBy(xpath="(//input[@name='filter_search'])[2]")
	public WebElement filterSearch;
	
	
	@FindBy(xpath = "(//div[contains(@class,'meta')])[1]")
	public WebElement searchedCourse;
	
	@FindBy(xpath="//a[text() = 'Create Batch']")
	public WebElement createBatch;
	
	@FindBy(xpath="//div[@class='content']")
	public WebElement batchDetails;
	
	@FindBy(xpath="//i[@class='edit large icon remove-outline']")
	public List<WebElement> editIconInUserProfileSearchL;
	
	@FindBy(xpath="//a[@class='header ']")
	public List<WebElement> profileNameInUserSearchL;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public List<WebElement> selectRoleCheckboxL ;
	
	@FindBy(xpath="//i[@class='edit large icon remove-outline']")
	public WebElement editIconInUserProfileSearch;
	
	@FindBy(xpath="//a[@class='header ']")
	public WebElement profileNameInUserSearch ;
	
	@FindBy(xpath="(//i[@class='edit large icon remove-outline'])[2]")
	public WebElement editIconInUserProfileSearch2;
	
	@FindBy(xpath="(//a[@class='header '])[2]")
	public WebElement profileNameInUserSearch2 ;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement selectRoleCheckbox ;
	
	@FindBy(xpath="//button[contains(text(),'UPDATE')]")
	public WebElement updateButtonInUserProfile ;
	
	@FindBy(xpath="//strong[contains(text(),'Roles updated successfully')]")
	public WebElement successfulMessage ;
	
	@FindBy(xpath="//i[@class='write icon float-ContentRight cursor-pointer']")
	public WebElement editBatch;
	
	@FindBy(xpath="//button[text()='Update']")
	public WebElement updateBatch;
	
	@FindBy(xpath="//i[@class='add icon']")
	public WebElement addIcon;
	
	@FindBy(xpath="//input[contains(@formcontrolname,'name')]")
	public WebElement nameOfBatch;
	
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement aboutBatch;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement endDate;
	
	//@FindBy(xpath="//div[@class='createbatchdropdown ui fluid multiple search selection dropdown active visible']")
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[4]")
	public WebElement mentorsInBatch;
	
	//@FindBy(xpath="(//div[@data-value='4b3c6d5b-22af-4b2b-b141-6e050bbb123d'])[1]")
	//@FindBy(xpath="//div[@data-value='833bd5aa-4259-4bb0-8dbd-fcd02598f247']")
	//@FindBy(xpath="//div[@data-value='ce337fab-7dd9-4059-9f71-700f7ab7caea']")
	//@FindBy(xpath="//div[@data-value='7e51e59e-5aca-410f-933e-851a35437c7e']")
	
	
	@FindBy(xpath="(//div[contains(@class,'item')])[8]")
	public WebElement suborgMentor2InBatch;
	
	//@FindBy(xpath="//label[text()='MEMBERS IN THE BATCH']/../div")
	//@FindBy(xpath="//div[@id='users']")
	@FindBy(xpath="(//div[@class='item'])[12]")
	public WebElement membersInBatch;
	
	@FindBy(xpath="//div[@class='item'][contains(.,'Test BookReviewer (te***************@qualitrix.com)')]")
	public WebElement testBookReviewerInBatch;
	
	@FindBy(xpath="//div[@data-value='b28661ad-385c-4c9f-970c-4763df7220f5']")
	//@FindBy(xpath="//div[@data-value='55584d30-2d68-41d2-9b66-7b967ea4b724']")
	//@FindBy(xpath="//div[@data-value='05af1026-21b7-4c47-8539-2fd1b1aeb225']")
	public WebElement suborgUser6InBatch;
	
	@FindBy(xpath="(//div[@data-value='c1234edf-eadd-4a3a-8990-6b7a84ee6079'])[2]")
	public WebElement orgAdminInBatch;
	
	@FindBy(xpath="(//div[@data-value='318e141e-6c24-4f32-9962-05d8a7c450ff'])[2]")
	public WebElement mentor1User;
	
	@FindBy(xpath="//div/../input[@id='userSelList']")
	public WebElement searchBatchMember;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement memberDropdown;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement mentorDropdown;
	
	@FindBy(xpath="//button[@class='ui primary button']")
	public WebElement buttonCreate;
	
	
	//@FindBy(xpath="//button[@class='blue right floated ui button courseHeaderButton margin-top-10']")
	//@FindBy(xpath="//button[text()='VIEW COURSE STATS']")
	@FindBy(xpath="//button[contains(text(),'VIEW COURSE STATS')]")
	public WebElement viewCourseStat;
	
	@FindBy(xpath="//button[@class='fluid blue right floated  ui button courseHeaderButton margin-top-0']")
	public WebElement resumeCourse;
	
	@FindBy(xpath="//span[text()='Organisations']")
	public WebElement SearchDropDownOrg;
	
	@FindBy(xpath="//span[text()='Courses']")
	public WebElement SearchDropDownCourse;
	
	//@FindBy(xpath = "//div[@class='ui black right ribbon label']")
	@FindBy(xpath="//div[@class='batch-content']/span")
	public List<WebElement> batchText;
	
	@FindBy(xpath = "//div[@class='ui black right ribbon label']")
	public WebElement batchText1;
	
	@FindBy(xpath="//img[contains(@src,'https://cdn.ntp.net.in/player/assets/images/default.png')]")
	public List<WebElement> courseImg;
	
	//@FindBy(xpath="//img[contains(@src,'https://cdn.ntp.net.in/player/assets/images/default.png')]")
	@FindBy(xpath="(//img[@src='assets/images/default.png'])[1]")
	public WebElement courseImg1;
	
	@FindBy(xpath="//div[@class='ui three stackable cards']//div[@class='batch-content']//span[@class='batch-content-description']")
	public WebElement batchDetail;
	
	//Added on 31 july 2018
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link']")
	public WebElement startDateCalendar;
	
	@FindBy(xpath="(//div[contains(@class,'meta')])[1]")
	public WebElement getCourseName;
	
	//Adding for test case 13 on 20 Aug 2018
	
	@FindBy(xpath="//ul//li")
	public WebElement courseStatMessage;
	
	//@author Sachin
	// ProfileImage Web Element
	@FindBy(xpath="//*[@id='dropdown-menu-list-header']/img")
	public WebElement profileImage; 
	
	//@author Sachin
	// ProfileImage Workspace
	@FindBy(xpath="(//a[@class='item'][contains(.,'Workspace')])[2]")
	public WebElement workSpace;
	
	
	//@author Sachin
	// Course Web Element
	@FindBy(xpath="/html/body/app-root/app-workspace/div/div[3]/app-create-content/div/div[1]/div/div[1]/div/div")
	public WebElement course;
	
	//@author Sachin
	//  Web Element ProfileIconClick
	@FindBy(xpath="//*[@id='dropdown-menu-list-header']/img")
	public WebElement ProfileIconClick;
	
	//@author Sachin
	//  Web Element workSpace
	@FindBy(xpath="/html/body/app-root/app-workspace/div/div[3]/app-create-content/div/div[1]/div/div[1]/div/div")
	public WebElement WorkSpace;
	
	//@author Sachin
	//  Web Element create
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[1]")
	public WebElement create;
	
	
	//@author Sachin
	//  Web Element lessonPlan
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-create-content/div/div[2]/div/div[1]/div/div/div/span")
	public WebElement lessonPlan;
	
	//@author Sachin
	//  Web Element lessonPlanName
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div/form/div/div[1]/app-content-creation-default-template/div/div[1]/div/div/input")		
	public WebElement lessonPlanName;
	
	//@author Sachin
	//  Web Element upForReview
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[7]")		
	public WebElement upForReview;
	
	
	//@author Sachin
	//  Web Element searchPlaceHolder
	@FindBy(xpath="//*[@id='search-input-container']/div/div/input")		
	public WebElement searchPlaceHolder;
	
	
			
	//@author Sachin
	//  Web Element firstContent
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-up-for-review/table/tbody/tr[1]/td[1]")		
	public WebElement firstContent;
			  
	//*[@id="commonHeader"]/div/div[4]/div/div/div[2]/div[7]
	
	//@author Sachin
	//  Web Element requestChanges
	@FindBy(xpath="//*[@id='commonHeader']/div/div[4]/div/div/div[2]/div[7]")		
	public WebElement requestChanges;
	
	//@author Sachin
	// Web Element drafts
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[3]")		
	public WebElement drafts;
	
	
	//@author Sachin
	// Web Element firstLessonPlan
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-draft/div[1]/div/div/div[1]/app-card/div/div/div[1]/div")		
	public WebElement firstLessonPlan;
	
	//@author Sachin
	// Web Element editPopupCloseIcon
	@FindBy(xpath="//*[@id='meta-modal']/div[1]/div/div/div[2]/i")		
	public WebElement editPopupCloseIcon;
	
	//@author Sachin
	// Web Element saveButton
	@FindBy(xpath="//*[@id='saveButton']/i")		
	public WebElement saveButton;
	
	//@author Sachin
	// Web Element limitedSharingDropdown
	@FindBy(xpath="//*[@id='reviewButton']/div[2]/i")		
	public WebElement limitedSharingDropdown;
			
	//@author Sachin
	// Web Element limitedSharing
	@FindBy(xpath="//*[@id='reviewButton']/div[2]/div/div")		
	public WebElement limitedSharing;
	
	
	//@author Sachin
	// Web Element limitedPublishing
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[8]")		
	public WebElement limitedPublishing;
	
	//@author Sachin
	// Web Element shareIcon
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-limited-published/div[1]/div/div/div/app-card/div/div/div[3]/div[2]/a/span/i")		
	public WebElement shareIcon;
	
	//@author Sachin
	// Web Element linkToBeCopied
	@FindBy(xpath="//*[@id='copyLinkData']")		
	public WebElement linkToBeCopied;
	
	//@author Sachin
	// Web Element limitedPublishingDelete
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-limited-published/div[1]/div/div/div/app-card/div/div/div[3]/div[1]/a/span/i")		
	public WebElement limitedPublishingDelete;
		
	//@author Sachin
	// Web Element yesPopUp
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/button[2]")		
	public WebElement yesPopUp;
	
	//@author Sachin
	// Web Element allMyContent
	@FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")		
	public WebElement allMyContent;	
	
	//@author Sachin
	// Web Element nameCopy
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-draft/div[1]/div/div/div/app-card/div/div/div[1]/div")		
	public WebElement nameCopy;	
	
	
	//@author Sachin
	// Web Element placeHolderSearch
	@FindBy(xpath="//*[@id='search-input-container']/div/div/input//*[@id='search-input-container']/div/div/input")		
	public WebElement placeHolderSearch;	
	

	//@author Sachin
	// Web Element searchIcon
	@FindBy(xpath="//*[@id='search-input-container']/div/div/i")		
	public WebElement searchIcon;
	
	
	//@author Sachin
	// Web Element preview
	@FindBy(xpath="//*[@id='content-list']/div/div/div/div/div[2]/div[4]/i[1]")		
	public WebElement preview;
	
	//@author Sachin
	// Web Element preview
	@FindBy(id="(//div[contains(@class,'avatar-content')])[2]")
	public WebElement dropdown;
	
	@FindBy(xpath="(//a[@class='item'][contains(.,'Logout')])[3]")
	public WebElement logout;
	
	@FindBy(xpath="(//a[contains(.,'LOGIN')])[3]")
	public WebElement Login;

	//@author Sachin
	@FindBy(xpath="(//div[contains(@class,'meta')])[35]")
	public WebElement latestCourse;
	
	
	//@author Sachin
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement membersinBatchDropDown;
	
	//@author Sachin
	@FindBy(xpath="(//div[contains(@class,'item')])[4]")
	public WebElement updateMentorInBatch;
	
	//@author Sachin
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[5]")
	public WebElement updateMembersInBatch;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}