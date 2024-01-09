package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Logout_Page {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='input-username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement button;
	
	@FindBy(xpath="//button[@class='btn-close']")
	WebElement remove;
	
	@FindBy(xpath="//a[@class='nav-link']")
	WebElement logout;
	
	@FindBy(xpath="//i[@class='far fa-bell']")
	WebElement notification;
	
	
	public Login_Logout_Page(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	wait=new WebDriverWait (driver,Duration.ofSeconds(20));
	}
	
	public void Username(String Username)
	{
	username.sendKeys(Username);	
	}
	
	public void Password(String Password)
	{
	password.sendKeys(Password);	
	}
	
	public void LoginButton() 
	{
	button.click();	
	}
	
	public void Close()
	{
		remove.click();	
	}
	
	public void LogoutButton()
	{
	wait.until(ExpectedConditions.visibilityOf(logout));
	logout.click();	
	}
	
	public String Title()
	{
	wait.until(ExpectedConditions.titleContains("Dashboard"));
	String title=driver.getTitle();	
	return title;
	}
	
	public boolean CheckIcon()
	{
	boolean	display=notification.isDisplayed();	
	return display;
	}
	
	public String Title2()
	{
	wait.until(ExpectedConditions.titleContains("Administration"));
	String title2=driver.getTitle();
	return title2;
	}
}
