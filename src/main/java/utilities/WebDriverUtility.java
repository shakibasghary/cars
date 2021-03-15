package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;

public class WebDriverUtility extends Base {

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void scrollUntilElementIsVisibleWithJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, long duration) {

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String screenShotFileName() {
		Date date = new Date();
		String screenShotName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return screenShotName;
	}

	public static void screenShot() {
		String location = System.getProperty("user.dir") + "\\screenshots\\";
		String screenShotFileName = screenShotFileName();
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception in execution");
		}
	}

}
