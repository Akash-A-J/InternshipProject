package base;

import java.io.FileNotFoundException;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import utility.ScreenshotUtil;

public class Base {
	protected WebDriver driver;
	Properties prop;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void readProp() throws IOException {
		FileReader f1=new FileReader("C:\\SDET\\Internship\\Automation\\Project\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(f1);
	}
	@BeforeTest
	public void setup() throws IOException {
		readProp();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:/temp/chrome-profile-automation");
		options.addArguments("--disable-features=PasswordLeakDetection");
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
	    driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
//	    options.addArguments("--start-maximized");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}
	@AfterTest
	public void clearbrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {

	    if (ITestResult.FAILURE == result.getStatus()) {
	        ScreenshotUtil.takeScreenshot(driver, result.getName());
	    }
	}

}
