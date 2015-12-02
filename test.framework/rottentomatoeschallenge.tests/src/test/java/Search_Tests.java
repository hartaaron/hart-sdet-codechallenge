import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import rottentomateschallenge.automation.AutomationException;
import rottentomateschallenge.automation.pages.SearchPage;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class Search_Tests extends RottenTomatoesAppTestBase {

    public Search_Tests(HashMap<String, String> expectedResults) {
        super(expectedResults);
    }

    @Test
    public void search_page_should_display_the_app_title() throws AutomationException {
        SearchPage search = (SearchPage) app.search.navigateTo();
        assertThat(search.getTitle()).isEqualTo(expected.get("title"));
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
