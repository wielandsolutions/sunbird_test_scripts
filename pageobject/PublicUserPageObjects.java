package org.sunbird.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class PublicUserPageObjects 
{
	WebDriver driver;

	public  PublicUserPageObjects(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	@FindBy(xpath="//input[@id='password-new']")
	public WebElement newPassword;
	
	@FindBy(xpath="//span[@class='kc-feedback-text']")
	public WebElement passwordMessage;

	@FindBy(xpath="//input[@id='password-confirm']")
	public WebElement confirmPassword;

	@FindBy(xpath="//input[@name='username']")
	public WebElement enterUsername;

	@FindBy(xpath="//a[.='Forgot Password?']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement forgotSubmit;
	
	@FindBy(xpath="//form[@id='kc-totp-login-form']/..//lable")
	public WebElement getMailConfirmation;
	
	@FindBy(xpath="//a[@id='backToApplication']")
	public WebElement backToApplicationLink;
	
	@FindBy(xpath="//span[.='user_not_found']")
	public WebElement userNotFound;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement headerHome;
	
	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[2]")
	public WebElement headerCourses;
	
	@FindBy(xpath = "(//a[contains(.,'Library')])[2]")
	public WebElement headerLibrary;
	
	@FindBy(xpath="//a[contains(text(),'Groups')]")
	public WebElement headerGroups;
	
	//Added on 18/07/2018
	//Adding Test case 4
	
	@FindBy(xpath="//span[@class='ui header accordian-heading']")
	public WebElement toDo;
	
	@FindBy(xpath="//span[@class='todolabel ui red circular inline label ']")
	public WebElement toDoCount;
	
	@FindBy(xpath="//p[@class='serch-allresult']")
	public WebElement showResults;
	

//	Updated the xpath of Header Profile on June 18,2018
	@FindBy(xpath="//div[@class='ui secondary pointing menu']//a[contains(text(),'Profile')]")
	//Updated on June 15 
//	@FindBy(xpath="//div//a[5][contains(text(),'Profile')]")
	public WebElement headerProfile;
	
	@FindBy(xpath="//div[.='Announcements']")
	public WebElement announcements;
	
	@FindBy(xpath="//input[@placeholder='Search'][@id='keyword']")
	public WebElement searchBar;
	
	@FindBy(xpath="//i[@class='circular search link icon']")
	public WebElement clickSearch;
	
	@FindBy(xpath="//p//span[contains(text(),'for ')]")
	public WebElement searchedInputResult;
	
	@FindBy(xpath="//a[@class='ui black right ribbon label']")
	public WebElement searchedResults;
	
	@FindBy(xpath="//i[@class='icon filter']")
	public WebElement filterIcon;
	
	@FindBy(xpath="//sui-multi-select[@id='subject']//i[@class='dropdown icon']")
	public WebElement clickFilterSubject;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="(//div[contains(.,'Select Subject')])[13]")
	public WebElement filterSubjectDropdown;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='subject']//div//span[.='English']")
	public WebElement selectFilterSubject;
	
	//@author Sachin
	// Web Element Subject English
	@FindBy(xpath="(//span[contains(.,'English')])[1]")
	public WebElement subjectEnglish;
	
	
	
	//@author Sachin
	// Web Element Subject Mathematics
	@FindBy(xpath="//span[contains(.,'Mathematics')]")
	public WebElement subjectMathematics;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='board']//i[@class='dropdown icon']")
	public WebElement clickFilterBoard;
	
	//@author Sachin
	// Slect Board dropdown
	@FindBy(xpath="//sui-multi-select[@id='board']")
	public WebElement filterBoardDropdown;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//i[@class='dropdown icon']")
	public WebElement clickFilterClass;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//span[.='Class 1']")
	public WebElement selectFilterClass;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='medium']//i[@class='dropdown icon']")
	public WebElement clickFilterMedium;
	
	//@author Sachin
	// Web Element Medium Dropdown
	@FindBy(xpath="//sui-multi-select[contains(@id,'medium')]")
	public WebElement clickMediumDropdown;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='contentType']")
	public WebElement clickContentTypes;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//input[contains(text(),'Concepts ')]")
	public WebElement clickConcepts;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//div//span[.='CBSE']")
	public WebElement selectFilterBoard;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//sui-multi-select[@id='medium']//div//span[.='English']")
	public WebElement selectFilterMedium;
	
	// @author Sachin
	// Web Element Select English
	@FindBy(xpath="(//sui-select-option[contains(.,'English')])[1]")
	public WebElement selectFilterEnglish;
	
	// @author Sachin
	// Web Element RESET
	@FindBy(xpath="//a[contains(.,'RESET')]")
	public WebElement reset;
	
	//@author Sachin
	// Web Element FilterSubjectDropdown
	@FindBy(xpath="//div[@class='ui search form']//input[@type='text'][@placeholder='Search']")
	public WebElement clickSearchConcepts;
	
	/*@FindBy(xpath="//a[@class='name'][text()='D.Ed._']")
	public WebElement clickSearchResult;
	
	@FindBy(xpath="//a[@class='name'][text()='D.Ed._Social_']")
	public WebElement clickSearaResult1;*/
	
	@FindBy(xpath="//a[.='Done']")
	public WebElement clickDone;
	
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement clickApply;
	
	@FindBy(xpath="(//a[@class='ui label margin-top--5'])[5]")
	public WebElement contentType;
	
	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//i[@class='dropdown icon']")
	public WebElement clickGradeFilter;
	
	@FindBy(xpath="//sui-select-option//span[.='Grade 2']")
	public WebElement selectFilterGrade;
	
	@FindBy(xpath="//span[.='No results found']")
	public WebElement noResults;
	
	@FindBy(xpath="//i[@class='delete icon']")
	public List<WebElement> clearAllFilters;
	
	@FindBy(xpath="//i[@class='edit icon']")
	public WebElement imageEditIcon;
	
	@FindBy(xpath="//span[.='Contributions']")
	public WebElement profileContributions;
	
	@FindBy(xpath="//span[.=' Summary ']/../a[.='EDIT']")
	public WebElement summaryEditButton;
	
	@FindBy(tagName="textarea")
	public WebElement summaryText;
	
	@FindBy(tagName="button")
	public WebElement summarySave;//button[.='SAVE ']
	
	@FindBy(xpath="//span[.=' Experience ']/../a[.='ADD']")
	public WebElement experienceAddButton;
	
	@FindBy(name="jobName")
	public WebElement eOccupationField;
	
	@FindBy(xpath="//input[@formcontrolname='role']")
	public WebElement eDesignationField;
	
	@FindBy(xpath="//input[@formcontrolname='orgName']")
	public WebElement eOrganizationField;
	
	@FindBy(xpath="//sui-multi-select[@formcontrolname='subject']")
	public WebElement eClickSubjectDropdown;
	
	@FindBy(xpath="//sui-select-option//span[.='Assamese']")
	public WebElement eSelectSubjectDropdown;
	

	//@FindBy(xpath="//input[@formcontrolname='isCurrentJob']/../label[.='Yes']")
	@FindBy(xpath="(//input[@formcontrolname='isCurrentJob'])[1]")
	public WebElement eSelectRadioButton;
	
	//@FindBy(xpath="html/body/sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr[4]/td[1]")
	@FindBy(linkText="18")
	public WebElement eSelectJoinDate;
	
	@FindBy(xpath="//input[@formcontrolname='joiningDate']")
	public WebElement eClickJoinDate;
	
	@FindBy(xpath="//p[.='permanent']/../div[@class='description']")
	public WebElement checkAddressStatus;
	
	@FindBy(xpath="//span[.='Address ']/../a[.='EDIT']")
	public WebElement addressEditButton;
	
	@FindBy(xpath="//input[@id='addTypeCurrent']")
	public WebElement selectCurrentRadioButton;
	
	@FindBy(xpath="//input[@name='addressLine1']")
	public WebElement addressLine1;
	
	@FindBy(xpath="//input[@name='addressLine2']")
	public WebElement addressLine2;
	
	@FindBy(xpath="//input[@name='city']")
	public WebElement aCity;
	
	@FindBy(xpath="//input[@name='state']")
	public WebElement aState;
	
	@FindBy(xpath="//input[@name='country']")
	public WebElement aCountry;
	
	@FindBy(xpath="//input[@name='zipcode']")
	public WebElement aZipcode;
	
	@FindBy(xpath="//span[.='Education ']/../a[.='ADD']")
	public WebElement educationEditButton;
	
	@FindBy(xpath="//input[@name='degree']")
	public WebElement eDegree;
	
	@FindBy(xpath="//input[@name='percentage']")
	public WebElement ePercentage;
	
	@FindBy(xpath="//input[@name='grade']")
	public WebElement eGrade;
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement eInstitution;
	
	@FindBy(xpath="//input[@name='boardOrUniversity']")
	public WebElement eBoard;
	
	@FindBy(xpath="//input[@name='yearOfPassing']")
	public WebElement eYOP;
	
	@FindBy(xpath="//span[.='Skill Tags ']/../a[.='ADD']")
	public WebElement skillAddButton;
	
	@FindBy(xpath="//span[.='Add Skills']")
	public WebElement addSkillsHeader;
	
	@FindBy(xpath="//div[@id='addSkill']")
	public WebElement addSkills;
	
	@FindBy(xpath="//sui-multi-select[@name='skills']")
	public WebElement selectSkills;
	
	@FindBy(xpath="//button[contains(text(),'FINISH')]")
	public WebElement finishButton;
	
	@FindBy(xpath="//span[.=' Additional Information']/../a[.='EDIT']")
	public WebElement additionalInfoEdit;
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement aFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement aLastName;
	
	@FindBy(xpath="//input[@name='location']")
	public WebElement aLocation;
	
	@FindBy(xpath="//span[.='Skill Tags ']/..//div//i[@class='lock icon']")
	public WebElement skillLockIcon;
	
	@FindBy(xpath="//div[@class='text']//span[.='All']")
	public WebElement headerDropdown;
	
	@FindBy(xpath="//sui-select-option//span[.='Users']")
	public WebElement headerDropdownUsers;
	
	/*@FindBy(xpath="//a[.='TestFlagReviewer  N']")
	public WebElement searchedEndorseUser;
	*/
	
	@FindBy(xpath="//span[.='Skill Tags ']/..//div//i[@class='unlock alternate icon']")
	public WebElement SkillUnlockIcon;
	
	@FindBy(xpath="//a[contains(text(),'+1')]")
	public WebElement endorsementIcon;
	
	@FindBy(xpath="//span[contains(text(),'Skill Tags')]")
	public WebElement skillTag;
	
	@FindBy(xpath="//div[@class='detail']//span[2]")
	public List<WebElement> eachSkillTagSize;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span[contains(text(),'Course')]")
	public 	List<WebElement> searchedCourses;
	
	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement searchedCourses1;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span")
	public WebElement courseToBeClicked;
	
	//Added for Test case 8 -18/07/2018
	@FindBy(xpath="//div[@class='no-result-text']")
	public WebElement noResultsFound;
	
	//Added for Test case 13 - 20/07/2018
	@FindBy(xpath="//a[.='Last']")
	public WebElement lastButton;
	
	//Added for test case 14 - 20/07/2018
	@FindBy(xpath="//div[@class='sectionHeading header']")
	public WebElement getUsername;
	
	@FindBy(xpath="//a[@class='header ']")
	public WebElement getResultsUsername;
	
	@FindBy(xpath="//span[@class='cursor-pointer']")
	public WebElement viewMoreSkills;
	
	@FindBy(xpath="//div[@class='detail']//span[2]")
	public WebElement endorsementCount;
	
	@FindBy(xpath="//div[@class='addition item selected']")
	public WebElement addSkill;
	
	//Added for Test case 7-20/07/2018
	
	@FindBy(xpath="//span[.='Resume']")
	public WebElement courseResumeButton;
	
//	@FindBy(xpath="/html/body/app-root/div/app-resource/div/div[2]/div[2]/app-page-section/div/div/ngx-slick/div/div/div[1]/app-card/div/div/div[1]/img")
//	public WebElement firstPopularContent;
	
	
	//@author Sachin
	// Web element ClickTakeNotes	
	@FindBy(xpath="/html/body/app-root/div/app-resource/div/div[2]/div[2]")
	public WebElement clickTakeNotes;
	
	//@author Sachin
	// Web element titlePlaceholder
	@FindBy(xpath="//input[@placeholder='Search'][@id='keyword']")
	public WebElement titlePlaceHolder;
	
	//@author Sachin
	// Web element save
	@FindBy(xpath="//i[@class='icon-save']")
	public WebElement save;
	
	//@author Sachin
	// Web element clear
	@FindBy(xpath="//input[@placeholder='Search'][@id='takeNotes']")
	public WebElement clear;
	
//	//@author Sachin
//	// Web element viewall
//	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/button[2]")
//	public WebElement viewall;
	
	//@author Sachin	
	// Web element edit
	@FindBy(xpath="//i[@class=\"edit icon\"]")
	public WebElement edit;
	
	//@author Sachin
	// Web element update
	@FindBy(xpath="//button[contains(text(),'UPDATE')]")
	public WebElement update;
	
	
	//@author Sachin
	// Web element allNotes
	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement allNotes;
	
	//@author Sachin
	// Web element delete
	@FindBy(xpath="//*[@id='content-list']/div/div[1]/div/div/div[2]/div[4]/i[2]")
	public WebElement delete;
	
//	//@author Sachin
//	// Web element confirmYes
//	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/button[2]")
//	public WebElement confirmYes;
	
//	//@author sachin
//	// Web element filterDropDown
//	@FindBy(xpath="/html/body/app-root/app-resource/div/div[2]/div[1]/div[1]/app-data-driven-filter/div/div/div/sui-accordion/sui-accordion-panel/div[1]/div/span/i[2]")
//	public WebElement filterDropDown;
	
	//@author sachin
	// Web element mainSearch
	@FindBy(xpath="(//input[@placeholder='Search'])[2]")
	public WebElement mainSearch;
	
	//@author sachin
	// Web element mainSearchIcon
	@FindBy(xpath="(//i[@class='circular search link icon'])[2]")
	public WebElement mainSearchIcon;
	
	//@author sachin
	// Web element lessonPlan
	@FindBy(xpath = "(//div[contains(@class,'creator ellipsis')])[1]")
	public WebElement lessonPlan;
	
	//@author sachin
	// Web element copyLessonPlan
	@FindBy(xpath="//i[@class='ui large blue clone outline icon ']")
	public WebElement copyLessonPlan;
	
	//@author sachin
	// Web element profileIcon
	@FindBy(xpath="//img[@class='ui circular image logged-in-user']")
	public WebElement profileIcon;
	
	//@author sachin
	// Web element workSpace
	@FindBy(xpath="(//a[@class='item'][contains(.,'Workspace')])[2]")
	public WebElement workSpace;
	
	//@author sachin
	// Web element LessonPlan
	@FindBy(xpath="//div[@class='textcontent'][contains(.,'Lesson Plan')]")
	public WebElement LessonPlan;
	
	//@author sachin
	// Web element LessonPlanNamePlaceHolder
	@FindBy(xpath="//input[contains(@placeholder,'Name')]")
	public WebElement LessonPlanNamePlaceHolder;
	
	//@author sachin
	// Web element boardPlaceHolder
	@FindBy(xpath="//sui-select[contains(@id,'board')]")
	public WebElement boardPlaceHolder;
	
	//@author sachin
	// Web element rajasthanBoard
	@FindBy(xpath="//span[contains(.,'State (Rajasthan)')]")
	public WebElement rajasthanBoard;
	
	//@author sachin
	// Web element gradePlaceHolder
	@FindBy(xpath="//sui-multi-select[contains(@id,'gradeLevel')]")
	public WebElement gradePlaceHolder;
	
	//@author sachin
	// Web element class10
	@FindBy(xpath="//sui-select-option[@class='item'][contains(.,'Class 10')]")
	public WebElement class10;
	
	
	//@author sachin
	// Web element subjectPlaceHolder
	@FindBy(xpath="//sui-select[@id='subject']")
	public WebElement subjectPlaceHolder;
	
	
	//@author sachin
	// Web element science
	@FindBy(xpath="//sui-select-option[@class='item'][contains(.,'Science')]")
	public WebElement science;
	
	//@author sachin
	// Web element mediumPlaceHolder
	@FindBy(xpath="//sui-select[contains(@id,'medium')]")
	public WebElement mediumPlaceHolder;
	
	
	//@author sachin
	// Web element english
	@FindBy(xpath="//sui-select-option[@class='item'][contains(.,'English')]")
	public WebElement english;
	
	//@author sachin
	// Web element startCreatingButton
	@FindBy(xpath="//button[contains(.,'START CREATING')]")
	public WebElement startCreatingButton;
	
	
	//@author sachin
	// Web element newChildButton
	@FindBy(xpath = "(//a[@class='blueColor'])[4]")
	public WebElement newChildButton;
	
	//@author sachin
	// Web element childUnitTitle
	@FindBy(xpath="//input[contains(@placeholder,'Enter title for unit')]")
	public WebElement childUnitTitle;
	
	//@author sachin
	// Web element descriptionPlaceHolder
	@FindBy(xpath = "(//textarea[@name='description'])[4]")
	public WebElement descriptionPlaceHolder;
		
	//@author sachin
	// Web element addNotesPlaceHolder
	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement addNotesPlaceHolder;
	
	//@author sachin
	// Web element addResource
	@FindBy(xpath="//button[@ng-click='addResource()']")
	public WebElement addResource;
	
	
	//@author sachin
	// Web element latestResourceCheckbox
	@FindBy(xpath="(//input[contains(@class,'checkBox')])[1]")
	public WebElement latestResourceCheckbox;
	
	//@author sachin
	// Web element secondResourceCheckbox
	@FindBy(xpath="(//input[@class='checkBox'])[2]")
	public WebElement secondResourceCheckbox;
	
	//@author sachin
	// Web element thirdResourceCheckbox
	@FindBy(xpath="(//input[@class='checkBox'])[3]")
	public WebElement thirdResourceCheckbox;
		
	//@author sachin
	// Web element proceedButton
	@FindBy(xpath="//button[contains(.,'PROCEED')]")
	public WebElement proceedButton;
	
	//@author sachin
	// Web element firstResourcePreview
	@FindBy(xpath="(//i[@data-content='Preview'])[1]")
	public WebElement firstResourcePreview;
	
	//@author sachin
	// Web element secondResourceDelete
	@FindBy(xpath="(//i[@data-content='Delete'])[2]")
	public WebElement secondResourceDelete;
	
	//@author sachin
	// Web element confirmDelete
	@FindBy(xpath="//button[contains(.,'YES, DELETE')]")
	public WebElement confirmDelete;
	
	//@author sachin
	// Web element closeDialog
	@FindBy(xpath="//i[contains(@ng-click,'closeThisDialog()')]")
	public WebElement closeDialog;
	
	//@author sachin
	// Web element lessonPlanTitle
	@FindBy(xpath="//*[@id='collection-tree']/ul/li/ul/li/span")
	public WebElement lessonPlanTitle;
	
	//@author sachin
	// Web element editDetails
	@FindBy(xpath="//span[@ng-if='showEditMeta'][contains(.,'Edit Details')]")
	public WebElement editDetails;
	
	//@author sachin
	// Web element editDetailsTitle
	@FindBy(xpath="//input[contains(@id,'name')]")
	public WebElement editDetailsTitle;
	
	//@author sachin
	// Web element editDetailsDescription
	@FindBy(xpath="//textarea[contains(@id,'description')]")
	public WebElement editDetailsDescription;
	
	//@author sachin
	// Web element editDetailsKeyword
	@FindBy(xpath="//input[contains(@placeholder,'Add a tag')]")
	public WebElement editDetailsKeyword;
	
	//@author sachin
	// Web element editDetailsCurriculum
	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[2]")
	public WebElement editDetailsCurriculum;
	
	//@author sachin
	// Web element editDetailsRajasthan
	@FindBy(xpath = "//div[@class='item active selected'][contains(.,'State (Rajasthan)')]")
	public WebElement editDetailsRajasthan;
	
	
	
	//@author sachin
	// Web element editDetailsClass
	@FindBy(xpath="//*[@class='ui fluid search dropdown ng-pristine ng-untouched ng-valid ng-empty ng-valid-required selection multiple']")
	public WebElement editDetailsClass;
	
	//@author sachin
	// Web element editDetailsClass10
	@FindBy(xpath="//div[@class='item'][contains(.,'Class 10')]")
	public WebElement editDetailsClass10;
	
	//@author sachin
	// Web element editDetailsSubject
	@FindBy(xpath="(//input[contains(@class,'search')])[3]")
	public WebElement editDetailsSubject;
	
	
	//@author sachin
	// Web element editDetailsMathematics
	@FindBy(xpath="//div[@class='item active selected'][contains(.,'Mathematics')]")
	public WebElement editDetailsMathematics;
	
	
	//@author sachin
	// Web element editDetailsMedium
	@FindBy(xpath="(//input[contains(@class,'search')])[4]")
	public WebElement editDetailsMedium;
	
	//@author sachin
	// Web element editDetailsHindi
	@FindBy(xpath="//div[@class='item selected'][contains(.,'Hindi')]")
	public WebElement editDetailsHindi;
	
	//@author sachin
	// Web element editDetailsAudience
	@FindBy(xpath="(//input[contains(@class,'search')])[5]")
	public WebElement editDetailsAudience;
	
	//@author sachin
	// Web element editDetailsInstructor
	@FindBy(xpath="//div[@class='item active'][contains(.,'Instructor')]")
	public WebElement editDetailsInstructor;
	
	//@author sachin
	// Web element editDetailsOwner
	@FindBy(xpath="(//input[contains(@class,'search')])[6]")
	public WebElement editDetailsOwner;
	
	//@author sachin
	// Web element editDetailsTestAutoOrg
	@FindBy(xpath="//div[@class='item selected'][contains(.,'Test Automation Org')]")
	public WebElement editDetailsTestAutoOrg;
	
	
	//@author sachin
	// Web element editDetailsSave
	@FindBy(xpath="//button[@class='ui blue button '][contains(.,'Save')]")
	public WebElement editDetailsSave;
	
	//@author sachin
	// Web element reviewButtonDropDown
	@FindBy(xpath="//*[@id='reviewButton']/div[2]/i")
	public WebElement reviewButtonDropDown;

	//@author sachin
	// Web element limitedSharing
	@FindBy(xpath="//div[@class='item'][contains(.,'Limited sharing')]")
	public WebElement limitedSharing;
	
	//@author sachin
	// Web element limitedPublishing
	@FindBy(xpath="//a[@href='/workspace/content/limited-publish/1']")
	public WebElement limitedPublishing;
	
	//@author sachin
	// Web element lessonPlanCreated
	@FindBy(xpath="(//div[contains(@class,'meta')])[1]")
	public WebElement lessonPlanCreated;
	
	//@author sachin
	// Web element trash
	@FindBy(xpath="//*[@class='fa fa-trash-o']")
	public WebElement trash;
	
	//@author sachin
	// Web element yesDelete
	@FindBy(xpath="//button[@class='ui red button'][contains(.,'YES, DELETE')]")
	public WebElement yesDelete;
	
	
	//@author sachin
	// Web element close
	@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	public WebElement close;
	
		
	//@author sachin
	// Web element sendForReview
	@FindBy(xpath="//i[contains(@class,'send icon')]")
	public WebElement sendForReview;
	
	//@author sachin
	// Web element sendForRevie
	@FindBy(xpath="//i[contains(@class,'send icon')]")
	public WebElement sendForRevie;
	
	//@author sachin
	// Web element sendEditDetailsTitle
	@FindBy(xpath="//input[contains(@id,'name')]")
	public WebElement sendEditDetailsTitle;
	
	//@author sachin
	// Web element sendEditDetailsDescription
	@FindBy(xpath="//textarea[contains(@id,'description')]")
	public WebElement sendEditDetailsDescription;
	
	//@author sachin
	// Web element sendKeywords
	@FindBy(xpath="//input[contains(@placeholder,'Add a tag')]")
	public WebElement sendKeywords;
	
	//@author sachin
	// Web element sendCurriculum
	@FindBy(xpath="(//input[contains(@autocomplete,'off')])[5]")
	public WebElement sendCurriculum;
	
	//@author sachin
	// Web element sendRajasthan
	@FindBy(xpath="//div[@class='item selected'][contains(.,'State (Rajasthan)')]")
	public WebElement sendRajasthan;
	
	//@author sachin
	// Web element sendClass
	@FindBy(xpath="//div[@class='default text'][contains(.,'Select Class')]")
	public WebElement sendClass;
	
	//@author sachin
	// Web element sendClass10
	@FindBy(xpath="//div[@class='item'][contains(.,'Class 10')]")
	public WebElement sendClass10;
	
	//@author sachin
	// Web element sendSubject
	@FindBy(xpath="(//div[contains(@class,'default text')])[3]")
	public WebElement sendSubject;
	
	//@author sachin
	// Web element sendScience
	@FindBy(xpath="//div[@class='item'][contains(.,'Science')]")
	public WebElement sendScience;
	
	//@author sachin
	// Web element sendMedium
	@FindBy(xpath="//div[@class='default text'][contains(.,'Select Medium')]")
	public WebElement sendMedium;
	
	//@author sachin
	// Web element sendEnglish
	@FindBy(xpath="//div[@class='item'][contains(.,'English')]")
	public WebElement sendEnglish;
	
	//@author sachin
	// Web element sendAudience
	@FindBy(xpath="(//input[contains(@class,'search')])[5]")
	public WebElement sendAudience;
	
	//@author sachin
	// Web element sendInstructor
	@FindBy(xpath="//div[@class='item'][contains(.,'Instructor')]")
	public WebElement sendInstructor;
	
	//@author sachin
	// Web element sendOwner
	@FindBy(xpath="(//input[contains(@class,'search')])[6]")
	public WebElement sendOwner;
	
	//@author sachin
	// Web element sendTestContentcreator
	@FindBy(xpath="//div[@class='item'][contains(.,'Test ContentCreator')]")
	public WebElement sendTestContentcreator;	
	
	//@author sachin
	// Web element sendSave
	@FindBy(xpath="//button[@class='ui blue button '][contains(.,'Save')]")
	public WebElement sendSave;
	
	//@author sachin
	// Web element sendaddImage
	@FindBy(xpath="//div[@class='addImageText'][contains(.,'Add an image')]")
	public WebElement sendaddImage;
	
	//@author sachin
	// Web element sendThumbnail1
	@FindBy(xpath="(//img[contains(@class,'asset_thumbnail')])[1]")
	public WebElement sendThumbnail1;
	
	//@author sachin
	// Web element sendSelect
	@FindBy(xpath="//button[@ng-switch-when='select'][contains(.,'Select')]")
	public WebElement sendSelect;
	
	
	
	
}	




