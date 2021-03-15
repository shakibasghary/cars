package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class SearchResultPageObj extends Base {
	public SearchResultPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//label[contains(text(),'Price: $50,000')])[1]")
	private WebElement priceFilterTag;

	@FindBy(xpath = "(//div[@class='cui-icon']//following-sibling::label[contains(text(),'Honda')])[1]")
	private WebElement makeFilterTag;

	@FindBy(xpath = "(//label[contains(text(),'Pilot')])[1]")
	private WebElement modelFilterTag;

	@FindBy(xpath = "(//label[contains(text(),'Used')])[1]")
	private WebElement stockTypeFilterTag;

	@FindBy(xpath = "//input[@id='stkTypId-28880']//following-sibling::label")
	private WebElement newRadioButton;

	@FindBy(xpath = "(//label[contains(text(),'New')])[1]")
	private WebElement newFilterTag;

	@FindBy(xpath = "(//label[contains(text(),'Used')])[1]")
	private WebElement usedFilterTag;

	@FindBy(xpath = "(//label[text()='Touring 8-Passenger'])[1]")
	private WebElement touring8PassengerFilter;

	@FindBy(xpath = "//li[@id='trId']//li//label")
	private List<WebElement> trimType;

	@FindBy(xpath = "(//h2[contains(text(),'8-Passenger')])[2]")
	private WebElement secondAvailableCar;



	public void clickOnSecondAvailableCar() {

		secondAvailableCar.click();
	}

	public void selectTouring8PassengerTrimType(String trimTypeInput) {

		for (WebElement w : trimType) {

			String elementText = w.getText();
			if (elementText.contains(trimTypeInput)) {
				WebDriverUtility.scrollUntilElementIsVisibleWithJS(driver, w);
				if (w.isSelected() == false) {
					WebDriverUtility.waitForElementToBeClickable(driver, w, 30);
					w.click();
					break;
				}

			}
		}
	}

	public boolean touring8PassengerFilterIsDisplayed() {
		if (touring8PassengerFilter.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean usedFilterTagIsNotDisplayed() {
		if (usedFilterTag.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean newFilterTagIsDisplayed() {

		if (newFilterTag.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void selectNewRadioButton() {
		newRadioButton.click();
	}

	public boolean priceFilterTagIsDisplayed() {
		if (priceFilterTag.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean makeFilterTagIsDisplayed() {
		if (makeFilterTag.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean modelFilterTagIsDisplayed() {
		if (modelFilterTag.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean stockTypeFilterTagIsDisplayed() {
		if (stockTypeFilterTag.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
