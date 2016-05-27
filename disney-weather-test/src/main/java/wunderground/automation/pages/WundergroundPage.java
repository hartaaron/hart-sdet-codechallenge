package wunderground.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class WundergroundPage<T extends WundergroundPage<T>>  {

	public String pageName;
	public String baseUrl = "http://wunderground.com/";
	public static String path = "";

	protected Logger log;
	protected WebDriver driver;

	public WundergroundPage(WebDriver driver) {
		pageName = this.getClass().getSimpleName();
		log = Logger.getLogger(pageName);
		this.driver = driver;
	}

	public String url() {
		return (this.baseUrl + path);
	}

	public T open() {
		log.info("opening wunderground page " + pageName);
		driver.get(this.url());

		return (T) this;
	}

	public static class Expected {
		public static String title;
	}
}
