package com.hrm.scenario2.Base;

import java.time.Duration; 

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterClass; 
import org.testng.annotations.BeforeClass; 
import com.hrm.scenario2.Pages.LoginPage; 
 
public class BaseClass { 
 
	public WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}