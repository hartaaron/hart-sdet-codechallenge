package wunderground.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import wunderground.automation.pages.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class WundergroundDriver {

	Logger log = Logger.getLogger(WundergroundDriver.class);

	WebDriver driver;
	HashMap<String, WundergroundPage> pages;

	public WundergroundDriver (WebDriver driver) {
		this.driver = driver;
		initializePages();
	}

	public <T extends WundergroundPage> T open(T page) {
		log.info("opening wunderground home page");
		page.open();
		return page;
	}

	public <T extends WundergroundPage> T open(Class<T> clazz) throws Exception {
//		// TODO: use Guava instead of reflection?
//		T page = clazz.getConstructor(WebDriver.class).newInstance(driver);

		// just use the HashMap for now
		return open(clazz.getSimpleName());
	}

	public <T extends WundergroundPage> T open(String pageName) {
		T page =  (T) pages.get(pageName);
		page.open();
		return page;
	}

	private void initializePages() {
		pages = new HashMap<String, WundergroundPage>();
		pages.put(HomePage.class.getSimpleName(), new HomePage(driver));
	}
}