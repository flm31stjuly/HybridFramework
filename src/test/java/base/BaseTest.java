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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public FileInputStream fis1;
	public Properties configProperties;
	
	// to read properties files 
	
	@BeforeTest
	public void filesRead() throws IOException
	{
		System.out.println("In Before Test...");
		 fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		 configProperties=new Properties();
		configProperties.load(fis1);
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("In Before Method ...");
		String browserName=configProperties.getProperty("browser");
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get(configProperties.getProperty("url"));
		
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
