package com.wwi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wwi.qa.base.TestBase;
import com.wwi.qa.pages.FindWorkshopPage;
import com.wwi.qa.pages.LocationPage;
import com.wwi.qa.pages.MainPage;   

public class FindWorkshopPageTest extends TestBase{
	MainPage mainPage;
	FindWorkshopPage findWorkshopPage;
	LocationPage locationPage;
	SoftAssert softassert = new SoftAssert();
	public FindWorkshopPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		mainPage = new MainPage();
		locationPage = new LocationPage();
		findWorkshopPage = mainPage.findWorkshop();
	}
	
	@Test(priority=1)
	public void verifyWorkshopPageTitle() {
		String wsptitle = findWorkshopPage.verifyWorkshopPageTitle();
		softassert.assertEquals(wsptitle, "WW Studios & Meetings Near You | WW USA");
	}
	
	@Test(priority=2)
	public void getLocationTitleTest() {
		System.out.println(findWorkshopPage.getLocationTitle(prop.getProperty("location")));
	}
	
	@Test(priority=3)
	public void getDistanceTitleTest() {
		System.out.println(findWorkshopPage.getDistance(prop.getProperty("location")));
	}
	
	@Test(priority=4)
	public void clickOnFirstSearchResultTest() {
		locationPage = findWorkshopPage.clickOnFirstSearchResult(prop.getProperty("location"));
	}
		
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	
}
