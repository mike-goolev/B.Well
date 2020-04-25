package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/report"},
        strict = true,
        tags = {})

public class TestRunner extends AbstractTestNGCucumberTests {

}
