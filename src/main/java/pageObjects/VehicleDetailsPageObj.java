package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class VehicleDetailsPageObj extends Base {

	public VehicleDetailsPageObj() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Check Availability']")
	private WebElement checkAvailabilityButton;

	@FindBy(name = "fname")
	private WebElement firstNameOnSellerSection;

	@FindBy(name = "lname")

	private WebElement LastNameOnSellerSection;
	@FindBy(name = "email")
	private WebElement emailOnSellerSection;

	@FindBy(xpath = "//h2[text()='Payment Calculator']")
	private WebElement paymentCalculator;

	public boolean checkAvailabilityButtonIsDisplayed() {
		if (checkAvailabilityButton.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void scrollToPaymentCalculatorSection() {
		WebDriverUtility.scrollUntilElementIsVisibleWithJS(driver, paymentCalculator);
	}

	public void enterfirstNameOnSellerSection(String firstName) {
		firstNameOnSellerSection.sendKeys(firstName);
	}

	public void enterLastNameOnSellerSection(String lastName) {
		LastNameOnSellerSection.sendKeys(lastName);
	}

	public void EnterEmailOnSellerSection(String email) {
		emailOnSellerSection.sendKeys(email);
	}

}
