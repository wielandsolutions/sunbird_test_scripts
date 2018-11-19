package org.sunbird.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentCreationResourcePageObjects {

	WebDriver driver;

	public ContentCreationResourcePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[text()='Announcement dashboard']")
	public WebElement profileIconAnnouncementDashboard;

	@FindBy(xpath = "//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement profileIconWorkspace;

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement profileIconLogout;

	@FindBy(xpath = "//a[text()='My Activity']")
	public WebElement profileIconActivity;

	@FindBy(xpath = "//div[@id='dropdown-menu-list-header']//a[text()='Profile']")
	public WebElement profileIconProfile;

	// Added For Test case TC_073

	@FindBy(xpath = "//a[contains(text(),' All My Content ')]")
	public WebElement allMyActivity;

	@FindBy(xpath = "//a[contains(text(),'Review Submissions')]")
	public WebElement reviewSubmissions;

	@FindBy(xpath = "//a[contains(text(),' Drafts')]")
	public WebElement drafts;

	@FindBy(xpath = "//a[contains(text(),'Published')]")
	public WebElement published;

	@FindBy(xpath = "//a[contains(text(),'All Uploads')]")
	public WebElement allUploads;

	@FindBy(xpath = "//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	@FindBy(xpath = "//a[contains(text(),'Flag Review')]")
	public WebElement flagReview;

	@FindBy(xpath = "//a[contains(text(),'Limited Publishing')]")
	public WebElement limitedPublishing;

	@FindBy(xpath = "//span[contains(text(),' Show Filters ')]")
	public WebElement showFilters;

	// FOR 'APPLY' BUTTON LOCATOR IS ALREADY PRESENT IN createUserPage
	@FindBy(xpath = "//a[.='APPLY']")
	public WebElement filterApplyButton;

	@FindBy(xpath = "//a[.='RESET']")
	public WebElement filterResetButton;

	@FindBy(xpath = "//sui-select[@labelfield='name']")
	public WebElement sortByIcon;

	// TC_74 Click on copy
	@FindBy(xpath = "//i[@class='ui large blue clone outline icon']")
	public WebElement courseCopyIcon;

	@FindBy(xpath = "(//div[@class='player-badge-alignment']//i)[7]")
	public WebElement libContentCopyIcon;

	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement copiedContentName;

	@FindBy(xpath = "//span[1][@class='ng-binding']")
	public WebElement textOnEditPage;

	@FindBy(xpath = "//span[@class='ui HomeAccordianHeading left floated header']")
	public WebElement searchedClickedCourseResource;

	@FindBy(xpath = "//span[@class='ui HomeAccordianHeading m-responsive-cp left floated header']")
	public WebElement searchedClickedContent;

	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement draftCopiedContentName;

	// TC_76

	@FindBy(xpath = "//a[@data-content='Add Slide']")
	public WebElement addSlide;

	@FindBy(xpath = "//a[@data-content='Add Text']")
	public WebElement addText;

	@FindBy(xpath = "//textarea[@placeholder='Add text here']")
	public WebElement addTextTextArea;

	@FindBy(xpath = "//button[.='Done']")
	public WebElement addTextDoneButton;

	// Updated on 05 Sep
	// @FindBy(xpath="//a[@data-content='Add Shapes']")

	@FindBy(xpath = "//div[@data-content='Add Shapes']")
	public WebElement addShapes;

	@FindBy(xpath = "//span[.='Triangle']")
	public WebElement addTriangleShape;

	@FindBy(xpath = "//a[@data-content='Add Image']")
	public WebElement addImage;

	@FindBy(xpath = "//img[@class='asset_thumbnail']")
	public WebElement resourceImage;

	@FindBy(xpath = "//a[@data-content='Add Audio']")
	public WebElement addAudio;

	@FindBy(xpath = "//div[@class='audioitem infopopover']")
	public static WebElement selectMyAudio;

	@FindBy(linkText = "All audio")
	public WebElement clickAllAudio;

	@FindBy(xpath = "(//audio[@id='audio-5'])[2]")
	public WebElement selectAudio_AllAudio;

	@FindBy(xpath = "//a[@data-content='Add Hotspot']")
	public WebElement addHotspot;

	@FindBy(xpath = "//a[@data-content='Add Scribblepad']")
	public WebElement addScribblepad;

	@FindBy(xpath = "//a[@data-content='Add Video']")
	public WebElement addVideo;

	// ADD QUESTION SET
	@FindBy(xpath = "//*[@id='toolbar']/div[1]/div/span[10]/span/span/a")
	public WebElement addQuestionSet;

	@FindBy(xpath = "//button[contains(text(),'Create question')]")
	public WebElement createQuestion;

	@FindBy(xpath = "//div[@class='card card-hover-effect ng-scope']//div[contains(text(),'Select')]")
	public WebElement questionTemplateSelect;

	// Updated on 05 Sep
	// @FindBy(xpath="//textarea[@placeholder='Enter the question']")

	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	// @FindBy(xpath="//div[@class='form-group segment textBoxDiv
	// questionTextBox']//textarea")
	public WebElement enterTheQuestion;

	// @FindBy(xpath="//div[@id='options_0']//p")
	@FindBy(xpath = "//div//input[@name='options_0']")
	// @FindBy(xpath="//div[@class='form-group segment textBoxDiv']//input")
	public WebElement setAnswer0;

	// @FindBy(xpath="//div[@id='options_1']//p")
	@FindBy(xpath = "//div//input[@name='options_1']")
	public WebElement setAnswer1;

	@FindBy(xpath = "//button[@id='next-button']")
	public WebElement createQueNext;

	@FindBy(xpath = "(//label[contains(text(),'Mark as right answer')])[1]")
	public WebElement markAsRight;

	@FindBy(xpath = "//label[.='LEVEL']/..//div[.='Select Level']")
	public WebElement clickLevel;

	@FindBy(xpath = "//div[.='Select Level']/..//div[@class='item selected']")
	public WebElement selectLevel;

	@FindBy(xpath = "//label[.='GRADE LEVEL']/..//div[.='Select Grade']")
	public WebElement clickGrade;

	@FindBy(xpath = "//div[.='Select Grade']/..//div[@class='item selected']")
	public WebElement selectGrade;

	@FindBy(xpath = "//label[.='SUBJECT']/..//div[.='Select Subject']")
	public WebElement clickSubject;

	@FindBy(xpath = "//div[.='Select Subject']/..//div[@class='item selected']")
	public WebElement selectSubject;

	@FindBy(xpath = "//label[.='BOARD']/..//div[.='Select Board']")
	public WebElement clickBoard;

	@FindBy(xpath = "//div[.='Select Board']/..//div[@class='item selected']")
	public WebElement selectBoard;

	@FindBy(xpath = "//label[.='MAX SCORE']/..//input[@id='max_score']")
	public WebElement questionMaxScore;

	@FindBy(xpath = "//label[.='CONCEPTS']/..//input[@name='concepts']")
	public WebElement clickConcepts;

	@FindBy(xpath = "//div[@id='conceptSelector_questionMetaDataTemplate-concept']//input[@placeholder='Search']")
	public WebElement searchConcepts;

	@FindBy(xpath = "//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[contains(text(),'Choose All')]")
	public WebElement conceptChooseAll;

	@FindBy(xpath = "//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[.='Done']")
	public WebElement conceptDoneButton;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement QueSubmitButton;

	@FindBy(xpath = "//div[@class='header ng-binding']")
	public WebElement pickQuestion;

	@FindBy(xpath = "//div[@class='seven wide column qb-question-container']//input")
	public WebElement pickQuestionCheckBox;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	public WebElement pickQueNextButton;

	@FindBy(xpath = "//input[@placeholder='Question Set Title']")
	public WebElement questionSetTitle;

	@FindBy(xpath = "(//button[contains(text(),'Add')])[3]")
	public WebElement questionSetAddButton;

	//
	@FindBy(xpath = "//a[@data-content='Add Math text']")
	public WebElement addMathText;

	@FindBy(xpath = "//div[@class='math-lib-header ng-binding']")
	public WebElement selectMathText;

	@FindBy(xpath = "//button[@class='ui basic primary button math-add-button']")
	public WebElement selectedMathTextAdd;

	@FindBy(xpath = "//img[@class='asset_thumbnail']")
	public WebElement checkAppIcon;

	// SelectAppIcon is in CreatorUP

	// Added for Test case 78
	@FindBy(xpath = "//button[contains(text(),'Upload/ Record')]")
	public WebElement btnUploadRecord;

	@FindBy(xpath = "//i[@class='huge upload icon']")
	public WebElement iconUpload;

	@FindBy(id = "assetfile")
	public WebElement btnChooseFile;

	@FindBy(xpath = "//label[contains(text(),'Yes, make it available to everyone')]")
	public WebElement rightBtnAvailable;

	@FindBy(xpath = "//button[contains(text(),'Upload and Use')]")
	public WebElement btnUploadAndUse;

	@FindBy(xpath = "//p[@class='slideIn']")
	public WebElement alertMessage;

	// Added for Test case 79

	@FindBy(xpath = "//input[@placeholder='Paste video url here...']")
	public WebElement pasteVideoUrl;

	@FindBy(xpath = "//div[@class='ui blue button']")
	public WebElement goButton;

	@FindBy(id = "addToLesson")
	public WebElement addToLessonBtn;

	@FindBy(xpath = "//div[@data-content='Preview']")
	public WebElement previewIcon;

	@FindBy(xpath = "//div[@class='child preview-bgimage']")
	public WebElement previewPopup;

	@FindBy(xpath = "//div[@id='gameArea']//video")
	public WebElement confirmContent;

	// @FindBy(xpath="//div[@class='preview-modal-content']")
	@FindBy(xpath = "//div[@class='iziModal-content']")
	public WebElement randomClickElement;

	@FindBy(xpath = "//a[@data-content='Add Activity']")
	public WebElement addActivity;

	@FindBy(xpath = "//input[@placeholder='Search activity']")
	public WebElement searchActivity;

	@FindBy(xpath = "//div//label[contains(text(),'Category')]/..//i")
	public WebElement clickCategory;

	@FindBy(xpath = "//div[@data-value='string:math']")
	public WebElement selectCategory;

	@FindBy(xpath = "//div[@class='content activity-meta']")
	public WebElement selectActivity;

	@FindBy(xpath = "//div[@class='content activity-meta']/..//button[.='Add']")
	public WebElement addActivityBtn;

	@FindBy(xpath = "(//a[@data-variation='tiny inverted'])[11]")
	public WebElement clickAddedActivity;

	@FindBy(xpath = "//button[.='ADD']")
	public WebElement addActivityPopupBtn;

	// Added for test case 81
	@FindBy(xpath = "//input[@placeholder='Search by question title']")
	public WebElement questionSetSearchBar;

	@FindBy(xpath = "//div[.='Select Language']")
	public WebElement AFClickLanguage;

	@FindBy(xpath = "//div[.='Select Language']/..//div[.='English']")
	public WebElement AFSelectLanguage;

	@FindBy(xpath = "//div[.='Select Level']")
	public WebElement AFClickDifficulty;

	// Select Difficulty is already located

	@FindBy(xpath = "//div[.='Question Type']")
	public WebElement AFClickQuestionType;

	@FindBy(xpath = "//div[.='Question Type']/..//div[@class='item selected']")
	public WebElement AFSelectQuestionType;

	@FindBy(xpath = "//div[.='Select Class']")
	public WebElement AFClickGradeLevel;

	@FindBy(xpath = "//div[.='Select Class']/..//div[@class='item selected']")
	public WebElement AFSelectGradeLevel;

	@FindBy(xpath = "//div[@class='advanceFilterDiv']")
	public WebElement AdvancedFilter;

	@FindBy(xpath = "//i[@id='qb-search-button']")
	public WebElement SearchIcon;

	@FindBy(xpath = "//iframe[@frameborder='0']")
	public WebElement enterQuestionIframe;

	@FindBy(xpath = "//iframe[@class='iziModal-iframe']")
	public WebElement createQuestionFrame1;

	// Added for test case 83 --14 Sep 2018
	@FindBy(xpath = "(//div[@class='card card-hover-effect ng-scope']//div[contains(text(),'Select')])[3]")
	public WebElement fibQuestionTemplate;

	@FindBy(xpath = "//select[@ng-model='keyboardType']")
	public WebElement selectKeyboard;

	// Keyboard Type

	@FindBy(xpath = "//select[@ng-model='keyboardType']//option[2]")
	public WebElement keyboardTypeEnglish;

	@FindBy(xpath = "//select[@ng-model='keyboardType']//option[1]")
	public WebElement keyboardTypeDevice;

	@FindBy(xpath = "//select[@ng-model='keyboardType']//option[3]")
	public WebElement keyboardTypeCustom;

	@FindBy(xpath = "//i[@class='icon undo ui right-floated replayIcon']")
	public WebElement previewRefreshIcon;

	@FindBy(xpath = "//input[@id='ans-field1']")
	// @FindBy(xpath="//input[@class='ans-field highlightInput']")
	public WebElement previewAnsFiled1;

	@FindBy(xpath = "//div[@class='parentDivMainKeyboard qc-keyboard-bottom']")
	public WebElement previewKeyboard;

	@FindBy(xpath = "(//div[@id='firstRowAlpha']//span)[1]")
	public WebElement keyboardLetterA;

	@FindBy(xpath = "//iframe[@id='iframeArea']")
	public WebElement previewFrameArea;

	@FindBy(xpath = "*//div[@ng-show='customTag']/..//input")
	public WebElement addKeysTB;

	@FindBy(xpath = "//div[.='Select Medium']")
	public WebElement clickMedium;

	@FindBy(xpath = "//div[.='Select Medium']/..//div[.='English']")
	public WebElement selectMedium;

	// Added for Test case 83 - 17 Sep 2018

	@FindBy(xpath = "//div[@class='key_barakhadi']//span")
	public List<WebElement> previewKBCharCount;

	/*
	 * @FindBy(xpath="//div[@class='key_barakhadi']//span") public WebElement
	 * previewKBCharCount;
	 */

	// Adding for Test case 88

	@FindBy(xpath = "//div[@id='previewVideo']/..//div[@class='ui text loader']")
	public WebElement videoLoaderText;

	// @FindBy(xpath="//div[@class='ui pointing dropdown icon button']")
	@FindBy(xpath = "//div[@data-content='Send for review']/..//div[@class='ui pointing dropdown icon button']")
	public WebElement limitedSharingIcon;

	@FindBy(xpath = "//div[contains(text(),'Limited sharing')]")
	public WebElement clickLimitedSharing;

	@FindBy(xpath = "//div[@class='left floated']//i")
	public WebElement contentShareIcon;

	@FindBy(tagName = "button")
	public WebElement copyLinkBtn;

	@FindBy(css = "body > sui-popup > div > div.content")
	public WebElement copiedMessage;

	@FindBy(xpath = "//input[@id='copyLinkData']")
	public WebElement linkDataField;

	@FindBy(xpath = "//div[@id='player-auto-scroll']//span")
	public WebElement resourceNameNewWindow;

	@FindBy(xpath = "//div[@id='commonHeader']//a[@class='btn at-btn at-btn-ok']")
	public WebElement editorEditDetails;

	@FindBy(xpath = "//input[@id='defaultTemplate-topic']")
	public WebElement clickTopics;

	// @FindBy(xpath="//div[@class='topic-tree-tab']/..//div[@class='node']")
	// @FindBy(xpath="//div[@class='topic-tree-tab']//div[@data-name='Vedic
	// Mathematics']//a")
	@FindBy(xpath = "//div[@data-id='rj_k-12_1_topic_mathematics_l1con_1']//a[@class='name']")
	public WebElement selectTopic;

	// @FindBy(xpath="(//a[.='Cancel']/following::a[@class='ui blue button
	// accept'])[1]")
	// @FindBy(xpath="(//div[@class='actions']/..//a[@class='ui blue button
	// accept'])[5]")
	// @FindBy(xpath="(//div[@id='topicSelector_defaultTemplate-topic']/..//a[.='Done'])[1]")
	@FindBy(xpath = "//div[@id='topicSelector_defaultTemplate-topic']/..//a[.='Done']")
	public WebElement topicsDoneBtn;

	// Added for Test case 93
	@FindBy(xpath = "//div[@class='content']//div[2]")
	public WebElement latestContentTimeUFR;

	// Added for Test case 94
	@FindBy(className = "no-result-text")
	public WebElement noResultText;

	// Added for Test 96
	@FindBy(xpath = "//sui-multi-select[@id='board']/..//sui-select-option[@class='item selected']")
	public WebElement selectFilterBoard;

	@FindBy(xpath = "//sui-multi-select[@id='gradeLevel']//sui-select-option[@class='item selected']")
	public WebElement selectFilterGrade;

	@FindBy(xpath = "//sui-multi-select[@id='subject']//sui-select-option[@class='item selected']")
	public WebElement selectFilterSubject;

	@FindBy(xpath = "//sui-multi-select[@id='contentType']//span[.='Resource']")
	public WebElement selectCotentType;

	@FindBy(xpath = "(//sui-multi-select[@id='medium']//sui-select-option[@class='item selected']//span)[2]")
	public WebElement selectFilterMedium;

	@FindBy(xpath = "(//div[@class='nine wide column']//div)[3]")
	public WebElement verifyFilterMedium;

	@FindBy(xpath = "//i[@class='ui remove icon']")
	public WebElement contentCloseIcon;

	// Added for Test case 119 and 120
	@FindBy(xpath = "//div[@class='ui fluid image']")
	public WebElement clickNextSlide;

	@FindBy(xpath = "//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath = "//a[@title='Properties']")
	public WebElement propertiesSection;

	@FindBy(xpath = "(//a[@class='nav-icon nav-next'])[2]")
	public WebElement previewNextBtn;

	@FindBy(xpath = "(//a[@class='nav-icon nav-previous'])[2]")
	public WebElement previewPreviousBtn;

	@FindBy(xpath = "//iframe[@id='previewContentIframe']")
	public WebElement previewPopupFrame;

	@FindBy(xpath = "//h2[@class='ps-heading']")
	public WebElement contentPreiviewCompleteScreen;

	@FindBy(xpath = "//a[@class='ps-btn ps-btn--orange endpage-icons']")
	public WebElement previewPopupReplayBtn;

	@FindBy(xpath = "*//i[@class='trash large icon']")
	public static WebElement deleteIconLP;

	@FindBy(xpath = "//button[.='Yes']")
	public static WebElement deletePopupYesBtn;

	// Added for Test case
	@FindBy(xpath = "//div[@id='board']//div[@class='text']")
	public static WebElement curriculumDivText;

	// @author Sachin
	// Web Element Delete Icon
	@FindBy(xpath = "//*[@id=\"delete\"]")
	public  WebElement trashIcon;

	// @author Sachin
	// Web Element Back button
	@FindBy(xpath = "//*[@id='back-button']")
	public  WebElement backButton;

	// @author Sachin
	// Web Element Match_The_Following_Select
	@FindBy(xpath = "//*[@id='templatsCards']/div/div[2]/div[3]/div/div")
	public WebElement matchTheFollowingSelectButton;

	// @author Sachin
	// Web Element Fill in the blanks question select
	@FindBy(xpath = "//*[@id='templatsCards']/div/div[3]/div[3]/div/div")
	public WebElement fillInTheBlankSelectButton;

	// @author Sachin
	// Web Element Edit Icon
	@FindBy(xpath = "//*[@id='edit-question-config']")
	public WebElement editIcon;
	
	 //@author Sachin 
	 // Web Element Checkbox2
	 @FindBy(xpath="//*[@id='qc-question-bank-model']/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div[2]/div/input")
	 public WebElement checkBox2;
	 
	 
	 //@author Sachin
	 // Web Element checkBox3
	 @FindBy(xpath="//*[@id=\"qc-question-bank-model\"]/div[2]/div[4]/div[2]/div[1]/div/div/div[3]/div[2]/div")
	 public WebElement checkBox3;
	 
	 //@author Sachin
	 // Web Element checkBox4
	 @FindBy(xpath="//*[@id=\"qc-question-bank-model\"]/div[2]/div[4]/div[2]/div[1]/div/div/div[4]/div[2]/div/input")
	 public WebElement checkBox4;
	 		 
	 //@author addQuestionSetTitle
	 // Web Element addQuestionSetTitle
	 @FindBy(xpath="//*[@id=\"qc-question-bank-model\"]/div[2]/div[4]/div[2]/div[1]/div/div/div[3]/div[2]/div")
	 public WebElement addQuestionSetTitle;
	 
		//@author sachin
		// Web element trashInEditor
		@FindBy(xpath="//*[@id='delete']")
		public WebElement trashInEditor;
		
		//@author sachin
		// Web element searchQuestion
		@FindBy(xpath="//*[@id='qb-search-button']")
		public WebElement searchQuestion;
		
		// ****************************************************************************************************************
		
		//@author Sachin  
		// Web element profileImage
		@FindBy(xpath="//*[@id='dropdown-menu-list-header']/img")
		public WebElement profileImage;

		//@author Sachin  
		// Web element Workspace
		@FindBy(xpath="//*[@id='dropdown-menu-list-header']/div/a[3]")
		public WebElement Workspace;

		//@author Sachin  
		// Web element Resource
		@FindBy(xpath="//span[contains(.,'Resource')]")
		public WebElement Resource;
		
		//@author Sachin  
		// Web element startCreatingButton
		@FindBy(xpath="//button[contains(.,'START CREATING')]")
		public WebElement startCreatingButton;


}