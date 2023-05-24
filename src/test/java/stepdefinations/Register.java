package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register {
	WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOptin();

	}

	@When("User enters the detalis into below fields")
	public void user_enters_the_detalis_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstNameAddress(dataMap.get("firstName"));
		registerPage.enterLastNameAddress(dataMap.get("lastName"));
		registerPage.enterEmailAddress(System.currentTimeMillis() + dataMap.get("email"));
		registerPage.enterTelephoneAddress(dataMap.get("telephone"));
		registerPage.enterPasswordAddress(dataMap.get("password"));
		registerPage.enterConfirmPasswordAddress(dataMap.get("password"));

	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {

		registerPage.selectPrivacyPolicyCheckBox();

	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {

		accountSuccessPage = registerPage.clickOnContinueButtonOption();

	}

	@Then("User account should get created successfull")
	public void user_account_should_get_created_successfull() {

		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.retriveAccountCreatedSuccessMessage());
	}

	@And("User selects yes Newslatter")
	public void user_selects_yes_newslatter() {

		registerPage.selectNewsLatterRadioButton();
	}

	@Then("User should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() {

		Assert.assertTrue(registerPage.retriveEmailAddressAlreadyRegisterWarningMessage()
				.contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enters any deatils into fields")
	public void user_dont_enters_any_deatils_into_fields() {
////

	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {

		Assert.assertTrue(registerPage.retriveWarningMessageForAgreeProivacyPolicy()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerPage.retriveFirstNameWarningMessage());

		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registerPage.retriveLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.retriveEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerPage.retriveTelephoneWarningMessage());

		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registerPage.retrivePasswordWarningMessage());
	}

	@When("User enters the detalis into below fields to create duplicate account")
	public void user_enters_the_detalis_into_below_fields_to_create_duplicate_account(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstNameAddress(dataMap.get("firstName"));
		registerPage.enterLastNameAddress(dataMap.get("lastName"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephoneAddress(dataMap.get("telephone"));
		registerPage.enterPasswordAddress(dataMap.get("password"));
		registerPage.enterConfirmPasswordAddress(dataMap.get("password"));

	}
}
