package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;

import lib.selenium.PreAndPost;

public class TC000_BasicInfo extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "New Registration";
		testDescription = "New Registration";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "BasicInfo";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String fullName, String conFullName, String lastName,String conLastName, String mobileNum, String conMobileName,
			String email,String domain,String conEmail,String picture,String signature) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		.startSBILogin()
		.clickNewRegistration()
		.enterFullName(fullName)
		.enterConfirmFullName(conFullName)
		.enterLastName(lastName)
		.enterConLastName(conLastName)
		.enterMobileNum(mobileNum)
		.enterConfirmMobileNum(conMobileName)
		.enterEmailID(email)
		.enterDomain(domain)
		.enterConfirmMailID(conEmail)
		.clickSaveAndNext()
		.uploadPicture(picture)
		.uploadSignature(signature)
		.clickBasicNextBtn(); 
		
		
		
		
	}
}




























