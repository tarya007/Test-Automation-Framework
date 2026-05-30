package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import com.ui.tests.TestBase;

public class TestListeners implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the Screenshot to the HTML File");
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReportUtility.setupSparkReporter("report.html");
		
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReportUtility.flushReport();
	}
}
