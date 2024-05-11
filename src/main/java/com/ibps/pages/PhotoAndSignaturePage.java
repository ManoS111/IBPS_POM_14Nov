package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class PhotoAndSignaturePage extends PreAndPost{

	
	public PhotoAndSignaturePage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	@FindBy(how=How.ID, using="picture") WebElement elePicture;
	@FindBy(how=How.ID, using="signature") WebElement eleSignature;
	@FindBy(how=How.ID, using="Submit") WebElement eleBasicNextBtn;

	public PhotoAndSignaturePage uploadPicture(String data) throws InterruptedException {
		type(elePicture, data);
		Thread.sleep(5000);
		return this;
	}
	public PhotoAndSignaturePage uploadSignature(String data) throws InterruptedException {
		type(eleSignature, data);  
		Thread.sleep(5000);
		return this;
	}
	public CandidateBasicDetailsPage clickBasicNextBtn() throws InterruptedException {
		click(eleBasicNextBtn);
		return new CandidateBasicDetailsPage(driver, test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
