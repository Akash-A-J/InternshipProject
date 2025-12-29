package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentorHome {

    WebDriver driver;
    WebDriverWait wait;

    public MentorHome(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clkMentor() {
        WebElement mentorclk=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[.//span[normalize-space()='Mentors']]")));
     
        // Scroll the Mentors menu into the center of the viewport
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", mentorclk);
    	
        // Click the Mentors menu using JavaScript to avoid interception issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mentorclk);
    	
    }
    
    //Click the addmentor button
    public void addMentor() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='+ Add Mentor']"))).click();
    }
    
    //Type mentor name 
    public void mntrName(String mename) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys(mename);
    }

    //Type the email
    public void mntrEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
    }

    //Type the phone number
    public void mntrPhone(String phn) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone"))).sendKeys(phn);
    }

    //type the password
    public void mntrPass(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pass);
    }
    
    // Select project for the mentor from a combobox input
    public void mntrProject(String project) {
    	// Locate the project selection combobox
    	WebElement projectInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@role='combobox'])[1]")));
    	// Click on the combobox to activate it
    	projectInput.click();
    	// Enter the project name
    	projectInput.sendKeys(project);

    		}

    // Click on the Add button to submit mentor details
    public void mntrAdd() {
    	// Wait until the Add button is clickable and submit the form
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))).click();
    }
}
