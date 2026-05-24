package api.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api/features",
        glue = "api.steps",
        tags = "@api",
        plugin = {
                "pretty",
                "html:reports/api.html",
                "json:reports/api.json"
        }
)
public class ApiTestRunner {
}