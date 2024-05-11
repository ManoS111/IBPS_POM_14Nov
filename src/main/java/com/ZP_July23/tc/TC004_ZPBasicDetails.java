package com.ZP_July23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC004_ZPBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC004_ZPBasicDetails";
		testDescription = "ZP age validation";
		nodes = "ZP";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "ZP4";
		sheetName = "ZPST4";
	}

	@Test(dataProvider = "fetchData")
	public void basicDetails(
			String Sno,String	Desc,String	Post,String	Category ,String AppliedCategory, 
			String PWD, String PWDcategory, String PWDTYPE ,String CompensatoryTime1,String cerebralPalcy, String	CompensatoryTime2,	
			String dominantHand, String	CompensatoryTime3, String	SCRIBE,String ZillaPaishad,String StateGov,
			String	exServiceman,String DisabledExServiceman, String periodofservice,String Women,
			String SportsPerson,String ProjectAffPerson,String EarthQuickAffPerson,String PartTime,String Orphan,
			String DomicileOfMaha,String PESAregion,String FreedomFighter,String CensusWork,
			String ElectionEmp,String GovTechEdu,String RecProcess,String Minority,String Religion,
			
			
			String maxDob, String minDob, String dateAsOnDate, String dateAsOnDateCal, String dateAsOnDate2,
			String dateLeap, String MaxAgeMOne, String MaxAge,String MaxAgePOne, String MinAgeMOne,
			String MinAge, String MinAgePOne, String MaxAgeP45, String MinAgeM45, String leapPass, String asOnDateMaxResult,
			String asOnDateMinResult, String payamount) throws Exception {

		new PersonalDetailsPage(driver, test)		
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
		.radioButtonName("IBPS_emp_zilla", ZillaPaishad)
		.radioButtonName("IBPS_state_govemp", StateGov)
		.radioButtonName("IBPS_exServiceman_name", exServiceman)
		.radioButtonName("IBPS_DisabledExService", DisabledExServiceman)
		.inputTextId("IBPS_exServicePeriod_id", periodofservice)
		.radioButtonName("IBPS_relax_remarried_name", Women)
		.radioButtonName("IBPS_sports_person", SportsPerson)
		.radioButtonName("IBPS_prjaffect_person", ProjectAffPerson)
		.radioButtonName("IBPS_earthquakeaffect_person", EarthQuickAffPerson)
		.radioButtonName("IBPS_PartTime", PartTime)
		.radioButtonName("IBPS_orphan", Orphan)
		.radioButtonName("IBPS_domicile", DomicileOfMaha)
		.radioButtonName("IBPS_domicle_maharastra_state", PESAregion)
		.radioButtonName("IBPS_freedom_fighter", FreedomFighter)
		.radioButtonName("IBPS_emp_census", CensusWork)
		.radioButtonName("IBPS_emp_electionduty", ElectionEmp) 
		.radioButtonName("IBPS_govt_technical_edu", GovTechEdu)
		.radioButtonName("IBPS_recruitment_process", RecProcess)
		.radioButtonName("IBPS_minority_id",Minority)
		.selectDropDownUsingIndexNew(locateElement("IBPS_religion_id"),Religion)
		
		.rowNumC4()		
		.ageValidatorMax(rowNumC4, maxDob, "ZP4", "ZPST4")
		.ageValidatorMin(rowNumC4, minDob, "ZP4", "ZPST4")
		.ageValidatorAsOnDate(rowNumC4,dateAsOnDate2, "ZP4", "ZPST4")
		//.ageValidatorLeapyear(dateLeap, "BNP_1", "BnpUsers1")
		.clickDetailsButton();

	}

}








