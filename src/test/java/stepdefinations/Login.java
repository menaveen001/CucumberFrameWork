package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("User has navigate to login page")
	public void User_has_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("User has enters valid email address {string} into the email field")
	public void User_has_enters_valid_email_address_into_the_email_field(String validEmail) {

		loginPage.enterEmailAddress(validEmail);

	}

	@And("User has enters valid password {string} into password field")
	public void user_has_enters_valid_password_into_password_field(String validPassword) {

		loginPage.enterPassword(validPassword);

	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButtonOption();

	}

	@Then("User should get successfully loged in")
	public void user_should_get_successfully_loged_in() {

		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
	}

	@When("User has enters invalid email address {string} into the email field")
	public void user_has_enters_invalid_email_address_into_the_email_field(String invalidEmail) {

		loginPage.enterEmailAddress(invalidEmail);
	}

	@And("User has enters invalid password {string} into password field")
	public void user_has_enters_invalid_password_into_password_field(String invalidPassword) {

		loginPage.enterPassword(invalidPassword);

	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWaringMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enters email address into email field")
	public void user_dont_enters_email_address_into_email_field() {

		loginPage.enterEmailAddress("");

	}

	@And("User dont enters Password into password field")
	public void user_dont_enters_password_into_password_field() {

		loginPage.enterPassword("");

	}
}
