package com.ibps.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;
import lib.utils.WriteData;

public class EducationDetailsPage extends PreAndPost{

	public EducationDetailsPage(RemoteWebDriver driver, ExtentTest test) {
		//PageFactory.initElements(driver, this);
				this.driver = driver;
				this.test = test;
	}
	
	@FindBy(how=How.ID, using="selstream3") WebElement eleGraduation;
	@FindBy(how=How.ID, using="seluniv3") WebElement eleGraduationCollege;
	@FindBy(how=How.ID, using="selday3") WebElement eleGraduationDay;
	@FindBy(how=How.ID, using="selmonth3") WebElement eleGraduationMonth;
	@FindBy(how=How.ID, using="selyr3") WebElement eleGraduationYear;
	@FindBy(how=How.ID, using="selmark3") WebElement eleGraduationPercentage;
	@FindBy(how=How.ID, using="selgrade3") WebElement eleGraduationGrade;
	@FindBy(how=How.ID, using="err_3") WebElement eleErrMsg;
	
	/*public EducationDetailsPage enterGraduation1(String data) {
	    selectDropDownUsingVisibleText(eleGraduation, data);
		return this;
	}
	public EducationDetailsPage enterGradutationCollge(String data) {
		type(eleGraduationCollege, data);
		return this;
	}
	public EducationDetailsPage enterGraduationDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleGraduationDay, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleGraduationMonth, month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleGraduationYear, year);
		return this;
	}
	public EducationDetailsPage enterGradutationPerecentage(String data) {
		type(eleGraduationPercentage, data);
		return this;
	}
	public EducationDetailsPage enterGradutationGrade(String data) {
		 selectDropDownUsingVisibleText(eleGraduationGrade, data);
		return this;
	}*/
	public EducationDetailsPage enterGraduation(String data) {
	    WebElement element = locateElement("selstream3"); 
		element.sendKeys(data);
		element.sendKeys(Keys.ENTER);
		return this;
	}
	public EducationDetailsPage enterGraduationDay(String date, String month, String year) throws InterruptedException {
		WebElement eleDay = locateElement("selday3");
		eleDay.sendKeys(date);
		eleDay.sendKeys(Keys.ENTER); 
		WebElement eleMonth = locateElement("selmonth3");
		eleMonth.sendKeys(month);
		eleMonth.sendKeys(Keys.ENTER);
		WebElement eleYear = locateElement("selyr3");
		eleYear.sendKeys(year);
		eleYear.sendKeys(Keys.ENTER);
		return this;
	}
	public EducationDetailsPage enterGradutationgrade(String data) {
		 WebElement eleDay = locateElement("selgrade3");
			eleDay.sendKeys(data);
			eleDay.sendKeys(Keys.ENTER);
		return this;
	}
	public void graduationNegativeValidation(String errorMsg, String scenario ) throws InterruptedException {
		switch (scenario) {
		case "1": 
			Thread.sleep(2000);
			String grdErrorMsg = eleErrMsg.getText().trim();
			if (grdErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		case "2": 
			Thread.sleep(2000);
			String collegeErrorMsg = eleErrMsg.getText();
			if (collegeErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		case "3": 
			Thread.sleep(2000);
			String dateErrorMsg = eleErrMsg.getText().trim();
			if (dateErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		case "4": 
			Thread.sleep(2000);
			String marksErrorMsg = eleErrMsg.getText();
			if (marksErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		case "5": 
			Thread.sleep(2000);
			String gradeErrorMsg = eleErrMsg.getText().trim();
			if (gradeErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		case "6": 
			Thread.sleep(2000);
			String invaliedDateErrorMsg = eleErrMsg.getText().trim();
			if (invaliedDateErrorMsg.contains(errorMsg)) { 
				reportStep("Error msg success", "PASS"); 
			} else {
				reportStep("Issue with Invalid Check", "FAIL");
			}
			break;
		}
	}
	
	public void graduationErrorMsgCapture(String errorMsg, String scenario ) throws InterruptedException {
		switch (scenario) {
		case "1": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText().trim();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 1, errorMsg);
			break;
		case "2": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 2, errorMsg);
			break;
		case "3": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText().trim();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 3, errorMsg);
			break;
		case "4": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 4, errorMsg);
			break;
		case "5": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText().trim();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 5, errorMsg);
			break;
		case "6": 
			Thread.sleep(2000);
			errorMsg = eleErrMsg.getText().trim();
			WriteData.writeData("EducationDetailsErrorMsgCapture", 9, 6, errorMsg);
			break;
		}
	}
	
	
	@FindBy(how=How.ID, using="selstream7") WebElement eleDualDegree;
	@FindBy(how=How.ID, using="seluniv7") WebElement eleDualDegreeCollege;
	@FindBy(how=How.ID, using="selday7") WebElement eleDualDegreeDay;
	@FindBy(how=How.ID, using="selmonth7") WebElement eleDualDegreeMonth;
	@FindBy(how=How.ID, using="selyr7") WebElement eleDualDegreeYear;
	@FindBy(how=How.ID, using="selmark7") WebElement eleDualDegreePercentage;
	@FindBy(how=How.ID, using="selgrade7") WebElement eleDualDegreeGrade;
	/*public EducationDetailsPage enterDualDegree(String data) {
	    selectDropDownUsingVisibleText(eleDualDegree, data);
		return this;
	}
	public EducationDetailsPage enterDualDegreeCollge(String data) {
		type(eleDualDegreeCollege, data);
		return this;
	}
	public EducationDetailsPage enterDualDegreeDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleDualDegreeDay, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleDualDegreeMonth, month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleDualDegreeYear, year);
		return this;
	}
	public EducationDetailsPage enterDualDegreePerecentage(String data) {
		type(eleDualDegreePercentage, data);
		return this;
	}
	public EducationDetailsPage enterDualDegreeGrade(String data) {
		 selectDropDownUsingVisibleText(eleDualDegreeGrade, data);
		return this;
	}*/
	
	
	@FindBy(how=How.ID, using="selstream4") WebElement elePostGraduation;
	@FindBy(how=How.ID, using="seluniv4") WebElement elePostGraduationCollege;
	@FindBy(how=How.ID, using="selday4") WebElement elePostGraduationDay;
	@FindBy(how=How.ID, using="selmonth4") WebElement elePostGraduationMonth;
	@FindBy(how=How.ID, using="selyr4") WebElement elePostGraduationYear;
	@FindBy(how=How.ID, using="selmark4") WebElement elePostGraduationPercentage;
	@FindBy(how=How.ID, using="selgrade4") WebElement elePostGraduationGrade;
	public EducationDetailsPage enterPostGraduation(String data) {
	    type(elePostGraduation, data);
		return this;
	}
	/*public EducationDetailsPage enterPostGraduationCollge(String data) {
		type(elePostGraduationCollege, data);
		return this;
	}
	public EducationDetailsPage enterPostGraduationDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(elePostGraduationDay, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(elePostGraduationMonth, month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(elePostGraduationYear, year);
		return this;
	}
	public EducationDetailsPage enterPostGraduationPerecentage(String data) {
		type(elePostGraduationPercentage, data);
		return this;
	}
	public EducationDetailsPage enterPostGraduationGrade(String data) {
		 selectDropDownUsingVisibleText(elePostGraduationGrade, data);
		return this;
	}*/
	
	
	@FindBy(how=How.ID, using="selstream5") WebElement eleProfessionalQualification;
	@FindBy(how=How.ID, using="seluniv5") WebElement eleProfessionalQualificationCollege;
	@FindBy(how=How.ID, using="selday5") WebElement eleProfessionalQualificationDay;
	@FindBy(how=How.ID, using="selmonth5") WebElement eleProfessionalQualificationMonth;
	@FindBy(how=How.ID, using="selyr5") WebElement eleProfessionalQualificationYear;
	@FindBy(how=How.ID, using="selmark5") WebElement eleProfessionalQualificationPercentage;
	@FindBy(how=How.ID, using="selgrade5") WebElement eleProfessionalQualificationGrade;
	public EducationDetailsPage enterProfessionalQualification(String data) {
	    type(eleProfessionalQualification, data);
		return this;
	}
	public EducationDetailsPage enterProfessionalQualificationCollge(String data) {
		type(eleProfessionalQualificationCollege, data);
		return this;
	}
	/*public EducationDetailsPage enterProfessionalQualificationDate(String date, String month, String year) throws InterruptedException {
		selectDropDownUsingVisibleText(eleProfessionalQualificationDay, date);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleProfessionalQualificationMonth, month);
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(eleProfessionalQualificationYear, year);
		return this;
	}
	public EducationDetailsPage enterProfessionalQualificationPerecentage(String data) {
		type(eleProfessionalQualificationPercentage, data);
		return this;
	}
	public EducationDetailsPage enterProfessionalQualificationGrade(String data) {
		 selectDropDownUsingVisibleText(eleProfessionalQualificationGrade, data);
		return this;
	}*/
	
	
	
	@FindBy(how=How.ID, using="FinalSubmit") WebElement eleSaveButton;
	public EducationDetailsPage clickSaveAndNext() throws InterruptedException {
		click(eleSaveButton);
		return this; 
	}
	
}



































