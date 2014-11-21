package org.testng.test;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
public class MyAuthenticator extends Authenticator {

private static final String userName = "xuguanzong@163.com";
private static final String passWord = "cfadhp20090622";
// * @author Michael.wu
//* 密码和用户的验证
public MyAuthenticator() {
super();
}

@Override
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(userName, passWord);
}

}