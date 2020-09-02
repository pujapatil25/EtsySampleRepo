package etsy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import etsy.BaseKeywords.TestBaseKeyword;

public class SignInPage extends TestBaseKeyword {
	@FindBy(id = "join_neu_email_field")
	WebElement emailId;
	@FindBy(id = "join_neu_password_field")
	WebElement password;
	@FindBy(xpath = "//button[@name='submit_attempt']")
	WebElement signInBtnOnSignPage;
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	WebElement registerBtn;

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean checkDisplay()
	{
		boolean b=emailId.isDisplayed();
		return b;
	}
	public HomePage signInToEtsy()
	{
		emailId.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("pass"));
		signInBtnOnSignPage.click();
		return new HomePage();
	}
	public RegisterPage clickOnRegisterBtn() {
	
		registerBtn.click();
		return new RegisterPage();
	}

}
