package runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(com.utilityclasses.TestEventListenersUtility.class)
@CucumberOptions(
		features = {"src/test/resources/featureFiles/salesforceApp.feature"},
		glue = {"steps"}
		
		)

public class RunnerForSalesforceApp extends AbstractTestNGCucumberTests  {

}
