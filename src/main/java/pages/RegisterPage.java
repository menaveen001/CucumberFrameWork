package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameAddressField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameAddressField;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneAddessField;

	@FindBy(id = "input-password")
	private WebElement passwordAddressField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordAddressField;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyCheckBoxOption;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButtonOption;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsLatterRadioButtonOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddressAlreadyRegisterWarningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessageForAgreeProivacyPolicy;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;

	// Actions

	public void enterFirstNameAddress(String firstName) {
		firstNameAddressField.sendKeys(firstName);
	}

	public void enterLastNameAddress(String lastName) {

		lastNameAddressField.sendKeys(lastName);
	}

	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}

	public void enterTelephoneAddress(String telephone) {
		telephoneAddessField.sendKeys(telephone);
	}

	public void enterPasswordAddress(String password) {
		passwordAddressField.sendKeys(password);
	}

	public void enterConfirmPasswordAddress(String password) {
		confirmPasswordAddressField.sendKeys(password);
	}

	public void selectPrivacyPolicyCheckBox() {
		privacyPolicyCheckBoxOption.click();

	}

	public AccountSuccessPage clickOnContinueButtonOption() {
		continueButtonOption.click();
		return new AccountSuccessPage(driver);
	}

	public void selectNewsLatterRadioButton() {
		newsLatterRadioButtonOption.click();
	}

	public String retriveEmailAddressAlreadyRegisterWarningMessage() {
		String emailWaringMessage = emailAddressAlreadyRegisterWarningMessage.getText();
		return emailWaringMessage;
	}

	public String retriveWarningMessageForAgreeProivacyPolicy() {
		String privacyPolicyWarningMessage = warningMessageForAgreeProivacyPolicy.getText();
		return privacyPolicyWarningMessage;

	}

	public String retriveFirstNameWarningMessage() {
		String firstNameMessage = firstNameWarningMessage.getText();
		return firstNameMessage;
	}

	public String retriveLastNameWarningMessage() {
		String lastNameMessage = lastNameWarningMessage.getText();
		return lastNameMessage;
	}

	public String retriveEmailWarningMessage() {
		String emailMessage = emailWarningMessage.getText();
		return emailMessage;
	}

	public String retriveTelephoneWarningMessage() {
		String telephoneMessage = telephoneWarningMessage.getText();
		return telephoneMessage;
	}

	public String retrivePasswordWarningMessage() {
		String passwordMessage = passwordWarningMessage.getText();
		return passwordMessage;
	}
}
