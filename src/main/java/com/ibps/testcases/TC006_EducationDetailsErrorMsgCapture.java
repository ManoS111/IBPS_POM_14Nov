package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;

import lib.selenium.PreAndPost;

public class TC006_EducationDetailsErrorMsgCapture extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC006_EducationDetailsErrorMsgCapture";
		testDescription = "Education Details ErrorMsg Capture";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "EducationDetailsErrorMsgCapture";
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
		.graduationErrorMsgCapture(errorMsg, scenario);*/ 
		
		
		
	}
}




























