package FUDM.AutomationProject;
import static com.vxl.lib.Global.browser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vxl.lib.BaseTest;
import com.vxl.lib.TableFunctions;


public class TableVerification{
	
	TableFunctions tblFunc = new TableFunctions();
	
	@Test
	public void verifyTable(){
		
		File chromePath = new File("resources/drivers/chromedriver.exe");
		WebDriver driver = null;
		try{
        System.setProperty("webdriver.chrome.driver", chromePath.getAbsolutePath());		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-table/");
		System.out.println(tblFunc.getRows(driver).size());
		System.out.println(tblFunc.getColumnHeading(driver).size());
		System.out.println(tblFunc.getCellData(driver, 1, 3));
		System.out.println(tblFunc.findItemInColumn(driver, "Shanghai" , "City"));
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		
		finally {
			driver.close();
		}
	}

}
