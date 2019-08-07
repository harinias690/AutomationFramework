package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Base;

public class CustomReporter extends Base {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest test;

	
	public static void reportingSetUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "//report-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Author", "Harini");
	}

	
	public static void reportingTearDown() {
		reports.flush();
	}
	
	public static ExtentTest getExtentTest(){
		return test;
	}
	
	public static ExtentHtmlReporter getExtentHtmlReporter(){
		return htmlReporter;
	}
	
	public static ExtentReports getExtentReports(){
		return reports;
	}

}
