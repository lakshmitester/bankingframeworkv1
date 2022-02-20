package com.banking.pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	
	WebDriver driver;
	
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
//	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
//	@CacheLookup
//	WebElement customer;

	@FindBy(how=How.XPATH,using=("//input [@name='name']"))
	@CacheLookup
	WebElement cname;
	
	@FindBy(how=How.XPATH,using=("//tr//td//input[@name='rad1'][1]"))
	@CacheLookup
	Set<WebElement> male;
	
	@FindBy(how=How.XPATH,using=("//tr//td//input[@name='rad1'][2]"))
	@CacheLookup
	Set<WebElement> female;
	
	@FindBy(how=How.NAME,using="dob")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement pinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement telephone;
	
	@FindBy(how=How.XPATH,using="//input[@name='emailid")
	@CacheLookup
	WebElement email;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement submit;
	
	@FindBy(how=How.NAME,using=("Reset"))
	@CacheLookup
	WebElement reset;

//public void createCustomer() {
//	customer.click();
//}
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

public void setName(String name) {
	
	cname.sendKeys(name);
}

public void setGender(String gender) {
	if(gender.equalsIgnoreCase("male")) {
			((WebElement) male).click();
	}
else {
	((WebElement) female).click();
}
}

public void setDOB(String mm,String dd,String yyyy) {
DOB.sendKeys(mm);
DOB.sendKeys(dd);
DOB.sendKeys(yyyy);
}

public void setAddress(String addre) {
	address.sendKeys(addre);
}

public void setCity(String ccity) {
	city.sendKeys(ccity);
}

public void setState(String cstate) {
	state.sendKeys(cstate);
}

public void setPinno(String pin) {
	pinno.sendKeys(pin);
}
public void setPhoneNo(String cPhoneno) {
	telephone.sendKeys(cPhoneno);
}

public void setEmail(String cemail) {
	email.sendKeys(cemail);
}

public void custpassword(String cpassword) {
	txtpassword.sendKeys(cpassword);
}

public void setSubmit() {
	submit.click();
}
public void setReset() {
	reset.click();
}
}



