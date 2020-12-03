package Com_Add_Automation_Test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaPropertiesFile
{
	@Test
	public void testA() throws InterruptedException, AWTException, IOException
	{
		//create and read properties file
		File f=new File("./src/test/resources/Data/input.properties");
		FileInputStream file=new FileInputStream(f);
		
		//creating object of Properties class
		Properties p=new Properties();
		
		//load the file
		p.load(file);
		
		//get the data
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		Thread.sleep(4000);
		driver.close();
	} 
}
