package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	// Method to capture screenshot and return the saved file path
    public static String takeScreenshot(WebDriver driver, String testName) {

    	// Generate timestamp to make screenshot name unique
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        // Define screenshot storage path with test name and timestamp
        String path = "screenshots/" + testName + "_" + timestamp + ".png";

        // Cast WebDriver instance to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Capture screenshot and store it as a temporary file
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
        	// Copy screenshot file to the desired location
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
        	// Print stack trace if screenshot capture fails
            e.printStackTrace();
        }

        // Return the screenshot file path (useful for reports)
        return path;
    }
}
