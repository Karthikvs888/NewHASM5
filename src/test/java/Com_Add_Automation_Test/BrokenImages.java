package Com_Add_Automation_Test;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages
{
	@Test
	public void testA() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./DemoA.png"));
		
		WebElement img = driver.findElement(By.xpath("//div[@class='atLogoImg']"));
		
		int x = img.getLocation().getX();
		int y = img.getLocation().getY();
		int h = img.getSize().getHeight();
		int w = img.getSize().getWidth();
		
		//Crop the image
		BufferedImage originalImage = ImageIO.read(new File("DemoA.png"));
		BufferedImage subImage = originalImage.getSubimage(x, y, w, h);
	
		ImageIO.write(subImage, "png", new File("./D.png")); 
		
		//read
		BufferedImage aimg = ImageIO.read(new File("./DemoA.png"));
		BufferedImage eimg = ImageIO.read(new File("./D.png"));
		
		DataBuffer aimgpix = aimg.getData().getDataBuffer();
		DataBuffer eimgpix = eimg.getData().getDataBuffer();
		
		int apixcount = aimgpix.getSize();
		int epixcount = eimgpix.getSize();

		int count=0;
		int matchcount=0;
	
		if(apixcount>epixcount)
		{
			count=epixcount;
		}
		else
		{
			count=apixcount;
		}
		
		for (int i = 0; i < count; i++) 
		{
			if(aimgpix.getElem(i) == eimgpix.getElem(i))
			{
				matchcount++;
			}
		}
		
		Reporter.log("Matching Count ="+matchcount,true);
		int percent=(matchcount*100)/epixcount;
		Reporter.log("Percent = "+percent,true);
		
		if(percent>72)
		{
			Reporter.log("The Image is Not Broken Image",true);
		}
		else
		{
			Reporter.log("The Image is Broken Image",true);
		}
		
		Thread.sleep(2000);
		driver.close();
	}
}
