package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.Homepage;
import pages.Login;
import pages.Logout;
import pages.MentorHome;
import pages.Signup;
import pages.Wrong;
import utility.ExcelUtility;


@Listeners(listeners.Listener.class)
public class LoginTest extends Base {

	//page object reference
    Login obj;
    Homepage hobj;
    MentorHome mobj;
    Logout lobj;
    Signup sobj;
    Wrong wrng;

    //Initialize page objects before executing any test cases
    @BeforeClass
    public void SetUp() {
    	
    	// Pass WebDriver instance from Base class to each Page Object
        obj = new Login(driver);
        hobj = new Homepage(driver);
        mobj = new MentorHome(driver);
        lobj = new Logout(driver);
        sobj = new Signup(driver);
        wrng = new Wrong(driver);
    }

    
    // Test Case 001: Verify successful login functionality
    @Test
    public void tc001_login() {
        Assert.assertTrue(obj.chkbtn(), "Login button not visible");
        obj.clkloginbtn();
        obj.getuname("ictak@example.com");
        obj.getpass("0000");
        obj.loginclk();
    }

    
    // Test Case 002: Add a new project
    @Test
    public void tc002_addProject() {
        hobj.addProject();
        hobj.projectTopic("manglish");
        hobj.projectDuration("5 months");
        hobj.addProjectbtn();
        
    }

    
    // Test Case 003: Add a mentor and assign project
    @Test
    public void tc003_addMentor() {
        mobj.clkMentor();
        mobj.addMentor();
        mobj.mntrName("akash");
        mobj.mntrEmail("akash@gmail.com");
        mobj.mntrPhone("1234567891");
        mobj.mntrPass("1234");
        
        mobj.mntrProject("HTML");
        mobj.mntrAdd();
    }
    
    // Test Case 004: Logout from the application
    @Test
    public void tc004_logut(){
    	  
    	 lobj.clickLogout();
    }

    // Test Case 005: Validate login with incorrect credentials using Excel data
    @Test
    public void tc005_wrong() throws IOException {
    	
    	Assert.assertTrue(wrng.btn(), "Login button not visible");
        wrng.loginbtn();
        wrng.getUsername(ExcelUtility.readExcel(0, 0));
        wrng.getpassw(ExcelUtility.readExcel(0, 1));
        wrng.loginclick();

    }
    
    // Test Case 006: Verify signup navigation
    @Test
    public void tc006_signup() {

    	sobj.login();
    	sobj.signupbtn();
    	
    }
}
