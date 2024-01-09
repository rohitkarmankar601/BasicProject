package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScenarioWebPage {
    
	WebDriver driver;
	WebDriverWait wait;
	
	private final String Username="//input[@name='username']";
	private final String Password="//input[@name='password']";
	private final String LoginButton="//button[@type='submit']";
    private final String titleAfterLogin="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
	private final String errorMessage="//p[text()='Invalid credentials']";
	@FindBy(xpath=Username)
	WebElement username;
	
	@FindBy(xpath=Password)
	WebElement password;
	
	@FindBy(xpath=LoginButton)
	WebElement loginbutton;
	
	@FindBy(xpath=titleAfterLogin)
	WebElement TitleAfterLogin;
	
	@FindBy(xpath=errorMessage)
	WebElement ErrorMessage;
	
	public ScenarioWebPage(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void Username(String USERNAME)
	{
	wait.until(ExpectedConditions.visibilityOf(username));	
	username.sendKeys(USERNAME);
	}
	
	public void Password(String PASSWORD)
	{
	password.sendKeys(PASSWORD);	
	}
	
	public void Loginbutton()
	{
	loginbutton.click();	
	}
	
	public String TitleAfterLogin()
	{
	wait.until(ExpectedConditions.visibilityOf(TitleAfterLogin));	
	String title1=TitleAfterLogin.getText();
	return title1;
	}
	
	public String ErrorMeaage()
	{
    wait.until(ExpectedConditions.visibilityOf(ErrorMessage));	
	String Error=ErrorMessage.getText();
	return Error;
	}
	
	public String TitleOfLoginPage()
	{
	wait.until(ExpectedConditions.titleContains("OrangeHRM"));
	String title2=driver.getTitle();	
	return title2;
	}
	
    public String UrlOfLoginPage()
    {
    wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));	
    String URL=driver.getCurrentUrl();
    return URL;
    }
}
