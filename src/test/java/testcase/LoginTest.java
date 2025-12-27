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

    Login obj;
    Homepage hobj;
    MentorHome mobj;
    Logout lobj;
    Signup sobj;
    Wrong wrng;

    @BeforeClass
    public void SetUp() {
        obj = new Login(driver);
        hobj = new Homepage(driver);
        mobj = new MentorHome(driver);
        lobj = new Logout(driver);
        sobj = new Signup(driver);
        wrng = new Wrong(driver);
    }

    @Test
    public void tc001_login() {
        Assert.assertTrue(obj.chkbtn(), "Login button not visible");
        obj.clkloginbtn();
        obj.getuname("ictak@example.com");
        obj.getpass("0000");
        obj.loginclk();
    }

    @Test
    public void tc002_addProject() {
        hobj.addProject();
        hobj.projectTopic("manglish");
        hobj.projectDuration("5 months");
        hobj.addProjectbtn();
        
    }

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
    @Test
    public void tc004_logut(){
    	  
    	 lobj.clickLogout();
    }

    @Test
    public void tc005_wrong() throws IOException {
    	
    	Assert.assertTrue(wrng.btn(), "Login button not visible");
        wrng.loginbtn();
        wrng.getUsername(ExcelUtility.readExcel(0, 0));
        wrng.getpassw(ExcelUtility.readExcel(0, 1));
        wrng.loginclick();

    }
    @Test
    public void tc006_signup() {

    	sobj.login();
    	sobj.signupbtn();
    	
    }
}
