package cucumber;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cucumber",
        glue = {"cc.robotdreams.cucumber.steps"},
        plugin = {
                "pretty",
                "json:target/cucumber.json"
        }
)

public class CucumberSuiteTest
{

}
