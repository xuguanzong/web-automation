package org.testng.test;  
  
import java.util.concurrent.TimeUnit;  
  




import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.*; 
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.chrome.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;

import org.openqa.selenium.TakesScreenshot;

import junit.framework.TestCase;  
  
public class baidu 
{  
    private static WebDriver driver =null;  
    private String baseUrl;  
    public ITestContext testContext = null;
    
    @BeforeClass  
    public void setUp(ITestContext context) throws Exception {   
    	this.testContext = context;
        baseUrl = "http://www.baidu.com/";  
        System.setProperty("webdriver.chrome.driver", "E:\\software\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
        testContext.setAttribute("SELENIUM_DRIVER", driver);
    }  
   
    @Test  
    public void testSearchMyBlog()  {  
        driver.get(baseUrl);  
          
        WebElement element = driver.findElement(By.id("kw"));  
        element.clear();  
        element.sendKeys("webDriver");
        driver.manage().window().maximize();
   
        element = driver.findElement(By.id("00000"));  
        element.click();  
          
        //Thread.sleep(3*1000);  
      
        
        
        /*
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.qq.com"); // 指定SMTP服务器
        props.put("mail.smtp.port", "25");  // 指定SMTP服务器端口
        props.put("mail.smtp.auth", "true"); // 指定是否需要SMTP验证
        
        
        try {
            Session mailSession = Session.getDefaultInstance(props);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress("584657555@qq.com")); // 发件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("137180873@qq.com")); // 收件人
            message.setSubject("测试自动化"); // 邮件主题
            Object content = null;
			//指定邮箱内容及ContentType和编码方式
            //message.setContent(content.toString(), "text/html;charset=utf-8");
            //指定邮件发送日期
            message.setSentDate(new Date());
            message.saveChanges();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.qq.com", "584657555@qq.com", "cfadhp20090622yl");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        
           */
        
        /*
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
        properties.setProperty("mail.smtp.auth", "true");//需要验证
        // properties.setProperty("mail.debug", "true");//设置debug模式 后台输出邮件发送的过程
        Session session = Session.getInstance(properties);
        session.setDebug(true);//debug模式
        //邮件信息
        Message messgae = new MimeMessage(session);
        messgae.setFrom(new InternetAddress("xuguanzong@163.com"));//设置发送人
        messgae.setText("what's up man");//设置邮件内容
        messgae.setSubject("测试邮件");//设置邮件主题
        //发送邮件
        Transport tran = session.getTransport();

        tran.connect("smtp.163.com", 25, "xuguanzong@163.com", "cfadhp20090622");//连接到QQ邮箱服务器
        tran.sendMessage(messgae, new Address[]{ new InternetAddress("584657555@qq.com")});//设置邮件接收人
        tran.close();
        
        */
        
    
    }  
   

        
    @AfterClass  
    public void tearDown() throws Exception 
    {  
        driver.quit();  
        MethodClass A = new MethodClass();
        A.multipleEmail("xuguanzong@163.com", "一封邮件", "584657555@qq.com", "smtp.163.com");

    } 

 
 
}  