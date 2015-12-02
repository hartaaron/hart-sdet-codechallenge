import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import rottentomateschallenge.automation.RottenTomatoesDriver;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RottenTomatoesChallenge_Tests {

    RottenTomatoesDriver app;

    HashMap<String, String> expected;

    static {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    }
    public RottenTomatoesChallenge_Tests(HashMap<String, String> expectedResults) {
        this.expected = expectedResults;
    }

    @Before
    public void setUp() {
        // TODO: get webdriver instance from a factory based on config settings
        WebDriver driver = new ChromeDriver();

        app = new RottenTomatoesDriver(driver);
    }

    @Test
    public void it_should_display_the_app_title() {
        app.start();
        assertThat(app.getTitle()).isEqualTo(expected.get("title"));
    }


    //TODO: get expected results from external data source
    @Parameters
    public static Iterable data() {
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("title", "Rotten Tomatoes Challenge");

        ArrayList<HashMap<String, String>> expectedResults = new ArrayList<>();
        expectedResults.add(expectedValues);

        return expectedResults;
    }

}
