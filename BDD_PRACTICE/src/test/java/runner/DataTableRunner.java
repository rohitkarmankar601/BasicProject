package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
	       features = {"src/test/resources/applicationApp/DataTable.feature"},		
			
	       glue= {"step","hook"},
	       
	       plugin={"pretty"},
	       
	       publish=true
	       
			)
public class DataTableRunner extends AbstractTestNGCucumberTests{

}
