package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    WebDriver driver;
    WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addProject() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='+ Add Project']"))).click();
    }

    public void projectTopic(String tpc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topic"))).sendKeys(tpc);
    }

    public void projectDuration(String dur) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("duration"))).sendKeys(dur);
    }

    public void addProjectbtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))).click();
    }
  
}
