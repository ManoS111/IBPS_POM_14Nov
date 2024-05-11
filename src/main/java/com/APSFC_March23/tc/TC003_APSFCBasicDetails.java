package com.APSFC_March23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC003_APSFCBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC003_APSFCBasicDetails";
		testDescription = "APSFC age validation";
		nodes = "APSFC";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "APSFC3";
		sheetName = "APSFCSHEET3";
	}


	@Test(dataProvider = "fetchData")
	public void basicDetails(
			String Sno,String Desc,String Post,String category,String appliedCategory,String PWD,String PWDTYPE,
			String cerebralPalcy,String CompensatoryTime2,String dominantHand,String dominantHandComTime,String SCRIBE,
			String Religion,String Minority,String Women ,String	exServiceman,
			String	periodofservice,String APSFC,String APSFCPOS,String centre, 
	
			String maxDob, String minDob, String dateAsOnDate, String dateAsOnDateCal, String dateAsOnDate2,
			String dateLeap, String MaxAgeMOne, String MaxAge,String MaxAgePOne, String MinAgeMOne,
			String MinAge, String MinAgePOne, String MaxAgeP45, String MinAgeM45, String leapPass, String asOnDateMaxResult,
			String asOnDateMinResult, String payamount) throws Exception {

		new PersonalDetailsPage(driver, test)
		.selectDropDownUsingIndexNew(locateElement("IBPS_post_id"), Post)
		.clickCategory1(category)
		.radioButtonId("IBPS_appldcategory", appliedCategory)
		.radioButtonId("IBPS_disablilty_id", PWD) 
		.selectDropDownUsingIndexNewwithAlert(locateElement("IBPS_DisabilityType_id"), PWDTYPE)
		.radioButtonId("IBPS_cerebralPalsy_name", cerebralPalcy)
		.radioButtonId("IBPS_cerebralPalsyCompensatoryTime_name", CompensatoryTime2)
		.radioButtonName("IBPS_dominantHand_name", dominantHand)
		.radioButtonId("IBPS_dominantHandCompensatoryTime_name", dominantHandComTime)
		.radioButtonName("scribeService_name", SCRIBE)
		.selectDropDownUsingIndexNew(locateElement("IBPS_religion_id"),Religion)
		.radioButtonName("IBPS_minority_id",Minority)
		.radioButtonName("IBPS_relax_remarried_name",Women)
		.radioButtonName("IBPS_exServiceman_name",exServiceman) 
		.inputTextId("IBPS_exServicePeriod_id", periodofservice)
		.radioButtonName("IBPS_apsfc_cand",APSFC)
		.inputTextId("IBPS_apsfc_cand_ser", APSFCPOS)
		.selectDropDownUsingIndexNew(locateElement("IBPS_selexamcentre_id"), centre)
		
		.rowNumC3()		
		.ageValidatorMax(rowNumC3, maxDob, "APSFC3", "APSFCSHEET3")
		.ageValidatorMin(rowNumC3, minDob, "APSFC3", "APSFCSHEET3")
		.ageValidatorAsOnDate(rowNumC3,dateAsOnDate2, "APSFC3", "APSFCSHEET3")
		//.ageValidatorLeapyear(dateLeap, "BNP_1", "BnpUsers1")
		.clickDetailsButton();
	}

}








