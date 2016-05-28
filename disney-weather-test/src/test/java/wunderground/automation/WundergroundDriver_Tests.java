package wunderground.automation;

import org.junit.Test;
import wunderground.automation.pages.*;

import static org.assertj.core.api.Assertions.*;

public class WundergroundDriver_Tests extends WebDriverTestBase {

	static Location Disneyland = new Location() {{
		city = "Anaheim";
		state = "CA";
		zip = "92801";
	}};

	static Location Disneyworld = new Location() {{
		city = "Orlando";
		state = "FL";
		zip = "32801";
	}};

	@Test
	public void should_open_wunderground_home_page() throws Exception {
		log.info("opening wunderground");

		HomePage homePage = wunderground.open(HomePage.class);

		System.out.println(driver.getTitle());

		assertThat(driver.getTitle()).isEqualTo(HomePage.Expected.title);

	}

	@Test
	public void should_search_for_location() throws Exception {
		log.info("searching for current weather in " + Disneyland.city);

		wunderground.search(Disneyland.city + " " + Disneyland.state);

		//check that we're on the Forecast page
		String title = driver.getTitle();
		System.out.println(title);

		assertThat(title).contains("Forecast");
		assertThat(title).contains(Disneyland.city);
		assertThat(title).contains(Disneyland.state);
		assertThat(wunderground.forecast.getLocation()).startsWith(Disneyland.city);

		// check the actual forecast
		System.out.println(wunderground.forecast.getTemperature());


	}

	@Test
	public void should_get_forecast_for_disneyland() throws Exception {
		wunderground.search(Disneyland.city + " " + Disneyland.state);

		//check that we're on the Forecast page
		assertThat(wunderground.forecast.getLocation()).startsWith(Disneyland.city);

		// check the actual forecast
		System.out.println("location: " + wunderground.forecast.getLocation());
		System.out.println("time: " + wunderground.forecast.getTime());
		System.out.println("temperature: " + wunderground.forecast.getTemperature());
		System.out.println("sky: " + wunderground.forecast.getSkyCondition());
		System.out.println("high: " + wunderground.forecast.getTodaysHigh());
		System.out.println("low: " + wunderground.forecast.getTodaysLow());
		System.out.println("precipitation: " + wunderground.forecast.getTodaysPrecipitation());

		System.out.println("low: " + wunderground.forecast.getTodaysHigh());
	}

	@Test
	public void should_get_forecast_for_disneyworld() throws Exception {
		wunderground.search(Disneyworld.city + " " + Disneyworld.state);

		//check that we're on the Forecast page
		assertThat(wunderground.forecast.getLocation()).startsWith(Disneyworld.city);

		// check the actual forecast
		System.out.println("location: " + wunderground.forecast.getLocation());
		System.out.println("time: " + wunderground.forecast.getTime());
		System.out.println("temperature: " + wunderground.forecast.getTemperature());
		System.out.println("sky: " + wunderground.forecast.getSkyCondition());
		System.out.println("high: " + wunderground.forecast.getTodaysHigh());
		System.out.println("low: " + wunderground.forecast.getTodaysLow());
		System.out.println("precipitation: " + wunderground.forecast.getTodaysPrecipitation());
		System.out.println("wind: " + wunderground.forecast.getWindSpeed() + " from the " + wunderground.forecast.getWindDirection());
	}

	//TODO: data drive this test
	@Test
	public void should_compare_weather_in_two_locations() {

	}
}
