package com.hrm.scenario2.TestCases;

import org.testng.Assert; 
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test; 
 
import com.hrm.scenario2.Base.BaseClass; 
import com.hrm.scenario2.Pages.AdminPage; 
 
public class LoginTest extends BaseClass { 
	 
	 AdminPage adminPage; 
	 
	 @BeforeMethod 
	 public void init() { 
	  adminPage = new AdminPage(driver); 
	 } 
	 
	 public void testLogin() { 
	 
	  loginPage.login(); 
	  adminPage.getCountOfMenuOptions(); 
	  adminPage.clickOnAdmin(); 
	  adminPage.searchByUserName(); 
	  adminPage.searchByUserRole(); 
	  adminPage.searchByUserStatus(); 
	 
	 } 
	 
	 @Test 
	 public void login() throws InterruptedException { 
	 
	 Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), 
	"Login failed......."); 
	  System.out.println("Login successful!!!!!!!"); 
	  Thread.sleep(2000); 
	 } 
	} 