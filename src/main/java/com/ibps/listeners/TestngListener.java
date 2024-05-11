package com.ibps.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestngListener implements IAnnotationTransformer,IRetryAnalyzer{
	
	int maxcount = 1;
	
	public void transform(ITestAnnotation annotation,@SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("basicDetails")) {
			annotation.setInvocationCount(1);
			String name = annotation.getClass().getName();
			System.out.println("method name: "+name); 
		}
	}
	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & maxcount < 2) {
			maxcount++;
			return true;
		}
		return false;
	}

}
























