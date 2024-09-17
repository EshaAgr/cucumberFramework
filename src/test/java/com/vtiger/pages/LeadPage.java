package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends PageActions {

	
	public LeadPage(WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(name="lastname")
	WebElement tb_latename;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement tb_save;
	
	
	public void clickNewLead()
	{
		//lnk_NewLead.click();
		clickElement(lnk_NewLead,"link new lead cclicked");
	}
	
	public void createlead(String lname, String comp)
	{
		
		//tb_latename.sendKeys(lname);
		setInput(tb_latename,lname,lname+"has been entered into last name field");
		//tb_company.sendKeys(comp);
		setInput(tb_company,comp,comp+"has been entered into company field");
		//tb_save.click();
		clickElement(tb_save,"save button clicked");
		
		
	}
}
