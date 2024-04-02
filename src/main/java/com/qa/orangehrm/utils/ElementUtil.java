package com.qa.orangehrm.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private final int DEFAULT_TIME_OUT = 10;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doSendKeys(By locator, String value) {
		if (value == null) {
			System.out.println("null vlaues are not allowed....");
		}

		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(By locator, int timeOut) {
		checkElementClickable(locator, timeOut).click();
	}

	public WebElement getElement(By locator, int timeOut) {
		WebElement element = waitForElementVisible(locator, timeOut);
		return element;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			System.out.println("element is found with locator: " + locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found using this locator..." + locator);
			element = waitForElementVisible(locator, DEFAULT_TIME_OUT);
		}

		return element;
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * default timeout = 500 ms
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public WebElement checkElementClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// ****************Actions class Utils************************

		public void doActionsSendKeys(By locator, String value) {
			Actions act = new Actions(driver);
			act.sendKeys(getElement(locator), value).build().perform();
		}

		public void doActionsClick(By locator) {
			Actions act = new Actions(driver);
			act.click(getElement(locator)).build().perform();
		}

		public void doActionsClick(By locator, int timeOut) {
			Actions act = new Actions(driver);
			act.click(checkElementClickable(locator, timeOut)).build().perform();
		}

		public void doDragAndDrop(By sourceLocator, By targetLocator) {
			Actions act = new Actions(driver);
			act.dragAndDrop(getElement(sourceLocator), getElement(targetLocator)).build().perform();
		}

		public void doContextClick(By locator) {
			Actions act = new Actions(driver);
			act.contextClick(getElement(locator)).build().perform();
		}

		public void doMoveToElement(By locator) {
			Actions act = new Actions(driver);
			act.moveToElement(getElement(locator)).build().perform();
		}

		public void handleTwoLevelMenu(By parentMenu, By childMenu) throws InterruptedException {
			doMoveToElement(parentMenu);
			Thread.sleep(2000);
			doClick(childMenu);
		}

		public void handleTwoLevelMenu(By parentMenu, String childMenuLinkText) throws InterruptedException {
			doMoveToElement(parentMenu);
			Thread.sleep(2000);
			doClick(By.linkText(childMenuLinkText));
		}

		public void multiLevelMenuChildMenuHandle(By parentMenuLocator, String level2LinkText, String level3LinkText,
				String level4LinkText) throws InterruptedException {

			WebElement level1 = getElement(parentMenuLocator);
			Actions act = new Actions(driver);

			act.moveToElement(level1).build().perform();
			Thread.sleep(1000);

			WebElement level2 = getElement(By.linkText(level2LinkText));
			act.moveToElement(level2).build().perform();
			Thread.sleep(1000);

			WebElement level3 = getElement(By.linkText(level3LinkText));
			act.moveToElement(level3).build().perform();
			Thread.sleep(1000);

			doClick(By.linkText(level4LinkText));
		}

}
