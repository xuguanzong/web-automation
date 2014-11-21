package org.testng.test;

import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sendEmail 
{

	 @BeforeClass  
	    public void setUp() throws Exception 
	    {   

	    } 
	 
	 @Test  
	 public void testSearchMyBlog() throws  AddressException, MessagingException 
	{
		MethodClass A = new MethodClass();
        A.multipleEmail("xuguanzong@163.com", "一封邮件", "584657555@qq.com", "smtp.163.com");

	}
	
    @AfterClass  
    public void tearDown() throws Exception 
    {  


    } 

}
