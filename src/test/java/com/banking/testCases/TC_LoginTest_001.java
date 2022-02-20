package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws IOException {
		//SoftAssert ass=new SoftAssert();
		logger.info("url is opened");
		LoginPage  loginPage1=new LoginPage(driver);
		loginPage1.setUserName(username);
		logger.debug("username entered");
		loginPage1.setPassword(password);
		logger.info("entered passeord");
		loginPage1.clickSubmit();
		System.out.println("userdir = "+System.getProperty("user.dir"));
		//ass.assertEquals(false, true);
		//Assert.assertEquals(false, true);
		//System.out.println("userdir = "+System.getProperty("user.dir"));
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
			
		}
		else
		{
			captureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.error("login test failed");
		}
		
	}
}
