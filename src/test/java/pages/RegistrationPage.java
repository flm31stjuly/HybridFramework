package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
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
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='re_password']")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath="//input[@name='full_name']")
	WebElement fullNameTextbox;
	
	@FindBy(xpath="//input[@name='email_add']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@name='captcha']")
	WebElement captchaTextbox;
	
	@FindBy(xpath="//input[@name='tnc_box']")
	WebElement termsAndConditionsCheckbox;
	
	
	public void  usernameTextbox(String text) {
		usernameTextbox.sendKeys(text);
	}
	public void  passwordTextbox(String text) {
		passwordTextbox.sendKeys(text);
	}
	public void  confirmPasswordTextbox(String text) {
		confirmPasswordTextbox.sendKeys(text);
	}
	public void  fullNameTextbox(String text) {
		fullNameTextbox.sendKeys(text);
	}
	public void  emailTextbox(String text) {
		emailTextbox.sendKeys(text);
	}
	public void  captchaTextbox(String text) {
		captchaTextbox.sendKeys(text);
	}
	public void  termsAndConditionsCheckbox() {
		termsAndConditionsCheckbox.click();
	}
	
	
	
}
