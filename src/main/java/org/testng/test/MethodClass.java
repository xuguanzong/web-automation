package org.testng.test;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;
import javax.mail.Address;


public class MethodClass 
{
	
	public void easyEmail(String sendMan, String content,String theme,String smtp,String port,String password,String receiver) throws AddressException, MessagingException
	{
		Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
        properties.setProperty("mail.smtp.auth", "true");//需要验证
        // properties.setProperty("mail.debug", "true");//设置debug模式 后台输出邮件发送的过程
        Session session = Session.getInstance(properties);
        session.setDebug(true);//debug模式
        //邮件信息
        Message messgae = new MimeMessage(session);
        messgae.setFrom(new InternetAddress(sendMan));//设置发送人
        messgae.setText(content);//设置邮件内容
        messgae.setSubject(theme);//设置邮件主题
        //发送邮件
        Transport tran = session.getTransport();

        tran.connect(smtp, 25, "xuguanzong@163.com", password);//连接到QQ邮箱服务器
        tran.sendMessage(messgae, new Address[]{ new InternetAddress(receiver)});//设置邮件接收人
        tran.close();
	}

	public void multipleEmail(String sendman, String zhuti,String receiver,String host) throws AddressException, MessagingException 
	{
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth","true");//设置验证机制
		properties.setProperty("mail.transport.protocol","smtp");//发送邮件协议
		properties.setProperty("mail.smtp.host",host);//设置邮箱服务器地址
		properties.setProperty("mail.smtp.port","25");
		Session session = Session.getInstance(properties,new MyAuthenticator());
		session.setDebug(true);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendman));
		message.setSubject(zhuti);
		message.setRecipients(RecipientType.TO,InternetAddress.parse(receiver));//接收人
		//message.setRecipients(RecipientType.CC,InternetAddress.parse("1348800595@qq.com"));//抄送人
		//message.setRecipients(RecipientType.BCC,InternetAddress.parse("1348800595@qq.com"));//密送人
		MimeBodyPart bodyPartAttch = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\index.html");//附件
		
		MimeBodyPart bodyPartAttch2 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\reportng.js");//附件
		MimeBodyPart bodyPartAttch3 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\sorttable.js");//附件
		MimeBodyPart bodyPartAttch4 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\reportng.css");//附件
		MimeBodyPart bodyPartAttch5 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\suite1_test1_results.html");//附件
		MimeBodyPart bodyPartAttch6 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\overview.html");//附件
		MimeBodyPart bodyPartAttch7 = createAttachMent("D:\\eclipsework\\test\\target\\surefire-reports\\html\\suites.html");//附件
		
		MimeBodyPart bodyPartContentAndPic = createContentAndPic("测试报告如下","F:\\YY娱乐需求\\Y歌之王bug\\审核中.jpg");//文本内容
		MimeMultipart mimeMuti = new MimeMultipart("mixed");
		mimeMuti.addBodyPart(bodyPartAttch);
		mimeMuti.addBodyPart(bodyPartAttch2);
		mimeMuti.addBodyPart(bodyPartAttch3);
		mimeMuti.addBodyPart(bodyPartAttch4);
		mimeMuti.addBodyPart(bodyPartAttch5);
		mimeMuti.addBodyPart(bodyPartAttch6);
		mimeMuti.addBodyPart(bodyPartAttch7);
		
		mimeMuti.addBodyPart(bodyPartContentAndPic);
		message.setContent(mimeMuti);
		message.saveChanges();
		//message.setContent("Michael", "text/html;charset=gbk");
		Transport.send(message);
	}
	
	public static MimeBodyPart createAttachMent(String path) throws MessagingException
	{
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		FileDataSource dataSource = new FileDataSource( new File(path));
		mimeBodyPart.setDataHandler(new DataHandler(dataSource));
		mimeBodyPart.setFileName(dataSource.getName());
		return mimeBodyPart;
		}
	
	
	public static MimeBodyPart createContentAndPic(String content,String path) throws MessagingException
	{
		MimeMultipart mimeMutiPart = new MimeMultipart("related");
		//图片
		MimeBodyPart picBodyPart = new MimeBodyPart();
		FileDataSource fileDataSource = new FileDataSource( new File(path));
		picBodyPart.setDataHandler(new DataHandler(fileDataSource));
		picBodyPart.setFileName(fileDataSource.getName());
		mimeMutiPart.addBodyPart(picBodyPart);
		//文本
		MimeBodyPart contentBodyPart = new MimeBodyPart();
		contentBodyPart.setContent(content,"text/html;charset=gbk");
		mimeMutiPart.addBodyPart(contentBodyPart);
		//图片和文本结合
		MimeBodyPart allBodyPart = new MimeBodyPart();
		allBodyPart.setContent(mimeMutiPart);
		return allBodyPart;
		
		}

}
