package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.ElementUtil;

public class DashBoardPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators
	private By dashBoardHeading = By.xpath("//h1[text()='Dashboard']");
	private By batchOption = By.xpath("//span[text()='Batches']");

	// Constructor
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public BatchPage selectBatchOption() {
		//eleUtil.waitForElementVisible(batchOption, 10);
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", eleUtil.getElement(batchOption));
		return new BatchPage(driver);
	}

	public boolean isDashBoardHeadingExist() {
		WebElement dashBoard = eleUtil.waitForElementVisible(dashBoardHeading, 20);
		return dashBoard.isDisplayed();
	}

	

}
