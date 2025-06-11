package com.hrm.scenario1.Pages;

import org.openqa.selenium.By; 
import org.testng.Assert; 
import org.testng.annotations.Listeners; 
import org.testng.annotations.Test; 
 
import com.hrm.scenario1.BaseClass; 
import com.hrm.scenario1.ExtentITestNGListener; 
import com.hrm.scenario1.Utility; 
 
@Listeners(ExtentITestNGListener.class) 
public class LoginAndLogout extends BaseClass { 
 
 By userName = By.name("username"); 
 By password = By.xpath("//input[@placeholder='Password']"); 
 By loginBtn = By.xpath("//button[text()=' Login ']"); 
 
 @Test(dataProvider = "Excel", dataProviderClass = Utility.class) 
 public void loginWithValidAndInvalidCred(String uid, String psw) 
throws InterruptedException { 
 
  driver.findElement(userName).sendKeys(uid); 
  driver.findElement(password).sendKeys(psw); 
  driver.findElement(loginBtn).click(); 
  Thread.sleep(1500); 
  System.out.println("Username : " + uid + " & Password : " + 
psw); 
 
  Utility util = new Utility(); 
  util.captureScreenshot(driver, uid + "_" + psw + "_"); 
 
  System.out.println("Logged in"); 
 
 
 Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), 
"Login Failed......."); 
  System.out.println("Login successful!!!!!!!"); 
  logout(); 
 
 } 
 
 public void logout() throws InterruptedException { 
  driver.findElement(By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")).click(); 
  driver.findElement(By.linkText("Logout")).click(); 
  Thread.sleep(2000); 
 } 
 
}