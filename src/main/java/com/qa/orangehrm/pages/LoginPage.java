package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators
	private By emailId = By.name("email");
	private By password = By.name("password");
	private By remember = By.xpath("//span[text()='Remember Me']/parent::div/preceding-sibling::div");
	private By terms = By.xpath("//span[text()='I agree to']/parent::span/parent::div/preceding-sibling::div");
	private By loginBtn = By.xpath("//span[text()='Log in']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Methods
	public void enterUserName(String un) {
		eleUtil.doSendKeys(emailId, un);
	}

	public void enterPassword(String pwd) {
		eleUtil.doSendKeys(password, pwd);
	}

	public void doClickRememberMe() {
		eleUtil.doClick(remember);

	}

	public void doSelectTerms() {
		eleUtil.doClick(terms);

	}

	public DashBoardPage doClickLoginButton() {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", eleUtil.getElement(loginBtn));
		return new DashBoardPage(driver);
	}

}
