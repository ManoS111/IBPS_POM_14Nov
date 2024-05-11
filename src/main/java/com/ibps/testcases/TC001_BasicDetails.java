package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;

import lib.selenium.PreAndPost;

public class TC001_BasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "Login to ibps";
		testDescription = "Login testCase using Valid Credentials";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "BasicDetails";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String RegNum, String pwd, String vacancies, String circle, String statToApply, String language,
			String subCast,String region,String preExamState,String preExamCnter,String mainExamState,String MainExamCenter,
			String day,String month,String year,String fatherName,String motherName,String add1,String dist1,String state1,String pincode1,
			String preAdd,String dist2,String state2,String pincode2,String gstInvoicing) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		/*.startSBILogin()
		.enterRegistrationNumber(RegNum)
		.enterPassword(pwd)
		.clickSubmit()
		.clickBasicNextBtn()
		.clickPhotoNextBtn()
		.enterApplyVacancies(vacancies)
		//.enterCircle(circle)
		//.enterApplyState(statToApply)
		//.enterLanguage(language)
		//.clickOfficalLanguage()
		//.clickCategory()
		.enterSubCategory(subCast)
		.clickDisability()
		.enterReligion(region)
		.clickMinority()
		.clickOptRemarried()
		.clickOptKashmir()
		.clickSbiEmployee()
		.clickExeSbiEmployee()
		.clickRepayment()
		.clickReport()
		.enterPreExamState(preExamState)
		.enterPreExamCenter(preExamCnter)
		.enterMainExamState(mainExamState)
		.enterMainExamCenter(MainExamCenter)
		.enterDate(day, month, year)
		.clickGender()
		.clickMaritalStatus()
		.enterFatherName(fatherName)
		.enterMotherName(motherName)
		.enterAddressForCorrespondence(add1)
		.enterCorspDistrict(dist1)
		.enterCorspState(state1)
		.enterCorspPincode(pincode1)
		.enterPerDistrict(dist2)
		.enterPerpState(state2)
		.enterPrePincode(pincode2)
		.enterGstState(gstInvoicing)
		.clickSaveAndNext()*/;
		
		
		
		
	}
}




























