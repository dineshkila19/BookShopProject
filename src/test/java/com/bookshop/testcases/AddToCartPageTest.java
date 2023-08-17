package com.bookshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bookshop.base.BaseClass;
import com.bookshop.pageobjects.AddToCartPage;
import com.bookshop.pageobjects.HomePage;
import com.bookshop.pageobjects.IndexPage;
import com.bookshop.pageobjects.LoginPage;
import com.bookshop.pageobjects.ProductPage;
import com.bookshop.utility.Log;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void AddToCartPageTest() throws InterruptedException {
		Log.startTestCase("AddToCartPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("user successfully entered login details");
		Thread.sleep(3000);
		productPage=homePage.clickOnShop();
		Thread.sleep(3000);
		addToCartPage=productPage.clickOnSelenium();
		Thread.sleep(3000);
		addToCartPage.addToCart("2");
		Log.info("user successfully entered quantity");
		Log.info("AddToCartPageTest testcase is passed");
		Log.endTestCase("AddToCartPageTest");
		
	}
	
	@Test(groups="Sanity")
	public void verifyAddToCartMsg() throws InterruptedException {
		Log.startTestCase("verifyAddToCartMsg");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		productPage=homePage.clickOnShop();
		Thread.sleep(3000);
		addToCartPage=productPage.clickOnSelenium();
		Thread.sleep(3000);
		addToCartPage.addToCart("2");
		Log.info("user successfully entered quantity");
		Thread.sleep(3000);
		boolean reasult1=addToCartPage.validateAddToCartSuccessMsg();
		Assert.assertTrue(reasult1);
		Log.info("user successfully verified success message");
		Thread.sleep(3000);
		addToCartPage.clickOnViewBasket();
		Log.info("verifyAddToCartMsg testcase is passed");
		Log.endTestCase("verifyAddToCartMsg");
		
	}

	

}
