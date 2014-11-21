package org.testng.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TestngListener extends TestListenerAdapter {
	private static Logger logger = Logger.getLogger(TestngListener.class);
	public static final String CONFIG = "config.properties";
	protected ITestContext testContext = null;

	@Override
	public void onStart(ITestContext testContext)
	{
		this.testContext = testContext;
		super.onStart(testContext);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		/**
		 * 自动截图，保存图片到本地
		 * 
		 * @param tr
		 * @throws IOException 
		 */
		
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		WebDriver webDriver = (WebDriver) testContext.getAttribute("SELENIUM_DRIVER");
		TakesScreenshot t = (TakesScreenshot)webDriver;
		File file = t.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("e:\\software\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
                
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

	}
	

	
}