package com.bookshop.testcases;

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

public class ProductPageTest extends BaseClass{
	
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
	
	@Test(groups="Sanity")
	public void ProductPageTest() throws InterruptedException {
		Log.startTestCase("ProductPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		productPage=homePage.clickOnShop();
		Thread.sleep(3000);
		Log.info("user is going to click on selenium ruby");
		addToCartPage=productPage.clickOnSelenium();
		Thread.sleep(3000);
		Log.info("ProductPageTest testcase is passed");
		Log.endTestCase("ProductPageTest");
	}

}
