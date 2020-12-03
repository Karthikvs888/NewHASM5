package com_actiTIME_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Com_Add_Automation_Pages.EnterTimeTrackAssignmentPage;
import Com_Add_Automation_Pages.LoginPage;
import Com_Add_Automation_Pages.ReportsDashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class P1 
{
	@Test
	public void tc_01() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com/reports/reports.do");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("manager");
		lp.clickOnLogin();
		
		ReportsDashboardPage rp=new ReportsDashboardPage(driver);
		rp.clickOnTimeTrackMenuBar();
		
		EnterTimeTrackAssignmentPage et=new EnterTimeTrackAssignmentPage(driver);
		et.clickOnAddNew();
		et.clickOnDropdownButton();
		et.clickOnNewCustomer();
		et.enterCustomerName("BenStokes");
		et.enterProjectName("ECB");
		et.enterTaskName("Training");
		et.enterEstimateHours("2");
		et.setDeadline(driver, 11);
		et.setCreateNewTasksButton();
		
		Thread.sleep(2000);
		driver.close();
	}
}
