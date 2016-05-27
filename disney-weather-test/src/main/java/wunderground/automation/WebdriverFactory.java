package wunderground.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Properties;

public class WebDriverFactory {

	Properties settings;

	public WebDriverFactory(Properties settings) {
		this.settings = settings;
	}
	public WebDriver get(Browser browser) {
		switch (browser) {
			case FIREFOX:
				return new FirefoxDriver();
			case CHROME:
				System.setProperty("webccriver.chrome.driver", settings.getProperty("chromedriver.path"));
				return new ChromeDriver();
			case IE:
				System.setProperty("webccriver.chrome.driver", settings.getProperty("chromedriver.path"));
				return new InternetExplorerDriver();
			case SAFARI:
				System.setProperty("webdriver.safari.noinstall", "true");
				return new SafariDriver();
			case HTMLUNIT:
				throw new NotImplementedException();
			default:
				return get(Browser.FIREFOX);

		}
	}

	public WebDriver getInstrance(String browserName) {
		browserName = browserName.toUpperCase();
		Browser browser = Browser.valueOf(browserName);
		return get(browser);
	}
}
