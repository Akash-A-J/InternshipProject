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
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", mentorclk);
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", mentorclk);
    	

    	
    }
    public void addMentor() {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='+ Add Mentor']"))).click();
    }

    public void mntrName(String mename) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys(mename);
    }

    public void mntrEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
    }

    public void mntrPhone(String phn) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone"))).sendKeys(phn);
    }

    public void mntrPass(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pass);
    }

    public void mntrProject(String project) {
    	WebElement projectInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@role='combobox'])[1]")));
    	projectInput.click();
    	projectInput.sendKeys(project);

    		}

    public void mntrAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))).click();
    }
}
