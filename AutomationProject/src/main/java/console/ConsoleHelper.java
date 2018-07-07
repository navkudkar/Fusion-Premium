package console;


import static com.vxl.lib.Global.browser;

import org.testng.Assert;

import com.fudm.screens.FudmConsolePanel;
import com.fudm.screens.FudmHomepagePanel;
import com.vxl.lib.SeleniumFunctions;

public class ConsoleHelper {
	
	private FudmConsolePanel  fc = new FudmConsolePanel();
	private FudmHomepagePanel fh = new FudmHomepagePanel();
	
	SeleniumFunctions selFunc = new SeleniumFunctions();
	
	public boolean logInToFudm(String uname, String passwd) throws InterruptedException{
		boolean loginResult = false;
		System.out.println("Log into Fusion Device Manager console");
		fc.getUsername().sendKeys(uname);
		fc.getPassword().sendKeys(passwd);
		fc.getLogin().click();	
		Assert.assertTrue(selFunc.isElementVisible(fh.getLogoutLink(), "logoutButton", 120));
		loginResult = true;
		return loginResult;
	}
	
	public boolean logOut() throws InterruptedException{
		
			boolean loginResult = false;			
			System.out.println("Logging out from FUDM console:");
			selFunc.click(fh.getLogoutLink(), "Logout button");
			selFunc.click(fh.getAlertOk(), "Alert Ok button");
			Assert.assertTrue(fc.getUsername().isDisplayed(), "Failed to log out from FUDM console");
			System.out.println("Logout from FUDM console successfully");
			loginResult = true;
			return loginResult;	
	}
}
