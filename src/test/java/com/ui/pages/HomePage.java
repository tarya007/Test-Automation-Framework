package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.ENV.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser chrome) {
		super(chrome);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	
	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector(".login");
	
	public LoginPage goToLoginPage()
	{
		logger.info("Trying to perform click on sign page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

}
