package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends BasePage{
	
	@FindBy(xpath="//input[@name='Submit]")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@name='Reset]")
	WebElement resetButton;
	
	
	
	

}
