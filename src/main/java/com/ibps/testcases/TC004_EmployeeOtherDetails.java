package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;
import com.ibps.pages.OtherDetailsPage;
import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC004_EmployeeOtherDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC004_EmployeeOtherDetails";
		testDescription = "Update Employee other Details";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "OtherDetails";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String RegNum, String pwd, String lang2) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		.startSBILogin()
		.enterRegistrationNumber(RegNum)
		.enterPassword(pwd)
		.clickSubmit()
		.clickBasicNextBtn()
		.clickPhotoNextBtn();
		new PersonalDetailsPage(driver, test)
		.clickSaveAndNext();
        new OtherDetailsPage(driver, test)
        .clickOfficialLangRead()
        .clickOfficialLangWrite()
        .clickOfficialLangSpeak()
        .clickLang1Read()
        .clickLang1Write()
        .clickLang1Speak()
        .enterLanguage2(lang2)
        .clickLang2Read()
        .clickLang2Write()
        .clickLang2Speak()
        .clickSaveAndNext();

        
		
		
	}
}




























