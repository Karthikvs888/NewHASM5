package Com_Add_Automation_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG_tag2
{
	@Test
	public void testA() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/Advance%20Selenium/SVG.html");
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		int size = allElements.size();
		Reporter.log("All Elements :"+size,true);
		
		int count=0;
		Actions act=new Actions(driver);
		for (WebElement line : allElements)
		{
			String tagName = line.getTagName();
			
			if(tagName.equals("line"))
			{
				Thread.sleep(1000);
				count++;
				
				String bfcolour = line.getCssValue("stroke");
				Reporter.log("Colour Before placing the cursor :"+bfcolour,true);
				
				act.moveToElement(line).perform();
				
				String afcolour = line.getCssValue("stroke");
				Reporter.log("Colour After placing cursor :"+afcolour,true);
				Reporter.log("=====================================================",true);
				
				WebElement tooltip = line.findElement(By.xpath("following-sibling::*")); //This Line is Different from pp
				String text = tooltip.getText();
				Reporter.log("ToolTio Information :"+text,true);
				Reporter.log("=====================================================",true);
				
			}
		}
		Reporter.log("Number of Lines :"+count,true);
		driver.close();
	} 
}

