package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Parameters({"browser"})
	@BeforeMethod(description = "Load the homepage of the website", groups = {"sanity"})
	public void setup(@Optional("chrome") String browser)
	{
		homepage = new HomePage(Browser.valueOf(browser.toUpperCase()));
	}
	public BrowserUtility getInstance()
	{
		return homepage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		homepage.getDriver().quit();
	}

}
