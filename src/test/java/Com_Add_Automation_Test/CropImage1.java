package Com_Add_Automation_Test;

import java.awt.image.BufferedImage;
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
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CropImage1
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
		Files.copy(src, new File("./FullImage.png"));
		
		WebElement img = driver.findElement(By.xpath("//div[@class='atLogoImg']"));
		
		int x = img.getLocation().getX();
		int y = img.getLocation().getY();
		int h = img.getSize().getHeight();
		int w = img.getSize().getWidth();
		
		//Crop the image
		BufferedImage originalImage = ImageIO.read(new File("FullImage.png"));
		BufferedImage subImage = originalImage.getSubimage(x, y, w, h);
	
		ImageIO.write(subImage, "png", new File("./CropImage.png")); 
		
		Thread.sleep(2000);
		driver.close();
	}
}
