package com.TDCN_June23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC004_TDCNBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC004_TDCNBasicDetails";
		testDescription = "TDCN age validation";
		nodes = "TDCN";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "TDCN4";
		sheetName = "TDCNST4";
	}

	@Test(dataProvider = "fetchData")
	public void basicDetails(
			String Sno,String Desc,String	Division,String	Post,String	Category ,String AppliedCategory,
			String PWD, String PWDcategory, String PWDTYPE ,String CompensatoryTime1,String cerebralPalcy, String	CompensatoryTime2,	
			String dominantHand, String	CompensatoryTime3, String	SCRIBE, String Women,String	exServiceman, String DisableexServiceman
            ,String periodofservice,
			String SportsPerson,String ProjectAffPerson,String EarthQuickAffPerson,String Orphan,
			String DomicileOfMaha,String PartTime,String Minority,String Religion,
			
			String maxDob, String minDob, String dateAsOnDate, String dateAsOnDateCal, String dateAsOnDate2,
			String dateLeap, String MaxAgeMOne, String MaxAge,String MaxAgePOne, String MinAgeMOne,
			String MinAge, String MinAgePOne, String MaxAgeP45, String MinAgeM45, String leapPass, String asOnDateMaxResult,
			String asOnDateMinResult, String payamount) throws Exception {

		new PersonalDetailsPage(driver, test)	
		.selectDropDownUsingIndexNew(locateElement("IBPS_division"), Division)
		.selectDropDownUsingIndexNew(locateElement("IBPS_post_id"), Post)
		.clickCategory1(Category)
		.radioButtonId("IBPS_apply_category", AppliedCategory)
		.radioButtonName("IBPS_disablilty_id", PWD)
		.selectDropDownUsingIndexNew(locateElement("IBPS_disabilitycategory"), PWDcategory)
		.selectDropDownUsingIndexNewwithAlert(locateElement("IBPS_DisabilityType_id"), PWDTYPE)
		.radioButtonId("IBPS_Compensatorytime_id", CompensatoryTime1)
		.radioButtonName("IBPS_cerebralPalsy_name", cerebralPalcy)
		.radioButtonId("IBPS_cerebralPalsyCompensatoryTime_name", CompensatoryTime2)
		.radioButtonName("IBPS_dominantHand_name", dominantHand)
		.radioButtonId("dominantHandCompensatoryTime_name", CompensatoryTime3)
		.radioButtonName("scribeService_name", SCRIBE)
		.radioButtonName("IBPS_relax_remarried_name", Women)
		.radioButtonName("IBPS_exServiceman_name", exServiceman)
		.radioButtonName("IBPS_DisabledExService", DisableexServiceman)
		.inputTextId("IBPS_exServicePeriod_id", periodofservice)
		.radioButtonName("IBPS_sport_person", SportsPerson)
		.radioButtonName("IBPS_project_affected", ProjectAffPerson)
		.radioButtonName("IBPS_earthquake_affected", EarthQuickAffPerson)
		.radioButtonName("IBPS_orphan_child", Orphan)
		.radioButtonName("IBPS_domicle_maharashtra", DomicileOfMaha)
		.radioButtonName("IBPS_govjob", PartTime)
		.radioButtonName("IBPS_minority_id",Minority)
		.selectDropDownUsingIndexNew(locateElement("IBPS_religion_id"),Religion)
		
		
		.rowNumC4()		
		.ageValidatorMax(rowNumC4, maxDob, "TDCN4", "TDCNST4")
		.ageValidatorMin(rowNumC4, minDob, "TDCN4", "TDCNST4")
		.ageValidatorAsOnDate(rowNumC4,dateAsOnDate2, "TDCN4", "TDCNST4")
		.clickDetailsButton();

	}

}








