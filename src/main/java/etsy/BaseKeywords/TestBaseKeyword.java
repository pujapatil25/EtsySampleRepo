package etsy.BaseKeywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseKeyword {
	public static WebDriver driver;
	public static Properties prop;
	public static WebElement element;
	public static Alert alert;

	public TestBaseKeyword() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\EclipseWorkspace\\EtsyProjectFramework\\src\\main\\java\\etsy\\Config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Invalid Browser Name");
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "XPATH":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "NAME":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "CLASS":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "LINKTEXT":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			System.out.println("Invalid locator Type Name");
			break;
		}
		return element;
	}
	/*public static void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	public static void clickOn(String locatorValue) {
		driver.findElement(By.xpath(locatorValue)).click();
	}
	public static void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}*/
	public static String getLocator(String element)
	{
		String elementFromOR = prop.getProperty(element);
		String locatorType=elementFromOR.split("##")[0].trim();
		String locatorValue=elementFromOR.split("##")[1].trim();
		return locatorValue;
	}
	public static void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	public static void rejectAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public static void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	public static void mouseHoverOn(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void scrollingPage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
