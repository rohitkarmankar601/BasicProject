package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features= {"src/test/resources/applicationApp/LoginLogout.feature"},
		
		glue= {"step","hook"},
		
		plugin= {"pretty"},
		
		publish=true
		
		)


public class Login_Logout_Page_Runner extends AbstractTestNGCucumberTests{

}
