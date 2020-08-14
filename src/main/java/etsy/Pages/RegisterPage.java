package etsy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import etsy.BaseKeywords.TestBaseKeyword;

public class RegisterPage extends TestBaseKeyword {
	@FindBy(id = "join_neu_email_field")
	WebElement emailOnReg;
	@FindBy(id = "join_neu_first_name_field")
	WebElement firstName;
	@FindBy(id = "join_neu_password_field")
	WebElement passwordOnReg;
	@FindBy(name = "submit_attempt")
	WebElement RegisterButton;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage registerToEtsy() {
		emailOnReg.sendKeys(prop.getProperty("email"));
		firstName.sendKeys(prop.getProperty("firstname"));
		passwordOnReg.sendKeys(prop.getProperty("pass"));
		RegisterButton.click();
		return new HomePage();
	}
}
