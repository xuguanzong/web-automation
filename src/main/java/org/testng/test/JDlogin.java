package org.testng.test;

import java.util.concurrent.TimeUnit;




import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.chrome.*;

import pageObjects.LogIn_Function;

import org.openqa.selenium.support.PageFactory;



public class JDlogin 
{
	WebDriver driver;

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\eclipsework\\test\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }
  
  
  
  @Test
  public void loginsuccess() throws InterruptedException 
  {
	  driver.get("http://www.jd.com/");
	  Thread.sleep(3000);
	  LogIn_Function loginpage = PageFactory.initElements(driver, LogIn_Function.class);
	  loginpage.loginlink.click();
	  Thread.sleep(3000);
	  loginpage.LogIn_Action("584657555@qq.com", "cfadhp20090622");
	  Thread.sleep(3000);
	  Assert.assertEquals("[退出]", loginpage.logoutlink.getText());
	  
  }
  
  @Test
  public void wrongusername() throws InterruptedException 
  {
	  driver.get("http://www.jd.com/");
	  Thread.sleep(3000);
	  LogIn_Function loginpage = PageFactory.initElements(driver, LogIn_Function.class);
	  loginpage.loginlink.click();
	  Thread.sleep(3000);
	  loginpage.LogIn_Action("", "");
	  Thread.sleep(3000);
	  Assert.assertEquals("请输入邮箱/用户名/已验证手机", loginpage.loginname_error.getText());
	  Assert.assertEquals("请输入密码", loginpage.loginpwd_error.getText());
	  
  }
  
  
  
  @Test
  public void test() throws InterruptedException 
  {
	  driver.get("http://www.jd.com/");
	  Thread.sleep(3000);
//      driver.findElement(By.xpath("html/body/div[8]/div[8]/div[2]/div[2]/div[2]/ul/li[4]/div[1]/a/img")).click();
	  driver.findElement(By.cssSelector("img[alt='听妈妈讲故事1元起']")).click();
//	  driver.findElement(By.partialLinkText("京东电子书畅读VIP 每本不到1分钱")).click();
//	  driver.findElement(By.linkText("京东电子书畅读VIP 每本不到1分钱")).click();
	  Thread.sleep(8000);
	  
  }
  
  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
