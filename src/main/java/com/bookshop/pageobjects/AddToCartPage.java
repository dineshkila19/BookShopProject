package com.bookshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookshop.actiondriver.Action;
import com.bookshop.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='input-text qty text']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//*[@class='single_add_to_cart_button button alt']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@class='list-post']/div/a")
	WebElement viewBasketBtn;
	
	@FindBy(xpath="//*[contains(text(),' “Selenium Ruby” has been added to your basket.')]")
	WebElement addToCartMsg;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void addToCart(String uqnty) {
		Action.type(txtQuantity, uqnty);
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCartSuccessMsg() {
		return Action.isDisplayed(getDriver(), addToCartMsg);
	}
	
	public CheckOutPage clickOnViewBasket() {
		Action.click(getDriver(), viewBasketBtn);
		return new CheckOutPage();
	}
	

}
