package com.hrm.scenario2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	By menuOptions = By.xpath("//div[@class='oxd-sidepanel-body']/ul/li/a"); 

	public int getCountOfMenuOptions() {
		List<WebElement> options = driver.findElements(menuOptions);
		System.out.println("Menu Options count is : " + 
				options.size()); 
				  return options.size(); 
	}

	By adminOpt = By.xpath("//span[text()='Admin']");

	public void clickOnAdmin() {
		driver.findElement(adminOpt).click();
	}

	By userNameSearchBox = By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input");

	public String searchByUserName() {
		String username = ExcelData.getFormattedData("Scenario2", 1, 3);
		driver.findElement(userNameSearchBox).sendKeys(username);
		clickOnSearchBtn();
		return getCountOfRecords();
	}

	By userRoleDropdown = By.xpath("(//div[@class='oxd-select-wrapper']/div)[1]");

	public String searchByUserRole() {
		String role = ExcelData.getFormattedData("Scenario2", 1, 4);
		driver.findElement(userRoleDropdown).click();
		selectOption(role);
		clickOnSearchBtn();
		return getCountOfRecords();
	}

	By statusDropdown = By.xpath("(//div[@class='oxd-select-wrapper']/div)[2]");

	public String searchByUserStatus() {
		String status = ExcelData.getFormattedData("Scenario2", 1, 5);
		driver.findElement(statusDropdown).click();
		selectOption(status);
		clickOnSearchBtn();
		return getCountOfRecords();
	}

	By searchBtn = By.xpath("//button[text()=' Search ']");

	public void clickOnSearchBtn() {
		driver.findElement(searchBtn).click();
	}

	By records = By.xpath("//div[@class='oxd-table-body']/div");

	public String getCountOfRecords() {
		return String.valueOf(driver.findElements(records).size());
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	By dropdownOptions = By.xpath("//div[contains(@class,'oxd-select-dropdown')]/div/span");

	public void selectOption(String text) {
		List<WebElement> options = driver.findElements(dropdownOptions);
		for (WebElement option : options) {
			if (option.getText().equals(text)) {
				option.click();
				break;
			}
		}
	}
}