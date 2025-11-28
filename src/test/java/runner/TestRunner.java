package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps", "hooks"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
                  "json:target/cucumber-reports/cucumber.json",},
        monochrome = true
)// Use 'and' to combine tags
public class TestRunner extends AbstractTestNGCucumberTests {
}
