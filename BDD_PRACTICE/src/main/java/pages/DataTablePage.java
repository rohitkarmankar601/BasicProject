package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataTablePage {
	
WebDriver driver;	
WebDriverWait wait;
private final String SignInButton="//div[@class='signupcontainer']//a[text()='Sign up']";
private final String Email="//input[@id='email' and @name='email']";
private final String Password="//input[@id='password']";
private final String PhoneNumber="//input[@id='rmobile']";
private final String aggrement="signup-termservice";
private final String SignInForFreeButton="//input[@type='submit']";
private final String Captcha="//span[text()='Please enter the CAPTCHA.']";

@FindBy(xpath=SignInButton)
WebElement SignButton;

@FindBy(xpath=Email)
WebElement EmailButton;

@FindBy(xpath=Password)
WebElement PasswordButton;

@FindBy(xpath=PhoneNumber)
WebElement Phonenumber;

@FindBy(id=aggrement)
WebElement Aggrement;

@FindBy(xpath=SignInForFreeButton)
WebElement SignInforFreeButton;

@FindBy(xpath=Captcha)
WebElement VerifyCaptcha;

public DataTablePage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
wait=new WebDriverWait(driver,Duration.ofSeconds(20));
}

public void SignIn()
{	
wait.until(ExpectedConditions.visibilityOf(SignButton));
SignButton.click();	
}

public void EnterEmail(String email)
{
wait.until(ExpectedConditions.visibilityOf(EmailButton));
EmailButton.sendKeys(email);
}

public void EnterPassword(String Pass)
{
PasswordButton.sendKeys(Pass);	
}

public void PhoneNumber(String Number)
{
Phonenumber.sendKeys(Number);	
}

public void Aggrement()
{
Aggrement.click();	
}

public void SignInUpForFreeButton()
{
SignInforFreeButton.click();	
}

public String Verifycaptcha()
{
wait.until(ExpectedConditions.visibilityOf(VerifyCaptcha));
String captcha=VerifyCaptcha.getText();	
return captcha;
}

public String Title()
{
String Title=driver.getTitle();	
return Title;
}

public String URL()
{
String URL=driver.getCurrentUrl();	
return URL;
}

public String SignInPageTitle()
{
wait.until(ExpectedConditions.titleContains("Create New Account - zoho.com"));
String title=driver.getTitle();
return title;
}
}
