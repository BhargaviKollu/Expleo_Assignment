package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".\\Features\\Challenge.feature",
		dryRun = true,
		glue= {".\\stepdef\\Challenge1.java"},
		monochrome = true,
				plugin= {"pretty","html:test-output"}
		)


public class Testrunner {

}
