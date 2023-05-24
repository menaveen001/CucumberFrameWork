package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButtonOption;

	public void clickOnMyAccount() {
		myAccountDropMenu.click();

	}

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	public LoginPage selectLoginOption() {

		loginOption.click();
		
		return new LoginPage(driver);
	}

	public RegisterPage selectRegisterOptin() {

		registerOption.click();
		return new RegisterPage(driver);
		
	}

	public void enterTextIntoSearchBoxField(String productName) {

		searchBoxField.sendKeys(productName);
	}

	public SearchResultsPage clickOnSearchButtonOption() {
		searchButtonOption.click();
		
		return new SearchResultsPage(driver);
	}
}
