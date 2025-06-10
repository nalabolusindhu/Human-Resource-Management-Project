package com.hrm.scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

public class Utility {
    public XSSFWorkbook book;

    @DataProvider(name = "Excel")
    public Object[][] readExcel() {
        File file = new File(System.getProperty("user.dir") + "/test data/HRMData.xlsx");
        FileInputStream fis;
        Object arr[][] = null;

        try {
            fis = new FileInputStream(file);
            book = new XSSFWorkbook(fis);
            int rows = book.getSheet("Scenario1").getPhysicalNumberOfRows();
            int cells = book.getSheet("Scenario1").getRow(0).getPhysicalNumberOfCells();
            arr = new Object[rows - 1][cells];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cells; j++) {
                    arr[i - 1][j] = book.getSheet("Scenario1").getRow(i).getCell(j).getStringCellValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public String captureScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot shot = (TakesScreenshot) driver;
        File f1 = shot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png";
        File f2 = new File(path);
        try {
            FileHandler.copy(f1, f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
