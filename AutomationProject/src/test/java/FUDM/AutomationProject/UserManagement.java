package FUDM.AutomationProject;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vxl.test.util.ExcelUtility;
import usermanagement.UserMgmtHelper;

/**
 * This class contains test scenario related to the user creation
 * @author Prashant Navkudkar
 */
public class UserManagement{

//	private static Logger Log = Logger.getLogger(Login.class.getName());
	
	@Test(dataProvider = "createUserData")
	public void createUser(Map<Object, Object> map)
	{	
		UserMgmtHelper userMgmt = new UserMgmtHelper();		
		boolean testResult = false;	
		try{
			System.out.println("test");
			System.out.println(map);
//			String username = (String)map.get("username");
//			String password = (String)map.get("password");			
			System.out.println("------------ Verifying create user scenario -------------");
			userMgmt.addUser();	
			testResult = true;

		}
		catch(Exception e){
			e.printStackTrace();
		}	
		
		if(testResult)
		{
			System.out.println("************ SUCCESS: Create user functionality verified successfully ************");
		}
		else
		{
			Assert.fail("======== FAILED: create user functionality failed =============");;
		}
	}
	
	/**
	 * This method is reading data from the excel sheet for data driven testing.
	 * @return Object[][] excel sheet data as 2D array
	 * @throws Exception throws exception if there is issue occurred in reading excel sheet.
	 */
	@DataProvider(name = "createUserData")
	public Object[][] testData() throws Exception {
		ExcelUtility excelUtils = new ExcelUtility();
		Object[][] testObjArray = excelUtils.getExcelData("dataSet//fudmUser//createUser.xlsx", "user");
		return (testObjArray);
	}
}
