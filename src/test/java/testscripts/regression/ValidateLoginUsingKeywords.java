package testscripts.regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateLoginUsingKeywords extends BaseTest  {
	
	@Test
	public void validateLoginTest()
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.type("username_textbox", "reyaz009");
		
		app.type("password_textbox", "reyaz123");
		
		app.click("login_button");
		
		app.validateTitle("Adactin.com - Search Hotel");
		
		app.close();
	}
	
	

}
