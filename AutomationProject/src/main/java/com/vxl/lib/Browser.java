package com.vxl.lib;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;




public class Browser {

 
    public final static String IE = "INTERNET EXPLORER";
    public final static String FIREFOX = "FIREFOX";
    public final static String CHROME = "CHROME";
    private int browserWidth;
    private int browserHeight;
    private WebDriver driver; 
    private final int defaultWidth = 1366;    
    private final int defaultHeight = 768; 
    private String browserType;
    
    /**
     * This method opens a Chrome browser, and returns a reference to this specific browser.
     * @return      a reference to a Chrome browser.
     */
    public Browser chrome () {
        return this.setBrowser(this.CHROME, this.defaultWidth, this.defaultHeight);
    }
    
    public Browser setBrowser (String browserType, int width, int height) {
        // setting browser type
        this.browserType = browserType;

        // setting width and height to default values
        this.browserWidth = width;
        this.browserHeight = height;
      

        // setting web driver for this browser based on the browser type
        this.setDriver();

        return this;
    }
    
    
    private void setDriver (){
    	 File f = new File(".");
    	 File chromePath = null;
    	 
    	 chromePath = new File("resources/drivers/chromedriver.exe");
    	 
    	 if (chromePath.exists()) {
             System.setProperty("webdriver.chrome.driver", chromePath.getAbsolutePath());
             DesiredCapabilities caps = DesiredCapabilities.chrome();       
             caps.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
             ChromeOptions options = new ChromeOptions();
             options.addArguments("disable-extensions");
             options.addArguments("disable-infobars");
             options.merge(caps);
             this.driver = new ChromeDriver(options);
             driver.manage().window().maximize();
         } else {
             throw new RuntimeException(("Failed to find Chrome Selenium driver at " + chromePath.getAbsolutePath()));
         }
    }
    
    public void navigate (String URL) {
        // in case the user is using an invalid URL, we need to give a nice message when this fails
        try {
            // navigating to the URL
            this.driver.get(URL);            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void close () {
        // if this.driver is null, it means that the browser has never been successfully started
        if (this.driver != null) {
            this.driver.close();
        }
        this.browserType = null;
    }
    
    /**
     * This method returns the browser instance. 
     * @return driver object.
     */
    public WebDriver getDriver() {
    	return driver;
    }    

    public void captureScreenShot(String scrName)
    {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	String path = "reports/screenshots";
    	File directory = new File(path);
    	File src= ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
    	try 
    	{	
    		if(!directory.exists())
    			directory.mkdir();
    		File dest = new File("reports/screenshots/"+scrName+"_"+sdf.format(timestamp)+".png");
    		FileUtils.copyFile(src, dest);
    		System.out.println("Screen shot captured and placed at location: "+dest.getAbsolutePath());
    	}
    	catch (IOException e)
    	{
    	System.out.println(e.getMessage());
    	}

    	}
    
    
}
