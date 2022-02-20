package com.banking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.*;


public class TC_Customer_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		CustomerPage addcust=new CustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.setName("Pavan");
		addcust.setGender("male");
		addcust.setDOB("10","15","1985");
		Thread.sleep(5000);
		addcust.setAddress("INDIA");
		addcust.setCity("HYD");
		addcust.setState("AP");
		addcust.setPinno("5000074");
		addcust.setPhoneNo("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.setEmail(email);
		addcust.custpassword("abcdef");
		addcust.setSubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}