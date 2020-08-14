package etsy.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsy.BaseKeywords.TestBaseKeyword;
import etsy.Pages.HomePage;
import etsy.Pages.RegisterPage;
import etsy.Pages.SignInPage;

public class RegisterPageTest extends TestBaseKeyword {
	HomePage homepage;
	SignInPage signpage;
	RegisterPage registerpage;

	public RegisterPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage=new HomePage();
		signpage=new SignInPage();
		registerpage=new RegisterPage();
	}
	@Test
	public void registerOnEtsyTest()
	{
		homepage.clickOnSignInBtn();
		signpage.clickOnRegisterBtn();
		registerpage.registerToEtsy();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
