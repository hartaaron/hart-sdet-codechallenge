package wunderground.automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends WundergroundPage {
	public static String path = "/";
	public static String title = "Weather Forecast & Reports - Long Range & Local | Wunderground | Weather Underground";

	public HomePage(WebDriver driver) {
		super(driver);
		Expected.title = title;
	}
}
