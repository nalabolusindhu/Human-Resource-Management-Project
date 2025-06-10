package com.hrm.scenario1;


import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.reporter.ExtentSparkReporter; 
import com.aventstack.extentreports.reporter.configuration.Theme; 
 
public class ExtentManager { 
 public static ExtentReports extent; 
 
 public static ExtentReports getInstance() { 
 
  if (extent == null) { 
   extent = createInstance(); 
   return extent; 
  } else { 
   return extent; 
  } 
 
 } 
 
 public static ExtentReports createInstance() { 
 
  ExtentSparkReporter sparkReporter = new ExtentSparkReporter( 
    System.getProperty("user.dir") + "//Reports//Extent-Report.html"); 
  sparkReporter.config().setTheme(Theme.DARK); 
  sparkReporter.config().setReportName("Login and Logout (Scenario 1)"); 
  sparkReporter.config().setDocumentTitle("OrangeHRM Report"); 
 
  ExtentReports extent = new ExtentReports(); 
  extent.attachReporter(sparkReporter); 
 
  return extent; 
 } 
}
 
