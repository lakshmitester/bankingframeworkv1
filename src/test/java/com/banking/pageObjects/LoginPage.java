package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;

public LoginPage(WebDriver rdriver){
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//input[@name='uid']")
WebElement txtUserName;

@FindBy(xpath="//input[@type='password']")
WebElement txtPassword;

@FindBy(xpath="//input[@type='submit']")
	WebElement  btnLogin;

@FindBy(xpath="//a[contains(text(),'Log out')]")
WebElement logout;

public void setUserName(String uname) {
	txtUserName.sendKeys(uname);
}
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void clickSubmit() {
	btnLogin.click();
}
public void clickLogout() {
	logout.click();
}
}
