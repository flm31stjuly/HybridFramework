package testscripts.regression;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleValidateLogin extends BaseTest {
	
	
	@Test
	public void validateLoginTest1() throws IOException, InterruptedException
	{
				
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz009");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
			
	}
	

}
