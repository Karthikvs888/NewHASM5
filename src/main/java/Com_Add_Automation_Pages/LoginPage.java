package Com_Add_Automation_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Declaration
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement lgBT;

	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void enterUserName(String un) 
	{
		unTB.sendKeys(un);
	}

	public void enterPassword(String pw) 
	{
		pwTB.sendKeys(pw);
	}

	public void clickOnLogin() 
	{
		lgBT.click();
	}
}
