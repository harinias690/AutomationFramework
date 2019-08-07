package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.Base;
import reporting.CustomReporter;

public class BeforeAfterSuiteTests {
	
	@BeforeTest
	public void bSuite(){
		CustomReporter.reportingSetUp();
	}
	
	@AfterTest
	public void aSuite(){
		CustomReporter.reportingTearDown();
	}

}
