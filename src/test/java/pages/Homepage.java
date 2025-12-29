package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    WebDriver driver;
    WebDriverWait wait;

    //construct to initialize webdriver and explicit waits
    public Homepage(WebDriver driver) {
        this.driver = driver;
        //Initialize explicit wait with 20 second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //click on add project button on home page using the xpath
    public void addProject() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='+ Add Project']"))).click();
    }

    //Type in project topics
    public void projectTopic(String tpc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topic"))).sendKeys(tpc);
    }

    //Type in project duration
    public void projectDuration(String dur) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("duration"))).sendKeys(dur);
    }

    //Click add project button
    public void addProjectbtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))).click();
    }
  
}
