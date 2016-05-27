package wunderground.automation;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverTestBase {
	static protected Logger log;
	static protected WebDriver driver;
	static protected WundergroundDriver wunderground;
	static protected Properties settings = new Properties();

	static {
		// default settings
		settings.setProperty("baseUrl", "http://wunderground.com");
		settings.setProperty("browser", "firefox");
		settings.setProperty("timeout", "30000");
	}

	static protected void initialiseSettings() {
		try {
			settings.load(new FileInputStream("/testrun.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static protected void initialiseSettings(Properties newSettings) {
		settings.putAll(newSettings);
	}

	@Rule
	public TestName testName = new TestName();

	@BeforeClass
	public static void init() {
		initialiseSettings();
		String browserName = settings.getProperty("browser").toUpperCase();
		Browser browser = Browser.valueOf(browserName);
		driver = new WebDriverFactory(settings).get(browser);
		wunderground = new WundergroundDriver(driver);
	}

	@Before
	public void beforeEach() {
		log = Logger.getLogger(this.getClass());
		log.info("--- test started : " + testName.getMethodName() + " ---\n");
	}

	@After
	public void afterEach() {
		log.info("--- test completed " + " ---\n");
		pause(3000);
	}

	@AfterClass
	public static void cleanup() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void pause(int milliseconds) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
