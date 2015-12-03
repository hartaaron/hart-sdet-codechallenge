import org.junit.runners.Parameterized;
import rottentomateschallenge.automation.AutomationException;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieListing_Tests extends RottenTomatoesAppTestBase {

    public MovieListing_Tests(HashMap<String, String> expectedResults) {
        super(expectedResults);
    }

    public void should_have_list_of_movies() throws AutomationException {
        app.search.navigateTo();
        app.search.searchFor(expected.get("movie-title"));

        app.movieListing.isCurrentPage();

        assert(app.movieListing.getMovieList().size() > 0);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("app-title", "Rotten Tomatoes Challenge");
        expectedValues.put("movie-title", "Star Wars");

        ArrayList<HashMap<String, String>> expectedResults = new ArrayList<>();
        expectedResults.add(expectedValues);

        return expectedResults;
    }
}
