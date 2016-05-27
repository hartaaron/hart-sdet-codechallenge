package hart.sdet.challenge;

import org.junit.Test;

public class WundergroundDriver_Tests {

	WundergroundDriver wunderground;

	@Test
	public void should_open_wunderground_home_page() {
		System.out.println("opening wunderground");

		wunderground.open();
	}

}
