package FUDM.AutomationProject;

import static com.vxl.lib.Global.browser;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vxl.lib.BaseTest;

public class Login extends BaseTest {
	
	//private static Logger Log = Logger.getLogger(Login.class.getName());
	
	/**
	 * This test contains details about 
	 */
	@Test
	public void sampleTest()
	{	
		boolean testResult= false;
		try{
			System.out.println("Browser Intiated");

			//int a =5/2;
			testResult = true;
		}
		catch(Exception e){
			System.out.println("In test catch block");
			e.printStackTrace();
			browser.captureScreenShot("Airthmatic");

		}
		
		if(testResult)
		{
			System.out.println("Test case passed");
		}
		else
		{
			Assert.fail("Test case failed");;
		}
	}
}
