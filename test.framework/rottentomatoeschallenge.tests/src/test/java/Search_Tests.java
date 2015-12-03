import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import rottentomateschallenge.automation.AutomationException;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class Search_Tests extends RottenTomatoesAppTestBase {

    public Search_Tests(HashMap<String, String> expectedResults) {
        super(expectedResults);
    }

    @Test
    public void search_page_should_display_the_app_title() throws AutomationException {
        app.search.navigateTo();
        assertThat(app.search.getTitle()).isEqualTo(expected.get("app-title"));
    }

    @Test
    public void should_handle_no_results() throws AutomationException {
        app.search.navigateTo();
        app.search.searchFor(expected.get("nonexistent-movie"));

        assertThat(app.search.isCurrentPage());
        assertThat(app.search.getText().contains("No Results"));
    }

    //TODO: get expected results from external data source
    @Parameters
    public static Iterable data() {
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("app-title", "Rotten Tomatoes Challenge");
        expectedValues.put("nonexistent-movie", "The Phantom Menace");

        ArrayList<HashMap<String, String>> expectedResults = new ArrayList<>();
        expectedResults.add(expectedValues);

        return expectedResults;
    }

}
