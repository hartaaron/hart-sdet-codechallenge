package hart.sdet.challenge;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WundergroundDriver {

	final static Logger log = Logger.getLogger(WundergroundDriver.class);

	WebDriver driver;

	public WundergroundDriver (WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		log.info("opening wunderground home page");
	}

}