package com.wwi.qa.pages;

//import org.openqa.selenium.WebDriver;
//import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wwi.qa.base.TestBase;

public class MainPage extends TestBase{
	
	//Page Factory
	@FindBy(linkText = "Find a Workshop")
	WebElement findBtn;
	
	//Initializing page objects
	public MainPage() {
		PageFactory.initElements(driver, this);//Initialize all webelements with driver
	}
	
	//Action
	public String validatMainPageTitle() {
		return driver.getTitle();
	}
	
	public FindWorkshopPage findWorkshop() {
		findBtn.click();
		return new FindWorkshopPage();
	}
	
	
	
}
