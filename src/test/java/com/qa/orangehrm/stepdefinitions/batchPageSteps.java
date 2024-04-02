package com.qa.orangehrm.stepdefinitions;

import org.testng.Assert;

import com.qa.orangehrm.factory.DriverFactory;
import com.qa.orangehrm.pages.BatchPage;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class batchPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private DashBoardPage dbPage;
	private BatchPage batchPage;

	@Given("the user is on the login page of the application")
	public void the_user_is_on_the_login_page_of_the_application() {
		DriverFactory.getDriver().get("https://dev.zeitblast.com/#/");
	}

	@When("the user logs in with the username {string} and password {string}")
	public void the_user_logs_in_with_the_username_and_password(String userName, String password) {
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@When("selects Remember Me")
	public void selects_Remember_Me() {
		loginPage.doClickRememberMe();
	}
	@When("the user accepts terms and conditions")
	public void the_user_accepts_terms_and_conditions() {
		loginPage.doSelectTerms();
	}
	
	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		dbPage = loginPage.doClickLoginButton();
	}

	@Then("the_user_is_on_Dashboard")
	public void the_user_is_on_Dashboard() {
		boolean exist = dbPage.isDashBoardHeadingExist();
		Assert.assertTrue(exist);
	}

	@When("the user selects the batch option")
	public void the_user_selects_the_batch_option() {
		dbPage.selectBatchOption();
	}

	@When("click on the create new batch option")
	public void click_on_the_create_new_batch_option() {
		batchPage.doClickNewBatch();

	}

	@When("select the campaign")
	public void select_the_campaign() {
		batchPage.selectCampaign();;
	}
}