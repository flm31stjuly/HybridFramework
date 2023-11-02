package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOM2 extends BaseTest { 
	
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap) throws InterruptedException
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox(dataMap.get("username"));
		
		loginPage.passwordTextbox(dataMap.get("password"));
		
		LoginPage.screenshot();
		
		loginPage.loginButton();
		
			
		Thread.sleep(3000);
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotelPage.validateTitle(dataMap.get("Expected Title"));
		
		SearchHotelPage.screenshot();
		
		
	}

	@DataProvider
	public Object[][] getData()
	{
		
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-100");
		
		return data;
	}
}
