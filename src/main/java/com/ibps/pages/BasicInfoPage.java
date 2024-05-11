package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class BasicInfoPage extends PreAndPost{

	
	public BasicInfoPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
		
		  this.driver = driver; this.test = test;
		 // new BasicInfoPage(driver, test).driver = driver;
		 
	}
	
	@FindBy(how=How.ID, using="fullname") WebElement eleFullName;
	@FindBy(how=How.ID, using="cfullname") WebElement eleCFullName;
	@FindBy(how=How.ID, using="lastname") WebElement eleLastName;
	@FindBy(how=How.ID, using="clastname") WebElement eleCLastName;
	@FindBy(how=How.ID, using="txtmobile") WebElement eleMobileNum;
	@FindBy(how=How.ID, using="txtcmobile") WebElement eleCMobile;
	@FindBy(how=How.ID, using="txtemail") WebElement eleEmailID;
	@FindBy(how=How.ID, using="seldomain") WebElement eleSelDomain;
	@FindBy(how=How.ID, using="txtcemail") WebElement eleCEmail;
	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSavAndNext; 

	public BasicInfoPage enterFullName(String data) {
		type(eleFullName, data);
		return this;
	}
	public BasicInfoPage enterConfirmFullName(String data) {
		type(eleCFullName, data);
		return this;
	}
	public BasicInfoPage enterLastName(String data) {
		type(eleLastName, data);
		return this;
	}
	public BasicInfoPage enterConLastName(String data) {
		type(eleCLastName, data);
		return this;
	}
	public BasicInfoPage enterMobileNum(String data) {
		type(eleMobileNum, data);
		return this;
	}
	public BasicInfoPage enterConfirmMobileNum(String data) {
		type(eleCMobile, data);
		return this;
	}
	public BasicInfoPage enterEmailID(String data) {
		type(eleEmailID, data);
		return this;
	}
	public BasicInfoPage enterDomain(String data) {
		//selectDropDownUsingVisibleText(eleSelDomain, data);
		return this;
	}
	public BasicInfoPage enterConfirmMailID(String data) {
		type(eleCEmail, data);
		return this;
	}
	public PhotoAndSignaturePage clickSaveAndNext() throws InterruptedException {
		click(eleSavAndNext);
		acceptAlert();
		return new PhotoAndSignaturePage(driver, test); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
