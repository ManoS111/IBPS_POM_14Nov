package lib.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class HTMLReporter {

	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes, authors,category;

	public void startReport() {
		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(html);		
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		testSuite = extent.createTest(testCaseName, testDescription);		
		return testSuite;
	}

	public ExtentTest startTestModule(String nodes) {
		test = testSuite.createNode(nodes);
		return test;
	}

	public abstract long takeSnap();

	protected long snapNumber = 100000L;
	public void reportStep(String desc, String status, boolean bSnap)  {
		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {	
			} 
		} 
		/*else if(testCaseName.getClass().getName().equals("alertMsg")){   
			try { 
				BufferedImage	image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				boolean write = ImageIO.write(image, "png", new File("./../reports/images/"+snapNumber+".jpg"));
			} catch (IOException e) { 
               System.err.println("IOException");
			} catch (HeadlessException e) { 
                System.err.println("HeadlessException");
			} catch (AWTException e) {
                System.err.println("AWTException");  
			}
		}*/
		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);			
		}else if (status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}else if (status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);
		}else if (status.equalsIgnoreCase("INFO")) {
			test.info(desc);
		}						
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	public void endResult() {
		extent.flush();
	}		


}
