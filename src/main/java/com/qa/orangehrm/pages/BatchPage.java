package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.ElementUtil;

public class BatchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators
	private By batchHeading = By.xpath("//h1[text()='Batches']");
	private By newBatch = By.xpath("//span[text()='Create New Batch']");
	private By campaign = By
			.xpath("//span[text()='Select Campaign']");
	private By campagnOption = By.xpath("//button[text()='Select']");

	// Constructor
	public BatchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void doClickNewBatch() {
		eleUtil.doClick(newBatch);
	}

	public void selectCampaign() {
		eleUtil.doClick(campaign);
		eleUtil.doClick(campagnOption);
	}

	public boolean isBatchHeadingExist() {
		WebElement dashBoard = eleUtil.waitForElementVisible(batchHeading, 10);
		return dashBoard.isDisplayed();
	}
}
