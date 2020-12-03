package Com_Add_Automation_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGdemo_tag_Assignment
{
	@Test
	public void testA() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/Advance%20Selenium/svgdemo.html");
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		int size = allElements.size();
		Reporter.log("All Elements :"+size,true);
		
		int count=0;
		
		for (WebElement circle : allElements)
		{
			String tagName = circle.getTagName();
			
			if(tagName.equals("circle"))
			{
				Thread.sleep(1000);
				count++;
				
				String colour = circle.getCssValue("stroke");
				Reporter.log("Colour of the Circle :"+colour,true);
				
				Reporter.log("=========================================",true);
			}
		}
		Reporter.log("Number of circles :"+count,true);
		driver.close();
	} 
}

