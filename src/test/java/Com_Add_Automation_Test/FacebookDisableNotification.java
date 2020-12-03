package Com_Add_Automation_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookDisableNotification 
{
	@Test
	public void facebookLogin() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(cp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("8951370580");
		WebElement pwdTB = driver.findElement(By.id("pass"));
		pwdTB.sendKeys("rahuldravid",Keys.ENTER);
		
		Thread.sleep(2000);
		driver.close();
	}
}
