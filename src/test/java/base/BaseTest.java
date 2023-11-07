package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentreports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public FileInputStream fis1;
	public static Properties configProperties;
	
	public FileInputStream fis2;
	public static Properties locatorsProperties;
	
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	// to read properties files 
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}
	
	@BeforeTest
	public void filesRead() throws IOException
	{
		System.out.println("In Before Test...");
		 fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		 configProperties=new Properties();
		configProperties.load(fis1);
		
		 fis2=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\locators.properties");
		 locatorsProperties=new Properties();
		 locatorsProperties.load(fis2);
		 
		 reports=ExtentManager.getReports();
		
	}
	
	@BeforeMethod
	public void setUp(ITestContext context)
	{
		
		//test=reports.createTest("Adactin Login Test");
		
		//test=reports.createTest(context.getCurrentXmlTest().getName());
		
		test=reports.createTest(context.getCurrentXmlTest().getName());
		
		context.setAttribute("report", "reports");
		
		context.setAttribute("test", "test");
		
		System.out.println("In Before Method ...");
		String browserName=configProperties.getProperty("browser");
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			test.info("Chrome browser started...");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			test.info("Firefox browser started...");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get(configProperties.getProperty("url"));
		
		test.info("App launched using url "+configProperties.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProperties.getProperty("implicitWait"))));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("In After Method ...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
