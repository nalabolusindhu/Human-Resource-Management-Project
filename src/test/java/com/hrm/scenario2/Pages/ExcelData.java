package com.hrm.scenario2.Pages;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 

import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ExcelData { 
 
 public static String getFormattedData(String sheetName, int 
rowIndex, int colIndex) { 
 
  File file = new File(System.getProperty("user.dir") + "//test data//HRMData.xlsx"); 
  FileInputStream fis; 
  XSSFWorkbook book; 
  String str = ""; 
  try { 
   fis = new FileInputStream(file); 
   book = new XSSFWorkbook(fis); 
   str = book.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue(); 
  } catch (IOException e) { 
   // TODO Auto-generated catch block 
   e.printStackTrace(); 
  } 
  return str; 
 
 } 
 
}