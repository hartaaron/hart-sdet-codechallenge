package wunderground.automation;

import org.junit.Test;
import wunderground.automation.pages.*;

import static org.assertj.core.api.Assertions.*;

public class WundergroundDriver_Tests extends WebDriverTestBase {

	@Test
	public void should_open_wunderground_home_page() throws Exception {
		System.out.println("opening wunderground");

		HomePage homePage = wunderground.open(HomePage.class);

		System.out.println(driver.getTitle());

		assertThat(driver.getTitle()).isEqualTo(HomePage.Expected.title);

	}
}
