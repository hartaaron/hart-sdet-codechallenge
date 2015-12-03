import org.junit.Test;
import org.junit.runners.Parameterized;
import rottentomateschallenge.automation.AutomationException;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieDetails_Tests extends RottenTomatoesAppTestBase {
    public MovieDetails_Tests(HashMap<String, String> expectedResults)
    {
        super(expectedResults);
    }

    @Test
    public void should_have_movie_details() throws AutomationException {
        app.search.navigateTo();
        app.search.searchFor(expected.get("movie-title"));

        app.movieListing.isCurrentPage();
        app.movieListing.findMovieByTitle(expected.get("movie-title")).click();

        app.movieDetails.isCurrentPage();
        app.movieDetails.getText().contains(expected.get("movie-title"));
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
