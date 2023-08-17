package com.bookshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bookshop.base.BaseClass;
import com.bookshop.pageobjects.HomePage;
import com.bookshop.pageobjects.IndexPage;
import com.bookshop.pageobjects.LoginPage;
import com.bookshop.pageobjects.ProductPage;
import com.bookshop.utility.Log;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void verifyDashboad() {
		Log.startTestCase("verifyDashboad");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		boolean reasult=homePage.validateDashboard();
		Assert.assertTrue(reasult);
		Log.info("successfully verified successfully");
		Log.info("verifyDashboad testcase is passed");
		Log.endTestCase("verifyDashboad");
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void productShopTest() throws InterruptedException {
		Log.startTestCase("productShopTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		productPage=homePage.clickOnShop();
		Log.info("user clicking on the shop link");
		Log.endTestCase("productShopTest");
	}
	
	
	
	
	
	

}
