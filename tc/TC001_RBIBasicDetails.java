package com.rbisb.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC001_RBIBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC001_RBIBasicDetails";
		testDescription = "RBI age validation";
		nodes = "RBI";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "RBI_1";
		sheetName = "RBIUSERS1";
	}
	
	@Test(dataProvider = "fetchData")
	public void basicDetails(String Snum,String Desc,String Area,String Post,String Category,String PWD,String PWDTYPE,String Blindness,String HardOfHearing,
	  String CompTime,String cerebralPalcy,String CompensatoryTime,String dominantHand,String dominantHandComTime,String SCRIBE,
	  String exserviceman,String selectCategory,String militaryService,String RBIStaff,String empId,String govtService,String employer,

	 
	  String maxDob, String minDob, String dateAsOnDate, String dateAsOnDateCal, String dateAsOnDate2,
	  String dateLeap, String MaxAgeMOne, String MaxAge,String MaxAgePOne, String MinAgeMOne,
	  String MinAge, String MinAgePOne, String MaxAgeP45, String MinAgeM45, String leapPass, String asOnDateMaxResult,
	  String asOnDateMinResult, String payamount) throws Exception {


	 new PersonalDetailsPage(driver, test)
	 .selectDropDownUsingIndexNew(locateElement("selpost_name"), Area)
	 .selectDropDownUsingIndexNew(locateElement("IBPS_designation"),Post)
	 .clickCategory1(Category)
	 .radioButtonId("IBPS_disablilty_id", PWD) 
	 .selectDropDownUsingIndexNew(locateElement("IBPS_disabliltyType_name"),PWDTYPE)
	 .radioButtonName("IBPS_Blind",Blindness)
	 .radioButtonName("IBPS_deaf_hh",HardOfHearing)
				/*
				 * .radioButtonId("IBPS_compTime_name", CompTime)
				 * .radioButtonId("IBPS_cerebralPalsy_name", cerebralPalcy)
				 * .radioButtonId("compensatory_id", CompensatoryTime)
				 * .radioButtonName("IBPS_dominantHand_name", dominantHand)
				 * .radioButtonName("IBPS_dominantHandCompensatoryTime_name",
				 * dominantHandComTime) .radioButtonName("scribeService_name", SCRIBE)
				 */
	 .radioButtonName("RBISB_exserviceman", exserviceman)
	 .selectDropDownUsingIndexNew(locateElement("RBISB_serv_cat"),selectCategory)
	 .radioButtonId("RBISB_serv_period", militaryService)
	 .radioButtonxpath("RBISB_rbi_staf",RBIStaff)
	 .inputTextXpath("RBISB_rbi_id", empId)
	 .radioButtonName("RBISB_govt_serv",govtService)
	 .radioButtonName("RBISB_emp_conf",employer)
	 .rowNumC1()  
	 .ageValidatorMax(rowNumC1, maxDob, "RBI_1", "RBIUSERS1")
	 .ageValidatorMin(rowNumC1, minDob, "RBI_1", "RBIUSERS1")
	 .ageValidatorAsOnDate(rowNumC1,dateAsOnDate2, "RBI_1", "RBIUSERS1")
	 //.ageValidatorLeapyear(dateLeap, "BNP_1", "BnpUsers1")
	 .clickDetailsButton();
		

	}
}








