package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;

import lib.selenium.PreAndPost;

public class TC005_EducationalQualificationDetailsNegativeValidation extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC005_EducationalQualificationDetailsNegativeValidation";
		testDescription = "Educational Qualification Details Negative Validation";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "EducationDetails-veValidation";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String RegNum, String pwd, String grdDegree, String grdCollege, String grdDay, String grdMonth,
			String grdYear,String grdMarks,String grdGrade,String errorMsg,String scenario) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		.startSBILogin()
		.enterRegistrationNumber(RegNum)
		.enterPassword(pwd)
		.clickSubmit()
		.clickBasicNextBtn()
		.clickPhotoNextBtn();
		/*new PersonalDetailsPage(driver, test)
		.clickSaveAndNext()
		.enterGraduation(grdDegree)
		.enterGradutationCollge(grdCollege)
		.enterGraduationDay(grdDay, grdMonth, grdYear)
		.enterGradutationPerecentage(grdMarks)
		.enterGradutationgrade(grdGrade)
		.clickSaveAndNext() 
		.graduationNegativeValidation(errorMsg, scenario);*/
		
		
		
	}
}




























