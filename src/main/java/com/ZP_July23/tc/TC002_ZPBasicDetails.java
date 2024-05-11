package com.ZP_July23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC002_ZPBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC002_ZPBasicDetails";
		testDescription = "ZP age validation";
		nodes = "ZP";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "ZP2";
		sheetName = "ZPST2";
	}
	@Test(dataProvider = "fetchData")
	public void basicDetails(
			String Sno,String	firstname,String	cname,String	mobileno ,String cmobileno, 
			String email, String org, String cemail ,String url, String status) throws Exception {

		new PersonalDetailsPage(driver, test)	
		
		.inputTextId("IBPS_fullname", firstname)
		.inputTextId("IBPS_cfullname", cname)
		.inputTextId("IBPS_txtmobile", mobileno)
		.inputTextId("IBPS_txtcmobile", cmobileno)
		.inputTextId("IBPS_txtemail", email)
		.selectDropDownUsingIndexNew(locateElement("IBPS_seldomain"), org)
		.inputTextId("IBPS_txtcemail", cemail)
				
		.rowNumC2()	
		.mobilenovalidator(rowNumC2, url, "ZP2", "ZPST2");

	}
}








