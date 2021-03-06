package Com_Add_Automation_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenersTest2 implements ITestListener 
{
	WebDriver driver;
	public void onFinish(ITestContext arg0) 
	{
		driver.close();
	}

	public void onStart(ITestContext arg0)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
	{
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult arg0) 
	{
		Reporter.log("ScreenShot",true);
	}

	public void onTestSkipped(ITestResult arg0) 
	{
		Reporter.log("Test Method Skipped",true);
	}

	public void onTestStart(ITestResult arg0) 
	{
		driver.get("https://www.google.com/");
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		Reporter.log("Test Method Successfully excueted",true);
	}

}
