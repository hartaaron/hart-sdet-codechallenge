package hart.sdet.challenge;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WundergroundDriver_Tests {

	static WebDriver driver;
	static WundergroundDriver wunderground;


	@BeforeClass
	public static void init() {
		driver = new FirefoxDriver();
		wunderground = new WundergroundDriver(driver);
	}

	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void should_open_wunderground_home_page() {
		System.out.println("opening wunderground");

		wunderground.open();
	}

}
