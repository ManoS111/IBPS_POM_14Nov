package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class WorkExperiancePage extends PreAndPost{

	public WorkExperiancePage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	
	@FindBy(how=How.ID, using="txtemp1") WebElement eleEmployeeName;
	@FindBy(how=How.ID, using="txtdesg1") WebElement eleDesignation;
	@FindBy(how=How.ID, using="selfromday1") WebElement eleFromDay;
	@FindBy(how=How.ID, using="selfrommon1") WebElement eleFromMonth;
	@FindBy(how=How.ID, using="selfromyr1") WebElement eleFromYear;
	@FindBy(how=How.ID, using="seltoday1") WebElement eleToday;
	@FindBy(how=How.ID, using="seltomon1") WebElement eleToMonth;
	@FindBy(how=How.ID, using="seltoyr1") WebElement eleToYear;
	@FindBy(how=How.ID, using="txtduty1") WebElement eleDuties;
	@FindBy(how=How.ID, using="txtreason1") WebElement eleReason;
	public WorkExperiancePage enterEmployeeName(String data) {
	    type(eleEmployeeName, data);
		return this;
	}
	public WorkExperiancePage enterDesignation(String data) {
		type(eleDesignation, data);
		return this;
	}
	/*public WorkExperiancePage enterFromDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleFromDay, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleFromMonth, month);
		WebElement element = locateElement("selfromyr1"); 
		element.sendKeys(year);
		element.sendKeys(Keys.ENTER); 
		return this;
	}
	public WorkExperiancePage enterToDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleToday, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleToMonth, month);
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleToYear));
		selectDropDownUsingVisibleText(eleToYear, year);
		return this;
	}*/
	public WorkExperiancePage enterNatureOfDuties(String data) {
		type(eleDuties, data);
		return this;
	}
	public WorkExperiancePage enterReason(String data) {
		 type(eleReason, data);
		return this;
	}

	@FindBy(how=How.ID, using="txtemp2") WebElement eleEmployeeName2;
	@FindBy(how=How.ID, using="txtdesg2") WebElement eleDesignation2;
	@FindBy(how=How.ID, using="selfromday2") WebElement eleFromDay2;
	@FindBy(how=How.ID, using="selfrommon2") WebElement eleFromMonth2;
	@FindBy(how=How.ID, using="selfromyr2") WebElement eleFromYear2;
	@FindBy(how=How.ID, using="seltoday2") WebElement eleToday2;
	@FindBy(how=How.ID, using="seltomon2") WebElement eleToMonth2;
	@FindBy(how=How.ID, using="seltoyr2") WebElement eleToYear2;
	@FindBy(how=How.ID, using="txtduty2") WebElement eleDuties2;
	@FindBy(how=How.ID, using="txtreason2") WebElement eleReason2;
	public WorkExperiancePage enterEmployeeName2(String data) {
	    type(eleEmployeeName2, data);
		return this;
	}
	public WorkExperiancePage enterDesignation2(String data) {
		type(eleDesignation2, data);
		return this;
	}
	/*public WorkExperiancePage enterFromDate2(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleFromDay2, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleFromMonth2, month);
		WebElement element = locateElement("selfromyr2"); 
		element.sendKeys(year);
		element.sendKeys(Keys.ENTER);
		return this;
	}
	public WorkExperiancePage enterToDate2(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleToday2, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleToMonth2, month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleToYear2, year);
		return this;
	}*/
	public WorkExperiancePage enterNatureOfDuties2(String data) {
		type(eleDuties2, data);
		return this;
	}
	public WorkExperiancePage enterReason2(String data) {
		 type(eleReason2, data);
		return this;
	}
	
	
	
	
	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSaveButton;
	public WorkExperiancePage clickSaveAndNext() throws InterruptedException {
		click(eleSaveButton);
		return this;  
	}
	
}



































