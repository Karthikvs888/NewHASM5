package Com_Add_Automation_Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks5 //3rd Link
{
	@Test
	public void testA() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("file:///E:/Advance%20Selenium/broken.html");
		WebElement link = driver.findElement(By.linkText("Qsp"));
		Reporter.log("Element name = "+link.getText(),true);
		
		String href = link.getAttribute("href");
		Reporter.log("Attribute value = "+href,true);
		
		try
		{
			URL url=new URL(href);
			
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			
			int status = con.getResponseCode();
			Reporter.log("Url status code = "+status,true);
			
			if(status==200)
			{
				Reporter.log("Link is not Broken",true);
			}
			else
			{
				Reporter.log("Link is Broken",true);
				String message = con.getResponseMessage(); 
				Reporter.log("Response Message = "+message,true);
			}
		}
		catch (Exception e)
		{
			Reporter.log("The Link is Invalid",true);
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
