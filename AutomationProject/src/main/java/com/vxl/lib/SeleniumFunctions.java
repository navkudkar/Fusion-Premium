package com.vxl.lib;

import static com.vxl.lib.Global.browser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.fudm.constants.FudmConstants;

/**
 * This class contains helper common selenium operation
 * @author Prashant Navkudkar
 *
 */
public class SeleniumFunctions {

	WebDriver driver;

	public SeleniumFunctions(){
		this.driver = browser.getDriver() ;
	}

	/**
	 * This function does following:
	 * step 1 : check for the element is clickable
	 * step 2:  click on the element
	 * step 3:  if fail to click using normal click then will try to with javascript click
	 * @param elementToBeClicked Element on which click operation to be performed
	 * @param eleName Name of the element
	 */
	public void click(WebElement elementToBeClicked, String eleName){

		WebElement element=elementToBeClicked;
		try
		{
			Assert.assertTrue(isElementClickable(elementToBeClicked, eleName, 0));
			element.click();
			System.out.println("Clicked on "+eleName+" successfully");
		}
		catch(Exception ex)
		{
			try{
				((JavascriptExecutor) driver).executeScript("window.scrollby(0, document.body.scrollHeight)");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
			catch (StaleElementReferenceException e) {
				System.out.println("Element is not attached to the page document "+ e.getStackTrace());
			} 
			catch (NoSuchElementException e) {
				System.out.println("Element was not found in DOM "+ e.getStackTrace());
			}
			catch(Exception e){		
				System.out.println("Unable to click on element "+eleName);
				e.getStackTrace();
			}
		}
		
	}

	public boolean isElementVisible(WebElement elementToBeClicked, String eleName, int timeOut){

		WebElement element = elementToBeClicked;

		try
		{
			if (timeOut == 0){
				timeOut = FudmConstants.DEFAULT_TIMEOUT;
			}
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element is visible: "+eleName);			

		}
		catch(Exception e)
		{
			System.out.println("Element is not visible"+eleName);
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean isElementClickable(WebElement elementToBeClicked, String eleName, int timeOut)
	{
		try
		{
			if (timeOut == 0){
				timeOut = FudmConstants.DEFAULT_TIMEOUT;
			}
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
			System.out.println(eleName+" element is clickable");
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(eleName+" element not clickable");
			ex.printStackTrace();
			return false;
		}
	}
	
	public void enterText(WebElement element, String input, String fieldName){
			
		try{
			
			isElementVisible(element, fieldName, FudmConstants.DEFAULT_TIMEOUT);
			element.sendKeys(input);
			System.out.println("Text entered "+input +" successfully in the field "+fieldName );
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void selectValue(WebElement element, String input, String fieldName){
		
		try{
			
			isElementVisible(element, fieldName, FudmConstants.DEFAULT_TIMEOUT);
			isElementClickable(element, fieldName, FudmConstants.DEFAULT_TIMEOUT);
			Select select = new Select(element);
			select.selectByVisibleText(input);
			System.out.println("Value Selected is  "+select.getFirstSelectedOption().getText() );
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}	

