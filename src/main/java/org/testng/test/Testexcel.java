package org.testng.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.annotations.*;
import org.testng.asserts.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Testexcel 
{
	    
	    WebDriver driver;
		@BeforeClass
		public void setUp()
		{
		  System.setProperty("webdriver.chrome.driver","E:\\software\\chromedriver.exe");
		  driver = new ChromeDriver();
		}
		
		
		@Test
		public void registry() throws InterruptedException, IOException
		{
			
		driver.get("http://www.100.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.className("close")).click();
		driver.findElement(By.id("hChange2")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.)
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://zc.100.com/reg/pc/webd/index.do?appid=5142&busiurl=http%3A%2F%2Fi.100.com%2Faccount%2Fprofile']")));
		
		//读取Excel文件
		FileInputStream filePath = new FileInputStream("./data/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(filePath);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		String data=sheet.getRow(1).getCell(0).getStringCellValue();
		
		driver.findElement(By.id("mobile")).sendKeys(data);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[contains(.,'" + "确认密码"+ "')]")).click();  
			
		
		
		}
		
		@AfterClass
		public void teardown()
		{
		driver.close();
		}
		
	
		
	


}
