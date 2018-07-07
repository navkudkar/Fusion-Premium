package usermanagement;
import org.testng.Assert;

import com.fudm.constants.ConfigurationSetupConstants;
import com.fudm.screens.ConfigurationSetup;
import com.fudm.screens.FudmHomepagePanel;
import com.fudm.screens.UserManagementPanel;
import com.vxl.lib.SeleniumFunctions;

/**
 * This class helper functions related to the configuration setup 
 * @author Prashant Navkudkar
 */
public class UserMgmtHelper {
	
	
	SeleniumFunctions seleniumFunctions = new SeleniumFunctions();
	ConfigurationSetup configurationSetup = new ConfigurationSetup();
	FudmHomepagePanel fh = new FudmHomepagePanel();
	UserManagementPanel userManagementPanel = new UserManagementPanel();

	/**
	 * This method use to navigates to the user management page
	 * @author prashant navkudkar
	 */
	
	public void navigateToUserMgmt()
	{
		seleniumFunctions.click(fh.getViews(), "Views");
		seleniumFunctions.click(fh.getConfig_setup(), "configuration setup");
		seleniumFunctions.click(fh.getExpandMenu(), "ExpandMenu");
		Assert.assertTrue(fh.getMenuTitle().getText().equals(ConfigurationSetupConstants.CONFIG_MENU_TITLE),
				"Title of the configuration menu does not match");
		System.out.println("Title of the menu side bar matched successfully");
		Assert.assertTrue(fh.getViewHeader().getText().equals(ConfigurationSetupConstants.CONFIG_MENU_TITLE.toUpperCase()),
				"Header of the configuration page does not match");
		System.out.println("Header of the configuration page matched successfully");
		System.out.println("User navigated successfully to configuration setup view");
		
	}
	
	
	public void addUser(){
		
		System.out.println("Navigating to the configuration setup");
		navigateToUserMgmt();
		seleniumFunctions.click(configurationSetup.getUserMgmtLink(), "User ");
		seleniumFunctions.isElementVisible(userManagementPanel.getUserMgmtHeader(), "Page Header", 0);
		Assert.assertEquals(userManagementPanel.getUserMgmtHeader().getText().trim(), "USER MANAGEMENT","User page title does not match");
		System.out.println("User management page title matched successfully");
		seleniumFunctions.click(userManagementPanel.getNewUserButton() , " New User button");
		seleniumFunctions.enterText(userManagementPanel.getUserNameTextbox(), "prashant", "Username");
		seleniumFunctions.enterText(userManagementPanel.getPasswordTextbox(), "admin123", "Password");
		seleniumFunctions.enterText(userManagementPanel.getConformPassTextbox(), "admin123", "Conform Password");
		seleniumFunctions.click(userManagementPanel.getNextButton(), "Next Button");
		seleniumFunctions.enterText(userManagementPanel.getFirstNameTextbox(), "prashant", "First Name");
		seleniumFunctions.enterText(userManagementPanel.getLastNameTextbox(), "Navkudkar", "Last Name");
		seleniumFunctions.enterText(userManagementPanel.getEmailIDTextbox(), "prashant.navkudkar@vxlsoftware.com", "Email ID");
		seleniumFunctions.click(userManagementPanel.getNextButtonPersonalInfo(), "Next Button");
		seleniumFunctions.selectValue(userManagementPanel.getSelectUserGroup(), "ADMIN", "User Group");
		seleniumFunctions.click(userManagementPanel.getSaveButton(), "Save button");
		
		
		
	}
	
}
