package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;

import lib.selenium.PreAndPost;

public class TC002_EducationalQualificationDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC002_EducationalQualificationDetails";
		testDescription = "Update Education Details";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "EducationDetails";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String RegNum, String pwd, String grdDegree, String grdCollege, String grdDay, String grdMonth,
			String grdYear,String grdMarks,String grdGrade,String ddDegree,String ddCollege,String ddDay, String ddMonth, String ddYear,
			String ddMarks,String ddGrade,String pgDegree,String pgColleg,String pgDay,String pgMonth,String pgYear,String pgMarks,String pgGrade,
			String pqDegree,String pqCollege,String pqDay,String pqMonth,String pqYear,String pqMarks,String pqGrade) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		.startSBILogin()
		.enterRegistrationNumber(RegNum)
		.enterPassword(pwd)
		.clickSubmit()
		.clickBasicNextBtn()
		.clickPhotoNextBtn();
		/*new PersonalDetailsPage(driver, test)
		.clickSaveAndNext()
		.enterGraduation1(grdDegree)
		.enterGradutationCollge(grdCollege)
		.enterGraduationDate(grdDay, grdMonth, grdYear)
		.enterGradutationPerecentage(grdMarks)
		.enterGradutationGrade(grdGrade)
		.enterDualDegree(ddDegree)
		.enterDualDegreeCollge(ddCollege)
		.enterDualDegreeDate(ddDay, ddMonth, ddYear)
		.enterDualDegreePerecentage(ddMarks)
		.enterDualDegreeGrade(ddGrade)
		.enterPostGraduation(pgDegree)
		.enterPostGraduationCollge(pgColleg)
		.enterPostGraduationDate(pgDay, pgMonth, pgYear)
		.enterPostGraduationPerecentage(pgMarks)
		.enterPostGraduationGrade(pgGrade)
		.enterProfessionalQualification(pqDegree)
		.enterProfessionalQualificationCollge(pqCollege)
		.enterProfessionalQualificationDate(pqDay, pqMonth, pqYear)
		.enterProfessionalQualificationPerecentage(pqMarks)
		.enterProfessionalQualificationGrade(pqGrade);*/
		
		
		
	}
}




























