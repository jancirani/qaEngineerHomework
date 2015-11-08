package testcases;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=".",format={"html:target/cucumber","json:target/cucumber.json"},
tags="@all")
//tags="@withMultipleTestData")
//tags=", @basicRate,  @higherRate,  @additionalRate")

public class RunCalculatorTest {

}
