package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateRegistrationUsingPOM extends BaseTest { 
	
	
	@Test(dataProvider = "getData")
	public void validateRegistration(HashMap<String, String> dataMap) throws InterruptedException
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.registrationLink();
		
		Thread.sleep(3000);
		
		RegistrationPage registrationPage=PageFactory.initElements(driver, RegistrationPage.class);
		
		registrationPage.validateTitle(dataMap.get("Expected Title"));
		
		registrationPage.usernameTextbox(dataMap.get("Username"));
		
		registrationPage.passwordTextbox(dataMap.get("Password"));
		
		registrationPage.confirmPasswordTextbox(dataMap.get("Confirm Password"));
		
		registrationPage.fullNameTextbox(dataMap.get("Full Name"));
		
		registrationPage.emailTextbox(dataMap.get("Email Address"));
		
		registrationPage.captchaTextbox(dataMap.get("Captcha Text"));
		
		registrationPage.termsAndConditionsCheckbox();
		
		Assert.assertTrue(false);
		
	}

	@DataProvider
	public Object[][] getData()
	{
		
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-101");
		
		return data;
	}
}
