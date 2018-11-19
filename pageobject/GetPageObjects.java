package org.sunbird.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetPageObjects {

	WebDriver driver;

	public  GetPageObjects(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	//Added for TC008

	@FindBy(xpath="//input[@name='search']")
	public WebElement getPageSearch;

	@FindBy(xpath="//div[@class='ui tiny image']")
	public WebElement getPageGooglePlayIcon;

	@FindBy(xpath="//div[@class='ui tiny header']")
	public WebElement getPageDialCode;
	
	//Added for TC015
	
	@FindBy(xpath = "//button[contains(text(),'Explore sunbird')]")
	public WebElement btnExploreSunbird;
	
	@FindBy(id = "keyword")
	public WebElement idSearchBar;
	
	@FindBy(xpath = "//button[contains(text(),'Enter DIAL code')]")
	public WebElement xEnterDialCode;
	
	@FindBy(xpath="//button[@class='ui basic button left-float']")
	public WebElement xEnterDialCode_Hindi;
	
	@FindBy(xpath = "//sui-select[@labelfield='name']")
	public WebElement xLanguageChange;
	
	@FindBy(id = "board")
	public WebElement iBoard;
	
	@FindBy(id = "medium")
	public WebElement iMedium;
	
	@FindBy(id = "subject")
	public WebElement iSubject;
	
	@FindBy(id = "gradeLevel")
	public WebElement iClass;
	
	@FindBy(xpath = "//a[contains(text(),'SUBMIT')]")
	public WebElement xBtnSubmit;
	
	@FindBy(xpath = "//a[contains(text(),'RESET')]")
	public WebElement xBtnReset;
	
	@FindBy(xpath = "//div[@role='listbox']")
	public List<WebElement> xListOfContents;
	
	@FindBy(xpath="//sui-select-option[@class='item']//span[contains(text(),'Hindi')]")
	public WebElement xSelectHindiLanguage;
	
	@FindBy(xpath="//div[contains(text(),'SUBMIT')]")
	public WebElement xDivBtnSubmit;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public List<WebElement> reviewDialCodeRelatedContent;
	
	@FindBy(xpath="//div[@class='title']")
	public List<WebElement> xDialContentTitles;
	
	@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Andhra')]")
	public WebElement xSelectBoard;
	
	@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Telugu')]")
	public WebElement xSelectMedium;
	
	@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Science')]")
	public WebElement xSelectSubject;
	
	@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Class 6')]")
	public WebElement xSelectClass;
	
	
}
