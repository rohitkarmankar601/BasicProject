package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
       features = {"src/test/resources/applicationApp/ScenarioOutline.feature"},		
		
       glue= {"step","hook"},
       
       plugin={"pretty"},
       
       publish=true,
       
       tags="@regression"
		)

public class SenarioRunner extends AbstractTestNGCucumberTests{

}
