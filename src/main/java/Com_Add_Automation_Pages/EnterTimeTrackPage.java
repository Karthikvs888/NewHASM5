package Com_Add_Automation_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage
{
	//Declaration
	@FindBy(xpath="(//div[@class='popup_menu_icon'])[4]")
	private WebElement helpBT;
	
	@FindBy(xpath="//a[.='Contact actiTIME Support']")
	private WebElement contactBT;
	
	@FindBy(xpath="//div[@class='icon dz-clickable']")
	private WebElement attachBT;

	//Initialization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void clickHelpButton() 
	{
		helpBT.click();
	}

	public void clickContactButton() 
	{
		contactBT.click();
	}

	public void clickAttachButton() 
	{
		attachBT.click();
	}
	
	public void uploadFile(String file_path)
	{
		StringSelection file =new StringSelection(file_path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		try
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("faileddddddd");
		}
	}
}
