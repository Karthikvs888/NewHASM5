package Com_Add_Automation_Test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersTest implements ITestListener 
{

	public void onFinish(ITestContext arg0) 
	{
		Reporter.log("My Test Method Completed",true);
	}

	public void onStart(ITestContext arg0)
	{
		Reporter.log("My Test Method Strated",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
	{
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult arg0) 
	{
		Reporter.log("Test Method Failed",true);
	}

	public void onTestSkipped(ITestResult arg0) 
	{
		Reporter.log("Test Method Skipped",true);
	}

	public void onTestStart(ITestResult arg0) 
	{
		Reporter.log("Before start of Test Method",true);	
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		Reporter.log("Test Method Successfully excueted",true);
	}

}
