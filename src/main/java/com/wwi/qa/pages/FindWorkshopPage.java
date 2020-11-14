package com.wwi.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wwi.qa.base.TestBase;

public class FindWorkshopPage extends TestBase{
	
	@FindBy(id="location-search")
	WebElement location;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement locationBtn;
	
	@FindBy(linkText="WW Studio Flatiron")
	WebElement locResult;
	
	@FindBy(className="distance-OhP63")
	WebElement locDistance;
	
	public FindWorkshopPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public String verifyWorkshopPageTitle() {
		return driver.getTitle();
	}
	
	public String getLocationTitle(String loc) {
		location.sendKeys(loc);
		location.sendKeys(Keys.ENTER);
		return locResult.getText();
	}
	
	public String getDistance(String loc) {
		location.sendKeys(loc);
		location.sendKeys(Keys.ENTER);
		return locDistance.getText(); 
	}
	
	public LocationPage clickOnFirstSearchResult(String loc) {
		location.sendKeys(loc);
		location.sendKeys(Keys.ENTER);
		locResult.click();
		return new LocationPage();
	}
}
