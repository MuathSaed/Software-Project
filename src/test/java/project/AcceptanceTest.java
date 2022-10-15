package project;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "requirements", monochrome = true, snippets = SnippetType.CAMELCASE, glue = { "project" })

public class AcceptanceTest {

}
