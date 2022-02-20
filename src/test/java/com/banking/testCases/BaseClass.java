package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;
//import com.google.common.io.Files;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationUrl();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static  Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	    logger=(Logger) org.apache.log4j.LogManager.getLogger(BaseClass.class);
	    PropertyConfigurator.configure("Log4j2.properties");
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		    driver=new ChromeDriver();
	    }
	    else if(br.equals("edge")) {
	    	System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
		    driver=new EdgeDriver();
	    }
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    driver.get(baseURL);
	  }
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreenshot(WebDriver driver,String tname) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String dateformat=new SimpleDateFormat("yyyy.MM.dd.HH.dd.sss").format(new Date());
		String screenshotpath="./Screenshots/"+tname+".png";
		File desc=new File(screenshotpath);
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
}
