package test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC001 {

	/*int i=1;
	public void getData() {
		System.out.println("new data");	
	}
	
	public void transform(ITestAnnotation annotation,@SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("transform")) {
			annotation.setInvocationCount(1);
			System.out.println("method name: "+testMethod.getName()); 
		} else {
			System.out.println("method name not matched");  
		}
	}
	int maxcount = 1;
	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & maxcount < 2) {
			maxcount++;
			return true;
		}
		return false;
	}
	@Test
	public void test2() {
		 
	}*/
	@Test
	public void alertSnap() throws AWTException, InterruptedException{ 
           System.out.println("new case");
		// System.out.println("method name:" + result.getMethod().getMethodName());
	
		/*Class run =RunClass.class;
		Method[] methods = run.getMethods();
		
		String name = "";
		for (Method method : methods) {
		    name = method.getName();
		   // System.out.println(name); 
		    if(name.equals("getData")) {
		    	System.out.println("true");
		    	break;
		    } else {
		    	System.out.println("false");  
		    }
		}
		}*/
		          

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			driver.switchTo().frame("iframeResult");
			driver.findElementByXPath("//button[text()='Try it']").click();
			try {
				takeSnap();
			} catch (IOException e) {

				e.printStackTrace();
			}
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		public void takeSnap() throws IOException, AWTException {
			BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			boolean write = ImageIO.write(img, "jpg", new File("./snaps/img1.jpg"));
			System.out.println(write);  


		}
		/*public static void main(String[] args) throws IOException {
		WriteData.writeData("WriteDataSheet", 0, 0, "gayatri");
		WriteData.writeData("WriteDataSheet", 2, 0, "chennai");

	}*/
	
	
}















