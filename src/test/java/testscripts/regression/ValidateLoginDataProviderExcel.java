package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginDataProviderExcel extends BaseTest {
	
	
	@Test(dataProvider="getData")
	public void validateLoginTest(HashMap<String,String> dataMap)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataMap.get("username"));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("password"));
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), dataMap.get("Expected Title"));
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-100");
		
		return data;
	}
	

}
