package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean chkbtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).isDisplayed();
    }

    public void clkloginbtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
    }

    public void getuname(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(name);
    }

    public void getpass(String passw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(passw);
    }

    public void loginclk() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }
}
