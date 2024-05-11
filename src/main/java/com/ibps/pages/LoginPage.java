package com.ibps.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class LoginPage extends PreAndPost{

	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	
	@FindBy(how=How.LINK_TEXT, using="Click here for New Registration") WebElement eleNewReg;
	@FindBy(how=How.ID, using="txtregno") WebElement eleRegNum;
	@FindBy(how=How.ID, using="txtpass") WebElement elePassword;
	@FindBy(how=How.ID, using="Submit") WebElement eleSubmit;
	
	public LoginPage startSBILogin() throws InterruptedException {
		//loadUrl("http://regqc.sifyitest.com/uiiclaug23/");
		//loadUrl("http://regqc.sifyitest.com/niacljun23/");//nia July23
		//loadUrl("http://regqc.sifyitest.com/zpvpjun23/");//Zilla July23

		//loadUrl("http://regqc.sifyitest.com/dambcdjun23/");//DAMBCD June23
		
		//loadUrl("http://regqc.sifyitest.com/mmoclfeb23/");//MMOCL/MMMM FEB23
		//loadUrl("http://regqc.sifyitest.com/csmcvpaug23/");//CSMC Aug23
		//loadUrl("http://regqc.sifyitest.com/aimsnnfmay23/"); //AIMSNNF June23
		//loadUrl("http://regqc.sifyitest.com/aimsnnfmay23/");
		//loadUrl("https://regqc.sifyitest.com/spmcilmay23/"); //SPMCIL May 23
		//loadUrl("https://regqc.sifyitest.com/mspgctjun23/"); //MSPGCT JUN23
		 // loadUrl("http://regqc.sifyitest.com/fcscpdjun23/"); //FCSCPD June 23
		loadUrl("http://regqc.sifyitest.com/tdcnjun23/");//TDCN MAY 23
		 //loadUrl("http://regqc.sifyitest.com/tdcnjun23/");//TDCN MAY 23
		//loadUrl("http://regqc.sifyitest.com/cidcoacjun23/");//CIDCO June23
		//loadUrl("http://regqc.sifyitest.com/rcfmtjun23");//RCF June23
		//loadUrl("http://regqc.sifyitest.com/cidcoapr23");//CIDCO June23
		//loadUrl("http://regqc.sifyitest.com/giciojun23/");//GIC June23
		//loadUrl("http://regqc.sifyitest.com/psbjun23");//PSB June23
		//loadUrl("http://regqc.sifyitest.com/dsysjun23/");//DSYS June23
		//loadUrl("http://regqc.sifyitest.com/bmcjsmay23/");//BMC May23
		//loadUrl("http://regqc.sifyitest.com/mmoclfeb23/");//MMOCL/MMMM FEB23
		//loadUrl("http://regqc.sifyitest.com/igmmmay23/");//IGM 2 MAY 22
		//loadUrl("http://regqc.sifyitest.com/spmcilmay23/");//SPMCIL MAY 23
		//loadUrl("http://regqc.sifyitest.com/rbijemay23");//RBIJE MAY 23
		//loadUrl("http://regqc.sifyitest.com/crps23may23");//CRP MAY 23
		 // loadUrl("https://regqc.sifyitest.com/igmkmay23/");//IGM MAY 23
		//loadUrl("http://regqc.sifyitest.com/pmcrnsmay23/");//PMC MAY 23
		//loadUrl("http://regqc.sifyitest.com/cahmay23/");//CAH MAY 23
	
		return this; 
	}
	public BasicInfoPage clickNewRegistration() throws IOException, InterruptedException {
		//click(locateElement("link", readData(1, 0, "newSheetname")));
		click(locateElement("link", "basicInfo_link_eleNewReg"));
		return new BasicInfoPage(driver, test);   
	}
	public LoginPage enterRegistrationNumber(String data) throws IOException {
		//String readData = readData(1, 0, "newSheetname");
		typer(locateElement("basicInfo_id_txtregno"), data); 
		return this;
	} 
	public LoginPage enterPassword(String data) throws IOException, InterruptedException {
		//String readData = readData(2, 0, "newSheetname");
		typer(locateElement("basicInfo_id_txtpass"), data);
		return this; 
	}
	public CandidateBasicDetailsPage clickSubmit() throws InterruptedException, IOException {
		//click(locateElement(readData(3, 0, "newSheetName")));
		clickr(locateElement("basicInfo_id_submit"));  
		return new CandidateBasicDetailsPage(driver, test); 
	}
}



