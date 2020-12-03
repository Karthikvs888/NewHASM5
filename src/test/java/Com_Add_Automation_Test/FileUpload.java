package Com_Add_Automation_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Com_Add_Automation_Pages.EnterTimeTrackPage;
import Com_Add_Automation_Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload 
{
	@Test
	public void testA() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		
		lp.enterUserName("admin");
		lp.enterPassword("manager");
		lp.clickOnLogin();
		
		Thread.sleep(3000);
		
		ep.clickHelpButton();
		ep.clickContactButton();
		ep.clickAttachButton();
		Thread.sleep(1000);
		ep.uploadFile("E:\\Selenium Extras\\DUMMY.docx");
		
		Thread.sleep(4000);
		driver.close();
		
	} 
}
