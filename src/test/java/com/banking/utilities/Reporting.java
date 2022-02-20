package com.banking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter extentReporter;
	public ExtentReports extent;
	public ExtentTest logger; 
	
	public void onStart(ITestContext testContext) {
		String newdate=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path=System.getProperty("user.dir")+"/test-output/"+"Test-Report-"+newdate+".html";
		extentReporter=new ExtentHtmlReporter(path);
		extentReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extentReporter.config().setDocumentTitle("BANKING FRAMEWORK Report");
		extentReporter.config().setReportName("fundtional testing report");
		extentReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		extentReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(extentReporter);
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("Envornment","QA");
		extent.setSystemInfo("user","Lakshmi");
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName()); 
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName()); 
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists())
		{
			try {
				logger.fail("screen is below: " +logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName()); 
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}