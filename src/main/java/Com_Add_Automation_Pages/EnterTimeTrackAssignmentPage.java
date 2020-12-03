package Com_Add_Automation_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackAssignmentPage
{
	//Declaration
	@FindBy(xpath="//span[.='New']")
	private WebElement addNew;
	
	@FindBy(xpath="(//div[@class='dropdownButton'])[5]")
	private WebElement dropdownButton;
	
	@FindBy(xpath="//div[text()='- New Customer -']")
	private WebElement newCustomer;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name']")
	private WebElement enterCustomerName;
	
	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	private WebElement enterProjectName;
	
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement enterTaskName;
	
	@FindBy(xpath="(//input[@placeholder='not needed'])[1]")
	private WebElement estimateHours;
	
	@FindBy(id="ext-gen34")
	private WebElement deadline;
	
	@FindBy(xpath="//div[.='Create Tasks']")
	private WebElement createNewTasksButton;
	
	//Initialization
	public EnterTimeTrackAssignmentPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void clickOnAddNew()
	{
		addNew.click();
	}

	public void clickOnDropdownButton() 
	{
		dropdownButton.click();
	}

	public void clickOnNewCustomer()
	{
		newCustomer.click();
	}

	public void enterCustomerName(String cn) 
	{
		enterCustomerName.sendKeys(cn);
	}

	public void enterProjectName(String pn) 
	{
		enterProjectName.sendKeys(pn);
	}

	public void enterTaskName(String tn) 
	{
		enterTaskName.sendKeys(tn);
	}

	public void enterEstimateHours(String eh) 
	{
		estimateHours.sendKeys(eh);
	}

	public void setDeadline(WebDriver driver, int day) 
	{
		deadline.click();
		driver.findElement(By.xpath("(//span[.='"+day+"'])[1]")).click();
	}

	public void setCreateNewTasksButton() 
	{
		createNewTasksButton.click();
	}

	
	
}

