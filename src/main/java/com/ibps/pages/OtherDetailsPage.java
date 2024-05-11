package com.ibps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class OtherDetailsPage extends PreAndPost{

	public OtherDetailsPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	@FindBy(how=How.ID, using="txtlangofficial") WebElement eleOfficialLang;
	@FindBy(how=How.ID, using="langofficialr") WebElement eleOfficialLangRead;
	@FindBy(how=How.ID, using="langofficialw") WebElement eleOfficialLangWrite;
	@FindBy(how=How.ID, using="langofficials") WebElement eleOfficialLangSpeak;
	@FindBy(how=How.ID, using="txtlang1") WebElement eleLang1;
	@FindBy(how=How.ID, using="lang1r") WebElement eleLang1Read;
	@FindBy(how=How.ID, using="lang1w") WebElement eleLang1Write;
	@FindBy(how=How.ID, using="lang1s") WebElement eleLang1Speak;
	@FindBy(how=How.ID, using="txtlang2") WebElement eleLang2;
	@FindBy(how=How.ID, using="lang2r") WebElement eleLang2Read;
	@FindBy(how=How.ID, using="lang2w") WebElement eleLang2Write;
	@FindBy(how=How.ID, using="lang2s") WebElement eleLang2Speak;
	public OtherDetailsPage enterOfficialLanguage(String data) {
		type(eleOfficialLang, data);
		return this;
	}
	public OtherDetailsPage clickOfficialLangRead() throws InterruptedException {
		click(eleOfficialLangRead);
		return this;
	}
	public OtherDetailsPage clickOfficialLangWrite() throws InterruptedException {
		click(eleOfficialLangWrite);
		return this;
	}
	public OtherDetailsPage clickOfficialLangSpeak() throws InterruptedException {
		click(eleOfficialLangSpeak);
		return this;
	}
	public OtherDetailsPage enterLanguage1(String data) {
		type(eleLang1, data);
		return this;
	}
	public OtherDetailsPage clickLang1Read() throws InterruptedException {
		click(eleLang1Read);
		return this;
	}
	public OtherDetailsPage clickLang1Write() throws InterruptedException {
		click(eleLang1Write);
		return this;
	}
	public OtherDetailsPage clickLang1Speak() throws InterruptedException {
		click(eleLang1Speak);
		return this;
	}
	public OtherDetailsPage enterLanguage2(String data) {
		type(eleLang2, data);
		return this;
	}
	public OtherDetailsPage clickLang2Read() throws InterruptedException {
		click(eleLang2Read);
		return this;
	}
	public OtherDetailsPage clickLang2Write() throws InterruptedException {
		click(eleLang2Write);
		return this;
	}
	public OtherDetailsPage clickLang2Speak() throws InterruptedException {
		click(eleLang2Speak);
		return this;
	}
	

	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSaveButton;
	public OtherDetailsPage clickSaveAndNext() throws InterruptedException {
		click(eleSaveButton);
		return this; 
	}

}



































