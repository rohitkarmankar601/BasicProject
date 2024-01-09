package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features={"src\\test\\resources\\applicationApp\\Edit.feature"},
		
		glue= {"step","hook"},
		
		plugin= {"pretty"},
		
		publish=true
		
		)
public class AppRunner extends AbstractTestNGCucumberTests{

}
