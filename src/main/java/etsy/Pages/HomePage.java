package etsy.Pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import etsy.BaseKeywords.TestBaseKeyword;

public class HomePage extends TestBaseKeyword {
	@FindBy(name = "search_query")
	WebElement searchBox;
	@FindBy(id = "logo")
	WebElement etsyLogo;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement signInButton;
	@FindBy(xpath = "//span[contains(text(),'Jewellery & Accessories')]")
	WebElement jwelleryLink;
	@FindBy(xpath = "//span[contains(text(),'Home & Living')]")
	WebElement homeAndLivingLink;
	@FindBy(id = "catnav-l3-10961")
	WebElement homeDecorLink;
	@FindBy(id= "side-nav-category-link-3288")
	WebElement bathAndBeautiesLink;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateEtsyImageLogo()
	{
		return etsyLogo.isDisplayed();
	}
	public SignInPage clickOnSignInBtn()
	{
		signInButton.click();
		return new SignInPage();
	}
	public boolean checkSubMenuHomeLiving()
	{
		mouseHoverOn(homeAndLivingLink);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return bathAndBeautiesLink.isDisplayed();
		
	}
	public void verifyAllSubMenuLinks()
	{
		mouseHoverOn(homeAndLivingLink);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div/div[3]/div/div/div/section[1]/div/ul/li"));
		System.out.println("links are"+list.size());
	}
	public HomeAndLivingPage clickOnHomeAndLivingLink()
	{
		homeAndLivingLink.click();
		return new HomeAndLivingPage();
	}
	
}
