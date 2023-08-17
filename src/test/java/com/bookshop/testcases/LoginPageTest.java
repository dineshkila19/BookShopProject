package com.bookshop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bookshop.base.BaseClass;
import com.bookshop.dataprovider.DataProviders;
import com.bookshop.pageobjects.HomePage;
import com.bookshop.pageobjects.IndexPage;
import com.bookshop.pageobjects.LoginPage;
import com.bookshop.utility.Log;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider="BookShopData", dataProviderClass=DataProviders.class ,groups= {"Smoke","Sanity"})
	public void loginTest(String uemail, String upwd) {
		Log.startTestCase("loginTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		Log.info("user is going to enter login details");
		//loginPage.enterLoginCredentials(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.enterLoginCredentials(uemail, upwd);
		Log.info("user successfully entered login credentials");
		Log.info("loginTest testcase is passed");
		Log.endTestCase("loginTest");
	}
	
	
	
	
	
	
	
	
	
	

}
