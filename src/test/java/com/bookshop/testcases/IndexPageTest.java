package com.bookshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bookshop.base.BaseClass;
import com.bookshop.pageobjects.IndexPage;
import com.bookshop.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyMyShopLogo() {
		Log.startTestCase("verifyMyShopLogo");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to validate logo");
		boolean reasult=indexPage.validateMyShopLogo();
		Assert.assertTrue(reasult);
		Log.info("verifyMyShopLogo test case is passed");
		Log.endTestCase("verifyMyShopLogo");
	}
	
	@Test(groups="Smoke")
	public void getMyTitle() {
		Log.startTestCase("getMyTitle");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to verify title");
		String actTitle1=indexPage.getMyTitle();
		String expTitle1="Automation Practice Site";
		Assert.assertEquals(actTitle1, expTitle1);
		Log.info("getMyTitle testcase is passed");
		Log.endTestCase("getMyTitle");
	}

}
