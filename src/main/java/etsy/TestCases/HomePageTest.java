package etsy.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import etsy.BaseKeywords.TestBaseKeyword;
import etsy.Pages.HomeAndLivingPage;
import etsy.Pages.HomePage;
import etsy.Util.CustomListner;
import etsy.Util.TestUtil;
@Listeners(CustomListner.class)
public class HomePageTest extends TestBaseKeyword {
	HomePage homepage;
	HomeAndLivingPage homeandlivpage;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage=new HomePage();
	}
	@Test
	public void takeFullPageScreenshot() throws IOException
	{
		TestUtil.fullPageScreenShot(600);
	}
	@Test(priority = 1)
	public void homePageTitleTest()
	{
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
	}
	@Test(priority = 2)
	public void etsyImageLogoTest()
	{
		boolean flag=homepage.validateEtsyImageLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void signInBtnClick()
	{
		homepage.clickOnSignInBtn();
	}
	@Test
	public void checkBathAndBeautySubMenu()
	{
		homepage.checkSubMenuHomeLiving();
	}
	@Test
	public void verifyLinksTest()
	{
		homepage.verifyAllSubMenuLinks();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
