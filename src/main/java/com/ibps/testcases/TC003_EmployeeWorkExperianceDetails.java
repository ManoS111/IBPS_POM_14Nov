package com.ibps.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.LoginPage;
import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC003_EmployeeWorkExperianceDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC003_EmployeeWorkExperianceDetails";
		testDescription = "Update Employee Work Experiance Details";
		nodes = "Admin";
		authors = "Gayatri";
		category = "Smoke";
		dataSheetName = "IBPSData";
		sheetName = "EmployeeDetails";
	}

	@Test(dataProvider = "fetchData")	
	public void basicDetails(String RegNum, String pwd, String empName, String designation, String fromDay, String fromMonth,String fromYear,
			String toDay,String toMonth,String toYear,String natureOfWork,String reason, String empName2, String des2,String fromDay2,String fromMonth2,
			String fromYear2,String toDay2,String toMonth2,String toYear2,String duties,String reason2) throws InterruptedException, IOException {
		
		new LoginPage(driver, test)	
		.startSBILogin()
		.enterRegistrationNumber(RegNum)
		.enterPassword(pwd)
		.clickSubmit()
		.clickBasicNextBtn()
		.clickPhotoNextBtn();
		new PersonalDetailsPage(driver, test)
		.clickSaveAndNext();
       /* new WorkExperiancePage(driver, test)
        .enterEmployeeName(empName)
        .enterDesignation(designation)
        .enterFromDate(fromDay, fromMonth, fromYear)
        .enterToDate(toDay, toMonth, toYear)
        .enterNatureOfDuties(natureOfWork)
        .enterReason(reason)
        .enterEmployeeName2(empName2)
        .enterDesignation2(des2)
        .enterFromDate2(fromDay2, fromMonth2, fromYear2)
        .enterToDate2(toDay2, toMonth2, toYear2)
        .enterNatureOfDuties2(duties)
        .enterReason2(reason2)
        .clickSaveAndNext();*/

        
		
		
	}
}




























