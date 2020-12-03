package Com_Add_Automation_Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckAllBrokenLinks 
{
	@Test
	public void testA() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/Advance%20Selenium/broken.html");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Reporter.log("Total Number of Links on the webpage = "+allLinks.size(),true);

		for (WebElement link : allLinks) 
		{
			String text = link.getText();
			Reporter.log("Link Name = "+text,true);
			String href = link.getAttribute("href");
			Reporter.log("Href Value = "+href,true);
		
			try
			{
				URL url=new URL(href);
				HttpURLConnection con=(HttpURLConnection)url.openConnection();
				int code = con.getResponseCode();
				Reporter.log("Url code = "+code,true);
				
				if(code==200)
				{
					Reporter.log("Link is not Broken",true);
				}
				else
				{
					Reporter.log("Url Code = "+code,true);
					Reporter.log("Link is Broken",true);
					String message = con.getResponseMessage(); 
					Reporter.log("Response Message = "+message,true);
				}
			}
			catch (Exception e)
			{
				Reporter.log("The Link is Invalid",true);
			}
		}
		Thread.sleep(2000);
		driver.close();
	}
}
