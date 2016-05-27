package wunderground.automation;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTestBase {
	static protected Logger log;
	static protected WebDriver driver;
	static protected WundergroundDriver wunderground;

	public WebDriverTestBase() {
		log = Logger.getLogger(this.getClass());
	}

	@Rule
	public TestName testName = new TestName();

	@BeforeClass
	public static void init() {

		driver = new FirefoxDriver();
		wunderground = new WundergroundDriver(driver);
	}

	@Before
	public void beforeEach() {
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
