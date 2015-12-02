
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import rottentomateschallenge.automation.RottenTomatoesDriver;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class RottenTomatoesChallenge_Tests extends SeleniumTestBase {

    RottenTomatoesDriver app;

    public RottenTomatoesChallenge_Tests(HashMap<String, String> expectedResults) {
        super(expectedResults);
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
