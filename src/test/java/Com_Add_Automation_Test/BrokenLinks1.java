package Com_Add_Automation_Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * One of the key test case is to find broken links on a webpage. Due to existence of broken links, your website reputation gets damaged and there will be a negative impact on your business. It’s mandatory to find and fix all the broken links before release. If a link is not working, we face a message as 404 Page Not Found.

Let’s see some of the HTTP status codes.

200 – Valid Link
404 – Link not found
400 – Bad request
401 – Unauthorized
500 – Internal Error
*/
 
public class BrokenLinks1 //3rd Link
{
	@Test
	public void testA() throws InterruptedException, IOException
	{
		URL url = new URL("http://www.qsp.com/");
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		
		int status = con.getResponseCode();
		Reporter.log("Url status = "+status,true);
		
		String messgae = con.getResponseMessage();
		Reporter.log("Url message = "+messgae,true);
	}
}
