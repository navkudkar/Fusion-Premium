package com.vxl.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * This Utility class is used to read data from excel sheet for Data Driven testing.
 * @author Prashant Navkudkar
 */
public class ExcelUtility {

	public Object[][] getExcelData(String fileName, String sheetName)  throws Exception
	{
		Map <Object, Object> datamap = null;
		Object[][] dataobject = null;
		try{
			File files  = new File(fileName);
			FileInputStream fis = new FileInputStream(files);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			wb.close();
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			dataobject = new Object[rowCount][1];
			for(int i =0 ; i<rowCount;i++)
			{
				datamap = new HashMap();
				for(int j =0;j<colCount;j++)
				{
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
				}
				dataobject[i][0] = datamap;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dataobject;	
	}


	/*
	private XSSFSheet excelWSheet;

	private XSSFWorkbook excelWBook;

	private XSSFCell cell;

	 *//**
	 * This method reads data from excel sheet and return a 2D  object array containing the data. 
	 * Each element of 2D array holds a java map. The map contains data of each row in excel sheet.  
	 * @param filePath Path of the .xlsx file (excel 2010 and 2013 format)
	 * @param sheetName Name of the sheet in excel file.
	 * @return 2Dimensional object array containing the data.
	 * @throws Exception
	 *//*
	public Object[][] getTableData(String filePath, String sheetName) throws Exception {

		//Get the absolute path of the file from resources folder.
		CommonUtility commonUtil = new CommonUtility();
		String absoluteFilePath = commonUtil.getFilePath(filePath);

		Map<String, Object> dataMap =  null;
		Object[][] tabDataMap = null;

		try {

			FileInputStream excelFile = new FileInputStream(absoluteFilePath);

			// Access the required test data sheet

			excelWBook = new XSSFWorkbook(excelFile);

			excelWSheet = excelWBook.getSheet(sheetName);

			int startRow = 1, startCol = 0, ci;

	  *//** Total number of rows in the sheet*//*
			int totalRows = excelWSheet.getLastRowNum();

	   *//** Total number of Columns in the sheet*//*
			int totalCols = excelWSheet.getRow(0).getLastCellNum();

			tabDataMap = new Object[totalRows][1];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++ , ci++) {
				dataMap =  new LinkedHashMap<String, Object>();

				for (int j = startCol; j < totalCols; j++) {
					dataMap.put((String) getCellData(0, j), getCellData(i, j));
				}

				tabDataMap[ci][0] = dataMap;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not find Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabDataMap);
	}

	    *//**
	    * This method reads data from a particular cell. If there is no data in the cell, it returns a blank value.
	    * @param rowNum The row number which is to be read.
	    * @param colNum The column which is to be read.
	    * @return Data in the form of object 
	    * @throws Exception
	    *//*
	private Object getCellData(int rowNum, int colNum) throws Exception {

		try {
			Object cellData = "";
			cell = excelWSheet.getRow(rowNum).getCell(colNum);

			if(null == cell){
				return cellData;
			}

			switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING: 	cellData =  cell.getStringCellValue();
													break; 

				case XSSFCell.CELL_TYPE_NUMERIC:	cell.setCellType(cell.CELL_TYPE_STRING);
													cellData =  cell.getStringCellValue();
													break;

				case XSSFCell.CELL_TYPE_BOOLEAN: 	cellData =  cell.getBooleanCellValue();
													break; 

				case XSSFCell.CELL_TYPE_BLANK :     break; 

				default : 
			}
			return cellData;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}
	}*/
}

/*	*//**
 * This method reads data from excel sheet and return a 2D  object array containing the data.
 * @param filePath Path of the .xlsx file (excel 2010 and 2013 format)
 * @param sheetName Name of the sheet in excel file.
 * @return 2Dimensional object array containing the data.
 * @throws Exception
 *//*
		public Object[][] getTableArray(String filePath, String sheetName) throws Exception {

			//Get the absolute path of the file from resources folder.
			CommonUtility commonUtil = new CommonUtility();
			String absoluteFilePath = commonUtil.getFilePath(filePath);

			Object[][] tabArray = null;

			try {

				FileInputStream excelFile = new FileInputStream(absoluteFilePath);

				// Access the required test data sheet

				excelWBook = new XSSFWorkbook(excelFile);

				excelWSheet = excelWBook.getSheet(sheetName);

				int startRow = 1, startCol = 0, ci, cj;

  *//** Total number of rows in the sheet*//*
				int totalRows = excelWSheet.getLastRowNum();

   *//** Total number of Columns in the sheet*//*
				int totalCols = excelWSheet.getRow(0).getLastCellNum();

				tabArray = new Object[totalRows][totalCols];

				ci = 0;

				for (int i = startRow; i <= totalRows; i++, ci++) {

					cj = 0;

					for (int j = startCol; j < totalCols; j++, cj++) {
						tabArray[ci][cj] = getCellData(i, j);
					}

				}
				displayExcelSheetData(tabArray, sheetName);
			} catch (FileNotFoundException e) {
				System.out.println("Could not find Excel sheet");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			return (tabArray);
		}

    *//**
    * Display the content of a particular sheet in excel sheet.
    * @param sheetData Data of the sheet stored in 2D object array.
    * @param sheetName Name of the sheet in excel file.
    *//*
	private void displayExcelSheetData(Object[][] sheetData, String sheetName){
		System.out.println("The data present in " + sheetName + " sheet of excel file is given below");
		System.out.println("-----------------------------------------------------------------------------------");
		for(int i = 0; i < sheetData.length; i++)
		{
		    for(int j = 0; j < sheetData[i].length; j++)
		    {
		        System.out.print(sheetData[i][j]);
		        if(j < sheetData[i].length - 1) 
		        	System.out.print(" ");
		    }
		    System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
     */


