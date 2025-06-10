package com.hrm.scenario2.Pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
 
 
 
public class LoginPage { 
 WebDriver driver; 
 
 public LoginPage(WebDriver driver) { 
  this.driver = driver; 
 } 
 
 By userName = By.name("username");
 By password = By.xpath("//input[@placeholder='Password']");
 By loginBtn = By.xpath("//button[text()=' Login ']");

 public void login() {
     String uid = ExcelData.getFormattedData("Scenario2", 1, 0);
     String psw = ExcelData.getFormattedData("Scenario2", 1, 1);

     driver.findElement(userName).sendKeys(uid);
     driver.findElement(password).sendKeys(psw);
     driver.findElement(loginBtn).click();
 }
}