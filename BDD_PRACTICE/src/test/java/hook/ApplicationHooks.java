package hook;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import qa.DriverFactory;
import utility.ConfigDataReader;

public class ApplicationHooks {
	
	DriverFactory DF;
	WebDriver driver;
	
	@Before(order=1)
	public void LaunchTheBrowser() throws IOException
	{
	DF=new DriverFactory();
	driver=DF.BrowserInit(ConfigDataReader.ReadData("Browser"));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	}
	
	@After(order=1)
	public void TearDownEnvironment()
	{
	driver.quit();	
	}
}
