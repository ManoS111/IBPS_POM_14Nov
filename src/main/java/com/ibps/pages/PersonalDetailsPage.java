package com.ibps.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class PersonalDetailsPage extends PreAndPost{

	public PersonalDetailsPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test; 
	}
	@FindBy(how=How.ID, using="seldobday") WebElement eleDate;
	@FindBy(how=How.ID, using="seldobmon") WebElement eleMonth;
	@FindBy(how=How.ID, using="seldobyear") WebElement eleYear;
	@FindBy(how=How.XPATH, using="//input[@id='optsex']/following-sibling::input") WebElement eleGender;
	@FindBy(how=How.XPATH, using="//input[@id='mstatus']") WebElement eleMaritalStatus;
	@FindBy(how=How.ID, using="fatherfirstname") WebElement eleFatherName;
	@FindBy(how=How.ID, using="motherfirstname") WebElement eleMotherName;
	@FindBy(how=How.ID, using="txtaddress1") WebElement eleAddCor;
	@FindBy(how=How.ID, using="txtdistrict") WebElement eleDistrict;
	@FindBy(how=How.ID, using="txtstate") WebElement eleState;
	@FindBy(how=How.ID, using="txtpin") WebElement elePincode;
	@FindBy(how=How.ID, using="txtpaddress1") WebElement elePreAdd;
	@FindBy(how=How.ID, using="same_presentadd") WebElement eleCheckBox;
	@FindBy(how=How.ID, using="txtpdistrict") WebElement elePreDistrict;
	@FindBy(how=How.ID, using="txtpstate") WebElement elePreState;
	@FindBy(how=How.ID, using="txtppin") WebElement elePrePincode;
	@FindBy(how=How.ID, using="gstState") WebElement eleGstState;
	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSavAndNext;

	public PersonalDetailsPage rowNumC1() {
		rowNumC1 = rowNumC1+1;
		System.out.println("Current Row Number Class1 >"+rowNumC1);
		//System.err.println("Increment row count >>"+rowNumC1);
		return this; 
	}

	public PersonalDetailsPage rowNumC2() {
		rowNumC2 = rowNumC2+1;
		System.out.println("Current Row Number Class2 >"+rowNumC2);
		return this; 
	}

	public PersonalDetailsPage rowNumC3() {
		rowNumC3 = rowNumC3+1;
		System.out.println("Current Row Number Class3 >"+rowNumC3);
		return this; 
	}

	public PersonalDetailsPage rowNumC4() {
		rowNumC4 = rowNumC4+1;
		System.out.println("Current Row Number Class4 >"+rowNumC4);
		return this; 
	}

	public PersonalDetailsPage rowNumC5() {
		rowNumC5 = rowNumC5+1;
		System.out.println("Current Row Number Class5 >"+rowNumC5);
		return this; 
	}
	public PersonalDetailsPage radioButtonId(String id, String selectableValue) throws InterruptedException {

		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.id(prop.getProperty(id)));
			for (WebElement webElement : radio) { 
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					webElement.click();
					break;
				}
			}
		} 
		return this;
	}
	public PersonalDetailsPage radioButtonIdwithAlert(String id, String selectableValue) throws InterruptedException {

		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.id(prop.getProperty(id)));
			for (WebElement webElement : radio) { 
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					webElement.click();
					break;
				}
			}
			Thread.sleep(1000);
			try {
			alertMsg();
			}catch (Exception e) {
			}
		} 
		return this;
	}
	public PersonalDetailsPage dateSelection1(String id, String date) throws Exception {
		// TODO Auto-generated method stub

		if(!date.equals("N/A"))
		{
		String[] dat = date.split("-");
		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");

		String[] ids = id.split("-");

		selectdropdown(ids[0], "Day");
		selectdropdown(ids[1], "Month");
		driver.findElement(By.id(ids[2])).sendKeys("Year");

		selectdropdown(ids[0], dat[0]);

		selectdropdown(ids[1], monthList.get(Integer.parseInt(dat[1]) - 1));

		driver.findElement(By.id(ids[2])).sendKeys(dat[2]);
		}
		return this;
	}
	
	public PersonalDetailsPage radioButtonxpath(String name, String selectableValue) {
		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.xpath(prop.getProperty(name)));
			for (WebElement webElement : radio) {
				String attribute = webElement.getAttribute("value");
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					webElement.click();
					break;
				}
			}
		}
		return this;
	}
	public PersonalDetailsPage radioButtonName(String name, String selectableValue) {

		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.name(prop.getProperty(name)));
			for (WebElement webElement : radio) {
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					webElement.click();
					break;
				}
			}
		}
		return this;
	}
	public PersonalDetailsPage radioButtonNameC(String name, String selectableValue) {

		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.name(prop.getProperty(name)));
			for (WebElement webElement : radio) {
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					if(!webElement.isSelected()) {
					webElement.click();
					}else {
						System.out.println("Already Selected");
					}
					break;
				}
			}
		}
		return this;
	}
	
	public PersonalDetailsPage radioButtonNameWithAlert(String name, String selectableValue) throws InterruptedException {

		if (!selectableValue.equalsIgnoreCase("N/A")) {
			List<WebElement> radio = driver.findElements(By.name(prop.getProperty(name)));
			for (WebElement webElement : radio) {
				if (webElement.getAttribute("value").trim().equals(selectableValue)) {
					webElement.click();
					break;
				}
			}
			alertMsg();
		}
		return this;
	}


	public PersonalDetailsPage enterPost(String data) {
		selectDropDownUsingIndex(locateElement("name", "selpost_name"), Integer.parseInt(data));
        return this;
	}
	public PersonalDetailsPage enterCircle(String data) {
		//selectDropDownUsingVisibleText(eleCircle, data);
		return this; 
	}
	public PersonalDetailsPage enterApplyState(String data) {
		//selectDropDownUsingVisibleText(eleApplyState, data);
		return this; 
	}
	public PersonalDetailsPage enterLanguage(String data) {
		//selectDropDownUsingVisibleText(eleLanguage, data);
		return this; 
	}
	public PersonalDetailsPage clickOfficalLanguage() throws InterruptedException {
		//click(ele10thCertificate);
		return this;
	}
	
	public PersonalDetailsPage clickCategory(String data) throws InterruptedException {
		System.out.println(data);
		if(data.equalsIgnoreCase("UR")) {
			click(locateElement("xpath", "eleCategory_UR_xpath")); 
		} else if (data.equalsIgnoreCase("GEN")) {
			click(locateElement("xpath", "eleCategory_GENERAL_xpath"));	
		}else if (data.equalsIgnoreCase("EWS")) {
			click(locateElement("xpath", "eleCategory_EWS_xpath"));	
		}else if (data.equalsIgnoreCase("OBC")) {
			click(locateElement("xpath", "eleCategory_OBC_xpath"));	
		}else if (data.equalsIgnoreCase("ST")) {
			click(locateElement("xpath", "eleCategory_ST_xpath"));	
		}else if (data.equalsIgnoreCase("SC")) {
			click(locateElement("xpath", "eleCategory_SC_xpath"));	
		} else {
			System.out.println("Category not matched");
		}
		//Thread.sleep(1000);
		alertMsg();
		//acceptAlert();
		return this;
	}
	public PersonalDetailsPage clickCategory1(String data) throws InterruptedException {
		System.out.println(data);
		List<WebElement> radio = driver.findElements(By.id("opt_cat"));
		for (WebElement webElement : radio) {
		if (webElement.getAttribute("value").trim().equals(data)) {
		webElement.click();
		break;
		}
		}
		//Thread.sleep(1000);
		alertMsg(); 
		alertMsg(); 
		//acceptAlert();
		return this;
	}
	
	public PersonalDetailsPage clickCategoryWithoutAlert(String data) throws InterruptedException {
		System.out.println(data);
		List<WebElement> radio = driver.findElements(By.id("opt_cat"));
		for (WebElement webElement : radio) {
		if (webElement.getAttribute("value").trim().equals(data)) {
		webElement.click();
		break;
		}
		}
		return this;
	}
	
	public PersonalDetailsPage clickCategory2(String data) throws InterruptedException {
		System.out.println(data);
		List<WebElement> radio = driver.findElements(By.id("appldcategory"));
		for (WebElement webElement : radio) {
		if (webElement.getAttribute("value").trim().equals(data)) {
		webElement.click();
		break;
		}
		}
		//Thread.sleep(1000);
		alertMsg();
		//acceptAlert();
		return this;
	}
	public void radioButtonId1(String id, String selectableValue) {
		// TODO Auto-generated method stub
		if (!selectableValue.equalsIgnoreCase("N/A")) {
		List<WebElement> radio = driver.findElements(By.id(id));
		for (WebElement webElement : radio) {
		if (webElement.getAttribute("value").trim().equals(selectableValue)) {
		webElement.click();
		break;
		}
		}
		}
		}
	public PersonalDetailsPage alertAccept() throws InterruptedException {
		String text = "";		
		try {
			Thread.sleep(5000); 
			Alert alert = driver.switchTo().alert();
			//text = alert.getText();
			alert.accept();
			Thread.sleep(2000); 
			//reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			//reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			////reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
		return this;
	}
	public PersonalDetailsPage clickDisability() throws InterruptedException {
		click(locateElement("xpath", "opt_no_xpath")); 
		
		
		return this;
	}
	public PersonalDetailsPage clickDisabilitySuffersoc() throws InterruptedException {
		click(locateElement("disabilitysuffersoc2_id"));
		return this;
	}
	public PersonalDetailsPage clickOptKashmir() throws InterruptedException {
		click(locateElement("xpath", "kashmir_no_xpath"));  
		return this;
	}
	public PersonalDetailsPage clickReligiousMinorityCommunity() throws InterruptedException {
		click(locateElement("xpath", "ReligiousMinorityCommunity_xpath"));
		return this;
	} 
	/*public PersonalDetailsPage selectStateOfExamination() throws InterruptedException {
		selectDropDownUsingVisibleText(locateElement("selstateapplied_id"), "DELHI ");
		Thread.sleep(1000);
		return this;  
	}
	public PersonalDetailsPage selectCenterOfExamination(String data) {
		selectDropDownUsingVisibleText(locateElement("selexamcentre_id"), "DELHI"); 
		return new PersonalDetailsPage(driver,test);  
	}*/
	public PersonalDetailsPage clickDeptCandidate() throws InterruptedException {
		click(locateElement("xpath", "dept_candidate_xpath"));
		return this;
	} 
	public PersonalDetailsPage clickCompensatory() throws InterruptedException {
		click(locateElement("xpath","compensatory_xpath"));
		return this;
	} 
	public PersonalDetailsPage clickCompensataryTime2() throws InterruptedException {
		click(locateElement("compensatary_time2_id"));
		return new PersonalDetailsPage(driver, test);
	}
	public PersonalDetailsPage ageValidatorMax(int rowNumC, String givenDate, String dataSheet,  String sheet) throws Exception {
		agevalidator_max(rowNumC, "IBPS_personalDOB_id", givenDate,dataSheet, sheet);
		return this; 
	}
	
	public PersonalDetailsPage ageValidatorMin(int rowNumC, String givenDate, String dataSheet, String sheet) throws Exception {
		agevalidator_min(rowNumC, "IBPS_personalDOB_id", givenDate, dataSheet, sheet);
		return this; 
	}
	public PersonalDetailsPage ageValidatorLeapyear(int rowNumC, String givenDate, String dataSheet, String sheet) throws Exception {
		agevalidator_leapyear(rowNumC, "IBPS_personalDOB_id", givenDate, dataSheet, sheet);
		Thread.sleep(1000); 
		return this; 
	}
	public PersonalDetailsPage ageValidatorAsOnDate(int rowNumC,String givenDate, String dataSheet, String sheet) throws Exception {
		agevalidator_asondate(rowNumC, "IBPS_personalDOB_id", givenDate, dataSheet, sheet);
		return this;  
	}
	//*********************************************************
	
	public PersonalDetailsPage aadharValidator(int rowNumC, String dataSheet,  String sheet) throws Exception {
		aadharvalidator(rowNumC, dataSheet, sheet);
		return this; 
	}
	
	public PersonalDetailsPage mobNoValidator(int rowNumC, String url, String dataSheet,  String sheet) throws Exception {
		mobilenovalidator(rowNumC,  url,dataSheet, sheet);
		return this; 
	}
	
	public PersonalDetailsPage startapp(String browser) throws Exception {
		startApp( browser);
		return this; 
	}
	
	public PersonalDetailsPage loadurl(String url)  throws Exception {
		loadUrl(url);
		return this; 
	}
	
	///************************************************************

	public PersonalDetailsPage clickDetailsButton() throws InterruptedException {
		Thread.sleep(4000);  
		click(locateElement("xpath", "details_xpath_button"));
		return this;
	}
	
	public PersonalDetailsPage clickRegistration1btn() throws InterruptedException {
		Thread.sleep(4000);  
		click(locateElement("xpath", "IBPS_DrdoRegistration1btn"));
		return this;
	}
	public PersonalDetailsPage clickPreliminarybtn() throws InterruptedException {
		Thread.sleep(4000);  
		click(locateElement("xpath", "IBPS_BARCPreliminary"));
		return this;
	}
	public PersonalDetailsPage clickProfilebtn() throws InterruptedException {
		Thread.sleep(3000);  
		click(locateElement("xpath", "IBPS_Bihar_Profile"));
		return this;
	}
	public PersonalDetailsPage clickNextbtn() throws InterruptedException {
		Thread.sleep(500);  
		click(locateElement("xpath", "eleBasicNextBtn_xpath"));
		Thread.sleep(1000);  
		return this;
	}
	public PersonalDetailsPage selectDropDownUsingIndexNew(WebElement ele, String index) throws InterruptedException {
		try {
			if (!index.equalsIgnoreCase("N/A")) {
				int indvalue=Integer.parseInt(index);
			new Select(ele).selectByIndex(indvalue);
			Thread.sleep(2000);
			//reportStep("The dropdown is selected with index "+index,"PASS");
		} }catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		try {
			acceptAlert();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	}
	public PersonalDetailsPage selectDropDownUsingIndexNewwithAlert(WebElement ele, String index) throws InterruptedException {
		Thread.sleep(2000);
		try {
			if (!index.equalsIgnoreCase("N/A")) {
				int indvalue=Integer.parseInt(index);
				new Select(ele).selectByIndex(indvalue);
				//reportStep("The dropdown is selected with index "+index,"PASS");
			} }catch (WebDriverException e) {
				//reportStep("The element: "+ele+" could not be found.", "FAIL");
			} 
		
		acceptAlert();
		return this;
	} 

	
	public PersonalDetailsPage selectDropDownUsingVisibleTextNew(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			//reportStep("The dropdown is selected with text "+value,"PASS");
		}catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		return this;
	} 

	public PersonalDetailsPage clickNew(WebElement ele) throws InterruptedException {
		String text = "";
		try {
			/*Thread.sleep(500);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));*/			
			text = ele.getText();
			ele.click();
			//reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			//reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
		return this; 
	}
	public PersonalDetailsPage inputTextId(String id, String inputText) throws Exception {
		Thread.sleep(2000); 
		if (!inputText.equalsIgnoreCase("N/A")) {
			driver.findElement(By.id(prop.getProperty(id))).clear();
			driver.findElement(By.id(prop.getProperty(id))).sendKeys(inputText.trim());
		} 
		return this; 
	}
	public PersonalDetailsPage inputTextXpath(String id, String inputText) throws Exception {
		Thread.sleep(2000); 
		if (!inputText.equalsIgnoreCase("N/A")) {
			driver.findElement(By.xpath(prop.getProperty(id))).clear();
			driver.findElement(By.xpath(prop.getProperty(id))).sendKeys(inputText.trim());
		} 
		return this; 
	}
	public PersonalDetailsPage enterReligion(String data) {
		selectDropDownUsingIndex(locateElement("religion_id"), Integer.parseInt(data));  
		return this; 
	}
	public PersonalDetailsPage clickExServiceMan() throws InterruptedException {
		click(locateElement("xpath", "exservice_xpath"));
		return this; 
	}

	/*public PersonalDetailsPage enterDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(locateElement("seldobday_id"), date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(locateElement("seldobmon_id"), month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(locateElement("seldobyear_id"), year);
		Thread.sleep(2000);
		//acceptAlert();
		return this;
	}*/
	public PersonalDetailsPage clickGender() throws InterruptedException {
		click(locateElement("xpath", "gender_xpath"));
		return this;
	}
	public PersonalDetailsPage clickMaritalStatus() throws InterruptedException {
		click(locateElement("xpath", "mstatus_xpath"));  
		return this;
	}
	public PersonalDetailsPage enterFatherName(String data) {
		type(locateElement("fatherfirstname_id"), data);
		return this;
	}
	public PersonalDetailsPage enterMotherName(String data) {
		type(locateElement("motherfirstname_id"), data);
		return this;
	}
	public PersonalDetailsPage enterAddressForCorrespondence(String data) {
		type(locateElement("txtaddress1_id"), data);
		return this;
	}
	public PersonalDetailsPage enterCorspDistrict(String data) {
		type(locateElement("txtdistrict_id"), data);
		return this;
	}
	public PersonalDetailsPage enterStreet() {
		type(locateElement("txtpaddress1_id"), "Ramayalam(st)");
		return this;
	}
	public PersonalDetailsPage enterCorspState(String data) {
		//selectDropDownUsingVisibleText(locateElement("txtstate_id"), data);
		return this;
	}
	public PersonalDetailsPage enterCorspPincode(String data) {
		type(locateElement("txtpin_id"), data);
		return this;
	}
	public PersonalDetailsPage permanentAddress(String data) {
		type(locateElement("txtpaddress1_id"), data);
		return this;
	}
	public PersonalDetailsPage enterPerDistrict(String data) throws InterruptedException {
		Thread.sleep(2000);
		//click(eleCheckBox); 
		type(locateElement("txtpdistrict_id"), data);
		return this;
	}
	public PersonalDetailsPage enterPerpState(String data) {
		//selectDropDownUsingVisibleText(locateElement("txtpstate_id"), data);
		return this;
	}
	public PersonalDetailsPage enterPrePincode(String data) throws InterruptedException {
		Thread.sleep(2000);
		type(locateElement("txtppin_id"), data);
		return this;
	}
	public PersonalDetailsPage enterGstState(String data) {
		//selectDropDownUsingVisibleText(locateElement("gstState_id"), data);
		return this;
	}
	public PersonalDetailsPage clickButtonNew(String xPath) throws Exception{
		//alert();
		driver.findElement(By.xpath(prop.getProperty(xPath))).click(); 
		waitUntilPageloads();
		return this;  
	}
	public EducationDetailsPage clickSaveAndNext() throws InterruptedException {
		click(locateElement("FinalSubmit_id")); 
		return new EducationDetailsPage(driver, test); 
	}
	
	public boolean isAlertPresent() {
		//TODO Alert check & returns boolean
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


public void alertcheck() throws InterruptedException {
		//TODO Alert check & accept with log

		if (isAlertPresent()) {
			Thread.sleep(2000);
			String text = driver.switchTo().alert().getText();
			System.out.println("Alerrt >>"+text);
			driver.switchTo().alert().accept();	
		
		}
	}
public PersonalDetailsPage radioButtonIdWithAlert(String id, String selectableValue) throws InterruptedException {
	System.out.println("***"+id);
	if (!selectableValue.equalsIgnoreCase("N/A")) {
		List<WebElement> radio = driver.findElements(By.id(prop.getProperty(id)));
		for (WebElement webElement : radio) { 
			if (webElement.getAttribute("value").trim().equals(selectableValue)) {
				webElement.click();
				if (isAlertPresent()) {
					Thread.sleep(2000);
					String text = driver.switchTo().alert().getText();
					System.out.println("Alerrt >>"+text);
					driver.switchTo().alert().accept();	
				
				}
				
				break;
			}
		}
	} 
	return this;
}

public PersonalDetailsPage radioButtonNameWithPopup(String name, String selectableValue) throws InterruptedException {

	if (!selectableValue.equalsIgnoreCase("N/A")) {
		List<WebElement> radio = driver.findElements(By.name(prop.getProperty(name)));
		for (WebElement webElement : radio) {
			if (webElement.getAttribute("value").trim().equals(selectableValue)) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(300);
		if(selectableValue.equalsIgnoreCase("Y")) {
			driver.findElement(By.xpath("//*[@class='close']")).click();	
		}
	
	}
	return this;
}	

public PersonalDetailsPage selectDropDownUsingValueNew(WebElement ele, String value) throws InterruptedException {
	try {
		if (!value.equalsIgnoreCase("N/A")) {
			//int indvalue=Integer.parseInt(index);
		new Select(ele).selectByValue(value);
		Thread.sleep(2000);
		//reportStep("The dropdown is selected with index "+index,"PASS");
	} }catch (WebDriverException e) {
		//reportStep("The element: "+ele+" could not be found.", "FAIL");
	} 
	try {
		acceptAlert();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return this;
}
public PersonalDetailsPage getCategory(String dataSheetName, String sheetNameTC) throws Exception {
	try {
	
	int size = driver.findElements(By.xpath("//*[@id='selpost']/option")).size();
	//int size=2;
	int rowstart=1; int colstart0=0;
	System.out.println("No of Post >"+(size-1));
	
	for(int p=1;p<size;p++) {
		new Select(driver.findElement(By.id("selpost"))).selectByIndex(p);
		String selectedPost = new Select(driver.findElement(By.id("selpost"))).getFirstSelectedOption().getText();
		writeDataNoC(rowstart, colstart0, selectedPost,dataSheetName, sheetNameTC);
		
		List<WebElement> catEnablelist = driver.findElements(By.xpath("//*[@id='opt_cat' and not(@disabled='disabled')]"));
		int categorySize = catEnablelist.size();
		
		for(int c=1;c<=categorySize;c++) {
			WebElement cat = driver.findElement(By.xpath("(//*[@id='opt_cat' and not(@disabled='disabled')])["+c+"]"));
			cat.click();
			String attribute1 = cat.getAttribute("value");
			
			int colstart1=1;
			writeDataNoC(rowstart, colstart1, attribute1,dataSheetName, sheetNameTC);
			
			List<WebElement> appCatEnablelist = driver.findElements(By.xpath("//*[@id='apply_category' and not(@disabled='disabled')]"));
			int appCatSize = appCatEnablelist.size();
			
			for(int ac=1;ac<=appCatSize;ac++) {
				WebElement appcat = driver.findElement(By.xpath("(//*[@id='apply_category' and not(@disabled='disabled')])["+ac+"]"));
				appcat.click();
				String attribute2 = appcat.getAttribute("value");
				int colstart2=2;
				if(ac==1) {
					writeDataNoC(rowstart, colstart2, attribute2,dataSheetName, sheetNameTC);
				}else if(ac==2){
					writeDataNoC(rowstart, colstart2+1, attribute2,dataSheetName, sheetNameTC);
				}else {
					writeDataNoC(rowstart, colstart2+2, Integer.toString(appCatSize),dataSheetName, sheetNameTC);
				}
			
			}		
			rowstart++;
		}	
		rowstart++;
	}
	}catch(Exception e) {System.out.println(e.getMessage());}
	
	return this;
}
//****************************************************************************
public boolean isEnabled(String ele) {
	try {
		driver.findElement(By.id(prop.getProperty(ele))).isEnabled();
		return true;
	} catch (WebDriverException e) {
		return false;
	}
}
public boolean isDisplayed(String ele) {
	try {
		driver.findElement(By.id(prop.getProperty(ele))).isDisplayed();
		return true;
	} catch (WebDriverException e) {
		return false;
	}
}
public boolean isSelected(String ele) {
	try {
		driver.findElement(By.id(prop.getProperty(ele))).isSelected();
		return true;
	} catch (WebDriverException e) {
		return false;
	}
}

public PersonalDetailsPage getCategory2(String dataSheetName, String sheetNameTC) throws Exception {
	try {
	
	int size = driver.findElements(By.xpath("//*[@id='selpost']/option")).size();
	//int size=2;
	int rowstart=1; int colstart0=0; int temp=0;
	System.out.println("No of Post >"+(size-1));
	
		for(int p=1;p<size;p++) {
		new Select(driver.findElement(By.id("selpost"))).selectByIndex(p);
		String selectedPost = new Select(driver.findElement(By.id("selpost"))).getFirstSelectedOption().getText();
		writeDataNoC(rowstart, colstart0, selectedPost,dataSheetName, sheetNameTC);
		
		 List<WebElement> catEnablelist = driver.findElements(By.xpath("//*[@id='opt_cat' and not(@disabled='disabled')]"));
		int categorySize = catEnablelist.size();
		
	retest:		for(int c=1;c<=categorySize;c++) {
			WebElement cat = driver.findElement(By.xpath("(//*[@id='opt_cat' and not(@disabled='disabled')])["+c+"]"));
			cat.click();
			String attribute1 = cat.getAttribute("value");
			
			//int colstart1=1;
			writeDataNoC(rowstart, colstart0+1, attribute1,dataSheetName, sheetNameTC);
			
			List<WebElement> appCatEnablelist = driver.findElements(By.xpath("//*[@id='apply_category' and not(@disabled='disabled')]"));
			int appCatSize = appCatEnablelist.size();
			
			for(int ac=1;ac<=appCatSize;ac++) {
				WebElement appcat = driver.findElement(By.xpath("(//*[@id='apply_category' and not(@disabled='disabled')])["+ac+"]"));
				appcat.click();
				String attribute2 = appcat.getAttribute("value");
				//int colstart2=2;||colstart2 ||colstart2+1||colstart2+2
				
				if(ac==1) {
					writeDataNoC(rowstart, colstart0+2, attribute2,dataSheetName, sheetNameTC);
				}else if(ac==2){
					writeDataNoC(rowstart, colstart0+3, attribute2,dataSheetName, sheetNameTC);
				}else {
					writeDataNoC(rowstart, colstart0+4, Integer.toString(appCatSize),dataSheetName, sheetNameTC);
				}
				if(temp==1) {
					break;
				}
//********************************************************************************
				radioButtonNameC("IBPS_disablilty_id", "N");
				radioButtonNameC("IBPS_emp_zilla", "N");
				radioButtonNameC("IBPS_state_govemp", "N");
				if((attribute2.equalsIgnoreCase("VJA"))||(attribute2.equalsIgnoreCase("NTB"))
						||(attribute2.equalsIgnoreCase("NTC"))||(attribute2.equalsIgnoreCase("NTD")
						||attribute2.equalsIgnoreCase("OBC")||(attribute2.equalsIgnoreCase("SBC"))		
						)) {
					radioButtonNameC("IBPS_noncreamy", "Y");
					
				}
				if(attribute2.equalsIgnoreCase("SC")||attribute2.equalsIgnoreCase("ST")
						||(attribute2.equalsIgnoreCase("VJA"))||attribute2.equalsIgnoreCase("NTB")
						||(attribute2.equalsIgnoreCase("NTC"))||(attribute2.equalsIgnoreCase("NTD"))
						||attribute2.equalsIgnoreCase("OBC")||(attribute2.equalsIgnoreCase("SBC"))
						) {
					radioButtonNameC("IBPS_CasteCertificate", "Y");
				}
				if(attribute2.equalsIgnoreCase("EWS")) {
					radioButtonNameC("IBPS_ewscert", "Y");
				}
				if(!(attribute2.equalsIgnoreCase("EWS")||attribute2.equalsIgnoreCase("OPEN"))) {
					radioButtonNameC("IBPS_castvalcert", "Y");
				}
				
				radioButtonNameC("IBPS_apply_qualification", "Y");
				
				radioButtonNameC("IBPS_exServiceman_name", "N");
				radioButtonNameC("IBPS_DisabledExService", "N");
				inputTextId("IBPS_exServicePeriod_id", "N/A");
				radioButtonNameC("IBPS_relax_remarried_name", "N");
				radioButtonNameC("IBPS_sports_person", "N");
				radioButtonNameC("IBPS_prjaffect_person", "N");
				radioButtonNameC("IBPS_earthquakeaffect_person", "N");
				radioButtonNameC("IBPS_PartTime", "N");
				radioButtonNameC("IBPS_orphan", "N");
				radioButtonNameC("IBPS_domicile", "Y");
				radioButtonNameC("IBPS_domicle_maharastra_state", "N");
				radioButtonNameC("IBPS_marathi_speaking", "Y");
				boolean enabled1 = isEnabled("IBPS_pesa_govt");
				if(enabled1) {
					System.out.println("Zilla Parshad Enabled");
					radioButtonNameC("IBPS_pesa_govt", "Y");
				}
				boolean enabled2 = isEnabled("IBPS_govt_technical_edu");
				if(enabled2) {
					System.out.println("govt_technical_edu Enabled");
					radioButtonNameC("IBPS_govt_technical_edu", "Y");
				}
				
				radioButtonNameC("IBPS_freedom_fighter", "N");
				radioButtonNameC("IBPS_emp_census", "N");
				radioButtonNameC("IBPS_emp_electionduty", "N"); 
				radioButtonNameC("IBPS_govt_technical_edu", "N");
				radioButtonNameC("IBPS_recruitment_process", "N");
				radioButtonNameC("IBPS_family_member", "N");
				radioButtonNameC("IBPS_suicide_declared", "N");
				selectDropDownUsingIndexNew(locateElement("IBPS_religion_id"),"1");
				radioButtonNameC("IBPS_optaadhar_id","N");
				//radioButtonName("IBPS_minority_id","N");
				selectDropDownUsingIndexNew(locateElement("IBPS_selexamcentre_id"),"1");
				selectDropDownUsingIndexNew(locateElement("IBPS_selexamcenter2"),"3");
				selectDropDownUsingIndexNew(locateElement("IBPS_selexamcenter3"),"5");
				
				selectDropDownUsingIndexNew(locateElement("seldobday_id"),"2");
				selectDropDownUsingIndexNew(locateElement("seldobmon_id"),"4");
				selectDropDownUsingIndexNew(locateElement("seldobyear_id"),"6");
				radioButtonNameC("rgender_id","M");
				radioButtonNameC("IBPS_twinbrosis","N");
				radioButtonNameC("IBPS_mstatus","Unmarried");
				inputTextId("fatherfirstname_id", "AABBCC");
				inputTextId("motherfirstname_id", "DDEEFF");
				inputTextId("txtaddress1_id", "Addr1");
				inputTextId("txtdistrict_id", "District1");
				selectDropDownUsingIndexNew(locateElement("txtstate_id"),"744000");
				radioButtonNameC("same_presentadd_id","same");
				selectDropDownUsingIndexNew(locateElement("gstState_id"),"1");
				click(locateElement("FinalSubmit_id"));
				
				boolean enabled3 = isDisplayed("IBPS_QulificationPge_Xp");
				if(enabled3) {
					System.out.println("QulificationPge Displayed");
					temp=1;
				}
				clickButton("//*[@type='button' and contains(text(),'Back')]");
				
				boolean enabled4 = isDisplayed("IBPS_HeaderBasicDetails_xp");
				if(enabled4) {
					System.out.println("Basic Page Displayed");
				}
				
				if(temp==1) {
					//temp=0;
					continue retest;
				}
//********************************************************************************	
			}
			rowstart++;
		}	
		rowstart++;
	}
	}catch(Exception e) {System.out.println(e.getMessage());}
	
	return this;
}

	
public PersonalDetailsPage getCategory1(String dataSheetName, String sheetNameTC) throws Exception {
	String userDir = System.getProperty("user.dir"); 
	//XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
	//XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
	//int size = driver.findElements(By.xpath("//*[@id='selpost']/option")).size();
	int size=2;
	System.out.println("No of Post >"+size);
	for(int p=1;p<size;p++) {
		new Select(driver.findElement(By.id("selpost"))).selectByIndex(12);
		String selectedPost = new Select(driver.findElement(By.id("selpost"))).getFirstSelectedOption().getText();
		System.out.println(selectedPost);
		
		List<WebElement> catEnablelist = driver.findElements(By.xpath("//*[@id='opt_cat' and not(@disabled='disabled')]"));
		int categorySize = catEnablelist.size();
		System.out.println("Category Size :"+categorySize);
		
		for(int c=1;c<=categorySize;c++) {
			WebElement cat = driver.findElement(By.xpath("(//*[@id='opt_cat' and not(@disabled='disabled')])["+c+"]"));
			cat.click();
			String attribute = cat.getAttribute("value");
			System.out.println("Selected cat :"+attribute);
			
			List<WebElement> appCatEnablelist = driver.findElements(By.xpath("//*[@id='apply_category' and not(@disabled='disabled')]"));
			int appCatSize = appCatEnablelist.size();
			
			for(int ac=1;ac<=appCatSize;ac++) {
				WebElement appcat = driver.findElement(By.xpath("(//*[@id='apply_category' and not(@disabled='disabled')])["+ac+"]"));
				appcat.click();
				String attribute2 = appcat.getAttribute("value");
				System.out.println("Selected Applied cat :"+attribute2);
			}		
			
		}	
		
	}
	return this;
}



}
