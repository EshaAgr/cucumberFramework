package com.vtiger.stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps extends basesteps{
int i;
@Before
public void getScenarioName(Scenario scenario)
{
	if(extent==null)
	{
		createExtentReport();
	}
	ScenarioName = scenario.getName();
	logger = extent.createTest(ScenarioName);
}

@After
public void tierdown()
{
	extent.flush();
	driver.quit();
}



	@Given("use should be on login page")
	public void use_should_be_on_login_page() throws Exception {
		LaunchApp();
		logger.info("Application launched");
	   lp = new LoginPage(driver, logger);
	   hp = new HomePage(driver,logger);
	   ldp = new LeadPage(driver,logger);

	   
	}
	
	@When("user enter the valid credentials")
	public void user_enter_the_valid_credentials() {
	   
		lp.login(dt.get(ScenarioName).get("UserId"),dt.get(ScenarioName).get("Password"));
		
	}
	@Then("user should navigated to home page")
	public void user_should_navigated_to_home_page() {
		hp.validate_home();

	   
	}
	@Then("user can see the logout link")
	public void user_can_see_the_logout_link() {
		hp.validate_logout();

	  
	}
	
	@When("user enter the invalid credentials")
	public void user_enter_the_invalid_credentials() {

		lp.login(dt.get(ScenarioName).get("UserId"),dt.get(ScenarioName).get("Password"));


		
	}
	@Then("user can see error message")
	public void error_message() {
		lp.validate_Error_message();
	}
	
	@When("user enter the invalid userid as {string} and password as {string}")
	public void user_enter_the_invalid_userid_as_and_password_as(String uid, String pwd) {
		lp.login(uid,pwd);


	}
	
	
}