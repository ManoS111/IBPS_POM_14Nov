package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CandidateBasicDetailsPage extends PreAndPost{

	public CandidateBasicDetailsPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test; 
	}

	@FindBy(how=How.XPATH, using="//a[text()=' Next ']") WebElement eleBasicNextBtn;  
	@FindBy(how=How.ID, using="Submit") WebElement elePhotoNeextBtn;
	@FindBy(how=How.ID, using="apply_under") WebElement eleVacancies;
	@FindBy(how=How.ID, using="circle") WebElement eleCircle;
	@FindBy(how=How.ID, using="circle_state") WebElement eleApplyState;
	@FindBy(how=How.ID, using="state_lang") WebElement eleLanguage;
	@FindBy(how=How.ID, using="studied_offical_lang") WebElement ele10thCertificate;
	@FindBy(how=How.XPATH, using="//input[@value='OBC']") WebElement eleCategory;
	@FindBy(how=How.ID, using="subcast") WebElement eleSubCast;
	@FindBy(how=How.XPATH, using="//input[@id='optdisability']/following-sibling::span[text()='No']") WebElement eleDisability;
	@FindBy(how=How.ID, using="religion") WebElement eleReligion;
	@FindBy(how=How.XPATH, using="//input[@id='optminority']/following::span[text()='No']") WebElement eleMinority;
	@FindBy(how=How.XPATH, using="//input[@id='relax_remarried']/following::span[text()='No']") WebElement eleRemarried;
	@FindBy(how=How.XPATH, using="//input[@id='optkashmir']/following::span[text()='No']") WebElement eleKashmir;
	@FindBy(how=How.XPATH, using="//input[@id='sbi_employee']/following::span[text()='No']") WebElement eleSbiEmployee;
	@FindBy(how=How.XPATH, using="//input[@id='exsbi_employee']/following::span[text()='No']") WebElement eleExsbiEmployee;
	@FindBy(how=How.XPATH, using="//input[@id='repayment']/following::span[text()='No']") WebElement eleRepaymnt;
	@FindBy(how=How.XPATH, using="//input[@id='adverse_report']/following::span[text()='No']") WebElement eleReport;
	@FindBy(how=How.ID, using="selstateapplied") WebElement elePreExamState;
	@FindBy(how=How.ID, using="pre_state_code") WebElement elePreExamCode;
	@FindBy(how=How.ID, using="selexamcentre") WebElement elePreExamCentre;
	@FindBy(how=How.ID, using="main_examstate") WebElement eleMainExamState;
	@FindBy(how=How.ID, using="mainexam_state_code") WebElement eleMainExamCode;
	@FindBy(how=How.ID, using="main_examcentre") WebElement eleMainExamCentre;
	public CandidateBasicDetailsPage clickBasicNextBtn() {
		clickr(locateElement("xpath", "eleBasicNextBtn_xpath"));  
		///clickr(locateElement("xpath","IBPS_PhotoandSignatureMenu")); 
		return this;
	}
	public CandidateBasicDetailsPage clickPhotoNextBtn() {
		clickr(locateElement("id", "Submit_id")); 
		return this;
	}
	public CandidateBasicDetailsPage clickProceed() {
		clickr(locateElement("xpath", "IBPS_Proceed")); 
		return this;
	}
	public CandidateBasicDetailsPage clickContinueBtn() throws Exception {
		Thread.sleep(500);
		clickr(locateElement("id", "IBPS_DrdoContinue")); 
		return this;
	}
	public CandidateBasicDetailsPage clickNewApplicationbtn() {
		clickr(locateElement("xpath", "IBPS_DrdoNewApplication")); 
		return this;
	}
	
	
	public CandidateBasicDetailsPage enterApplyVacancies(String data) {
	//	selectDropDownUsingVisibleText(eleVacancies, data);
		return this; 
	}
	
	
	public CandidateBasicDetailsPage enterSubCategory(String data) {
		type(eleSubCast, data);
		return this;
	}
	
	
	
	public CandidateBasicDetailsPage clickCompensatory1() throws InterruptedException {
		click(locateElement("xpath","compensatory1_xpath"));
		return this;
	}
	public CandidateBasicDetailsPage clickMinority() throws InterruptedException {
		click(eleMinority);
		return this;
	}
	public CandidateBasicDetailsPage clickOptRemarried() throws InterruptedException {
		click(eleRemarried);
		return this;
	}
	public CandidateBasicDetailsPage clickSbiEmployee() throws InterruptedException {
		click(eleSbiEmployee);
		return this;
	}
	public CandidateBasicDetailsPage clickExeSbiEmployee() throws InterruptedException {
		click(eleExsbiEmployee);
		return this;
	}
	public CandidateBasicDetailsPage clickRepayment() throws InterruptedException {
		click(eleRepaymnt);
		return this;
	}
	public CandidateBasicDetailsPage clickReport() throws InterruptedException {
		click(eleReport);
		return this;
	}
	/*public CandidateBasicDetailsPage enterPreExamState(String data) {
		//selectDropDownUsingVisibleText(elePreExamState, data);
		driver.getKeyboard().sendKeys(Keys.TAB);
		return this; 
	}
	public CandidateBasicDetailsPage enterPreExamCenter(String data) throws InterruptedException {
		selectDropDownUsingVisibleText(elePreExamCentre, data);
		return this; 
	}
	public CandidateBasicDetailsPage enterMainExamState(String data) {
		selectDropDownUsingVisibleText(eleMainExamState, data);
		driver.getKeyboard().sendKeys(Keys.TAB);
		return this; 
	}
	public PersonalDetailsPage enterMainExamCenter(String data) throws InterruptedException {
		selectDropDownUsingVisibleText(eleMainExamCentre, data);
		return new PersonalDetailsPage(driver, test); 
	}*/
}



































