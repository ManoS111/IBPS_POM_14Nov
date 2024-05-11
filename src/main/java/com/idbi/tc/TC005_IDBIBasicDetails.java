package com.idbi.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC005_IDBIBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC005_IDBIBasicDetails";
		testDescription = "IDBI age validation";
		nodes = "IDBI";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "IDBI_5";
		sheetName = "IDBIUSERS5";
	}

	@Test(dataProvider = "fetchData")
	public void basicDetails(String snum,String Desc,String Post,String Area,String Category,String PWD,
			String PWDTYPE,String ceberalPalsy,String dominantHand,String riots,String Religion,String Minority,
			String exserviceman,String CivilSide,String PeriodOfService,String state,

			String maxDob, String minDob, String dateAsOnDate, String dateAsOnDateCal, String dateAsOnDate2,
			String dateLeap, String MaxAgeMOne, String MaxAge,String MaxAgePOne, String MinAgeMOne,
			String MinAge, String MinAgePOne, String MaxAgeP45, String MinAgeM45, String leapPass, String asOnDateMaxResult,
			String asOnDateMinResult, String payamount) throws Throwable {


		new PersonalDetailsPage(driver, test)

		.selectDropDownUsingIndexNew(locateElement("IBPS_post_id"),Post)
		.selectDropDownUsingIndexNew(locateElement("IBPS_functional_area"),Area)
		.clickCategory1(Category)
		.radioButtonId("IBPS_disablilty_id", PWD)
		.selectDropDownUsingIndexNewwithAlert(locateElement("IBPS_disabliltyType_name"), PWDTYPE)
		.radioButtonName("IBPS_cerebralPalsy_name", ceberalPalsy)
		.radioButtonName("IBPS_dominantHand_name", dominantHand)
		.radioButtonName("IBPS_members1984_name", riots)
		.selectDropDownUsingIndexNew(locateElement("IBPS_religion_id"),Religion)
		.radioButtonName("IBPS_minority_id",Minority)
		.radioButtonName("IBPS_exServiceman_name", exserviceman)
		.radioButtonName("govJobexService_name", CivilSide)
		.inputTextId("IBPS_exServicePeriod_id", PeriodOfService)
		.selectDropDownUsingIndexNew(locateElement("IBPS_State_id"),state)
		.rowNumC5()		
		.ageValidatorMax(rowNumC5, maxDob, "IDBI_5", "IDBIUSERS5")
		.ageValidatorMin(rowNumC5, minDob, "IDBI_5", "IDBIUSERS5")
		.ageValidatorAsOnDate(rowNumC5,dateAsOnDate2, "IDBI_5", "IDBIUSERS5")
		//.ageValidatorLeapyear(dateLeap, "BNP_1", "BnpUsers1")
		.clickDetailsButton();


	}
}








