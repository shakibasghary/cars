package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class HomePageObj extends Base {

	public HomePageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "stockType")
	private WebElement stockType;

	@FindBy(name = "makeId")
	private WebElement makeID;

	@FindBy(name = "modelId")
	private WebElement model;

	@FindBy(name = "priceMax")
	private WebElement price;

	@FindBy(name = "radius")
	private WebElement miles;

	@FindBy(name = "zip")
	private WebElement zipCode;

	@FindBy(css = "input.NZE2g")
	private WebElement searchButton;
	
	public String getPageTitle() {
		String title =driver.getTitle();
		
		return title;
	}

	public void selectStockType(String inputVisibleText) {
		WebDriverUtility.selectByVisibleText(stockType, inputVisibleText);
	}

	public void selectMakeID(String inputVisibleText) {
		WebDriverUtility.selectByVisibleText(makeID, inputVisibleText);
	}

	public void selectModel(String inputVisibleText) {
		WebDriverUtility.selectByVisibleText(model, inputVisibleText);
	}

	public void selectPrice(String inputValueText) {
		WebDriverUtility.selectByValue(price, inputValueText);
	}

	public void selectMiles(String inputValueText) {
		WebDriverUtility.selectByValue(miles, inputValueText);
	}

	public void enterZipCode(String inputZipCode) {
		zipCode.clear();
		zipCode.sendKeys(inputZipCode);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

}
