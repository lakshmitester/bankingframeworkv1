package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void LoginTest(String uname,String password) throws IOException, InterruptedException {
		//SoftAssert ass=new SoftAssert();
		logger.info("url is opened  ***");
		LoginPage  loginPage1=new LoginPage(driver);
		loginPage1.setUserName(uname);
		logger.info("username entered");
		loginPage1.setPassword(password);
		logger.info("entered password");
		loginPage1.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			loginPage1.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
//	public boolean isAlertPresent() {
//		try {
//		driver.switchTo().alert();
//		return true;
//		}
//		catch(Exception e) {
//			return false;
//		}
//	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/banking/testData/TestData.xlsx";
		int rowCount=XLUtils.getRowCount(path,"Sheet1");
		int colCount=XLUtils.getCellCount(path,"Sheet1",1);
		String data[][]=new String[rowCount][colCount];
		System.out.println("no of rows: "+rowCount);
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
			data[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
	}
}
