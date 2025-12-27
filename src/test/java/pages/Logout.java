package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	 WebDriver driver;
	    WebDriverWait wait;

	    public Logout(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }
	    
	    public void clickLogout() {
	    	WebElement logoutbotn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='button' and .//span[text()='Logout']])[1]")));
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", logoutbotn);
	    	js.executeScript("arguments[0].click();", logoutbotn);
	    }
}
