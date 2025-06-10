package com.hrm.scenario2.TestCases;

import org.testng.Assert; 
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test; 
 
import com.hrm.scenario2.Base.BaseClass; 
import com.hrm.scenario2.Pages.AdminPage; 
 
public class AdminTest extends BaseClass { 
	 
	 AdminPage adminPage; 
	 
	 @BeforeMethod 
	 public void init() { 
	  adminPage = new AdminPage(driver); 
	 } 
	 
	 @Test(priority = 1) 
	 public void assertCountAndNavigateToAdmin() { 
	  Assert.assertEquals(adminPage.getCountOfMenuOptions(), 12, 
	"Menu option count not matched......."); 
	  System.out.println("Menu options count matched!!!!!!!"); 
	 
	  adminPage.clickOnAdmin(); 
	  Assert.assertTrue(driver.getCurrentUrl().contains("admin"), 
	"Admin page not opened"); 
	  System.out.println("Admin page opened"); 
	 } 
	 
	 @Test(priority = 2) 
	 public void testByUserName() { 
	  adminPage.clickOnAdmin(); 
	  String records = adminPage.searchByUserName(); 
	  System.out.println("Username records are : " + records); 
	  adminPage.refresh(); 
	 } 
	 
	 @Test(priority = 3) 
	 public void testByUserRole() { 
	  adminPage.clickOnAdmin(); 
	  String records = adminPage.searchByUserRole(); 
	  System.out.println("User Role records are : " + records); 
	  adminPage.refresh(); 
	 } 
	 
	 @Test(priority = 4) 
	 public void testByUserStatus() { 
	  adminPage.clickOnAdmin(); 
	  String records = adminPage.searchByUserStatus(); 
	  System.out.println("User status records are : " + records); 
	  adminPage.refresh(); 
	 } 
	} 