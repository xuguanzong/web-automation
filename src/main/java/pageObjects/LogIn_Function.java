package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class LogIn_Function 
{
	WebDriver driver;
	
	@FindBy(partialLinkText  = "登录")
	public  WebElement loginlink;
	
	@FindBy(id = "loginname")
	public  WebElement username;
	
	@FindBy(id = "nloginpwd")
	public  WebElement password;
	
	@FindBy(id = "loginsubmit")
	public  WebElement loginbutton;
	
	@FindBy(className = "link-logout")
	public  WebElement logoutlink;
	
	@FindBy(id = "loginname_error")
	public  WebElement loginname_error;
	
	@FindBy(id = "loginpwd_error")
	public  WebElement loginpwd_error;
	
	public void LogIn_Action(String susername,String spassword)
	{
		username.sendKeys(susername);
		password.sendKeys(spassword);
		loginbutton.click();
	}
	

	

}
