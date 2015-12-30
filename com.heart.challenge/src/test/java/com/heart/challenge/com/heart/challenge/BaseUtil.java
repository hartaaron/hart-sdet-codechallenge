package com.heart.challenge.com.heart.challenge;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Nvalenzuela
 * 
 */
public class BaseUtil {

	public static WebDriver driver;
	DesiredCapabilities caps = new DesiredCapabilities();
	private static final Logger log = LoggerFactory.getLogger(BaseUtil.class);

	/**
	 * Sets the browser before every class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {

		InputStream input = null;
		Properties prop = new Properties();

		try {
			input = new FileInputStream((new File(
					"C:\\workspace\\test.properties")));
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String browser = (prop.getProperty("browser"));

			if (browser.equals("mobile")) {
				log.info("Mobile device chosen");
			} else {
				log.info("Browser = " + browser);
			}

			if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\workspace\\Drivers\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("ie9")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\workspace\\Drivers\\IE64\\IEDriverServer.exe");
				final DesiredCapabilities caps = DesiredCapabilities
						.internetExplorer();
				caps.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				caps.setCapability("ignoreProtectedModeSettings", true);
				driver = new InternetExplorerDriver(caps);

			} else if (browser.equals("mobile")) {

				SelendroidCapabilities capa = new SelendroidCapabilities(
						"io.selendroid.testapp:0.12.0");
				driver = new SelendroidDriver(capa);
				capa.setEmulator(true);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kills the session after the test is done
	 */
	@AfterClass
	public void teardownClass() {
		// driver.close();
		driver.quit();
	}
}
