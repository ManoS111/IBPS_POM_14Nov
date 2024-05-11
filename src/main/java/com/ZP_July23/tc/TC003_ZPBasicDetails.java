package com.ZP_July23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC003_ZPBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC003_ZPBasicDetails";
		testDescription = "ZP age validation";
		nodes = "ZP";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "ZP3";
		sheetName = "ZPST3";
	}
	@Test(dataProvider = "fetchData")
	public void basicDetails(
			String Sno,  String url,String	firstname,String aadhar,String	mobileno , 
		String email, String status,String warningmsg) throws Exception {

		new PersonalDetailsPage(driver, test)	
		
		.startapp("chrome") // need to uncomment for other app
		.loadurl(url)
		.clickButtonNew("IBPS_reglink")
		.inputTextId("IBPS_fullname", firstname)
		.inputTextId("IBPS_cfullname", firstname)
		.inputTextId("IBPS_txtaadhar", aadhar)
		.inputTextId("IBPS_txtmobile", mobileno)
		.inputTextId("IBPS_txtcmobile", mobileno)
		.inputTextId("IBPS_txtemail", email)
		.inputTextId("IBPS_txtcemail", email)
		.clickButtonNew("IBPS_notifypermission")		
		.rowNumC3()	
		.aadharValidator(rowNumC3, "ZP3", "ZPST3")
		;

	}
}








