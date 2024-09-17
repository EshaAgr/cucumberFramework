package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {

		
		public HomePage(WebDriver driver, ExtentTest logger)
		{
			super(driver,logger);
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(linkText="Logut")
		WebElement lnk_logout;
		
		@FindBy(linkText="Home")
		WebElement lnk_home;

		public void click_logout()
		{
			//lnk_logout.click();
			clickElement(lnk_logout,"Link logout click");
		}
		
		public void validate_logout()
		{
			//lnk_logout.isDisplayed();
			ElementExist(lnk_logout,"link logout is displayed");
		}
		
		public void validate_home()
		{
			//lnk_home.isDisplayed();
			ElementExist(lnk_home, "link home is displayed");
		}
}
