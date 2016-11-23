package amazon.pages.stepdefinition;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        format = {"pretty", "json:target/amazon.pages.json"},
        features = {"src/test/resource/"}
        //tags = {"@Pub, @CS, @PB, @SBP"}




)


public class RunnerTest {
}
