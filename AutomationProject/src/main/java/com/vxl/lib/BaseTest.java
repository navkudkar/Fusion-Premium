package com.vxl.lib;

import static com.vxl.lib.Global.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import console.ConsoleHelper;

public class BaseTest {
	
/*	public static Browser browser = new Browser();*/

    private static  String testMethodName = "";
    private static  String testClassName = "";
    private static String propertyFileName = "rc.properties";
    private static String propertyFileDirectory =  "properties" + File.separator + propertyFileName;
    private static String username = null;
    private static String password = null;
    private static String serverName = null;
    private boolean loginSuccess = false;


    /**
     * This method will log the method name which is being executed.
     * 
     * @param method to get test method name.
     *
     */
    @BeforeMethod
    public void beforeMethod(final Method method) {
    	testMethodName =  method.getName();
        System.out.println("===============================================================================");
        System.out.println(testClassName + "." + testMethodName + " : is getting executed.");
        System.out.println("===============================================================================");
    }
    
    
    /**
     * This method is called before each test run and before the test's @Before method.
     * @throws InterruptedException 
     * @throws IOException 
     */
    
	@BeforeClass
	public void beforeTest(){
		testClassName = this.getClass().getSimpleName();
		FileInputStream fileInput = null;
		System.out.println("==================================================================================");
		System.out.println("beforeClass: " + testClassName + " @Before - beforeTest() - open browser and login");
		System.out.println("==================================================================================");
		Properties prop = new Properties();
		File file = new File(propertyFileDirectory);

		try{
			fileInput = new FileInputStream(file); 
			prop.load(fileInput);


			username = prop.getProperty("username");
			password = prop.getProperty("password");  
			serverName = prop.getProperty("url");

			browser = browser.chrome();  
			browser.navigate(serverName); 

			
/*		    FudmConsole fudmConsole = PageFactory.initElements(browser.getDriver(), FudmConsole.class);	
			loginSuccess = fudmConsole.logInToFudm(username, password);*/	
			
			ConsoleHelper ch = new ConsoleHelper();
			loginSuccess = ch.logInToFudm(username, password);
			
			if (loginSuccess) {
				System.out.println("SUCCESS:  Able to log into FUDM console");
			} else {
				System.out.println("May be the locator of username and password is changed in GUI");
				/*        	System.out.println("Closing browser");
        	browser.getDriver().quit();*/
				System.out.println("Unsuccessful login to FUDM console");
			}

		}catch (Exception ex) {
			ex.printStackTrace();
			browser.captureScreenShot("login");
		}

		
	  }   
            // since Maven is having different folder structure,
            // we are using below approach to read the file.
		/*	URL resourceUrl = BaseTest.class.getClassLoader().getResource(propertyFile);
			if (null == resourceUrl) {
				throw new FileNotFoundException(propertyFile + "  file not found in the specified path.");
			}
			try {
				ressourceFile = new File(resourceUrl.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			
			if (ressourceFile.exists()) {
				propertyFile = ressourceFile.getAbsolutePath();
				System.out.println("property file Name with path is : " + propertyFile);
			}
            
			if (testUserName.isEmpty()) {
				//get value from property file, use default "Admin" if property file not found or can't find property in file.
               testUserName = getPropertyValue(propertyFile, "login.username", "Admin");
            }

           if (testPassword.isEmpty()) {
               //get value from property file, use default "hpinvent" if property file not found or can't find property in file.
               testPassword = getPropertyValue(propertyFile, "login.password", "admin");
           }
           if(!IP.isEmpty())
           {       	           
            if(!testUrl.isEmpty())
            {
         	   BaseTest.testUrl="";
         	   String protocol = getPropertyValue(propertyFile, "protocol", "https");
                String port = getPropertyValue(propertyFile, "port", "443");
                testUrl = protocol + "://" + IP + ":" + port;
            }
            else {
                //get values from property file.
                //String serverName = getPropertyValue(propertyFile, "serverName", "localhost");
                String protocol = getPropertyValue(propertyFile, "protocol", "https");
                String port = getPropertyValue(propertyFile, "port", "443");
                testUrl = protocol + "://" + IP + ":" + port;
            }
           }
           else
           {
         	  String serverName = getPropertyValue(propertyFile, "serverName", "localhost");
               String protocol = getPropertyValue(propertyFile, "protocol", "https");
               String port = getPropertyValue(propertyFile, "port", "443");
               testUrl = protocol + "://" + serverName + ":" + port;
           }

           if (testUrl.isEmpty()) {
               //get values from property file.
               String serverName = getPropertyValue(propertyFile, "serverName", "localhost");
               String protocol = getPropertyValue(propertyFile, "protocol", "https");
               String port = getPropertyValue(propertyFile, "port", "443");
               testUrl = protocol + "://" + serverName + ":" + port;
           }
           
           // navigate to the Avengers login window
           browser.navigate(testUrl);
           if(browserType.toUpperCase().equals("INTERNET EXPLORER"))
           {
        	   browser.navigate("javascript:document.getElementById('overridelink').click()");
           }
           Utility.sleep(7, TimeUnit.SECONDS);
           
           // login
           loginSuccess = login(testUserName, testPassword);
           // log an issue if logging in wasn't successful
           if (loginSuccess) {
               System.out.println("SUCCESS:  Able to log into Avengers");
           } else {
        	   System.out.println("may be the locator of username and password is changed in GUI");
               System.out.println("Closing browser");
               browser.close();
               System.out.println("UNSUCCESSFUL LOG IN TO Avengers");
           }
           Thread.sleep(4, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(testClassName + " - may be issue with browser driver.");
        }*/
  
	
	
    @AfterClass
	public void afterTest() throws IOException {
    	ConsoleHelper ch = new ConsoleHelper();
    	try {

			if (loginSuccess) {
				System.out.println("==================================================================================");
				System.out.println(testClassName+ "."+testMethodName+": @After - afterClasst() - logout and close browser");
				System.out.println("==================================================================================");
				if (!ch.logOut()) {
					System.out.println("Unable to logout from Avengers.");
					browser.getDriver().close();
				}
			} else {
				System.out.println("Login was not successfully done to the application");
				System.out.println(testClassName + "." + testMethodName + ": @After - afterTest() - close browser");
				browser.getDriver().close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// close browser
			System.out.println("Closing browser");
			browser.getDriver().close();
	//		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f/im firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefoxdriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		}
	}

}
