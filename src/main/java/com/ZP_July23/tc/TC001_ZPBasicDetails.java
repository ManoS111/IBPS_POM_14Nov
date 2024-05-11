package com.ZP_July23.tc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ibps.pages.PersonalDetailsPage;

import lib.selenium.PreAndPost;

public class TC001_ZPBasicDetails extends PreAndPost{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC001_ZPBasicDetails";
		testDescription = "ZP age validation";
		nodes = "ZP";
		authors = "Gayatri";
		category = "Sanity";
		dataSheetName = "ZP1";
		sheetName = "ZPST1";
	}

	@Test
	public void basicDetails() throws Exception {

		new PersonalDetailsPage(driver, test)		
		//.getCategory("ZP1", "ZPST1");
		
		
		
		       //.getCategory("ZillaCategoryVacancy", "Pune");
				//.getCategory("ZillaCategoryVacancy", "Satara");
				//.getCategory("ZillaCategoryVacancy", "Sangli");
				//.getCategory("ZillaCategoryVacancy", "Solapur");
				 //.getCategory("ZillaCategoryVacancy", "Kolhapur");
				 //.getCategory("ZillaCategoryVacancy", "Akola");
				//.getCategory("ZillaCategoryVacancy", "Amravati");
				//.getCategory("ZillaCategoryVacancy", "Buldana");
				//.getCategory("ZillaCategoryVacancy", "Yavatmal");
				//.getCategory("ZillaCategoryVacancy", "Washim");
		        // .getCategory("ZillaCategoryVacancy", "Aurangabad");
				//.getCategory("ZillaCategoryVacancy", "Beed");
				///.getCategory("ZillaCategoryVacancy", "Jalna");
		.getCategory("ZillaCategoryVacancy", "Osmanabad");
		 //  .getCategory("ZillaCategoryVacancy", "Nanded");
		//.getCategory("ZillaCategoryVacancy", "Latur");
		//.getCategory("ZillaCategoryVacancy", "Parbhani");
		//.getCategory("ZillaCategoryVacancy", "Hingoli");
		//.getCategory("ZillaCategoryVacancy", "Nagpur");
		//.getCategory("ZillaCategoryVacancy", "Bhandara");
		//.getCategory("ZillaCategoryVacancy", "Chandrapur");
		//.getCategory("ZillaCategoryVacancy", "Gadchiroli");
		//.getCategory("ZillaCategoryVacancy", "Gondia");
		//.getCategory("ZillaCategoryVacancy", "Wardha");
		//.getCategory("ZillaCategoryVacancy", "Nashik");
		//.getCategory("ZillaCategoryVacancy", "Ahmednagar");
		//.getCategory("ZillaCategoryVacancy", "Dhule");
		//.getCategory("ZillaCategoryVacancy", "Jalgaon");
		//.getCategory("ZillaCategoryVacancy", "Nandurbar");
		//.getCategory("ZillaCategoryVacancy", "Thane");
		//.getCategory("ZillaCategoryVacancy", "Palghar");
		//.getCategory("ZillaCategoryVacancy", "Raigad");
		//.getCategory("ZillaCategoryVacancy", "Ratnagiri");
		//.getCategory("ZillaCategoryVacancy", "Sindhudurg");
	}
}








