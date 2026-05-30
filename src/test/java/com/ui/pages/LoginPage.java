package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	private static final By EMAILTEXTBOXLOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMITBUTTONLOCATOR = By.cssSelector("#SubmitLogin");
	
	
	public MyAccountPage doLoginWith(String email, String password)
	{
		enterText(EMAILTEXTBOXLOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMITBUTTONLOCATOR);
		MyAccountPage myaccountpage = new MyAccountPage(getDriver());
		return myaccountpage;
	}

}
