package lib.selenium;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.ibps.pages.LoginPage;

import lib.utils.DataInputProvider;

public class PreAndPost extends WebDriverServiceImpl{

	public static int rowNumC1=0, rowNumC2=0, rowNumC3=0, rowNumC4=0, rowNumC5 =0;
	public String dataSheetName, sheetName;

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		//startReport();
	}
	@BeforeClass
	public void beforeClass() throws Exception {
		
		 // startTestCase(testCaseName, testDescription);
		  System.out.println("new testcass name "+testCaseName +" test description "+testDescription);
		  
		startApp("chrome"); // need to uncomment for other app
		System.out.println("browser launched chrome");
		new LoginPage(driver, test)
		.startSBILogin()
		
		
		.enterRegistrationNumber("326000040") //TDCN MAY 23
		.enterPassword("PPRB427U")
	/**///	.enterRegistrationNumber("400000129") //Zilla Sindhudurg July23
		//.enterPassword("3EL5PK6M")
		/*
		.enterRegistrationNumber("400000128") //Zilla Ratnagiri July23
		.enterPassword("YK94T3YN") 
	
		.enterRegistrationNumber("400000127") //Zilla Raigad July23
		.enterPassword("SPB23N8R") 

		
		.enterRegistrationNumber("400000126") //Zilla Palghar July23
		.enterPassword("76DBEV6F") 
			
		.enterRegistrationNumber("400000125") //Zilla Thane July23
		.enterPassword("8BAH9W2C")   
	
		.enterRegistrationNumber("400000124") //Zilla Nandurbar July23
		.enterPassword("H3M9URY5") 
		
		.enterRegistrationNumber("400000123") //Zilla Jalgaon July23
		.enterPassword("CS3N9K5T")

		
		.enterRegistrationNumber("400000122") //Zilla Dhule July23
		.enterPassword("K6YYU37V")
		
		.enterRegistrationNumber("400000121") //Zilla Ahmednagar July23
		.enterPassword("B47E6FGT")
		
		.enterRegistrationNumber("400000120") //Zilla Nashik July23
		.enterPassword("YG7GHF42")

		
		.enterRegistrationNumber("400000119") //Zilla Wardha July23
		.enterPassword("47URYY2P")
		
		.enterRegistrationNumber("400000118") //Zilla Gondia July23
		.enterPassword("BGFVK226")
		
		
		.enterRegistrationNumber("400000117") //Zilla Gadchiroli July23
		.enterPassword("R9Z2TEW6")
		
		
		.enterRegistrationNumber("400000116") //Zilla Chandrapur July23
		.enterPassword("2ZST56EP") 
		
		.enterRegistrationNumber("400000115") //Zilla Bhandara July23
		.enterPassword("C5ZLC7U2")
			
		.enterRegistrationNumber("400000114") //Zilla Nagpur July23
		.enterPassword("YT5A69DM")

		
		.enterRegistrationNumber("400000113") //Zilla Hingoli July23
		.enterPassword("N6T58WPU")
		
		
		.enterRegistrationNumber("400000112") //Zilla Parbhani July23
		.enterPassword("CL5DM2M2") 
		
		.enterRegistrationNumber("400000110") //Zilla Latur July23
		.enterPassword("S2T5EG4W")

         .enterRegistrationNumber("400000070") //Zilla Nanded July23
		.enterPassword("G6K8FSP7")
		                              */
		//.enterRegistrationNumber("400000068") //Zilla Jalna July23
		//.enterPassword("YLVT3T63")
		//.enterRegistrationNumber("400000036") //Zilla Osmanabad July23
		//.enterPassword("59SNN8AV")
		//.enterRegistrationNumber("400000055") //Zilla Beed July23
		//.enterPassword("59KKEA4N")
		//.enterRegistrationNumber("400000046") //Zilla Aurangabad July23
		//.enterPassword("YT4NZG59")
		
		//.enterRegistrationNumber("400000045") //Zilla Washim July23
		//.enterPassword("NZ5S4WH2")
		
		//.enterRegistrationNumber("400000035") //Zilla Yavatmal July23
		//.enterPassword("Y93BEKF6")
		
		//.enterRegistrationNumber("400000044") //Zilla Buldana July23
		//.enterPassword("56ZVUC9A")
		
		//.enterRegistrationNumber("400000029") //Zilla Amravati July23
		//.enterPassword("EAL222RR")
		//.enterRegistrationNumber("400000043") //Zilla Akola July23
		///.enterPassword("HG78VM8C")
		
		//.enterRegistrationNumber("400000042") //Zilla Kolhapur July23
		//.enterPassword("2WBDKL55")
		
		//.enterRegistrationNumber("400000040") //Zilla Solapur July23
		//.enterPassword("HT46RRV6")
		
		//.enterRegistrationNumber("400000038") //Zilla Sangli July23
		//.enterPassword("VM789YYU")
		
		//.enterRegistrationNumber("400000015") //Zilla Satara July23
		//.enterPassword("2SK5WL8H")
		
		//.enterRegistrationNumber("400000005") //Zilla Pune July23
		//.enterPassword("G34UH8DA")

		//.enterRegistrationNumber("343000004") //nia July23
		//.enterPassword("KWW6F34T")
		//.enterRegistrationNumber("318000024") //DSYS June23
		  //.enterPassword("964FMSLL")
		
		//.enterRegistrationNumber("325000008") //DAMBCD June23
		//.enterPassword("9FP5DY2U")

		//.enterRegistrationNumber("277000101") //MMOCL/MMMM FEB23
		//.enterPassword("LUP95LC2")

		//.enterRegistrationNumber("340000009") //CSMC Aug23
		///.enterPassword("4S97BNFU")
		
		//.enterRegistrationNumber("323000012") //GIC June23
		//.enterPassword("C8KEDZ82")
		
		//.enterRegistrationNumber("334000008") //FCSCPD June 23
		//.enterPassword("CCA56L3T")

		
		//.enterRegistrationNumber("313000067") //AIMSNNF June23
		//.enterPassword("T3KLM22D")

		//.enterRegistrationNumber("313000017") //AIMSNN june 23
		//.enterPassword("R8MPS7E9")

		
		//.enterRegistrationNumber("311000022") //SPMCIL May 23
		//.enterPassword("K8WU8TR9")
		//.enterRegistrationNumber("334000003") //FCSCPD June 23
		//.enterPassword("CP5LYU55")

		//.enterRegistrationNumber("30000005") //MSPGCT june 23
		//.enterPassword("M5RNW83A")

		//.enterRegistrationNumber("326000024") //TDCN MAY  23
		//.enterPassword("F9V85RUE")
		//.enterRegistrationNumber("326000019") //TDCN MAY  23
		//.enterPassword("AK7HMK44")


		//.enterRegistrationNumber("324000012") //CIDCO June23
		//.enterPassword("9F8C2GWV")

		//.enterRegistrationNumber("321000005") //RCF June23
		//.enterPassword("B2SZPM97")
		
		//.enterRegistrationNumber("290000029") //CIDCO June23
		//.enterPassword("3WNL9U7A")

		//.enterRegistrationNumber("323000003") //GIC June23
		//.enterPassword("EE2Y3L6Y")
		//.enterRegistrationNumber("320000009") //PSB June23
		//.enterPassword("Z4BEA8N3")

		
		//.enterRegistrationNumber("318000010") //DSYS June23
		//.enterPassword("B5RC2GW4")
		//.enterRegistrationNumber("312000007") //BMC May23
		//.enterPassword("S2K5TUP2")
		//.enterRegistrationNumber("277000094") //MMOCL/MMMM FEB23
	    //.enterPassword("32PWKUT8")
		//.enterRegistrationNumber("277000101") //MMOCL/MMMM FEB23
		//.enterPassword("LUP95LC2")

		//.enterRegistrationNumber("310000012") //IGM 2 MAY 22
	    // .enterPassword("L387EBNM")
		//.enterRegistrationNumber("311000005") //SPMCIL MAY  23
		//.enterPassword("UCP24SF6")
		//.enterRegistrationNumber("300008") //RBIJE MAY  23
		//.enterPassword("DF8PNE54")

		
		//.enterRegistrationNumber("2260000006") //CRP MAY  23
		//.enterPassword("9KZM7SW9")

		//.enterRegistrationNumber("308000006") //IGM MAY  23
		//.enterPassword("T5NMV79D")
		//.enterRegistrationNumber("306000018") //PMC MAY  23
		//.enterPassword("LLLZ9W35")
		
		//.enterRegistrationNumber("304000017") //CAH MAY April 23
		//.enterPassword("BZCM444M")
		//.enterRegistrationNumber("303000007") //PNB MAY April 23
		//.enterPassword("W86TKP3D")
		
		//.enterRegistrationNumber("302000012") //MCGAD April 23
		//.enterPassword("BAWDG495")
		
		//.enterRegistrationNumber("300000016") //BMC April 23
		//.enterPassword("UPK9D45R")
		
		//.enterRegistrationNumber("301000009") //moil April 23
		//.enterPassword("8FVMN3K2")
		//.enterRegistrationNumber("620008") //RBI Grade  April 23
		// .enterPassword("7LYG4G6G")
		//.enterRegistrationNumber("289000011") //sbi March 23
		// .enterPassword("96UBB6WB")
		
		//.enterRegistrationNumber("299000006") //DOS April 23
		// .enterPassword("MZ5H22WA")
		//.enterRegistrationNumber("296000009") //MSTC April 23
		//.enterPassword("DFM5S72U")

		///.enterRegistrationNumber("297000011") //GSD April 23
		// .enterPassword("SEV449FD")
		//.enterRegistrationNumber("277000025") //MMM April 23
		//.enterPassword("9GP6B7UG")
		//.enterRegistrationNumber("284000007") //DES April 23
		//.enterPassword("3CS87UCH")
		//.enterRegistrationNumber("289000011") //APSFC March 23
		// .enterPassword("96UBB6WB")
		
		//.enterRegistrationNumber("287000003") //APSFC March 23
		// .enterPassword("P83R6AUU")
		//.enterRegistrationNumber("283000012") //BOB March 23
		// .enterPassword("D8YFP83Y")
		
		//.enterRegistrationNumber("285000051") //DCCB March 23
		//.enterPassword("MN7E6W3B")
		
		//.enterRegistrationNumber("286000013") //IDBISCO MARCH 23
		// .enterPassword("C57DHKT8")

		//.enterRegistrationNumber("274000016") //MPRAJ mARCH23
		//.enterPassword("A587NZRM")
		
		//.enterRegistrationNumber("2130000007") //Bihar Feb23
		// .enterPassword("Tamilnadu1234")
	//	.enterRegistrationNumber("278000010") //ShimlaFeb23
		// .enterPassword("V54YACZ6")
	//	.enterRegistrationNumber("273000007") //PMC Feb23
	 // .enterPassword("89HBR8SD")
		// .enterRegistrationNumber("264000013") //MPRAJYA 638 Post Feb23
		 //.enterPassword("29TGZ6BD")
		 
		 //.enterRegistrationNumber("274000005") //MPRAJYA  27 Post Feb23
		 //.enterPassword("BCR5M52A")
		
		//.enterRegistrationNumber("272000006") //Ip Feb 23
		 // .enterPassword("TA94SWK8")
		 // .enterRegistrationNumber("269000002") //IB 20 Feb 23
		//  .enterPassword("VT77W3AS")
		  
		//.enterRegistrationNumber("266000007") //IB Feb 23
		//  .enterPassword("4MG43RHF")

		//.enterRegistrationNumber("260000003") //CBI JAN 23
		  //.enterPassword("TV853PSS")
		//.enterRegistrationNumber("sifytechsify@gmail.com") //Barc Jeb 23
		 // .enterPassword("86DDS7TW")
//		.enterRegistrationNumber("258000004") //ESIC JAN 23
//		  .enterPassword("EZHS29U9")

		//.enterRegistrationNumber("264000004") //MPRSB FEB 23
		 // .enterPassword("97GK5FZA")
		
		//.enterRegistrationNumber("218000007")  //CNP
		//.enterPassword("PNPGD929")
		
		//.enterRegistrationNumber("217000014")  //Repco
		//.enterPassword("EVYZ699G")
		
		//.enterRegistrationNumber("186000056")  //DCCB
		//.enterPassword("CS97CB6H")
		//.enterRegistrationNumber("228000007") //bom 25 nov 22
		//  .enterPassword("D2TSZK67")
		//.enterRegistrationNumber("241000009") //IOB 5 Dec 22
		//  .enterPassword("RHZ55Z4T")
		//.enterRegistrationNumber("226000037") //Mahatransco 8 Dec 22
		//  .enterPassword("8ZWN8MC5")
		//.enterRegistrationNumber("243000006") //RCF 20 Dec 22
		 // .enterPassword("8KA59UDT")
//		  
		 // .enterRegistrationNumber("210000034") //CSB
		 // .enterPassword("F6E5P2KG")
//		.enterRegistrationNumber("248000014") //NHB 3 Jan 23
//		  .enterPassword("3PCY7S7H")
		//.enterRegistrationNumber("251000010") //lic
		//  .enterPassword("Z79H6AAG")
		//.enterRegistrationNumber("257000002") //BOKARO
		// .enterPassword("SFN8WS87")
		
		//.enterRegistrationNumber("281000005") //CAMP March 23
		//.enterPassword("6SCF38VK")
		
		//.enterRegistrationNumber("254000105") //CIDCO
		//.enterPassword("HRPY298D")
		
		//.enterRegistrationNumber("254000006") //CIDCO
		 // .enterPassword("P84L6GZT")
		
		//.enterRegistrationNumber("246000005") //BOMSRO
		 // .enterPassword("A7SCP57E")
		
		//.enterRegistrationNumber("244000008") //Mahatransco 8 Dec 22
		 // .enterPassword("73LMDLP5")

		
		//.enterPassword("2LBZ3B2H")
		//.enterRegistrationNumber("213000018")  //NHB
		//.enterPassword("DN5U75DF")
		//.enterRegistrationNumber("210000003")  //CSB
		//.enterPassword("L96M4FNA")
		//.enterRegistrationNumber("191000026")  //IGM
		//  .enterPassword("AM8CP8S5")
		//.enterRegistrationNumber("191000031") // Mint
		//.enterPassword("5T26CMHL")
		// .enterRegistrationNumber("204000007")  //CBI
		 // .enterPassword("BH5NA8E7")
		////.enterRegistrationNumber("204000016")  //CBI
		//.enterPassword("R36KM2LH")
		//.enterRegistrationNumber("216000008")  //PSC
		 /// .enterPassword("SCU92E9B")
		//.enterRegistrationNumber("2220000015")  //SBI 14 Nov 22
		//.enterPassword("T27MAB7V")
		//.enterRegistrationNumber("225000005")  //SPMCIL 15 Nov 22
		//.enterPassword("Z5U34MBY")
		//.enterRegistrationNumber("212000051")  //MAHAGEN 16 Nov 22
		//.enterPassword("6KFHB5L7")
		//.enterRegistrationNumber("225000017")  //SPMCIL 15 Nov 22
		//.enterPassword("G5EHMV87")
		//.enterRegistrationNumber("223000019")  //MPRAJ 18 Nov
		//.enterPassword("H26FKL3V")


		//.enterRegistrationNumber("2120000004")  //Bihar
	//.enterPassword("65TA2GMH")
		//.enterRegistrationNumber("sify@gmail.com")  //ceptomoct
	  //.enterPassword("sifynet4321")
		// .enterRegistrationNumber("202000015")  //Sardar 
		//  .enterPassword("CKC4T77T")
		//.enterRegistrationNumber("202000082")  //Sardar 
		// .enterPassword("ZB4Y53VY")
		//.enterRegistrationNumber("191000045")  //IGM kOLKATA
		//.enterPassword("ZUSUW858")
		//.enterRegistrationNumber("206000004")  //SPMCIL HY
		//.enterPassword("8D4S4TSG")
	 //.enterRegistrationNumber("202000031")  //Sardar 
	 // .enterPassword("33ANPPG8")
		//.enterRegistrationNumber("197000002")  //IPPB
		  //.enterPassword("M56RPF7V")
		
		//.enterRegistrationNumber("200000006")  //MAHAGENGO
		//  .enterPassword("NN2F22DL")
		//.enterRegistrationNumber("205000023") //TSCAB
	   // .enterPassword("654NPBPG")

		
		//.enterPassword("Z23Z5MUT")
		
		//.enterRegistrationNumber("177000040") 
		//.enterPassword("38KAMWG7")
//\\		.clickNewRegistration()
			.clickSubmit()
			                 //.clickProceed()        //UnComment for BARC
		.clickBasicNextBtn() // Comment for BARC
		.clickPhotoNextBtn() // Comment for BARC// Comment for Bihar                          */
		//=====================================
		//.clickContinueBtn()
		//.clickNewApplicationbtn()  
		;
	}

	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		//  startTestModule(nodes);
		 // test.assignAuthor(authors);
		 // test.assignCategory(category);
		 
		//startApp("chrome");
	}

	@AfterMethod
	public void afterMethod() {		
		//endResult();
	}

	@AfterClass
	public void afterClass() {
		closeAllBrowsers();
	}
	@AfterSuite
	public void afterSuite() {
	}

	@DataProvider(name="fetchData") //,indices= {0,1})       
	public  Object[][] getData(){		  
		return DataInputProvider.getSheet(dataSheetName, sheetName);		
	}

}
