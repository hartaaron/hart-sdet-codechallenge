package wunderground.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends WundergroundPage {
	public static String path = "/";
	public static String title = "Weather Forecast & Reports - Long Range & Local | Wunderground | Weather Underground";

	public static By SearchField = By.id("wuSearch");

	public HomePage(WebDriver driver) {
		super(driver);
		Expected.title = title;
	}

	public WebElement searchField() {
		return driver.findElement(SearchField);
	}

	public void search(String location) {
		searchField().sendKeys(location + Keys.RETURN);

		// TODO: check whether search succeeded
	}
}
