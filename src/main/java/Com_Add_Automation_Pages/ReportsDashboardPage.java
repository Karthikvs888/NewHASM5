package Com_Add_Automation_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsDashboardPage 
{
	//Declaration
	@FindBy(id="container_tt")
	private WebElement timeTrackMenuBar;

	//Initialization
	public ReportsDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void clickOnTimeTrackMenuBar()
	{
		timeTrackMenuBar.click();
	}
}
