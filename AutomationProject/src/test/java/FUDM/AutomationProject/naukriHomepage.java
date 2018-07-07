package FUDM.AutomationProject;

import static com.vxl.lib.Global.browser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vxl.lib.BaseTest;

public class naukriHomepage extends BaseTest {
	
	/**
	 * This test contains details about 
	 */
	@Test
	public void sampleTest()
	{	
		boolean testResult= false;
		try{
			System.out.println("Browser Intiated");
			int a =5/0;
			testResult = true;
		}
		catch(Exception e){
			System.out.println("In test carch block");
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
