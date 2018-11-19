package org.sunbird.startup;

public interface IAutoConst {

	//User Roles
	String PUBLICUSER="PUBLICUSER";
	String ADMIN="ADMIN";
	String CREATOR="CREATOR";
	String REVIEWER="REVIEWER";
	String FLAGREVIEWER="FLAGREVIEWER";
	String MENTOR="MENTOR";
	String XPATH="XPATH";
	
	//Merged from Ajith
	String ID="ID";
	
	String PUBLICUSER1="PUBLICUSER1";
	String BOOKREVIEWER="BOOKREVIEWER";
	String AUTOCREATOR="AUTOCREATOR";
	String BOOKCREATOR="BOOKCREATOR";
	String MENTOR_S="MENTOR_S";
	String REVIEWER_S="REVIEWER_S";
	String PUBLICUSER_S="PUBLICUSER_S";
	String MENTORS_S="MENTORS_S";
	String PUBLICUSERS_S="PUBLICUSERS_S";
	String A_CONTENT_CREATOR="A_CONTENT_CREATOR";
	String CONTENT_CREATOR="CONTENT_CREATOR";
	//Driver values
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VAL="./Drivers/chromedriver.exe";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VAL="./Drivers/geckodriver.exe";
	String APP_URL="https://staging.open-sunbird.org";
	String AUTO_APP_URL="http://qatestautomation.centralus.cloudapp.azure.com";


	//Upload documents name
	String UPLOAD_ROOT_ORG="Test_Data_Sample_Organizations-1.csv";
	String UPLOAD_USERS_ROOT_ORG="Sample_Users (44).csv";
	String UPLOAD_SUB_ORG="Test_Data_Sample_Sub_Organizations-1.csv";
	String UPLOAD_USERS_SUB_ORG="Sample_Users (45).csv";
	String FILTER_CREATION="Creation";
	String FILTER_CONSUMPTION="Consumption";
	String A_HOME_URL="https://staging.open-sunbird.org/home";
	String SEARCH_COURSE="courseA";
	String SEARCH_LIBRARY="Library";
	String SEARCH_COURSES="Courses";
	String SEARCH_LIBRARIES="content";	
	String[] searchInput = new String[]{"Book","Automation content","Collection","lesson plan","Resource"};
	String UPLOAD_PROFILE_PIC="images1";
	String[] SEARCH_USERS=new String[]{"mentor","admin","public user","creator","reviewer"};
	String[] SEARCH_ORG=new String[]{"Org","Root Org"};
	String SUMMARY_EDIT ="Profile Summary is edited";
	String EXP_OCCUPATION="Test Occupation";
	String EXP_DESIGNATION="Test Designation";
	String EXP_ORG="Test Organization";

	String[] ADDRESS=new String[]{"Test #15","Test Vasanthnagar","Test Bangalore","Test Karnataka","Test India","Test 560035"};
	String ENDORSE_USER="TestFlagReviewer  N";
	String BOOK="book";
	String COURSE="Course";
	String RESOURCE="resource";
	String COLLECTION="collection";
	String LESSONPLAN="lesson plan";
	String UPLOADCONTENT="upload content";
	String PUBLISHER="Test Automation Publisher";
	
	//Updated on 11 Sep 2018
	//String[] DIAL_CODE={"UH8FPE","XGDMVD","4EP38B","7DUAEA","ACZHK9","DC5PR8","GBAWX7","JAG546","M9LCA5","Q8RJG4"};
	
	String[] DIAL_CODE={"F2SGB5","I1XNH4","L13VN3","NZ93U2","65BTS8","94H1Y7","C3M956","RYEB11","UXJI6Z","XWPQCY"};
	String LESSON_NAME="Automation Lesson Plan";	
	//Added for content upload
	String MP4_CONTENT_NAME="Automation Content Mp4";
	String SEARCH_CONTENT_IMAGE="content image";
	String SEARCH_RESOURCE_IMAGE="content image";
	String SEARCH_COURSE_IMAGE="course image";
	String SEARCH_BOOK_IMAGE="book image";
	String BOOK_IMAGE="book image.jpg";
	String LESSON_PLAN_IMAGE="lesson plan";

	String MP4="mp4";
	String UPLOAD_MP4="Upload content-mp4.mp4";
	String WEBM="WEBM";
	String UPLOAD_WEBM="Upload content-webm.webm";
	String YOUTUBE="YOUTUBE";
	String UPLOAD_YOUTUBE="https://www.youtube.com/watch?v=qCs0pm_D_hM";
	String UPLOAD_YOUTUBE1="https://www.youtube.com/watch?v=y3qtS_TLVF4&list=PLhW3qG5bs-L-oT0GenwPLcJAPD_SiFK3C";	
	String EPUB="EPUB";
	String UPLOAD_EPUB="faulkner-sound-and-the-fury.epub";
	String HTML="HTML";
	String UPLOAD_HTML="HTMLContent_test.zip";
	String H5P="H5P";
	String UPLOAD_H5P="fill-in-the-blanks-837.h5p";
	String PDF="PDF";
	String UPLOAD_PDF="Short-Stories-for-Children-PDF.pdf";
	String SEARCH_COLLECTION_IMAGE="Collection Image";

	//Added for Test case 13
	String [] REVIEW_COMMENTS={"Inappropriate course","Empty Course","Duplicate Course","Not Suitable for Children"};

	//Added for announcement
	String IMAGE="images1.jpg";
	String DESCRIPTION="DESCRIPTION";
	String ENTERURL="ENTERURL";
	String UPLOADDOCUMENT="UPLOADDOCUMENT";

	//Adding for FlagReviewer
	String ACCEPT="accept";
	String DISCARD="discard";
	String PUBLISH="publish";
	String REQUESTCHANGES="request changes";

	//Adding for Public user 
	String TEST_MAIL_ID="testmemeight@gmail.com";
	String [] CONTENT_TYPE={"//sui-select-option/..//span[.='TextBook']","//sui-select-option/..//span[.='Collection']","//sui-select-option/..//span[.='LessonPlan']","//sui-select-option/..//span[.='Resource']"};

	//Added for Audio Upload Regression Test case 78 
	String AUDIO_UPLOAD="school_chale_hum.mp3";

	//Added for Audio Upload Regression Test case 79
	String VIDEO_UPLOAD="https://goo.gl/uw2hGe";
	
	//Merged from Ajith - 25/09/2018
	String HINDI_LABEL="डायल कोड दर्ज करें ";
	
	// Added by Sachin
	String ALLMYCONTENT = "allMyContent";
}

