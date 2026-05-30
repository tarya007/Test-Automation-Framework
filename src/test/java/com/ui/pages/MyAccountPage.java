package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By BY_USER_NAME_LOCATOR = By.xpath("//span[normalize-space()='Tarun Arya']");
	
	
	public String getUserName()
	{
		return getVisibleText(BY_USER_NAME_LOCATOR);
	}

}
