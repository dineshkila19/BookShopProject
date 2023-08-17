package com.bookshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookshop.actiondriver.Action;
import com.bookshop.base.BaseClass;

public class ProductPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='products masonry-done']/li[7]/a[1]/h3")
	WebElement selectSelenium;
	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddToCartPage clickOnSelenium() {
		Action.click(getDriver(), selectSelenium);
		return new AddToCartPage();
	}
	
	
	
	
	

}
