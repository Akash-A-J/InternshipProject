package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
		 WebDriver driver;
		    WebDriverWait wait;

		    public Signup(WebDriver driver) {
		        this.driver = driver;
		        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    }

		    //Click the login button 
		    public void login() {
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
		    }
		    
		    //Click the sign
		    public void signupbtn() {
		    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Don’t have an account yet? Sign Up Now"))).click();;
		    	
		 }
	
}
