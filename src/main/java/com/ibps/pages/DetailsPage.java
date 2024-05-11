package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class DetailsPage extends PreAndPost{

	public DetailsPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	
	@FindBy(how=How.XPATH, using="//a[text()=' Next ']") WebElement eleBasicNextBtn;
	@FindBy(how=How.ID, using="Submit") WebElement elePhotoNeextBtn;
	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSubmit;
	@FindBy(how=How.ID, using="selstream3") WebElement eleDegreeDropdown;
	@FindBy(how=How.ID, using="selstream3") WebElement eleInstitute;
	public DetailsPage clickBasicNextBtn() throws InterruptedException {
		click(eleBasicNextBtn);
		return this;
	}
	
	public DetailsPage clickPhotoNeextBtn() throws InterruptedException {
		click(elePhotoNeextBtn);
		return this;
	}
	
	public DetailsPage clickDetailsSubmitBtn() throws InterruptedException {
		click(eleSubmit);
		return this;
	}
	
	public DetailsPage enterDegree(String data) {
		type(eleDegreeDropdown, data);
		return this;
	}
}




















