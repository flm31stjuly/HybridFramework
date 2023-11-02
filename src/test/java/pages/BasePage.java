package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import base.BaseTest;

public class BasePage extends BaseTest {
	
	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	public static void screenshot()
	{
		String screenshotsFolderPath=System.getProperty("user.dir")+"\\screenshots";
		File screenshotsFolder=new File(screenshotsFolderPath);
		screenshotsFolder.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		date=date.replace(":", "-");
		System.out.println(date);
		
	     File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     
	     try {
			FileUtils.copyFile(srcFile, new File(screenshotsFolderPath+"\\"+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
