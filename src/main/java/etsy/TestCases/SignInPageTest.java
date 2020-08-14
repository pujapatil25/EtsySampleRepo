package etsy.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsy.BaseKeywords.TestBaseKeyword;
import etsy.Pages.HomePage;
import etsy.Pages.SignInPage;

public class SignInPageTest extends TestBaseKeyword{
	HomePage homepage;
	SignInPage signpage;
	public SignInPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage=new HomePage();
		signpage=new SignInPage();
	}
	@Test(priority = 1)
	public void displayCheck()
	{ homepage.clickOnSignInBtn();
		Assert.assertEquals(true,signpage.checkDisplay(),"Element not displayed");
	}
	@Test(priority = 2)
	public void signInEtsyTest()
	{
		homepage.clickOnSignInBtn();
		signpage.signInToEtsy();
	}
	@Test(priority = 3)
	public void clickOnRegisterToOpenPage()
	{
		homepage.clickOnSignInBtn();
		signpage.clickOnRegisterBtn();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
