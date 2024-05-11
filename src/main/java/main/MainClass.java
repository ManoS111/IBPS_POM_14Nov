package main;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.TDCN_June23.tc.TC001_TDCNBasicDetails;

public class MainClass {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> list = new ArrayList<String>();
		//list.add(".//classes//testng_TDCN_June23.xml");
		//testng.setTestSuites(list);
		//testng.setTestClasses(new Class[] {com.TDCN_June23.tc.TC001_TDCNBasicDetails.class});
		testng.setTestClasses(new Class[] {TC001_TDCNBasicDetails.class});
		testng.run();
	}

}
