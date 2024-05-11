package lib.selenium;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import junit.framework.Assert;
import lib.utils.HTMLReporter;


public class WebDriverServiceImpl extends HTMLReporter implements WebDriverService{

	public RemoteWebDriver driver;
	public Properties prop;
	//public static String location ="local";
	//public static String location ="linux";
	public static String location ="Eclipse";

	public WebDriverServiceImpl() {
		prop = new Properties();
		try {
			if(location.equalsIgnoreCase("local")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/classes/locators.properties")));
			}else if(location.equalsIgnoreCase("linux")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/classes/locators.properties")));
			}else {
				prop.load(new FileInputStream(new File("./src/main/resources/locators.properties")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp(String browser, String url) throws Exception {
		try {
		if(location.equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("chrome")){
				System.out.println("Location Local");
				System.setProperty("webdriver.chrome.driver", "/classes/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}	
		}else if(location.equalsIgnoreCase("linux")) {
			if(browser.equalsIgnoreCase("chrome")){
				System.out.println("Location linux");
				 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	                ChromeOptions chromeOptions = new ChromeOptions();
	                //chromeOptions.addArguments("--headless");
	                chromeOptions.addArguments("--no-sandbox");
	 
	                WebDriver driver = new ChromeDriver(chromeOptions);
	                Thread.sleep(1000);
	                driver.get("https://google.com");
	 
	          /*     Thread.sleep(1000);
				System.setProperty("webdriver.chrome.driver", "/classes/drivers/chromedriver.exe");
				driver = new ChromeDriver(); */
			}	
		}else {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//reportStep("The browser: "+browser+" launched successfully", "PASS");
		} catch (WebDriverException e) {			
			//reportStep("The browser: "+browser+" could not be launched", "FAIL");
		}
		}}catch(WebDriverException e1) {}
	}

	public void startApp(String browser) throws Exception {
		try {
			if(location.equalsIgnoreCase("local")) {
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/classes/drivers/chromedriver.exe");
					ChromeOptions op = new ChromeOptions();
					op.addArguments("disable-infobars");
					driver = new ChromeDriver(op);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
				}	
			}else if(location.equalsIgnoreCase("linux")) {
				if(browser.equalsIgnoreCase("chrome")){
					System.out.println("Location linux");
					 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		                ChromeOptions chromeOptions = new ChromeOptions();
		                //chromeOptions.addArguments("--headless");
		                chromeOptions.addArguments("--no-sandbox");
		 
		                driver = new ChromeDriver(chromeOptions);
		                Thread.sleep(500);
		                driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
				}	}
			else {
		
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions op = new ChromeOptions();
				op.addArguments("disable-infobars");
				driver = new ChromeDriver(op);
			}else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			}
				}catch(WebDriverException e1) {}
	}
	public void loadUrl(String url) {
		try {
			driver.get(url); 
			//reportStep("The url: "+url+" launched successfully", "PASS");
		} catch (Exception e) {
			//reportStep("The url: "+url+" could not be launched", "FAIL");
		}
	}
	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElementById(prop.getProperty(locValue));
			case "name": return driver.findElementByName(prop.getProperty(locValue));
			case "class": return driver.findElementByClassName(prop.getProperty(locValue));
			case "link" : return driver.findElementByLinkText(prop.getProperty(locValue));
			case "xpath": return driver.findElementByXPath(prop.getProperty(locValue));
			case "tagname": return driver.findElementByTagName(prop.getProperty(locValue));
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			//reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}
	public List<WebElement> locateElements(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElementsById(prop.getProperty(locValue));
			case "name": return driver.findElementsByName(prop.getProperty(locValue));
			case "class": return driver.findElementsByClassName(prop.getProperty(locValue));
			case "link" : return driver.findElementsByLinkText(prop.getProperty(locValue));
			case "xpath": return driver.findElementsByXPath(prop.getProperty(locValue));
			case "tagname": return driver.findElementsByTagName(prop.getProperty(locValue));
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			//reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}



	public WebElement locateElement(String locValue) {
		return driver.findElementById(prop.getProperty(locValue));
	}
	public List<WebElement> locateElements(String locValue) {
		List<WebElement> findElementsById = driver.findElementsById(prop.getProperty(locValue));
		return findElementsById; 
	}


	public void typer(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			//reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			//reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			//reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			//reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void click(WebElement ele) throws InterruptedException {
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
	}
	public void clickr(WebElement ele) {
		String text = "";
		try {
			/*WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));*/			
			text = ele.getText();
			ele.click();
			//reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			//reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			//reportStep("The element :"+text+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			//reportStep("The element: "+text+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while clicking in the field :","FAIL",false);
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			//reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		return bReturn;
	}

	/*public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			//reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			//reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 

	}*/

	public boolean verifyExactTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				//reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				//reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				//reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
			}else {
				//reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				//reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				//reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				//reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				//reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				//reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				//reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				//reportStep("The element "+ele+" is selected","PASS");
			} else {
				//reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public boolean verifySelectedBoolean(WebElement ele) {

		boolean selected = false;

		try {
			if(ele.isSelected()) {
				//reportStep("The element "+ele+" is selected","PASS");
				selected = true;
			} else {
				//reportStep("The element "+ele+" is not selected","FAIL");
				selected = false;
			}
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		return selected;
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				//reportStep("The element "+ele+" is visible","PASS");
			} else {
				//reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			//reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			//reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void acceptAlert() throws InterruptedException {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			Thread.sleep(1000); 
			//reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			//reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			//reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			//reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			//reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}


	public void closeActiveBrowser() {
		try {
			driver.close();
			//reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			//reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			//reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			//reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}


	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			//reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			//reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}
	long number;
	@Override
	public long takeSnap(){
		number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			if(location.equals("local")) {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File(System.getProperty("user.dir")+"/classes/reports/images/"+number+".jpg"));
			}else {
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
				
			}
		} catch (WebDriverException e) {
			//System.out.println("The snapshot could not be taken");
		} catch (IOException e) {
			//System.out.println("The snapshot could not be taken");
		}
		return number;
	}


	@Override
	public boolean verifyPartialTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().contains(title)) {
				//reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				//reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			//reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;		
	}


	public boolean verifyEnabled(WebElement ele) {
		boolean enabled = false;
		try {
			if(ele.isEnabled()) {				
				enabled = true;
			} else {				
				enabled = false;
			}
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		return enabled; 
	}

	public void navigate(String Url) throws MalformedURLException {
		driver.navigate().to(new URL(Url));
	}

	public void inputText(String xPath, String inputText) throws Exception {
		if (!inputText.equalsIgnoreCase("N/A")) {
			driver.findElement(By.xpath(xPath)).clear();
			driver.findElement(By.xpath(xPath)).sendKeys(inputText.trim());
		}
	}

	public void inputTextid(String id, String inputText) throws Exception {

		if (!inputText.equalsIgnoreCase("N/A")) {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(inputText.trim());
		}
	}

	public void inputTextname(String name, String inputText) throws Exception {
		driver.findElement(By.name(name)).clear();
		driver.findElement(By.name(name)).sendKeys(inputText.trim());
	}

	public void clickButton(String xPath) throws Exception{
		//alert();
		driver.findElement(By.xpath(xPath)).click();
		waitUntilPageloads();
	}

	public void clickButtonWithInput(String xPath,String inputText) throws Exception{
		//alert();
		if(!inputText.equalsIgnoreCase("N/A"))
		{
			driver.findElement(By.xpath(xPath)).click();
			waitUntilPageloads();
		}
	}
	@SuppressWarnings("deprecation")
	public void waitUntilPageloads() throws InterruptedException{

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver jse) {
				return ((JavascriptExecutor) jse).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		try {
			//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 3);

			try{
				//selnium
				wait.until(expectation);
				alertMsg();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='status' and contains(@style,'display: none')]")));
			}catch(Exception e){
				//System.err.println("Captured");
			}
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}

	}
	public void wait(String millis) throws InterruptedException {
		/* To wait until page loads */
		waitUntilPageloads();
		Thread.sleep(Long.parseLong(millis));
	}
	public String checkResult(String xpath, String resultText) throws InvocationTargetException, InterruptedException{
		String result = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(result);
		wait("1500");
		if (result.trim().contains(resultText.trim())) {
			System.err.println("Test Case pass");
			return "Pass";
		}
		return "Fail";
	}
	public void clickButtoncss(String cssSelector) throws Exception {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}

	public void clickButtonclass(String classname) throws Exception {
		driver.findElement(By.className(classname)).click();
	}

	public void clickButtonid(String id) throws Exception {
		driver.findElement(By.id(id)).click();
	}

	public void clickButtonname(String name) throws Exception {
		driver.findElement(By.name(name)).click();
	}

	public void selectdropdown(String id, String selectvalue) throws Exception {

		if (!selectvalue.equalsIgnoreCase("N/A")) {
			//System.err.println("SelectedValue :: "+selectvalue);
			new Select(driver.findElement(By.id(id)))
			.selectByVisibleText(selectvalue);
		}
	}

	public void selectdropdownidindex(String id, String indexvalue) throws Exception {

		if (!indexvalue.equalsIgnoreCase("N/A")) {
			int indvalue=Integer.parseInt(indexvalue);
			new Select(driver.findElement(By.id(id))).selectByIndex(indvalue);
		}
	}

	public void selectdropdownxpathIndx(String id, String indexvalue) throws Exception {

		if (!indexvalue.equalsIgnoreCase("N/A")) {
			int indvalue=Integer.parseInt(indexvalue);
			new Select(driver.findElement(By.xpath(id))).selectByIndex(indvalue);
		}
	}

	public void selectdropdownname(String name, String selectvalue)	throws Exception {
		if (!selectvalue.equalsIgnoreCase("N/A")) {
			new Select(driver.findElement(By.name(name)))
			.selectByVisibleText(selectvalue);
		}
	}

	public void selectdropdownxpath(String xpath, String selectvalue) throws Exception {
		new Select(driver.findElement(By.xpath(xpath)))
		.selectByVisibleText(selectvalue);
	}

	public void checkboxByName(String boxName) throws Exception {
		driver.findElement(By.name(boxName)).click();
	}

	public void checkboxByNameisChecked(String boxName) throws Exception {	//Ensure checkbox remains Checked
		if (!driver.findElement(By.name(boxName)).isSelected()){
			driver.findElement(By.name(boxName)).click();
		}
	}

	public void checkboxByNameisUnchecked(String boxName) throws Exception { ////Ensure checkbox remains Unchecked
		if (driver.findElement(By.name(boxName)).isSelected()){
			driver.findElement(By.name(boxName)).click();
		}
	}



	//*****************************************************************	

	public void selectDropDown(String id, String selectvalue) throws Exception {

		if (!selectvalue.equalsIgnoreCase("N/A")) {
			Thread.sleep(2000);
			//System.err.println("SelectedValue :: "+selectvalue);
			new Select(driver.findElement(By.id(id)))
			.selectByVisibleText(selectvalue);
		}
	}
	public void dropDownDefaultValue(String id) throws Exception {
			Thread.sleep(2000);
			new Select(driver.findElement(By.id(id))).selectByIndex(0);
			
	}
	List<Date> list_date;
	public List<Date> fromtodatespliter(String fromtoavalue) throws ParseException {
		// TODO String to date
		try {
			list_date = new ArrayList<Date>();
			for (String string : fromtoavalue.split("\\,")) {
				list_date.add(new SimpleDateFormat("dd-MM-yyyy").parse(string));
			}
			//reportStep(list_date.toString(), "PASS");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		return list_date;
	}

	public void alertMsg() throws InterruptedException {
		try{
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			//reportStep("Alert accept: " + alert.getText(), "PASS");
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			boolean write;
			if(location.equals("local")) {
				 write = ImageIO.write(image, "png", new File(System.getProperty("user.dir")+"/classes/reports/images/"+number+".jpg"));	
				
			}else {
			 write = ImageIO.write(image, "png", new File("./reports/images/"+number+".jpg"));	
			}
			//reportStep("Alert accept:", "PASS", write);
			Thread.sleep(1000);
			alert.accept();	 
		}
		catch(NoSuchElementException e){
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
		catch(Exception e){
			
		}
	}
	public void scrolltoview(String value) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = locateElement("xpath", value);
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			//reportStep("Element scrolled", "PASS");
		} catch (Exception e) {
			//reportStep("Element not scroll down", "FAIL");
 		}
	}
	public boolean noagealert(boolean status1) {
		// TODO To validate the alert based on inputs
		boolean status2 = true;
		for (WebElement webElement : driver.findElements(By.xpath(prop.getProperty("nehru_dob_xpath")))) {
			if (webElement.isDisplayed()) {
				//reportStep("Error on date: " + webElement.getText(), "PASS");
				status2 = false;				
				continue;
			}
		}
		return (status1 == status2) ? true : false;
	}
	
	

	public static ExtentTest testlog;

	public void agevalidator_max(int sRowNum, String id, String givendate, String dataSheetName, String sheetNameTC) throws Exception {
		// TODO BVA with max_DOB
		String userDir = System.getProperty("user.dir"); 
		XSSFWorkbook wb ;
		if(location.equals("local")) {
			wb = new XSSFWorkbook(userDir+"\\classes\\data\\"+dataSheetName+".xlsx");
		}else if(location.equals("local")) {
			wb = new XSSFWorkbook(userDir+"/classes/data/"+dataSheetName+".xlsx");
		} else {
		 wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		}
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		//System.out.println("Row Count >"+rowCount);
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("MaxAge-1")) {
				break;
			}
		}
		//String rowName = "" ;
		id = prop.getProperty(id); 
		String[] ids = id.toString().split("\\-");
		List<Date> dates = fromtodatespliter(givendate);
		int printCell = i;  
		List<Boolean> ispositive = new ArrayList<Boolean>(); 
		ispositive.addAll(Arrays.asList(false,true,true,true));
		Iterator<Boolean> ite_ispositive = ispositive.iterator();
		for (Date date : dates) {
			Calendar cal = Calendar.getInstance();
			Date[] temp_date = new Date[4];
			cal.setTime(date); cal.add(Calendar.DATE, -1); temp_date[0] = cal.getTime();
			temp_date[1] = date;
			cal.setTime(date); cal.add(Calendar.DATE, 1); temp_date[2] = cal.getTime();
			cal.setTime(date); cal.add(Calendar.DATE, 45); temp_date[3] = cal.getTime();
			String result = "";
			Boolean scenario = null;
			for (Date day : temp_date) {
				try {
					scenario = ite_ispositive.next();
					result = "Fail";
					//scrolltoview(id); 
					//reportStep("Max date: " + day, "PASS");
				} catch (WebDriverException e) {
					//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
				}
			/*	selectDropDown(ids[2], "Year");
				selectDropDown(ids[1], "Month");
				//reportStep("Max date: " + day, "PASS");
				selectDropDown(ids[0], "Day"); */
				dropDownDefaultValue(ids[2]);
				dropDownDefaultValue(ids[1]);
				dropDownDefaultValue(ids[0]);
				
				try { 
					selectDropDown(ids[2], new SimpleDateFormat("yyyy").format(day));
					selectDropDown(ids[1], new SimpleDateFormat("MMMM").format(day));
					selectDropDown(ids[0], new SimpleDateFormat("dd").format(day));
					//reportStep("Max date is: ", "PASS"); 
				} catch (Exception e) {
					System.err.println("Invalid date");
					alertMsg();
					//reportStep(/*scenario ? "No alert" :*/ "Alert displayed", result);  
					if(printCell==(i+3)) {
						printCell = (i+6); 
					}
					try {
						writeDataNoC(sRowNum, printCell, result, dataSheetName, sheetNameTC);
						printCell++;
					} catch (NumberFormatException e1) {
						System.err.println("Number Format Exception");  
					}
					continue;
				}
				//Thread.sleep(2000);
				alertMsg();
				//Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='Recheck']")).click();
				Thread.sleep(1000); 
				result = noagealert(scenario) ? "Pass" : "Fail";
				//reportStep(/*scenario ? "No alert" :*/ "Alert displayed", result); 
				if(printCell==(i+3)) {
					printCell = (i+6);
				}
				writeDataNoC(sRowNum, printCell, result,dataSheetName, sheetNameTC);
				printCell++;
			}
			Thread.sleep(2000);  
		}
	}

	public void mobilenovalidator(int sRowNum, String url,  String dataSheetName, String sheetNameTC) throws Exception {
		String userDir = System.getProperty("user.dir"); 
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		//System.out.println("Row Count >"+rowCount);
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("Status")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[@id='FinalSubmit']")).click();
		
		for (WebElement webElement : driver.findElements(By.xpath(prop.getProperty("IBPS_mobile_err_xpath")))) {
			if (webElement.isDisplayed()) {
				try {
				writeDataNoC(sRowNum, i, "Pass", dataSheetName, sheetNameTC);
				System.out.println("Row Num : "+sRowNum +" Pass");
				}  catch (NumberFormatException e1) {
					System.err.println("Number Format Exception");  
				}
				
				
			}else {
				Thread.sleep(2000);
				acceptAlert();
				Thread.sleep(2000);
				boolean displayed = driver.findElement(By.id("picture")).isDisplayed();
				if(displayed) {
					try {
					writeDataNoC(sRowNum, i, "Fail", dataSheetName, sheetNameTC);
					System.out.println("Row Num : "+sRowNum +" Fail");
					}  catch (NumberFormatException e1) {
						System.err.println("Number Format Exception");  
					}
				}
			}
		}}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean aadharalert(boolean status1) throws Exception {
		boolean status2 = true;
		if (!isAlertPresent()) {
			for (WebElement webElement : driver.findElements(By.xpath(prop.getProperty("IBPS_aadhar_err_xpath")))) {
				Thread.sleep(1500);
				if (webElement.isDisplayed()) {
					status2 = false;
					continue;
				}
			}
		}
		return (status1 == status2) ? true : false;
	}
		public void aadharvalidator(int sRowNum,  String dataSheetName, String sheetNameTC) throws Exception {
			String userDir = System.getProperty("user.dir"); 
			XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
			XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
			String stringCellValue = null;
			int rowCount = sheetAt.getRow(0).getLastCellNum();
			//System.out.println("Row Count >"+rowCount);
			int i;
			int j =0; 
			for (i = 0; i < rowCount; i++) {
				XSSFRow row = sheetAt.getRow(0);
				XSSFCell cell = row.getCell(j++);
				stringCellValue = cell.getStringCellValue();
				if(stringCellValue.equals("Status")) {
					break;
				}
			}
			
		driver.findElement(By.xpath("//*[@id='FinalSubmit']")).click();
		Thread.sleep(1000);
		boolean status = false;

		String result = aadharalert(status) ? "Pass" : "Fail";
		System.out.println("Status : " + result);
		writeDataNoC(sRowNum, i, result, dataSheetName, sheetNameTC);
		if (result.equals("Pass")) {
			String warningmsg = driver.findElement(By.xpath(prop.getProperty("IBPS_aadhar_err_xpath"))).getText()
					.trim();
			writeDataNoC(sRowNum, i + 1, warningmsg, dataSheetName, sheetNameTC);
			System.out.println("if Status : " + result);
			driver.close();
		} else if (result.equals("Fail")) {
			driver.switchTo().alert().accept();
			writeDataNoC(sRowNum, i + 1, "Aadhar Card No Accepted", dataSheetName, sheetNameTC);
			System.out.println(" else if Status : " + result);
			driver.close();
		}
	}
	public void agevalidator_min(int sRowNum, String id, String givendate, String dataSheetName, String sheetNameTC) throws Exception {
		// TODO BVA with Max_DOB
		String userDir = System.getProperty("user.dir");
		XSSFWorkbook wb ;
		if(location.equals("local")) {
			wb = new XSSFWorkbook(userDir+"\\classes\\data\\"+dataSheetName+".xlsx");
		}else if(location.equals("linux")) {
			wb = new XSSFWorkbook(userDir+"/classes/data/"+dataSheetName+".xlsx");
		} 
			else {
		 wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		}
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("MinAge-1")) {
				break;
			}
		}
		String rowName = "" ;
		id = prop.getProperty(id);
		//String[] splStr = sRowNum.split("\\|");
		String[] ids = id.split("\\-");
		List<Date> dates = fromtodatespliter(givendate);
		int printCell = i;
		List<Boolean> ispositive = new ArrayList<Boolean>();
		ispositive.addAll(Arrays.asList(true,true,false,true));
		Iterator<Boolean> ite_ispositive = ispositive.iterator();		
		for (Date date : dates) {
			Calendar cal = Calendar.getInstance();
			Date[] temp_date = new Date[4];		
			cal.setTime(date); cal.add(Calendar.DATE, -1); temp_date[0] = cal.getTime();
			temp_date[1] = date;
			cal.setTime(date); cal.add(Calendar.DATE, 1); temp_date[2] = cal.getTime();
			cal.setTime(date); cal.add(Calendar.DATE, -45); temp_date[3] = cal.getTime();		
			for (Date day : temp_date) {
				Boolean scenario = ite_ispositive.next();
				String result = "Fail";
				//scrolltoview(id);
			/*	selectdropdown(ids[2], "Year");
				selectdropdown(ids[1], "Month");
				//reportStep("Min date: " + day, "PASS");
				selectdropdown(ids[0], "Day"); */
				
				dropDownDefaultValue(ids[2]);
				dropDownDefaultValue(ids[1]);
				dropDownDefaultValue(ids[0]);
				
				try {
					//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					selectdropdown(ids[2], new SimpleDateFormat("yyyy").format(day));
					selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(day));
					selectdropdown(ids[0], new SimpleDateFormat("dd").format(day));
					Thread.sleep(1000);
					//reportStep("Min date is: ", "PASS"); 
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Invalid date");
					alertMsg();
					//reportStep(/*scenario ? "No alert" :*/ "Alert displayed", result);
					if(printCell==(i+3)) {
						printCell =(i+4); 
					}
					writeDataNoC(sRowNum, printCell, result, dataSheetName, sheetNameTC);
					printCell++;
					continue;
				}			
				alertMsg();
				driver.findElement(By.xpath(".//*[@id='Recheck']")).click();
				Thread.sleep(1000);
				result = noagealert(scenario) ? "Pass" : "Fail";
				//reportStep(/*scenario ? "No alert" : */"Alert displayed", result);
				if(printCell==(i+3)) {
					printCell =(i+4); 
				}
				writeDataNoC(sRowNum, printCell, result,dataSheetName, sheetNameTC);
				printCell++;
			}
			Thread.sleep(2000);
		}	
	}
	
	
/*	public void agevalidator_leapyear(int sRowNum, String id, String givendate, String dataSheetName, String sheetNameTC) throws Exception { Old
		String rowName = "" ;
		String userDir = System.getProperty("user.dir");
		XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("LeapPass")) {
				break;
			}
		}
		// TODO To validate leap year date between Max_DOB and Min_DOB
		id = prop.getProperty(id);
		//String[] splStr = sRowNum.split("\\|");
		String[] ids = id.split("\\-");
		List<Date> dates = fromtodatespliter(givendate);
		int printCell = i;
		int foundcnt = 0;
		String result = "Fail";
		List<Boolean> ispositive = new ArrayList<Boolean>();		
		for (Date date : dates) {
			if (dates.indexOf(date) == 0) {
				ispositive.add(true);
				continue;
			} 
			ispositive.add(false);
		}		
		Iterator<Boolean> ite_ispositive = ispositive.iterator();		
		for (Date date : dates) {
			Boolean scenario = ite_ispositive.next();
			result = "Fail";
			//reportStep("Leap date: " + date, "");			
			selectdropdown(ids[2], "Year");
			selectdropdown(ids[1], "Month");
			selectdropdown(ids[0], "Day");			
			try {
				selectdropdown(ids[2], new SimpleDateFormat("yyyy").format(date));
				selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(date));
				selectdropdown(ids[0], new SimpleDateFormat("dd").format(date));				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Invalid date");
				alertMsg();
				//reportStep(result, scenario ? "No alert" : "Alert displayed");
				//Controller.testlog.log(LogStatus.ERROR, Controller.testlog.addScreenCapture(screenshotfail(Thread.currentThread().getStackTrace()[1].getMethodName())));
				continue;
			}				
			alertMsg();
			driver.findElement(By.xpath(".//*[@id='Recheck']")).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			result = noagealert(scenario) ? "Pass" : "Fail";
			//reportStep(result, scenario ? "No alert" : "Alert displayed");			
			if (noagealert(scenario))
				foundcnt++;
		}
		if (foundcnt == dates.size())
			result = "Pass";
		writeDataNoC(sRowNum, printCell, result, dataSheetName,sheetNameTC);
	} */
	
	public void agevalidator_leapyear(int sRowNum, String id, String givendate, String dataSheetName, String sheetNameTC) throws Exception {
		String rowName = "" ;
		String userDir = System.getProperty("user.dir");
		XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("LeapPass")) {
				break;
			}
		}
		// TODO To validate leap year date between Max_DOB and Min_DOB
		id = prop.getProperty(id);
		//String[] splStr = sRowNum.split("\\|");
		String[] ids = id.split("\\-");
		List<Date> dates = fromtodatespliter(givendate);
		System.out.println("Return Value"+dates);
		int printCell = i;
		int foundcnt = 0;
		String result = "Fail";
		List<Boolean> ispositive = new ArrayList<Boolean>();		
		for (Date date : dates) {
			if (dates.indexOf(date) == 0) {
				ispositive.add(true);
				continue;
			} 
			ispositive.add(false);
		}	
		
		Iterator<Boolean> ite_ispositive = ispositive.iterator();		
		for (Date date : dates) {
			Boolean scenario = ite_ispositive.next();
			System.err.println("scenario::"+scenario);
			result = "Fail";
			System.err.println("date  ::::"+date);
			//reportStep("Leap date: " + date, "");			
			selectdropdown(ids[2], "Year");
			selectdropdown(ids[1], "Month");
			selectdropdown(ids[0], "Day");			
			try {
				selectdropdown(ids[2], new SimpleDateFormat("yyyy").format(date));
				if(scenario==false) {
					System.out.println("Entered in Condition");
					
					Calendar cal = Calendar.getInstance();
					Date[] temp_date = new Date[4];
					cal.setTime(date); cal.add(Calendar.MONTH, -1); temp_date[0] = cal.getTime();
					System.err.println("Scenario False Condition for Month ::"+temp_date[0]);
					
					selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(temp_date[0]));
					
					cal.setTime(date); cal.add(Calendar.DATE, -1); temp_date[1] = cal.getTime();
					System.err.println("Scenario False Condition for Date ::"+temp_date[1]);
					
					String format = new SimpleDateFormat("dd").format(temp_date[1]);
                     int value=Integer.parseInt(format)+1;		
                     String text=String.valueOf(value);

                     selectdropdown(ids[0], text);	
				 }else {
					 selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(date));
					 selectdropdown(ids[0], new SimpleDateFormat("dd").format(date));	
				} 
			} catch (Exception e) {
				// handle exception
				System.err.println("Invalid date");
				alertMsg();
				reportStep(result, scenario ? "No alert" : "Alert displayed");
				//Controller.testlog.log(LogStatus.ERROR, Controller.testlog.addScreenCapture(screenshotfail(Thread.currentThread().getStackTrace()[1].getMethodName())));
				continue;
			}				
			alertMsg();
			driver.findElement(By.xpath(".//*[@id='Recheck']")).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			result = noagealert(scenario) ? "Pass" : "Fail";
			System.err.println("Result ::"+result);
			reportStep(result, scenario ? "No alert" : "Alert displayed");			
			if (noagealert(scenario))
				foundcnt++;
		}
		if (foundcnt == dates.size())
			result = "Pass";
		writeDataNoC(sRowNum, printCell, result, dataSheetName,sheetNameTC);
	}


	public LocalDate dateToLocalDate(final Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();		
	}

	public void agevalidator_asondate1(int sRowNum, String id, String givendates, String dataSheetName, String sheetNameTC) throws Exception {
		// TODO To validate age by calculating difference Max_DOB & Min_DOB with as on date
		String userDir = System.getProperty("user.dir");
		XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("AsOnDateMax Result")) {
				break;
			}
		}
		id = prop.getProperty(id);
		//	String[] splStr = sRowNum.split("\\|");
		String[] ids = id.split("\\-");
		List<Date> dates = fromtodatespliter(givendates);

		Date givendate = dates.get(0);
		Date asondate = dates.get(1);
		int printCell = i;
		String result = "Fail";

		selectdropdown(ids[2], "Year");
		selectdropdown(ids[1], "Month");
		selectdropdown(ids[0], "Day");

		Calendar cal = Calendar.getInstance();
		cal.setTime(givendate); cal.add(Calendar.DATE, -1);

		try {
			selectdropdown(ids[2], new SimpleDateFormat("yyyy").format(givendate));
			selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(givendate));
			selectdropdown(ids[0], new SimpleDateFormat("dd").format(givendate));
		} catch (Exception e) {
			// TODO: handle exception
			alertMsg();
			//Controller.testlog.log(LogStatus.ERROR, Controller.testlog.addScreenCapture(screenshotfail(Thread.currentThread().getStackTrace()[1].getMethodName())));

			System.err.println("Invalid date");
		}
		LocalDate Maxdate = dateToLocalDate(cal.getTime());
		LocalDate ason = dateToLocalDate(asondate);
		Period p = Period.between(Maxdate, ason);

		wait("100");
		String txtage = driver.findElement(By.id("txtage")).getText();

		try {
			if (p.getYears() == Integer.parseInt(txtage)) {
				result = "Pass";
			} 
		} catch (Exception e) {
			// TODO: handle exception
			result = "Fail";
		}

		//log(result, String.valueOf(p.getYears()), txtage);
		String amount = driver.findElement(By.id("txtfee")).getText();

		if (txtage.trim().length() == 0) {
			txtage = "Null";
		}
		writeDataNoC(sRowNum, printCell, txtage, dataSheetName, sheetNameTC);
		printCell++;
		writeDataNoC(sRowNum, printCell, amount, dataSheetName, sheetNameTC);
		printCell++;
		/*xlsWriter.writeExcelAtColumnWithResult(Integer.parseInt(splStr[2]), printCell++,
				result, configPropMap.get("dataXlsImportPath"), splStr[1]);

		xlsWriter.writeExcelAtColumnWithResult(Integer.parseInt(splStr[2]), printCell++,
				txtage, configPropMap.get("dataXlsImportPath"), splStr[1]);

		xlsWriter.writeExcelAtColumnWithResult(Integer.parseInt(splStr[2]), printCell++,
				amount, configPropMap.get("dataXlsImportPath"), splStr[1]);*/

	}
	@SuppressWarnings("resource")
	public void agevalidator_asondate(int sRowNum, String id, String givendate, String dataSheetName, String sheetNameTC) throws Exception {
		// TODO To validate age by calculating difference Max_DOB & Min_DOB with as on date
		String userDir = System.getProperty("user.dir");
		System.out.println("given date is: "+givendate); 	
		XSSFWorkbook wb ;
		if(location.equals("local")) {
			wb = new XSSFWorkbook(userDir+"\\classes\\data\\"+dataSheetName+".xlsx");
		}else if(location.equals("linux")) {
			wb = new XSSFWorkbook(userDir+"/classes/data/"+dataSheetName+".xlsx");
		}else {
		 wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		}
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC); 
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("AsOnDateMax Result")) {
				break;
			}
		}
		id = prop.getProperty(id);
		//String[] splStr = sRowNum.split("\\|");
		String[] ids = id.split("\\-");
		List<Date> dates = fromtodatespliter(givendate);
		Date asondate = dates.get(2);
		System.out.println("as on date: "+dates.get(2));
		dates = dates.subList(0, 2);
		//Date[] givendate = {dates.get(0),dates.get(1)};
//		Date asondate = dates.get(0);
//		System.out.println("date: "+dates.get(0));  
		int printCell = i;
		String result = "Fail";

		for (Date date : dates) {
			/*selectdropdown(ids[2], "Year");
			selectdropdown(ids[1], "Month");
			selectdropdown(ids[0], "Day");	 */ // UnComment for Other
			
			dropDownDefaultValue(ids[2]);
			dropDownDefaultValue(ids[1]);
			dropDownDefaultValue(ids[0]);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date); cal.add(Calendar.DATE, -1);			
			try {
				selectdropdown(ids[2], new SimpleDateFormat("yyyy").format(date));
				selectdropdown(ids[1], new SimpleDateFormat("MMMM").format(date));
				selectdropdown(ids[0], new SimpleDateFormat("dd").format(date));
				//reportStep("as on date date is :", "PASS");
			} catch (Exception e) { 
				alertMsg();
				//reportStep("Alert displayed", result);
				//Controller.testlog.log(LogStatus.ERROR, Controller.testlog.addScreenCapture(screenshotfail(Thread.currentThread().getStackTrace()[1].getMethodName())));
				System.err.println("Invalid date");
			}

			LocalDate Maxdate = dateToLocalDate(cal.getTime());
			LocalDate ason = dateToLocalDate(asondate);
			Period p = Period.between(Maxdate, ason);			
			wait("100");
			String txtage = driver.findElement(By.id("txtage")).getText();
			System.out.println(txtage); 
			//String txtage = driver.findElement(By.id("ageAsOnLabel")).getText();
			try {
				if (p.getYears() == Integer.parseInt(txtage)) {
					result = "Pass";
				}
				else {
					result = "Fail";
				} 
			} catch (Exception e) {
				result = "Fail";
			}			
			if (txtage.trim().length() == 0) {
				txtage = "Null";
			}
			//log(result, String.valueOf(p.getYears()), txtage);
            //reportStep("txt age "+txtage, "PASS");  
			if (result.equals("Pass")) {
				//writeData(16, i++, result, sheetNameTC, "Green");
//				writeDataNoC(sRowNum, printCell, txtage, dataSheetName, sheetNameTC);
				writeDataNoC(sRowNum, printCell, result+" : "+txtage, dataSheetName, sheetNameTC);
				printCell++;
			} else {
//				writeDataNoC(sRowNum, printCell, txtage, dataSheetName, sheetNameTC);
				writeDataNoC(sRowNum, printCell, result+" : "+txtage, dataSheetName, sheetNameTC);
				printCell++;
			}
		}
		//recheck
		String amount = driver.findElement(By.id("txtfee")).getText();
		writeDataNoC(sRowNum, printCell, amount, dataSheetName, sheetNameTC);
		printCell++;
	}




	int lastRowNum;
	int lastCellNum;
	public String readData(int rows , int coloum, String dataSheetName, String newSheetname) throws IOException {
		String fileName = null;
		String data = null;
		Workbook wb = null;
		fileName = "./data/"+dataSheetName+".xlsx";
		FileInputStream fileInputStream = new FileInputStream(fileName);
		// fileInputStream.reset();
		String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
		// System.err.println("File Extension : "+fileExtensionName);
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(fileInputStream);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(fileInputStream);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		}
		Sheet sheet = wb.getSheet(newSheetname);
		Row row = sheet.getRow(rows);
		//lastRowNum = sheet.getLastRowNum();
		Cell cell = row.getCell(coloum);
		//lastCellNum = sheet.getRow(0).getLastCellNum();
		cell.setCellType(CellType.STRING);
		if (cell.getCellType() == CellType.STRING) {
			System.out.println("string: " + cell.getStringCellValue());
			data = cell.getStringCellValue();
		}
		if (cell.getCellType() == CellType.NUMERIC) {
			System.out.println("numeric: " + cell.getNumericCellValue());
		}
		System.out.println("any: " + cell.toString());
		data = cell.toString();
		return data;
	}

	public void writeData(int rows , int coloum, String text, String dataSheetName, String sheetname, String color)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		String fileName =null;
		Workbook wb1 = null;
		Sheet sheet;
		Cell cell;
		Row row;
		CellStyle style = null;
		fileName = "./data/"+dataSheetName+".xlsx";
		FileInputStream fileInputStream = new FileInputStream(fileName);
		String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb1 = new XSSFWorkbook(fileInputStream);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
			style = wb1.createCellStyle();

			Font font = wb1.createFont();
			/*if (color.equalsIgnoreCase("Green")) {
				font.setColor(IndexedColors.GREEN.getIndex());
			} else if (color.equalsIgnoreCase("Red")) {
				font.setColor(IndexedColors.RED.getIndex());
			} else {
				font.setColor(IndexedColors.BLACK.getIndex());
			}*/
			style.setFont(font);
		}

		else if (fileExtensionName.equals(".xls")) {
			wb1 = new HSSFWorkbook(fileInputStream);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
			style = wb1.createCellStyle();
			Font font = wb1.createFont();

			/*if (color.equalsIgnoreCase("Green")) {
				font.setColor(HSSFColor.toHSSFColor(color));
			} else if (color.equalsIgnoreCase("Red")) {
				font.setColor(HSSFColor.RED.index);
			} else {
				font.setColor(HSSFColor..index);
			}*/
			style.setFont(font);
		}
		if (wb1 == null) {
			sheet = wb1.createSheet();
		}
		sheet = wb1.getSheet(sheetname);
		row = sheet.getRow(rows);
		if (row == null) {
			row = sheet.createRow(rows);
		}
		cell = row.getCell(coloum);
		if (cell == null)
			cell = row.createCell(coloum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(text);
		cell.setCellStyle(style);
		
		FileOutputStream fileOut;
		if(location.equals("local")) {
		 fileOut = new FileOutputStream(System.getProperty("user.dir")+"/classes/data/"+dataSheetName+".xlsx");
		}else if(location.equals("linux")) {
			 fileOut = new FileOutputStream(System.getProperty("user.dir")+"/classes/data/"+dataSheetName+".xlsx");
			}
			else {
			fileOut = new FileOutputStream("./data/"+dataSheetName+".xlsx");
		}
		wb1.write(fileOut);
		fileOut.close();
	}


	@SuppressWarnings({ "null" })
	public void writeDataNoC(int rows , int coloum, String text, String dataSheetName, String sheetname)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		String fileName =null;
		Workbook wb1 = null;
		Sheet sheet;
		Cell cell;
		Row row;
		if(location.equals("local")) {
			String property = System.getProperty("user.dir");
			fileName =property+"/classes/data/"+dataSheetName+".xlsx";
		}else if(location.equals("linux")) {
			String property = System.getProperty("user.dir");
			fileName =property+"/classes/data/"+dataSheetName+".xlsx";
		}else {
		fileName = "./data/"+dataSheetName+".xlsx";
		}
		FileInputStream fileInputStream = new FileInputStream(fileName);
		String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb1 = new XSSFWorkbook(fileInputStream);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);


			Font font = wb1.createFont();
			/*if (color.equalsIgnoreCase("Green")) {
				font.setColor(IndexedColors.GREEN.getIndex());
			} else if (color.equalsIgnoreCase("Red")) {
				font.setColor(IndexedColors.RED.getIndex());
			} else {
				font.setColor(IndexedColors.BLACK.getIndex());
			}*/

		}

		else if (fileExtensionName.equals(".xls")) {
			wb1 = new HSSFWorkbook(fileInputStream);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);


			/*if (color.equalsIgnoreCase("Green")) {
				font.setColor(HSSFColor.toHSSFColor(color));
			} else if (color.equalsIgnoreCase("Red")) {
				font.setColor(HSSFColor.RED.index);
			} else {
				font.setColor(HSSFColor..index);
			}*/

		}
		if (wb1 == null) {
			sheet = wb1.createSheet();
		}
		sheet = wb1.getSheet(sheetname);
		row = sheet.getRow(rows);
		if (row == null) {
			row = sheet.createRow(rows);
		}
		cell = row.getCell(coloum);
		if (cell == null)
			cell = row.createCell(coloum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(text);

		FileOutputStream fileOut;
		if(location.equals("local")) {
		 fileOut = new FileOutputStream(System.getProperty("user.dir")+"/classes/data/"+dataSheetName+".xlsx");
		}else if(location.equals("linux")) {
			 fileOut = new FileOutputStream(System.getProperty("user.dir")+"/classes/data/"+dataSheetName+".xlsx");
			}
			else {
			fileOut = new FileOutputStream("./data/"+dataSheetName+".xlsx");
		}
		wb1.write(fileOut);
		fileOut.close();
	}



	public int getRowNo(String dataSheetName, String sheetname) throws IOException {
		String fileName =null;
		Workbook wb = null;
		fileName = "./data/"+dataSheetName+".xlsx"; 
		// System.err.println("File path is : "+fileName);
		FileInputStream fileInputStream = new FileInputStream(fileName);
		// fileInputStream.reset();
		String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
		// System.err.println("File Extension : "+fileExtensionName);
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(fileInputStream);			
			//XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		} else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(fileInputStream);
			//HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		}
		Sheet sheet = wb.getSheet(sheetname);
		int lastRowNum = sheet.getLastRowNum();

		return lastRowNum;
	}
	
	
	public void alertSnap() throws IOException, AWTException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		driver.findElementById("loginbutton").click();
		Thread.sleep(1000);
		// take snap		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		
		ImageIO.write(image, "png", new File("./snaps/Alert1.png"));
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void feesvalidator(int sRowNum, String id, String data, String dataSheetName, String sheetNameTC) throws Exception {
		String userDir = System.getProperty("user.dir"); 
		XSSFWorkbook wb = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
		XSSFSheet sheetAt = wb.getSheet(sheetNameTC);
		String stringCellValue = null;
		int rowCount = sheetAt.getRow(0).getLastCellNum();
		//System.out.println("Row Count >"+rowCount);
		int i;
		int j =0; 
		for (i = 0; i < rowCount; i++) {
			XSSFRow row = sheetAt.getRow(0);
			XSSFCell cell = row.getCell(j++);
			stringCellValue = cell.getStringCellValue();
			if(stringCellValue.equals("Previewfees")) {
				break;
			}
		}
	}
	}

	
	
	
	
	
	
	
	
	
