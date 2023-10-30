package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginDataProvider extends BaseTest {
	
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String uName,String pwd,String expTitle)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), expTitle);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		//int[] a=new int[5];
		
		Object[][] data=new Object[4][3];
		
		data[0][0]="reyaz009";
		data[0][1]="reyaz123";
		data[0][2]="Adactin.com - Search Hotel";
		
		data[1][0]="reyaz009";
		data[1][1]="reyaz456";
		data[1][2]="Adactin.com - Hotel Reservation System";
		
		data[2][0]="reyaz1245";
		data[2][1]="reyaz123";
		data[2][2]="Adactin.com - Hotel Reservation System";
		
		data[3][0]="reyaz1245";
		data[3][1]="reyaz456";
		data[3][2]="Adactin.com - Hotel Reservation System";
		
		return data;
		
	}
	

}
