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

    //Check whether the login button is displayed and clickable
    public boolean chkbtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).isDisplayed();
    }

    //click on the login button
    public void clkloginbtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
    }

    //Type in the usename or email
    public void getuname(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(name);
    }

    //Type in the password
    public void getpass(String passw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(passw);
    }

    //Click the login button
    public void loginclk() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }
}
