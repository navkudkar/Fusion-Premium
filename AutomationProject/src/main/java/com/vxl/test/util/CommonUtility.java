package com.vxl.test.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * This class provides common utility methods.
 */
public class CommonUtility {

	/**
	 * This method returns the absolute path of the file present in resources folder of the project.
	 * @param filePath Name of the file (like NewFolder/data.txt).
	 * @return Absolute path of the file.
	 * @throws FileNotFoundException
	 */
	public String getFilePath(String filePath) throws FileNotFoundException{
		
		//Get the file from resources folder.
		File ressourceFile = null;
		String absoluteFilePath = null;
		
		URL resourceUrl = getClass().getClassLoader().getResource(filePath);
		if (null == resourceUrl) {
			throw new FileNotFoundException(filePath + "  file not found in the specified path.");
		}
		
		try {
			ressourceFile = new File(resourceUrl.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		if (ressourceFile.exists()) {
			absoluteFilePath = ressourceFile.getAbsolutePath();
			System.out.println("Path of the input file is : " + absoluteFilePath);
		}
		return absoluteFilePath;
	}
}