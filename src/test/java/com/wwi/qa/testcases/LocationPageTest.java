package com.wwi.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wwi.qa.base.TestBase;
import com.wwi.qa.pages.FindWorkshopPage;
import com.wwi.qa.pages.LocationPage;
import com.wwi.qa.pages.MainPage;

public class LocationPageTest extends TestBase {
	LocationPage locPage;
	MainPage mainPage;
	FindWorkshopPage findWorkshopPage;
	public LocationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		locPage = new LocationPage();
		mainPage = new MainPage();
		findWorkshopPage = mainPage.findWorkshop();
		locPage = findWorkshopPage.clickOnFirstSearchResult(prop.getProperty("location"));
	}
	
	@Test(priority=1)
	public void verifyLocationTitleEqualsSearchResultTest() {
		String actualLocationName = locPage.verifyLocationTitleEqualsSearchResult();
		findWorkshopPage = mainPage.findWorkshop();
		String expectedLocationName = findWorkshopPage.getLocationTitle(prop.getProperty("location"));
		Assert.assertEquals(actualLocationName, expectedLocationName);
	}
	
	@Test(priority=2)
	public void verifyTodaysHourTest() {
		String time = locPage.todaysHoursOfOperations();
		System.out.println(time);
	}
	
	@Test(priority=3)
	public void printMeeting() {
		locPage.todaysAppointments();
	}

	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
}
