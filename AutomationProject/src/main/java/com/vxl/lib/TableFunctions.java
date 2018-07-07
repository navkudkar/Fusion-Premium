package com.vxl.lib;

import static com.vxl.lib.Global.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * This class contains helper common selenium operation
 * @author Prashant Navkudkar
 *
 */
public class TableFunctions {


	public List<WebElement> getRows(WebDriver driver){
		
		WebElement table = driver.findElement(By.className("tsc_table_s13"));
		List<WebElement> totalRows= table.findElements(By.xpath("tbody/tr"));
		return totalRows;
	}	
	
	public List<WebElement> getColumnHeading(WebDriver driver){
		
		WebElement table = driver.findElement(By.className("tsc_table_s13"));
		List<WebElement> totalColumnsList= table.findElements(By.xpath("thead/tr/th"));
		return totalColumnsList;
	}	
	
	public WebElement getRowElements(WebDriver driver, int rowIndex){
		
		WebElement table = driver.findElement(By.className("tsc_table_s13"));
		List<WebElement> totalRows= table.findElements(By.xpath("tbody/tr"));
		return totalRows.get(rowIndex-1);
	}
	
	public String[] getRowText(WebDriver driver, int rowNum){
		String[] data = {};
		WebElement row = getRowElements(driver, rowNum);
		List<WebElement> columnElements = row.findElements(By.xpath("td"));
		data = new String[columnElements.size()];
		for(int j=0; j<columnElements.size(); j++)
		{
			WebElement column = columnElements.get(j);
			data[j] = column.getText();
		}
		return data;
	}
	
	public String getCellData(WebDriver driver, int rowNum, int colNum){
		String[] rowData = getRowText(driver, rowNum);				
		return rowData[colNum-1];
	}
	
	public int getColumnIndex(WebDriver driver, String columnName){
		int returnValue =-1;
		List<WebElement> colHeadings = getColumnHeading(driver);
		for (int i=0; i<colHeadings.size(); i++)
			{
				if(columnName.equalsIgnoreCase(colHeadings.get(i).getText().trim()))
				{
					returnValue = i;
					break;
				}									
			}		
		return returnValue;
	}	
	
	public int findItemInColumn(WebDriver driver, String itemName, String colName){
		int rowIndex = -1;
		int colIndex = getColumnIndex(driver, colName);
		List<WebElement> rows = getRows(driver);
		int totalRows = rows.size();
		for (int i=0; i<totalRows; i++)
		{
			WebElement row = rows.get(i);
			WebElement column = row.findElement(By.xpath("td["+colIndex+"]"));
			if( column.getText().trim().equals(itemName)){
				rowIndex = i+1;
			}			
		}
		return rowIndex;
	}
	
	
	
}	

