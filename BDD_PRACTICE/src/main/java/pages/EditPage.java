package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//i[@class='fas fa-caret-down fa-fw']")
	WebElement DropDown;
	
	@FindBy(xpath="//a[text()=' Your Profile']")
	WebElement Myprofile;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm btn-block']")
	WebElement profile;
	
	@FindBy(xpath="//button[@id='button-upload']")
	WebElement UploadButton;
	
	@FindBy(xpath="//i[@class='fas fa-save']")
	WebElement SaveButton;
	
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement close;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right show']")
    WebElement Drop;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email; 
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement repassword;
	
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement CloseButton;
	
	public EditPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void DropDown()
	{
	DropDown.click();	
	}
	
	public void Myprofile()
	{
		Myprofile.click();	
	}
	
	public void ProfilePhoto() throws AWTException
	{
	profile.click();
	wait.until(ExpectedConditions.visibilityOf(UploadButton));
	UploadButton.click();
	Robot rb=new Robot();
	rb.delay(5000);
	
	StringSelection ss=new StringSelection("C:\\Users\\USER\\Documents\\IMG_20230817_230419_971.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
	rb.delay(500);
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	rb.delay(500);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	wait.until(ExpectedConditions.visibilityOf(CloseButton));
	CloseButton.click();
	}
	
	public void SaveButton()
	{
	wait.until(ExpectedConditions.visibilityOf(SaveButton));	
	JavascriptExecutor Js=(JavascriptExecutor)driver;
	Js.executeScript("arguments[0].click()",SaveButton);
	}
	
	public boolean Drop()
	{
	boolean DROP=Drop.isDisplayed();
	return DROP;
	}
	
	public void Username(String Username)
	{
	username.clear();	
	username.sendKeys(Username);	
	}
	
	public void FirstName(String FirstName)
	{
	Firstname.clear();	
	Firstname.sendKeys(FirstName);
	}
	
	public void LastName(String Lastname)
	{
	lastname.clear();
	lastname.sendKeys(Lastname);
	}
	
	public void Eamil(String email)
	{
	Email.clear();
	Email.sendKeys(email);	
	}
	
	public void Passsword(String Password)
	{
	wait.until(ExpectedConditions.visibilityOf(password));
	password.sendKeys(Password);	
	}
	
	public void Repassword(String Repassword)
	{
	repassword.sendKeys(Repassword);		
	}
	
	public String Title()
	{
	wait.until(ExpectedConditions.titleContains("Profile"));
	String title=driver.getTitle();
	return title;
	}
}
