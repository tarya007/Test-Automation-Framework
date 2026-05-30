package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
 
@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase{
	/* test method!!!
	 * test script small!!!
	 * you cannot have conditional statements, loops, try catch in your test methods
	 * TestScripts -----> test cases
	 * reduce the use of local variables
	 * 
	 */
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	
		@Test(groups = {"smoke", "e2e"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
		public void logintest(User user)
		{
			assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tarun Arya");
		}
		
		@Test(groups = {"smoke", "e2e"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestCSVDataProvider")
		public void loginCSVtest(User user)
		{
			
			assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tarun Arya");
		}
		
		@Test(groups = {"smoke", "e2e"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider="LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
		public void loginExceltest(User user)
		{
			
			
			assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tarun Arya");
		}

}
