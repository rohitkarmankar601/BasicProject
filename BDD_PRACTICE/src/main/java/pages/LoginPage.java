package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

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
	
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
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
	
	public String Title()
	{
	String title=driver.getTitle();	
	return title;
	}
	
	public String GetUrl()
	{
	String Url=driver.getCurrentUrl();
	return Url;
	}
	
	public void Notification()
	{
	wait.until(ExpectedConditions.visibilityOf(remove));
	remove.click();
	}
	
	public String Title2()
	{
	wait.until(ExpectedConditions.titleContains("Dashboard"));	
	String Title2=driver.getTitle();
	return Title2;
	}
}
