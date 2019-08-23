package com.employeesapi.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testcontext) {

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "./Reports/myReport.html");
		htmlreporter.config().setDocumentTitle("Automation");
		htmlreporter.config().setReportName("RestApi testing");
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("environment", "QA");
		extent.attachReporter(htmlreporter);
	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Testcase is passed:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Testcase is failed:" + result.getName());
		test.log(Status.FAIL, "testcase exception:" + result.getThrowable());

		String ScreenShotpath = System.getProperty(("user.dir") + ".//Screenshots\\" + result.getName() + ".png");
		try {
			test.addScreenCaptureFromPath(ScreenShotpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}



