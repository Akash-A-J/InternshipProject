package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrong {

    WebDriver driver;
    WebDriverWait wait;

    public Wrong(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean btn() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).isDisplayed();
    }

    public void loginbtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
    }

    public void getUsername(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(name);
    }

    public void getpassw(String passw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(passw);
    }

    public void loginclick() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }

}
