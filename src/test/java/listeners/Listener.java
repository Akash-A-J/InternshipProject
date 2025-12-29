package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;
import utility.ScreenshotUtil;

public class Listener extends Base implements ITestListener {

	//This method is triggered automatically by TestNG
    @Override
    public void onTestFailure(ITestResult result) {
    	
    	//Print the failed test case name in the console
        System.out.println("Test Failed: " + result.getName());

        //check if the webdriver instance is available
        if (driver != null) {
        	
        	// Capture screenshot of the failure using utility class
            // Screenshot name will be the test method name
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }
    }
}
