package Com_Add_Automation_Test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersTest.class)
public class ListenersDemoA
{
	@Test
	public void testA()
	{
		Reporter.log("Test method A",true);
	}
	
	@Test
	public void testB()
	{
		Reporter.log("Test method B",true);
	}

}
