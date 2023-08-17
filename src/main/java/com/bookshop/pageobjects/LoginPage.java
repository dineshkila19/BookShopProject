package com.bookshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookshop.actiondriver.Action;
import com.bookshop.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="username")
	WebElement txtEmailId;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="rememberme")
	WebElement checkBox;
	
	@FindBy(xpath="//*[@name='login']")
	WebElement loginBtn;
	
	@FindBy(id="reg_email")
	WebElement txtRegisterEmail;
	
	@FindBy(id="reg_password")
	WebElement txtRegisterPassword;
	
	@FindBy(xpath="//*[@name='register']")
	WebElement registerBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage enterLoginCredentials(String uemail, String upwd) {
		Action.type(txtEmailId, uemail);
		Action.type(txtPassword, upwd);
		Action.click(getDriver(), checkBox);
		Action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	public void createAnAccount(String regemail, String regpwd) {
		Action.type(txtRegisterEmail, regemail);
		Action.type(txtRegisterPassword, regpwd);
		Action.click(getDriver(), registerBtn);
		
	}
	
	
	
	
	
	
	
	
	
	
}
