package testcases;

import java.io.IOException;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.photobox.qaEngineerHomeworkTest.ApplicationLandingPage;
import com.photobox.qaEngineerHomeworkTest.BaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsukTaxCalculator extends BaseClass {
	BaseClass action = new BaseClass();
	ApplicationLandingPage taxAppPage = new ApplicationLandingPage();

	@Before
	public void Initialize() throws IOException, ATUTestRecorderException,
			InterruptedException {
		 action.initialize();

	}

	@Given("^tax application is running$")
	public void tax_application_is_running() throws Throwable {
		 action.lanchTaxApplication();
	}

	@Given("^I select a title\"([^\"]*)\"$")
	public void i_select_a_title(String title) throws Throwable {
		taxAppPage.selectTitle(title);
	}

	@Given("^I enter \"([^\"]*)\" with (\\d+)$")
	public void i_enter_with(String name, int sal) throws Throwable {
		taxAppPage.enterSalry(name, sal);
	}

	@When("^I calculate tax$")
	public void i_calculate_tax() throws Throwable {
		taxAppPage.calculateTax();
	}

	@Then("^it should show your calculated tax (\\d+) with an message$")
	public void it_should_show_your_calculated_tax_with_an_message(int taxAmount)
			throws Throwable {
		taxAppPage.verifyExpedtedTaxAmount(taxAmount);
	}

	@Then("^a message contains title name \"([^\"]*)\"$")
	public void a_message_contains_title_name(String message) throws Throwable {
		taxAppPage.verifyMessage(message);
	}
	@Given("^an income of £(\\d+)$")
	public void an_income_of_£(int income) throws Throwable {
		action.lanchTaxApplication();
		taxAppPage.enterSalry(null, income);
	}

	@When("^I calculate the taxes$")
	public void i_calculate_the_taxes() throws Throwable {
		taxAppPage.calculateTax();
	}

	@Then("^I find £(\\d+)$")
	public void i_find_£(int taxAmount) throws Throwable {
		taxAppPage.verifyExpedtedTaxAmount(taxAmount);
	}

	
	@After
	public void closeApplication() throws ATUTestRecorderException{
		action.closeBrowser();
	}

}
