package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utility.ScreenshotUtil;

public class Base {
	protected WebDriver driver;
	
	//properties object to read the config values
	Properties prop;
	public WebDriver getDriver() {
		return driver;
	}
	
	//method to read values from the config file
	public void readProp() throws IOException {
		//Load values of the file usinf filereader
		FileReader f1=new FileReader("C:\\SDET\\Internship\\Automation\\Project\\src\\test\\resources\\config.properties");
		//initializing the object
		prop=new Properties();
		prop.load(f1);
	}
	
	//this method runs before executing any test
	@BeforeTest
	public void setup() throws IOException {
		//To read the value of config file
		readProp();
		//Chrome options to customize browser behavior
		ChromeOptions options = new ChromeOptions();
		//custom profile to suppress password popuos
		options.addArguments("--user-data-dir=C:/temp/chrome-profile-automation");
		//Disable password leak
		options.addArguments("--disable-features=PasswordLeakDetection");
		//disable chrome password manager
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
	    //For initializing the driver 
	    driver = new ChromeDriver(options);
	    //maximize browser window
	    driver.manage().window().maximize();
	    //set implicit wait for element loading
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch application url from config file
		driver.get(prop.getProperty("url"));
	}
	
	//This method runs after all the tests
	@AfterTest
	public void clearbrowser() {
		//quit the browser
		if(driver!=null) {
			driver.quit();
		}
	}
	//Capture screenshot after the test fails
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		//check if test execution failed
	    if (ITestResult.FAILURE == result.getStatus()) {
	    	//capture screenshot using utility class
	        ScreenshotUtil.takeScreenshot(driver, result.getName());
	    }
	}

}
