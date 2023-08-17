package com.bookshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookshop.actiondriver.Action;
import com.bookshop.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[contains(text(),'Shop')]")
	WebElement shopBtn;
	
	@FindBy(xpath="//*[contains(text(),'Dashboard')]")
	WebElement dashboardLink;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateDashboard() {
		return Action.isDisplayed(getDriver(), dashboardLink);
	}
	
	public ProductPage clickOnShop() {
		Action.click(getDriver(), shopBtn);
		return new ProductPage();
	}
	
	

}
