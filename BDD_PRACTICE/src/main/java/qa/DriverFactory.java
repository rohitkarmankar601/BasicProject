package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

public static WebDriver driver;
	
	public WebDriver BrowserInit(String Browser) 
	{
	if(Browser.equals("Chrome")) 
	{
	driver=new ChromeDriver();	
	}
	else if(Browser.equals("Edge"))
	{
	driver=new EdgeDriver();	
	}
	else if(Browser.equals("FireFox"))
	{
	driver=new FirefoxDriver();	
	}
	return driver;
	}
	
	public static WebDriver GetDriver()
	{
	return driver;
	}
}
