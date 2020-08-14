package etsy.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import etsy.BaseKeywords.TestBaseKeyword;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
 
public class TestUtil extends TestBaseKeyword {
	
	public static void fullPageScreenShot(int scrollTimeout) throws IOException
	{
		driver.getCurrentUrl();
		AShot shot=new AShot();
		Screenshot screen=shot.shootingStrategy(ShootingStrategies.viewportPasting(scrollTimeout)).takeScreenshot(driver);
		BufferedImage img=screen.getImage();
		ImageIO.write(img, "PNG",new File(prop.getProperty("imgfilename")));
	}
	public static void takeScreenShot(String testMethodName)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("D:\\EclipseWorkspace\\EtsyProjectFramework\\Screenshots\\"+testMethodName+".jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
