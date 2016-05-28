package wunderground.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForecastPage extends WundergroundPage {

	// this path doesn't work without a query string ?query=location
	public static String path = "/cgi-bin/findweather/getForecast?query=${location}";

	// this title is not accruate without replacing location values below
	public static String title = "${location.city}, ${location.state} (${location.zip}) Forecast";

	public static By location = By.cssSelector("#location h1");
	public static By time = By.cssSelector(".local-time");
	public static By temperature = By.cssSelector("[data-variable=temperature]");
	public static By sky = By.cssSelector("[data-variable=condition]");
	public static By windSpeed = By.cssSelector("[data-variable=wind_speed]");
	public static By windDirection = By.cssSelector("[data-variable=wind_dir]");
	public static By precipitation = By.cssSelector("#precip-link");
	public static By high = By.cssSelector("");
	public static By low = By.cssSelector("");
	public static By todaysForecast = By.id("todaySummary");
	public static By todaysHigh = By.cssSelector("#todaySummary .high:first");
	public static By todaysLow = By.cssSelector("#todaySummary .low:first");

	public ForecastPage(WebDriver driver) {
		super(driver);
		this.title = "${location.city}, ${location.state} (${location.zip}) Forecast";
		Expected.title = title;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTemperature() {
		return driver.findElement(temperature).getText();
	}

	public String getLocation() {
		return driver.findElement(location).getText();
	}

	public String getTime() {
		return driver.findElement(time).getText();
	}

	public String getSkyCondition() {
		return driver.findElement(sky).getText();
	}

	public String getWindSpeed() {
		return driver.findElement(windSpeed).getText();
	}

	public String getWindDirection() {
		return driver.findElement(windDirection).getText();
	}

	public String getTodaysHigh() {
		return driver.findElement(todaysHigh).getText();
	}

	public String getTodaysLow() {
		return driver.findElement(todaysLow).getText();
	}

	public String getTodaysPrecipitation() {
		return driver.findElement(precipitation).getText();
	}
}
