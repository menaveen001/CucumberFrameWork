package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;

	@Given("User is Open the Application")
	public void user_is_open_the_application() {
		driver = DriverFactory.getDriver();

	}

	@When("User enters valid product {string} into Search box fields")
	public void user_enters_valid_product_into_search_box_fields(String productName) {

		homePage = new HomePage(driver);
		homePage.enterTextIntoSearchBoxField(productName);

	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {

		
		searchResultsPage = homePage.clickOnSearchButtonOption();

	}

	@Then("User should get valid product displayed in search  results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	
		Assert.assertTrue(searchResultsPage.displayValidSearchProduct());

	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String productName) {
		homePage = new HomePage(driver);
		homePage.enterTextIntoSearchBoxField(productName);
	}

	@Then("User should get a message about product matching")
	public void user_should_get_a_message_about_product_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.",
				searchResultsPage.retriveProductMissMatchMessage());

	}

}
