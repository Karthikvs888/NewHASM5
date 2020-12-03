package Com_Add_Automation_Test;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Com_Add_Automation_Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUpScreenShot3
{
	@Test
	public void testA() throws InterruptedException, AWTException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.enterUserName("admin");
		lp.enterPassword("manager");
		lp.clickOnLogin();
		
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[4]")).click();
		driver.findElement(By.xpath("//a[.='Contact actiTIME Support']")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./Screenshot/c.png"));
		
		Thread.sleep(2000);
		driver.quit();
		
	} 
}

