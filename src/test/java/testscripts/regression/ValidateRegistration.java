package testscripts.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateRegistration extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateRegistrationTest(HashMap<String,String> dataMap)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.click("newUserRegister_linktext");
		
		app.validateTitle(dataMap.get("Expected Title"));
		
		//Assert.assertTrue(false);		
		/*
		 * register_username_textbox=//input[@name='username']
register_password_textbox=//input[@name='password']
register_confirmPassword_textbox=//input[@name='re_password']
register_fullname_textbox=//input[@name='full_name']
register_email_textbox=//input[@name='email_add']
register_captcha_textbox=//input[@name='captcha']
register_termsAndCondition_checkbox=//input[@name='tnc_box']
register_button=//input[@name='Submit']
		 */
		
		app.type("register_username_textbox", dataMap.get("Username"));
		app.type("register_password_textbox", dataMap.get("Password"));
		app.type("register_confirmPassword_textbox", dataMap.get("Confirm Password"));
		app.type("register_fullname_textbox", dataMap.get("Full Name"));
		app.type("register_email_textbox", dataMap.get("Email Address"));
		app.type("register_captcha_textbox", dataMap.get("Captcha Text"));
		
		app.click("register_termsAndCondition_checkbox");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		app.close();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-101");
		
		return data;
	}

}
