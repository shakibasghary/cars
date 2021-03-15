package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import core.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePageObj;
import pageObjects.SearchResultPageObj;
import pageObjects.VehicleDetailsPageObj;
import utilities.WebDriverUtility;

public class searchButton extends Base {

	HomePageObj homePageObj = new HomePageObj();
	SearchResultPageObj searchResultPageObj = new SearchResultPageObj();
	VehicleDetailsPageObj vehicleDetailsPageObj = new VehicleDetailsPageObj();

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		Base.initializeDriver();
		logger.info("Cars Homepage is opened");
		String actualPageTitle = homePageObj.getPageTitle();
		String expectedPageTitle = "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Page title  is verified");
	}

	@When("^user select below criteria$")
	public void user_select_below_criteria(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		homePageObj.selectStockType(list.get(0).get("StockType"));
		System.out.println(list.get(0).get("What"));
		homePageObj.selectMakeID(list.get(0).get("Make"));
		homePageObj.selectModel(list.get(0).get("Model"));
		homePageObj.selectPrice(list.get(0).get("Price"));
		System.out.println(list.get(0).get("StockType"));
		homePageObj.selectMiles(list.get(0).get("MilesFrom"));
		homePageObj.enterZipCode(list.get(0).get("ZipCode"));

		logger.info("user selected the search criteria");
	}

	@When("^user clicks on Search button$")
	public void user_clicks_on_Search_button() throws Throwable {

		homePageObj.clickOnSearchButton();

		logger.info("user clicks on search button");

	}

	@Then("^user should see filtered list based on criteria$")
	public void user_should_see_filtered_list_based_on_criteria() throws Throwable {

		Assert.assertTrue(searchResultPageObj.stockTypeFilterTagIsDisplayed());
		Assert.assertTrue(searchResultPageObj.makeFilterTagIsDisplayed());
		Assert.assertTrue(searchResultPageObj.modelFilterTagIsDisplayed());
		Assert.assertTrue(searchResultPageObj.priceFilterTagIsDisplayed());

		logger.info("'StockType', 'Make', 'Model' and 'Price filter tags are displayed");

	}

	@When("^user selects New radio button from New/Used$")
	public void user_selects_New_radio_button_from_New_Used() throws Throwable {
		searchResultPageObj.selectNewRadioButton();
		Assert.assertTrue(searchResultPageObj.newFilterTagIsDisplayed());
		Assert.assertTrue(searchResultPageObj.usedFilterTagIsNotDisplayed());
		logger.info("User selects 'New' Radio Button");

	}

	@When("^user selects 'Touring (\\d+)-Passenger' from Trim$")
	public void user_selects_Touring_Passenger_from_Trim(String trimTypeInput) throws Throwable {

		searchResultPageObj.selectTouring8PassengerTrimType(trimTypeInput);
		Assert.assertTrue(searchResultPageObj.touring8PassengerFilterIsDisplayed());
		logger.info("User selects Touring 8 Passenger Trim");

	}

	@When("^user clicks on second available car$")
	public void user_clicks_on_second_available_car() throws Throwable {

		searchResultPageObj.clickOnSecondAvailableCar();
		String actualTitle = driver.getTitle();
		String expectedTitle = "2019 Honda Pilot Touring 8-Passenger For Sale In Schaumburg | Cars.com";
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertTrue(vehicleDetailsPageObj.checkAvailabilityButtonIsDisplayed());
		logger.info("user clicks on second available car");
	}

	@When("^user fills out the contact seller section with below information$")
	public void user_fills_out_the_contact_seller_section_with_below_information(DataTable arg1) throws Throwable {

		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		vehicleDetailsPageObj.enterfirstNameOnSellerSection(list.get(0).get("FirstName"));
		vehicleDetailsPageObj.enterfirstNameOnSellerSection(list.get(0).get("LastName"));
		vehicleDetailsPageObj.enterfirstNameOnSellerSection(list.get(0).get("Email"));
		logger.info("User enters the provided Contact Seller information");
	}

	@Then("^user should scroll down to 'Payment Calculator'$")
	public void user_should_scroll_down_to_Payment_Calculator() throws Throwable {
		vehicleDetailsPageObj.scrollToPaymentCalculatorSection();
		WebDriverUtility.screenShot();
		logger.info("User scrolled down to Payment Calculator");
	}

}
