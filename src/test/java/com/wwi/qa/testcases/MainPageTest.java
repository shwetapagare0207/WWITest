package com.wwi.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wwi.qa.base.TestBase;
import com.wwi.qa.pages.FindWorkshopPage;
import com.wwi.qa.pages.MainPage;

public class MainPageTest extends TestBase{
	MainPage mainPage;
	FindWorkshopPage fwsp;
	
	public MainPageTest() {
		super();//calling TestBase class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		mainPage = new MainPage();
	}
	
	@Test(priority=1)
	public void ValidatMainPageTitleTest() {
		String title = mainPage.validatMainPageTitle();
		Assert.assertEquals(title, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA");
	}
	
	@Test(priority=2)
	public void FindWorkshopTest() {
		fwsp = mainPage.findWorkshop();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
