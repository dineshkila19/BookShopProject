package com.bookshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookshop.actiondriver.Action;
import com.bookshop.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='header-bar']/div/a/img")
	WebElement myShopLogo;
	
	@FindBy(xpath="//*[contains(text(),'My Account')]")
	WebElement myAccountBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyShopLogo() {
		return Action.isDisplayed(getDriver(), myShopLogo);
	}
	
	public LoginPage clickOnMyAccount() {
		Action.click(getDriver(), myAccountBtn);
		return new LoginPage();
	}
	
	public String getMyTitle() {
		String actTitle=getDriver().getTitle();
		return actTitle;
		
	}
	

}
